package com.nhinhnguyenuit.unittestjetpackcompose.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nhinhnguyenuit.unittestjetpackcompose.data.model.Item
import com.nhinhnguyenuit.unittestjetpackcompose.data.repository.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val itemRepository: ItemRepository
) : ViewModel() {
    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items : StateFlow<List<Item>> = _items
    init {
        viewModelScope.launch {
            val fetchItems = itemRepository.getItems()
            _items.value = fetchItems
        }
    }
}