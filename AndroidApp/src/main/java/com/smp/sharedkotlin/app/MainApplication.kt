package com.smp.sharedkotlin.app

import android.app.Application
import com.smp.sharedkotlin.app.data.MemoDataSource
import com.smp.sharedkotlin.app.data.MemoDataSourceImpl
import com.smp.sharedkotlin.app.data.MemoRepositoryImpl
import com.smp.sharedkotlin.app.presentation.MemoListViewModel
import com.smp.sharedkotlin.app.support.SchedulerProvider
import com.smp.sharedkotlin.app.support.SchedulerProviderImpl
import com.smp.sharedkotlin.domain.GetAllMemosUseCase
import com.smp.sharedkotlin.domain.GetMemoUseCase
import com.smp.sharedkotlin.domain.MemoRepository
import org.koin.android.ext.android.startKoin
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val memoModule = module {
            single { SchedulerProviderImpl() as SchedulerProvider }
            single { MemoDataSourceImpl() as MemoDataSource }
            single { MemoRepositoryImpl(get()) as MemoRepository }
            single { GetAllMemosUseCase(get()) }
            single { GetMemoUseCase(get()) }
            viewModel { MemoListViewModel(get(), get()) }
        }

        startKoin(this, listOf(memoModule))
    }
}