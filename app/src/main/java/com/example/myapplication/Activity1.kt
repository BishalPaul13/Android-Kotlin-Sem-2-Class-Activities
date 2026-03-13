package com.example.myapplication

import android.os.Bundle
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.size
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class Activity1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainFun()
        }
    }
}

@Composable
fun mainFun() {
    Column(
//        modifier = Modifier
//            .fillMaxSize()
    ){
        Text(
            text="Top 10 ICC Cricket Teams",
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF0F9D58))
                .padding(16.dp)
        )
        topImage()
        Teams()
    }
}

@Composable
fun topImage() {
    Image(
        painter = painterResource(id = R.drawable.img),
        contentDescription = "banner",
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun Teams(){
    val teams = listOf(
        Pair("India", R.drawable.india),
        Pair("New Zealand", R.drawable.nz),
        Pair("Australia", R.drawable.australia),
        Pair("England", R.drawable.england),
        Pair("South Africa", R.drawable.sa),
        Pair("Pakistan", R.drawable.pakistan),
        Pair("Sri Lanka", R.drawable.srilanka),
        Pair("Bangladesh", R.drawable.bangladesh),
        Pair("West Indies", R.drawable.wi),
        Pair("Afghanistan", R.drawable.afg)
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(8.dp)
    ) {
        itemsIndexed(teams) { index, team ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                elevation = CardDefaults.cardElevation(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "${index+1}",
                        fontSize = 22.sp,
                        modifier = Modifier.padding(end = 8.dp)
                    )

                    Image(
                        painter = painterResource(id = team.second),
                        contentDescription = team.first,
                        modifier = Modifier
                            .size(30.dp)
                            .padding(end = 8.dp)
                    )

                    Text(
                        text = team.first,
                        fontSize = 25.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    mainFun()
}