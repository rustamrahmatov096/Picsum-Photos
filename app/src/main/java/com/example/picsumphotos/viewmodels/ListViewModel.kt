package com.example.picsumphotos.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.picsumphotos.paging.ListDataSource
import com.example.picsumphotos.retrofit.ApiService

class ListViewModel(val apiService: ApiService):ViewModel() {
    val list = Pager(PagingConfig(5)){
        ListDataSource(apiService)
    }.flow.cachedIn(viewModelScope)
}