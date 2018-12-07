package com.smp.sharedkotlin.app.support

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer


fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(
    liveData: L,
    body: (T?) -> Unit
) = liveData.observe(this, Observer(body))

inline fun <T : Any, L : LiveData<T>> LifecycleOwner.observeNotNull(
    liveData: L,
    crossinline body: (T) -> Unit
) = liveData.observe(this, Observer { value -> value?.let(body) })