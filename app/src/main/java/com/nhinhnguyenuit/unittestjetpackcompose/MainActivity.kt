package com.nhinhnguyenuit.unittestjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.nhinhnguyenuit.unittestjetpackcompose.ui.theme.UnitTestJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitTestJetpackComposeTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                ) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .paint(
                                painterResource(id = R.drawable.ic_launcher_background),
                                contentScale = ContentScale.FillBounds
                            )
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var imageUrl by rememberSaveable {
        mutableStateOf("")
    }
    Column {
        Image(painter = rememberImagePainter(data = imageUrl),
            contentDescription = null,
            modifier = Modifier.size(500.dp, 400.dp))
    }
    Button(onClick = { imageUrl = "https://picsum.photos/200/300" }) {
        Text(text = "Load Image")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UnitTestJetpackComposeTheme {
        Greeting("Android")
    }
}