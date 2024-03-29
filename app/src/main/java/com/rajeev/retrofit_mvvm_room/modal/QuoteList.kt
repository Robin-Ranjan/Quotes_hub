package com.rajeev.retrofit_mvvm_room.modal

data class QuoteList(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<ResultDTO>,
    val totalCount: Int,
    val totalPages: Int
)