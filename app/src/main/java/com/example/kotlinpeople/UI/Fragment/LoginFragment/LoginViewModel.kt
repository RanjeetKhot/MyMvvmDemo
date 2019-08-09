package com.example.kotlinpeople.ui.fragment.loginFragment

import Coroutines
import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.kotlinpeople.ui.Activity.DrawerActivity
import com.example.kotlinpeople.ui.Activity.MainActivity
import com.example.kotlinpeople.util.ApiException
import com.example.kotlinpeople.util.NoInternetException


class LoginViewModel(private val repository: LoginRepository) : ViewModel() {
    var name: String? = null
    var email: String? = null
    var password: String? = null
    var passwordconfirm: String? = null

    var loginListener: LoginListener? = null

    fun getLoggedInUser() = repository.getUser()


    fun onLoginButtonClick(view: View){
        loginListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            loginListener?.onFailure("Invalid email or password")
            return
        }

        Coroutines.main {
            try {
                val authResponse = repository.userLogin(email!!, password!!)
                authResponse.user?.let {
                    loginListener?.onSuccess(it)
                    repository.saveUser(it)
                    return@main
                }
                loginListener?.onFailure(authResponse.message!!)
            }catch(e: ApiException){
                loginListener?.onFailure(e.message!!)
            }
        }

    }

    fun onLogin(view: View){
        Intent(view.context, DrawerActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun onSignup(view: View){
        Intent(view.context, DrawerActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun onSignupButtonClick(view: View){
        loginListener?.onStarted()

        if(name.isNullOrEmpty()){
            loginListener?.onFailure("Name is required")
            return
        }

        if(email.isNullOrEmpty()){
            loginListener?.onFailure("Email is required")
            return
        }

        if(password.isNullOrEmpty()){
            loginListener?.onFailure("Please enter a password"

            )
            return
        }

        if(password != passwordconfirm){
            loginListener?.onFailure("Password did not match")
            return
        }


        Coroutines.main {
            try {
                val authResponse = repository.userSignup(name!!, email!!, password!!)
                authResponse.user?.let {
                    loginListener?.onSuccess(it)
                    repository.saveUser(it)
                    return@main
                }
                loginListener?.onFailure(authResponse.message!!)
            }catch(e: ApiException){
                loginListener?.onFailure(e.message!!)
            }
        }

    }

    fun setListener(loginFragment: LoginFragment) {
        loginListener=loginFragment
    }

}