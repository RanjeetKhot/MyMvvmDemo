package com.example.kotlinpeople.DB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlinpeople.other.QuotesResponse

@Dao
interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllQuotes(quotes: List<QuotesResponse>)

    @Query("SELECT * FROM QuotesResponse")
    fun getQuotes(): LiveData<List<QuotesResponse>>

}