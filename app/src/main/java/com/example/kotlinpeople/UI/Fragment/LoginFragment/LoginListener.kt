package com.example.kotlinpeople.ui.fragment.loginFragment

import com.example.kotlinpeople.DB.User

interface LoginListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}