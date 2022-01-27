package com.navin.composelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.navin.composelearning.ui.theme.ComposeLearningTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearningTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(
                        gradient = Brush.horizontalGradient(
                            colors = listOf(
                                Color.Blue,
                                Color.DarkGray
                            )
                        )
                    )
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun Greeting(
    gradient: Brush,
    text: String = "Button"
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            onClick = {}, contentPadding = PaddingValues(),
            elevation = ButtonDefaults.elevation(defaultElevation = 6.dp, pressedElevation = 12.dp)
        ) {
            Box(
                modifier = Modifier.background(gradient)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .width(128.dp)
                    .height(46.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = text, color = Color.White)
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeLearningTheme {
        Surface(color = MaterialTheme.colors.background) {
            Greeting(
                gradient = Brush.horizontalGradient(
                    colors = listOf(
                        Color.Red,
                        Color.Cyan
                    )
                )
            )
        }
    }
}