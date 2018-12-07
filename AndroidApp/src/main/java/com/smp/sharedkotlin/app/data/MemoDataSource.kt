package com.smp.sharedkotlin.app.data

interface MemoDataSource {
    fun getAllMemos(): List<MemoModel>
    fun getMemo(id: Int): MemoModel?
}