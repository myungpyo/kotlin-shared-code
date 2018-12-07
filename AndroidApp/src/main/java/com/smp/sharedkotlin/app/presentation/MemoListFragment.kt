package com.smp.sharedkotlin.app.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smp.sharedkotlin.app.R
import com.smp.sharedkotlin.app.support.BaseFragment
import com.smp.sharedkotlin.app.support.Progress
import com.smp.sharedkotlin.app.support.observeNotNull
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MemoListFragment : BaseFragment() {

    private val memoListViewModel: MemoListViewModel by viewModel()

    companion object {
        fun create(): Fragment {
            return MemoListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        swipeRefreshView.setOnRefreshListener {
            memoListViewModel.syncMemos()
        }

        memosView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = MemosAdapter()
        }

        withViewModel<MemoListViewModel> {
            observeNotNull(memos) {
                submitList(it)
            }

            observeNotNull(memosSyncProgress) {
                swipeRefreshView.isRefreshing = it != Progress.IDLE
            }
        }

        memoListViewModel.syncMemos()
    }

    private fun submitList(memos: List<Memo>) {
        (memosView.adapter as? MemosAdapter)?.let {
            it.submit(memos)
            it.notifyDataSetChanged()
        }
    }

}