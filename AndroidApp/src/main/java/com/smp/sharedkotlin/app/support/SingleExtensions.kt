package com.smp.sharedkotlin.app.support

import androidx.lifecycle.MediatorLiveData
import io.reactivex.Single


fun <T> Single<T>.syncProgress(
    progressState: MediatorLiveData<Progress>,
    startsWith: Progress = Progress.INITIAL
): Single<T> {
    return doOnSubscribe { progressState.postValue(startsWith) }
        .doFinally { progressState.postValue(Progress.IDLE) }
}