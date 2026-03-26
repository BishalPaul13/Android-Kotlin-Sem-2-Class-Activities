package com.example.myapplication

import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class Practice : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MainScreen1()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreen1(){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HorizontalList()
        VerticalList()
    }
}

@Composable
fun VerticalList(){
    val feats = listOf("Android", "Kotlin", "Jetpack Compose", "Material3", "Android", "Kotlin", "Jetpack Compose", "Material3", "Android", "Kotlin", "Jetpack Compose", "Material3")

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
            .padding(16.dp)
    ) {
        items(feats) { feat ->
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
                    text = feat,
                    fontSize = 25.sp,
                    color = Color.Blue,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}


@Composable
fun HorizontalList(){
    val feats = listOf("Java", "Kotlin", "C++", "Python", "Java", "Kotlin", "C++", "Python", "Java", "Kotlin", "C++", "Python")

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.Yellow)
    ) {
        items(feats) { feat ->
            Card(
                modifier = Modifier
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.LightGray
                )
            ) {
                Text(
                    text = feat,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(20.dp)
                )
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview7() {
    MyApplicationTheme {
//        VerticalList()
//        HorizontalList()
    }
}