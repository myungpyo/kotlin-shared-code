package com.smp.sharedkotlin.domain

import com.smp.sharedkotlin.entity.MemoEntity


class GetMemoUseCase(private val repository: MemoRepository) :
    UseCaseWithParam<GetMemoUseCase.Param, MemoEntity?> {

    override fun execute(params: Param): MemoEntity? {
        return repository.getMemo(params.id)
    }

    data class Param(val id: Int)
}