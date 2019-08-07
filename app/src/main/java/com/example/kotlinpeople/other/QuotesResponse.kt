package com.example.kotlinpeople.other

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class QuotesResponse(
    @PrimaryKey(autoGenerate = false)
    val id :Int,
    val userId :Int,
    val title :String,
    val body :String
)