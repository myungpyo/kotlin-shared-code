package com.smp.sharedkotlin.app.data

import android.util.Log
import java.util.*

class MemoDataSourceImpl : MemoDataSource {

    companion object {
        const val MOCK_NETWORK_DELAY = 1500L
        const val MAX_MOCK_MEMO = 100
    }

    private val mockMemos: List<MemoModel> by lazy {
        val cal = Calendar.getInstance()

        1.rangeTo(MAX_MOCK_MEMO).map {
            MemoModel(
                it,
                "Test Memo $it",
                "This is test memo $it",
                cal.apply { add(Calendar.DAY_OF_YEAR, -1) }.timeInMillis,
                cal.apply { add(Calendar.DAY_OF_YEAR, -1) }.timeInMillis
            )
        }
    }

    override fun getAllMemos(): List<MemoModel> {
        try {
            Thread.sleep(MOCK_NETWORK_DELAY)
            return mockMemos.toList()
        } catch (throwable: Throwable) {
            Log.e("MemoDataSource", "getMemoList Error : $throwable")
        }
        return listOf()
    }

    override fun getMemo(id: Int): MemoModel? {
        if (id <= 0 || id > MAX_MOCK_MEMO) {
            return null
        }

        try {
            Thread.sleep(MOCK_NETWORK_DELAY)
            return mockMemos[id - 1]
        } catch (throwable: Throwable) {
            Log.e("MemoDataSource", "getMemo Error : $throwable")
        }
        return null
    }

}