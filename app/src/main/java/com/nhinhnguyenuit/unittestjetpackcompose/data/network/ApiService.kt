package com.nhinhnguyenuit.unittestjetpackcompose.data.network

import com.nhinhnguyenuit.unittestjetpackcompose.data.model.Item
import retrofit2.http.GET

interface ApiService {
    @GET("restaurants.json")
    suspend fun getItems(): List<Item>
}