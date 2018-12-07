package com.smp.sharedkotlin.app.support

import io.reactivex.Scheduler


interface SchedulerProvider {

    fun io(): Scheduler

    fun computation(): Scheduler

    fun ui(): Scheduler
}