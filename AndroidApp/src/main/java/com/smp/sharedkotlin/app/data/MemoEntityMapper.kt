package com.smp.sharedkotlin.app.data

import com.smp.sharedkotlin.app.support.Mapper
import com.smp.sharedkotlin.entity.MemoEntity

object MemoEntityMapper : Mapper<MemoModel, MemoEntity> {

    override fun map(obj: MemoModel): MemoEntity {
        return MemoEntity(
            obj.id,
            obj.title,
            obj.content,
            obj.lastModifiedAt,
            obj.createdAt
        )
    }

    override fun mapAll(objs: Iterable<MemoModel>): List<MemoEntity> {
        return objs.map { map(it) }
    }

    override fun reverse(obj: MemoEntity): MemoModel {
        return MemoModel(
            obj.id,
            obj.title,
            obj.content,
            obj.lastModifiedAt,
            obj.createdAt
        )
    }

    override fun reverseAll(objs: Iterable<MemoEntity>): List<MemoModel> {
        return objs.map { reverse(it) }
    }

}