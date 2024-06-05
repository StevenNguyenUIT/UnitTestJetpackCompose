package com.nhinhnguyenuit.unittestjetpackcompose.data.repository

import com.nhinhnguyenuit.unittestjetpackcompose.data.model.Item
import com.nhinhnguyenuit.unittestjetpackcompose.data.network.ApiService
import javax.inject.Inject

class ItemRepository @Inject constructor(
    val apiService: ApiService
): ApiService {
    override suspend fun getItems(): List<Item> = apiService.getItems()
}