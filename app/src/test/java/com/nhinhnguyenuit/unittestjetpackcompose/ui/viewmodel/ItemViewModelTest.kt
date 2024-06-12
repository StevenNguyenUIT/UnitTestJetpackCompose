//package com.nhinhnguyenuit.unittestjetpackcompose.ui.viewmodel
//
//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import com.nhinhnguyenuit.unittestjetpackcompose.data.model.Item
//import com.nhinhnguyenuit.unittestjetpackcompose.data.network.ApiService
//import com.nhinhnguyenuit.unittestjetpackcompose.data.repository.ItemRepository
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.test.UnconfinedTestDispatcher
//import kotlinx.coroutines.test.runTest
//import kotlinx.coroutines.test.setMain
//import org.junit.Assert.*
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import org.mockito.Mockito.mock
//import org.mockito.MockitoAnnotations
//import org.mockito.kotlin.whenever
//
//@ExperimentalCoroutinesApi
//class ItemViewModelTest{
//    @get:Rule
//    val instantTaskExecutorRule = InstantTaskExecutorRule()
//
//    private lateinit var repository: ItemRepository
//    private lateinit var viewModel: ItemViewModel
//    private lateinit var apiService: ApiService
//
//    private val testDispatcher = UnconfinedTestDispatcher()
//
//    @Before
//    fun setUp() {
//        MockitoAnnotations.openMocks(this)
//        apiService = mock(ApiService::class.java)
//        repository = ItemRepository(apiService)
////        repository = mock()
//        Dispatchers.setMain(testDispatcher)
//    }
//
//    @Test
//    fun `test items are fetched correctly`() = runTest {
//        val mockItems = listOf(
//            Item(id = 1, name = "Item 1", description = "Description 1"),
//            Item(id = 2, name = "Item 2", description = "Description 2")
//        )
//
//        whenever(repository.getItems()).thenReturn(mockItems)
//
//        viewModel = ItemViewModel(repository) // Reinitialize to trigger init block
//        assertEquals(mockItems, viewModel.items.value)
//    }
//}