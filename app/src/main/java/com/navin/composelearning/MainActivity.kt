package com.navin.composelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    var myValue by remember { mutableStateOf(item) }
    Row(
        modifier = Modifier.fillMaxWidth().background(Color.LightGray),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment =  Alignment.CenterVertically
    ) {
//        Divider(thickness = 10.dp)
        CustomItems(3f)
//        Divider()
        CustomItems(1f, MaterialTheme.colors.onSecondary)
//        Divider()
        Button(onClick = {
            myValue++
        }) {
            Text(text = "I am $myValue")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeLearningTheme {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment =  Alignment.CenterVertically
        ) {
            CustomItems(2f)
//            Divider()
            CustomItems(1f, MaterialTheme.colors.onSecondary)
//            Divider()
//            Greeting(5)
        }

    }
}

@Composable
fun RowScope.CustomItems(weight: Float, color: Color = MaterialTheme.colors.primary) {
    Surface(
        modifier = Modifier
            .width(50.dp)
            .height(50.dp)
            .weight(weight),
        color = color
    ) { }
}

@Composable
fun ColumnScope.CustomItem(weight: Float, color: Color = MaterialTheme.colors.primary) {
    Surface(
        modifier = Modifier
            .width(50.dp)
            .weight(weight),
        color = color
    ) { }
}