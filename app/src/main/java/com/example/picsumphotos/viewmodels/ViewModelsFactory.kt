package com.example.picsumphotos.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.picsumphotos.retrofit.ApiService
import java.lang.IllegalArgumentException

class ViewModelsFactory(val apiService: ApiService) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
            return ListViewModel(apiService) as T
        }
        throw IllegalArgumentException("Error")
    }
}