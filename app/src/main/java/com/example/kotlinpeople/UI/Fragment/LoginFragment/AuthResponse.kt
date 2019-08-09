package com.example.kotlinpeople.ui.fragment.loginFragment

import com.example.kotlinpeople.DB.User


data class AuthResponse(
    val isSuccessful : Boolean?,
    val message: String?,
    val user: User?
)