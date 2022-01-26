package com.navin.composelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.navin.composelearning.ui.theme.ComposeLearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearningTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(5)
                }
            }
        }
    }
}

@Composable
fun Greeting(item: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Yellow),
        contentAlignment = Alignment.TopCenter
    ) {

        Box(
            modifier = Modifier
                .background(color = Color.Green)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "I Love Android", fontSize = 30.sp
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeLearningTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Yellow),
            contentAlignment = Alignment.Center
        ) {

            Box(
                modifier = Modifier
                    .width(150.dp)
                    .background(color = Color.Green)
                    .verticalScroll(rememberScrollState()),
                contentAlignment = Alignment.Center
                ) {

                Box(
                    modifier = Modifier
                        .width(20.dp).height(20.dp)
                        .background(color = Color.Blue),
                    contentAlignment = Alignment.BottomCenter
                ) {

                }

                Text(
                    text = "I Love Android", fontSize = 40.sp
                )
            }
        }
    }
}