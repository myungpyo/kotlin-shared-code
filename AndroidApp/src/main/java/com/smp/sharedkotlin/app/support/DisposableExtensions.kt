package com.smp.sharedkotlin.app.support

import io.reactivex.disposables.Disposable


fun Disposable.bind(autoDisposable: AutoDisposable) {
    autoDisposable.bind(this)
}