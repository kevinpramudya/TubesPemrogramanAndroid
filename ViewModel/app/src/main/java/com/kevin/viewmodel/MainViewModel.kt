package com.kevin.viewmodel

import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    var number = 0

    fun addNumber(){
        number++
    }
}