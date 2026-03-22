package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color
import com.example.myapplication.ui.theme.MyApplicationTheme

class Progressbar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProgressBarScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ProgressBarScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Indeterminate Linear Progress
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .border(1.dp, Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            IndeterminateLinearProgress()
        }

        // Circular Progress
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .border(1.dp, Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text("Circular Progress")
                CircularProgressBarEx()
            }
        }

        // Determinate Circular Progress (NEW)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .border(1.dp, Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            CircularDeterminateProgress()
        }

        // Linear Progress
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .border(1.dp, Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            LinearProgressBar()
        }
    }
}


@Composable
fun LinearProgressBar() {
    var progress by remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    progress += 0.1f
                    if (progress > 1f) progress = 0f
                }
            ) {
                Text("Add")
            }

            Text("${(progress * 100).toInt()}%")
        }
    }
}


@Composable
fun IndeterminateLinearProgress() {
    LinearProgressIndicator(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
}


@Composable
fun CircularProgressBarEx() {
    CircularProgressIndicator(
        modifier = Modifier.size(60.dp),
        strokeWidth = 6.dp
    )
}


// ✅ NEW: Determinate Circular Progress (very important in real apps)
@Composable
fun CircularDeterminateProgress() {
    var progress by remember { mutableStateOf(0f) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CircularProgressIndicator(
            progress = progress,
            modifier = Modifier.size(80.dp),
            strokeWidth = 6.dp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text("${(progress * 100).toInt()}%")

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                progress += 0.1f
                if (progress > 1f) progress = 0f
            }
        ) {
            Text("Increase")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewProgressBar() {
    MyApplicationTheme {
        ProgressBarScreen()
    }
}