package com.smp.sharedkotlin.app.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smp.sharedkotlin.app.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.memo_item.*
import java.text.DateFormat
import java.util.*

class MemosAdapter : RecyclerView.Adapter<MemoViewHolder>() {

    private val memos = mutableListOf<Memo>()

    fun submit(memos: List<Memo>) {
        this.memos.clear()
        this.memos.addAll(memos)
    }

    override fun getItemCount(): Int {
        return memos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        return MemoViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        holder.bind(memos[position])
    }

}


class MemoViewHolder(
    override val containerView: View,
    private val dateFormat: DateFormat = DateFormat.getDateInstance()
) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    companion object {
        fun create(parent: ViewGroup): MemoViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.memo_item, parent, false)

            return MemoViewHolder(view)
        }
    }

    fun bind(memo: Memo) {
        titleView.text = memo.title
        contentView.text = memo.content
        timeView.text = dateFormat.format(Date(memo.lastModifiedAt))
    }

}