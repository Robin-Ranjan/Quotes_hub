package com.rajeev.retrofit_mvvm_room.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.rajeev.retrofit_mvvm_room.modal.ResultDTO

@Dao
interface QuoteDao {

    @Insert
    suspend fun addQuotes(quotes: List<ResultDTO>)

    @Query("SELECT * FROM quote")
    suspend fun getQuotes(): List<ResultDTO>
}