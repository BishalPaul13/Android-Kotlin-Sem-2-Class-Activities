package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class Activity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                UiComponent()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UiComponent() {

    val items = listOf("Select Category", "Languages", "Frameworks", "Databases")

    val progLangs = listOf(
        "Java",
        "Kotlin",
        "Python",
        "C++",
        "JavaScript",
        "C",
        "C#",
        "PHP",
        "Swift",
        "Go",
    )

    val techs = listOf(
        "Android" to Icons.Default.Android,
        "Flutter" to Icons.Default.Build,
        "React" to Icons.Default.Face,
        "Firebase" to Icons.Default.Favorite,
        "MongoDB" to Icons.Default.Home,
        "NodeJS" to Icons.Default.Star
    )

    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf(items[0]) }

    val greenBg = Color(0xFFE8F5E9)
    val primaryGreen = Color(0xFF2E7D32)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Android UI Components",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = primaryGreen,
                    titleContentColor = Color.White
                )
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(greenBg)
                .padding(padding)
                .padding(16.dp)
        ) {

            /* Dropdown */

            Box(
                modifier = Modifier.fillMaxWidth()
            ) {

                OutlinedTextField(
                    value = selectedItem,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Category") },
                    trailingIcon = {
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = "dropdown",
                            modifier = Modifier.clickable { expanded = !expanded }
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expanded = true }
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.fillMaxWidth()
                ) {

                    items.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(item) },
                            onClick = {
                                selectedItem = item
                                expanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            /* Programming Languages */

            Text(
                text = "Programming Languages",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = primaryGreen,
                modifier = Modifier.padding(bottom = 10.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {

                items(progLangs) { item ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        elevation = CardDefaults.cardElevation(6.dp),
                        shape = MaterialTheme.shapes.large,
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        )
                    ) {

                        Text(
                            text = item,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(16.dp),
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            /* Tech Grid */

            Text(
                text = "Technology Grid",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = primaryGreen,
                modifier = Modifier.padding(bottom = 10.dp)
            )

            LazyHorizontalGrid(
                rows = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(techs) { (name, icon) ->

                    Card(
                        modifier = Modifier.size(110.dp),
                        elevation = CardDefaults.cardElevation(8.dp),
                        shape = MaterialTheme.shapes.large
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.White),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {

                            Icon(
                                imageVector = icon,
                                contentDescription = name,
                                modifier = Modifier.size(36.dp),
                                tint = primaryGreen
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = name,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MyApplicationTheme {
        UiComponent()
    }
}