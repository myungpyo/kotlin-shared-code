package com.smp.sharedkotlin.app.presentation


data class Memo(
    val id: Int,
    val title: String,
    val content: String,
    val createdAt: Long,
    val lastModifiedAt: Long
)