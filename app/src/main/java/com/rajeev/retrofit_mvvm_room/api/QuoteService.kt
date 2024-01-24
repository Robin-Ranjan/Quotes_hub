package com.rajeev.retrofit_mvvm_room.api

import com.rajeev.retrofit_mvvm_room.modal.QuoteList
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {
    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page:Int ):retrofit2.Response<QuoteList>
}