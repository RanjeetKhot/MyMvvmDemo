package com.example.kotlinpeople.ui.fragment.HomeFragment

import androidx.lifecycle.ViewModel
import lazyDeferred


class HomeViewModel(private val repository: HomeRepository) : ViewModel() {


    val quotes by lazyDeferred {
        repository.getQuotes()
    }


}