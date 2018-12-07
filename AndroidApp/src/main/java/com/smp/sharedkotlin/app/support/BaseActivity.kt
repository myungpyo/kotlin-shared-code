package com.smp.sharedkotlin.app.support

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


abstract class BaseActivity : AppCompatActivity() {

    inline fun <reified T : ViewModel> withViewModel(body: T.() -> Unit) {
        val viewModel: T by viewModel()
        viewModel.body()
    }
}