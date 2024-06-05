package com.nhinhnguyenuit.unittestjetpackcompose.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nhinhnguyenuit.unittestjetpackcompose.ui.viewmodel.ItemViewModel

@Composable
fun ItemDetailScreen(id: Int, viewModel: ItemViewModel = hiltViewModel()) {
    val items by viewModel.items.collectAsState()
    val item = items.find { it.id == id }
    item?.let {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "Title: ${it.name}", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Description: ${it.description}",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}