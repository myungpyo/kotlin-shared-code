package com.smp.sharedkotlin.app.presentation

import com.smp.sharedkotlin.app.support.Mapper
import com.smp.sharedkotlin.entity.MemoEntity


object MemoMapper : Mapper<MemoEntity, Memo> {

    override fun map(obj: MemoEntity): Memo {
        return Memo(
            obj.id,
            obj.title,
            obj.content,
            obj.lastModifiedAt,
            obj.createdAt
        )
    }

    override fun mapAll(objs: Iterable<MemoEntity>): List<Memo> {
        return objs.map { map(it) }
    }

    override fun reverse(obj: Memo): MemoEntity {
        return MemoEntity(
            obj.id,
            obj.title,
            obj.content,
            obj.lastModifiedAt,
            obj.createdAt
        )
    }

    override fun reverseAll(objs: Iterable<Memo>): List<MemoEntity> {
        return objs.map { reverse(it) }
    }

}