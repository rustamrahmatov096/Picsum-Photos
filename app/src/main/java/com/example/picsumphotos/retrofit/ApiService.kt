package com.example.picsumphotos.retrofit

import com.example.picsumphotos.models.ListData
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("list")
    suspend fun getList(@Query("page") page: Int, @Query("limit") limit: Int = 5): ListData


}