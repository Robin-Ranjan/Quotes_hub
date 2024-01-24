package com.rajeev.retrofit_mvvm_room

import android.app.Application
import com.rajeev.retrofit_mvvm_room.api.QuoteService
import com.rajeev.retrofit_mvvm_room.api.RetrofitHelper
import com.rajeev.retrofit_mvvm_room.db.QuoteDatabase
import com.rajeev.retrofit_mvvm_room.repo.QuoteRepo

class QuoteApplication : Application() {

    lateinit var quoteRepo: QuoteRepo

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val quoteDatabase = QuoteDatabase.getDatabase(applicationContext)
         quoteRepo = QuoteRepo(quoteService,quoteDatabase,applicationContext)

    }

}