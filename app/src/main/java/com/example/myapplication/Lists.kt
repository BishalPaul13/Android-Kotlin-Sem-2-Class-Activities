package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Lists : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        HorizontalListExample()
        ListExample()
    }
}

@Composable
fun ListExample() {

    val items = listOf("Android", "Kotlin", "Jetpack Compose", "Material3", "Android", "Kotlin", "Jetpack Compose", "Material3", "Android", "Kotlin", "Jetpack Compose", "Material3")

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
            .padding(16.dp)
    ) {
        items(items) { item ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),

                elevation = CardDefaults.cardElevation(6.dp),

                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF5F5F5)
                )
            ) {

                Text(
                    text = item,
                    fontSize = 25.sp,
                    color = Color.Blue,
                    fontStyle = FontStyle.Normal,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun HorizontalListExample() {

    val items = listOf("Java", "Kotlin", "C++", "Python", "Java", "Kotlin", "C++", "Python", "Java", "Kotlin", "C++", "Python")

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.Yellow)
    ) {

        items(items) { item ->

            Card(
                modifier = Modifier
                    .padding(8.dp),

                elevation = CardDefaults.cardElevation(6.dp),

                colors = CardDefaults.cardColors(
                    containerColor = Color.LightGray
                )
            ) {

                Text(
                    text = item,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(20.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen() {
    MainScreen()
}