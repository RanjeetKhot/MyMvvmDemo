package com.example.kotlinpeople.UI.Fragment.LoginFragment

import com.example.kotlinpeople.API.MyApi
import com.example.kotlinpeople.DB.AppDatabase
import com.example.kotlinpeople.other.RegistrationResponse
import com.example.kotlinpeople.util.PreferenceProvider
import com.example.kotlinpeople.util.SafeApiRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class LoginRepository(
    private val api: MyApi,
    private val db: AppDatabase,
    private val pref: PreferenceProvider): SafeApiRequest()  {

    fun checkIsLogin(email: String, password: String) {
        if (pref.getLastSavedAt().isNullOrBlank()) {
            //val response=api.getLogin()
        }

    }

    suspend fun saveLogin(email: String, password: String) {
        GlobalScope.async {
            if (pref.getLastSavedAt().isNullOrBlank()) {
                val response = api.getLogin()
            }
        }



        CoroutineScope(Dispatchers.IO).let {

            db.getRegistartionDao().saveRegistration(RegistrationResponse(1, email, password))
        }


    }


}
