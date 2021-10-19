package com.example.picsumphotos.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.picsumphotos.models.ListDataItem
import com.example.picsumphotos.retrofit.ApiService

class ListDataSource(private val apiService: ApiService) : PagingSource<Int, ListDataItem>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ListDataItem> {
        try {
            val nextPageNumber = params.key ?: 1
            val list = apiService.getList(nextPageNumber)
            if (nextPageNumber > 1) {
                return LoadResult.Page(list, nextPageNumber - 1, nextPageNumber + 1)
            } else {
                return LoadResult.Page(list, null, nextPageNumber + 1)
            }
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ListDataItem>): Int? {
        return state.anchorPosition
    }
}