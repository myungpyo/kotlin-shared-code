package com.smp.sharedkotlin.domain


interface UseCase<Result> {
    fun execute(): Result
}

interface UseCaseWithParam<Params, Result> : UseCase<Result> {

    override fun execute(): Result {
        throw UnsupportedOperationException("You must use parameterized version for this use case")
    }

    fun execute(params: Params): Result
}