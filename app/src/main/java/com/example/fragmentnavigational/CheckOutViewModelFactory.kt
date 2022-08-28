package com.example.fragmentnavigational

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CheckOutViewModelFactory(val id: Int?, val quantity: Int) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CheckOutViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return id?.let { CheckOutViewModel(it,quantity) } as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
