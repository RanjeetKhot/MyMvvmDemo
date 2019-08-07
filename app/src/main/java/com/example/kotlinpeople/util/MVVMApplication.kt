package com.example.kotlinpeople.util

import android.app.Application
import com.example.kotlinpeople.API.MyApi
import com.example.kotlinpeople.API.NetworkConnectionInterceptor
import com.example.kotlinpeople.DB.AppDatabase
import com.example.kotlinpeople.UI.Fragment.HomeFragment.HomeRepository
import com.example.kotlinpeople.UI.Fragment.HomeFragment.HomeViewModelFactory
import com.example.kotlinpeople.UI.Fragment.LoginFragment.LoginRepository
import com.example.kotlinpeople.UI.Fragment.LoginFragment.LoginViewModel
import com.example.kotlinpeople.UI.Fragment.LoginFragment.LoginViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { PreferenceProvider(instance()) }
        bind() from singleton {
            HomeRepository(
                instance(),
                instance(),
                instance()
            )
        }
        bind() from provider { HomeViewModelFactory(instance()) }

        bind() from provider { LoginViewModelFactory(instance()) }
        bind() from provider { LoginRepository(instance(),instance(),instance()) }


    }

}