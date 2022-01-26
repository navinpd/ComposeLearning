package com.navin.composelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
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
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomText()
    }
}

@Composable
fun CustomText() {
    Text(
        text = stringResource(id = R.string.app_name),
        modifier = Modifier
            .background(color = MaterialTheme.colors.primary)
            .padding(16.dp)
            .width(200.dp),
        color = Color.White,
        fontSize = MaterialTheme.typography.h6.fontSize,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.End
    )
}

@Composable
fun CustomText2() {
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colors.primary,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("A")
            }
            append("B")
            append("C")
            append("D")
        }
    )
}

@Composable
fun CustomText3() {
    SelectionContainer {
        Column {
            Text(
                text = "Hello World"
                    .repeat(20),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(horizontal = 5.dp)
            )
            DisableSelection {
                Text(text = "This text is disabled from Selection")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeLearningTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomText()
            CustomText2()
            CustomText3()
        }
    }
}