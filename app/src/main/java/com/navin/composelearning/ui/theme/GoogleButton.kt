package com.navin.composelearning.ui.theme

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.navin.composelearning.R

@ExperimentalMaterialApi
@Composable
fun GoogleButton(
    text: String = "Sign Up with Google",
    loadingText: String = "Creating Account..."
) {
    var clicked by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            onClick = {
                clicked = !clicked
            },
            shape = Shapes.medium,
            border = BorderStroke(width = 1.dp, color = Color.LightGray),
//        modifier = Modifier.padding(8.dp),
            color = MaterialTheme.colors.surface,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(5.dp)
                    .animateContentSize(
                        animationSpec = tween(
                            durationMillis = 300,
                            easing = LinearOutSlowInEasing
                        )
                    ),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.google_drawable),
                    contentDescription = "Description",
                    modifier = Modifier.width(45.dp).height(45.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = if (clicked) loadingText else text, fontSize = 24.sp)
                if (clicked) {
                    Spacer(modifier = Modifier.width(16.dp))
                    CircularProgressIndicator(
                        modifier = Modifier.width(16.dp).height(16.dp),
                        strokeWidth = 2.dp,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                }
            }

        }
    }

}

@ExperimentalMaterialApi
@Composable
@Preview
fun GoogleButtonPreview() {
    GoogleButton()
}