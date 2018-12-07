package com.smp.sharedkotlin.domain

import com.smp.sharedkotlin.entity.MemoEntity


class GetAllMemosUseCase(private val repository: MemoRepository) : UseCase<List<MemoEntity>> {

    override fun execute(): List<MemoEntity> {
        return repository.getAllMemos()
    }

}