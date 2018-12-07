package com.smp.sharedkotlin.app.support

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class BaseViewModel : ViewModel(), AutoDisposable {

    private val disposeBag = CompositeDisposable()

    override fun onCleared() {
        disposeBag.dispose()
        super.onCleared()
    }

    final override fun bind(disposable: Disposable) {
        disposeBag.add(disposable)
    }

}