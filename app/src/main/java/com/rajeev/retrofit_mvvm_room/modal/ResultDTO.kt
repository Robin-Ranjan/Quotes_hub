package com.rajeev.retrofit_mvvm_room.modal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class ResultDTO(

    @PrimaryKey(autoGenerate = true)
    val quoteId: Int,
    val _id: String,
    val author: String,
    val authorSlug: String,
    val content: String,
    val length: Int,
)