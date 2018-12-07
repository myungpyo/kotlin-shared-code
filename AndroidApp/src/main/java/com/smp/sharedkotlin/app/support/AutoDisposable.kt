package com.smp.sharedkotlin.app.support

import io.reactivex.disposables.Disposable


interface AutoDisposable {
    fun bind(disposable: Disposable)
}