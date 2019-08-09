package com.example.kotlinpeople.ui.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinpeople.R
import com.example.kotlinpeople.ui.fragment.HomeFragment.HomeFragment
import com.example.kotlinpeople.ui.fragment.loginFragment.LoginFragment

class MainActivity : AppCompatActivity() {
    var homeFragment = HomeFragment()
    var loginFragment = LoginFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container, loginFragment).commitAllowingStateLoss()

    }
}
