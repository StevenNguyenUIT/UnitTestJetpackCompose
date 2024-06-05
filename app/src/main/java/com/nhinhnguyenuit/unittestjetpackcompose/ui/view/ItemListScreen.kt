package com.nhinhnguyenuit.unittestjetpackcompose.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.nhinhnguyenuit.unittestjetpackcompose.ui.viewmodel.ItemViewModel

@Composable
fun ItemListScreen(
    navController: NavHostController,
    viewModel: ItemViewModel = hiltViewModel()
) {
    val items by viewModel.items.collectAsState()

    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        items(items) { item ->
            Card(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = "${item.name}",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate("item_detail/${item.id}")
                        }
                        .padding(16.dp))
            }
        }
    }
}