package com.smp.sharedkotlin.app.support

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

abstract class BaseFragment : Fragment() {

    inline fun <reified T : ViewModel> withViewModel(body: T.() -> Unit) {
        val viewModel: T by viewModel()
        viewModel.body()
    }
}