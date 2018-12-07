package com.smp.sharedkotlin.app.support

import io.reactivex.Single

class SingleSupport {
    companion object {
        fun <T> deferredJust(func: () -> T): Single<T> {
            return Single.defer { Single.just(func.invoke()) }
        }
    }
}