package com.rajeev.retrofit_mvvm_room.repo

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rajeev.retrofit_mvvm_room.api.QuoteService
import com.rajeev.retrofit_mvvm_room.db.QuoteDatabase
import com.rajeev.retrofit_mvvm_room.modal.QuoteList
import com.rajeev.retrofit_mvvm_room.utils.NetworkUtils

// accessing api interface
class QuoteRepo(
    private val quoteService: QuoteService,
    private val quoteDatabase: QuoteDatabase,
    private val applicationContext: Context
) {

    private val quotesLiveData = MutableLiveData<QuoteList>()

    val quotes: LiveData<QuoteList>
        get() = quotesLiveData

    suspend fun getQuotes(page: Int) {

        if (NetworkUtils.isInternetAvailable(applicationContext)) {
            val result = quoteService.getQuotes(page) // calling API

            if (result?.body() != null) {
                quoteDatabase.quoteDao()
                    .addQuotes(result.body()!!.results) // if response is not null , then it will store in database
                quotesLiveData.postValue(result.body()) // setting the liveData

            }
        } else {
            val quotes = quoteDatabase.quoteDao().getQuotes()
            val quoteList = QuoteList(1,1,1,quotes,1,1)
            quotesLiveData.postValue(quoteList)

        }

    }
}