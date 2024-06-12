package com.nhinhnguyenuit.unittestjetpackcompose.data.repository

import com.nhinhnguyenuit.unittestjetpackcompose.data.model.Item
import com.nhinhnguyenuit.unittestjetpackcompose.data.network.ApiService
import com.nhinhnguyenuit.unittestjetpackcompose.data.network.RetrofitInstance
import javax.inject.Inject

class ItemRepository @Inject constructor(
    val apiService: ApiService
){
     suspend fun getItems(): List<Item> = RetrofitInstance.api.getItems()
}