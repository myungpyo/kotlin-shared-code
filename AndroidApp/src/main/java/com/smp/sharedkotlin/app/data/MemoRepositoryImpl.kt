package com.smp.sharedkotlin.app.data

import com.smp.sharedkotlin.domain.MemoRepository
import com.smp.sharedkotlin.entity.MemoEntity


class MemoRepositoryImpl(private val dataSource: MemoDataSource) : MemoRepository {

    override fun getAllMemos(): List<MemoEntity> {
        return MemoEntityMapper.mapAll(dataSource.getAllMemos())
    }

    override fun getMemo(id: Int): MemoEntity? {
        dataSource.getMemo(id)?.let {
            return MemoEntityMapper.map(it)
        }
        return null
    }
}