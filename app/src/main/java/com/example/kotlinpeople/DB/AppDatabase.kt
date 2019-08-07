package com.example.kotlinpeople.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlinpeople.other.QuotesResponse
import com.example.kotlinpeople.other.RegistrationResponse

@Database(
    entities = [QuotesResponse::class,RegistrationResponse::class],
    version = 2
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getQuoteDao(): QuoteDao
    abstract fun getRegistartionDao(): RegistrationDao

    companion object {

        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(
            LOCK
        ) {
            instance
                ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "MyDatabase.db"
            ).build()
    }
}