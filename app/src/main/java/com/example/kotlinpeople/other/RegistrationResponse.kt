package com.example.kotlinpeople.other

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class RegistrationResponse(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    var email: String,
    val password: String
)