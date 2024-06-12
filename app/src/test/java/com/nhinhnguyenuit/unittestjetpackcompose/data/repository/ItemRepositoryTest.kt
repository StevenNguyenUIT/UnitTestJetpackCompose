package com.nhinhnguyenuit.unittestjetpackcompose.data.repository

import com.nhinhnguyenuit.unittestjetpackcompose.data.model.Item
import com.nhinhnguyenuit.unittestjetpackcompose.data.network.ApiService
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever

class ItemRepositoryTest {
    private lateinit var apiService: ApiService
    private lateinit var repository: ItemRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        apiService = mock(ApiService::class.java)
        repository = ItemRepository(apiService)
    }

    @Test
    fun `test getItems returns list of items`() = runBlocking {
        val mockItems = listOf(
            Item(id = 1, name = "Item 1", description = "Description 1"),
            Item(id = 2, name = "Item 2", description = "Description 2")
        )

        whenever(apiService.getItems()).thenReturn(mockItems)

        val items = repository.getItems()
        assertEquals(mockItems, items)
    }
}