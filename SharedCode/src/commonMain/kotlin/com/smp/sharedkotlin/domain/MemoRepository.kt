package com.smp.sharedkotlin.domain

import com.smp.sharedkotlin.entity.MemoEntity


interface MemoRepository {

    fun getAllMemos(): List<MemoEntity>

    fun getMemo(id: Int): MemoEntity?
}