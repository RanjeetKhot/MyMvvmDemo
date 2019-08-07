package com.example.kotlinpeople.UI.Fragment.LoginFragment

interface LoginListener {
    fun onStarted()
    fun onSuccess(message: String)
    fun onFailure(message: String)
}