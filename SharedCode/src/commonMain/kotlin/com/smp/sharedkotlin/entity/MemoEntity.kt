package com.smp.sharedkotlin.entity

data class MemoEntity(
    val id: Int,
    val title: String,
    val content: String,
    val createdAt: Long,
    val lastModifiedAt: Long
)