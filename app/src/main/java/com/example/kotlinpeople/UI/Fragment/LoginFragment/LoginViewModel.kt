package com.example.kotlinpeople.UI.Fragment.LoginFragment

import android.view.View
import androidx.lifecycle.ViewModel
import lazyDeferred


class LoginViewModel(private val repository: LoginRepository) : ViewModel() {
    var name: String? = null
    var email: String? = null
    var password: String? = null


    var loginListener: LoginListener? = null


    suspend  fun onLoginButtonClick(view: View) {
        loginListener!!.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            loginListener!!.onFailure("enter valid email and password")
            return
        }
        repository.checkIsLogin(email!!, password!!)
        loginListener!!.onSuccess("Login")


    }


    suspend fun onSignup(view: View) {
        loginListener!!.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            loginListener!!.onFailure("enter valid email and password")
            return
        }
        val signUp by lazyDeferred {
            repository.saveLogin(email = email!!, password = password!!)
            loginListener!!.onSuccess("Login")
        }
    }


}