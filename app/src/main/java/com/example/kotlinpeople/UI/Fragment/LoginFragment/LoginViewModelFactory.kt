package com.example.kotlinpeople.ui.fragment.loginFragment


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class LoginViewModelFactory(
    private val repositorys: LoginRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(repositorys) as T
    }
}