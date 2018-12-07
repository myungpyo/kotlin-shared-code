package com.smp.sharedkotlin.domain

expect fun platformName(): String

fun createWelcomeMessage(): String {

    return "Welcome !! You are using kotlin on ${platformName()}"
}