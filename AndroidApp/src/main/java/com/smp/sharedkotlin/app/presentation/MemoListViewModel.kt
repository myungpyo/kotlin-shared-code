package com.smp.sharedkotlin.app.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.smp.sharedkotlin.app.support.*
import com.smp.sharedkotlin.domain.GetAllMemosUseCase


class MemoListViewModel(
    private val schedulerProvider: SchedulerProvider,
    private val getAllMemosUseCase: GetAllMemosUseCase
) : BaseViewModel() {

    private val _memos = MutableLiveData<List<Memo>>()
    val memos: LiveData<List<Memo>> = _memos
    val memosSyncProgress = MediatorLiveData<Progress>()

    fun syncMemos() {
        SingleSupport.deferredJust { getAllMemosUseCase.execute() }
            .subscribeOn(schedulerProvider.io())
            .map(MemoMapper::mapAll)
            .observeOn(schedulerProvider.ui())
            .syncProgress(memosSyncProgress)
            .subscribe { result ->
                _memos.value = result
            }
            .bind(this)

    }
}