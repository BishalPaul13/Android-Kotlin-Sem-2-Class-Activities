package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class Grids : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Task1()
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun GridExample() {
    val items = (1..16).map{"item $it"}

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        items(items) { item ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .height(120.dp),
                elevation = CardDefaults.cardElevation(6.dp),
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Text(text = item, fontSize = 18.sp)
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun Task1() {

    val sem1 = listOf("C", "C++", "Java")
    val sem2 = listOf("Android", ".NET", "Database")

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Sem 1",
                fontSize = 18.sp
            )

            LazyColumn {
                items(sem1) { item ->
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .height(100.dp)
                            .fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(6.dp)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Text(text = item, fontSize = 18.sp)
                        }
                    }
                }
            }
        }

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Sem 2",
                fontSize = 18.sp
            )

            LazyColumn {
                items(sem2) { item ->
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .height(100.dp)
                            .fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(6.dp)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Text(text = item, fontSize = 18.sp)
                        }
                    }
                }
            }
        }
    }
}
