package com.example.kotlinpeople.ui.fragment.loginFragment

import com.example.kotlinpeople.API.MyApi
import com.example.kotlinpeople.DB.AppDatabase
import com.example.kotlinpeople.DB.User
import com.example.kotlinpeople.util.SafeApiRequest

class LoginRepository(
    private val api: MyApi,
    private val db: AppDatabase
) : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { api.userLogin(email, password) }
    }


    suspend fun userSignup(
        name: String,
        email: String,
        password: String
    ) : AuthResponse {
        return apiRequest{ api.userSignup(name, email, password)}
    }

    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)

    fun getUser() = db.getUserDao().getuser()

}