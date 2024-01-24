package com.rajeev.retrofit_mvvm_room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rajeev.retrofit_mvvm_room.modal.ResultDTO

@Database(entities = [ResultDTO::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun quoteDao(): QuoteDao

    companion object {
        @Volatile
        private var INSTANCE: QuoteDatabase? = null

        fun getDatabase(context: Context): QuoteDatabase {
            if (INSTANCE == null) {

                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context.applicationContext, QuoteDatabase::class.java, "quoteDB").build()
                }
            }
            return INSTANCE!!
        }
    }
}