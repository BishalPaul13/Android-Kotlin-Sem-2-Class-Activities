package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class Scroll : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleScrollExample()
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun NestedScrollExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Header Section",
            fontSize = 22.sp,
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(900.dp)
        ) {
            items(40) { index ->
                Text(
                    text = "Lazy Item ${index + 1}",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                )
            }
        }

        Text(
            text = "Footer Section",
            fontSize = 22.sp,
            modifier = Modifier.padding(16.dp)
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ){
            items(20) { index ->
                Text(
                    text = "Lazy Item ${index + 1}",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleScrollExample(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.Gray)
            .padding(20.dp)
    ){
        repeat(25) {
            Text(
                text = "Scrollable item ${it + 1}",
                fontSize = 26.sp,
                color = Color.Blue,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}