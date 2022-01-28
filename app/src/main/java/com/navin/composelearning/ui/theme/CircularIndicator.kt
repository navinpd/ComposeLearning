package com.navin.composelearning.ui.theme

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomComponent(
    canvasSize: Dp = 300.dp,
    indicatorValue: Int = 0,
    maxIndicatorValue: Int = 100,
    backgroundIndicatorColor: Color = MaterialTheme.colors.onSurface.copy(alpha = 0.1f),
    foregroundIndicatorColor: Color = MaterialTheme.colors.primary,
    backgroundIndicatorStrokeWidth: Float = 80f,
    foregroundIndicatorStrokeWidth: Float = 120f,
    frontWidth: Float = 24f
) {
    var animatedIndicatorValue by remember { mutableStateOf(0f) }
    var allowedIndicatorValue by remember { mutableStateOf(indicatorValue) }
    if (indicatorValue > maxIndicatorValue)
        allowedIndicatorValue = maxIndicatorValue
    else
        allowedIndicatorValue = indicatorValue
    LaunchedEffect(key1 = allowedIndicatorValue) {
        animatedIndicatorValue = allowedIndicatorValue.toFloat()
    }
    val percentage = (animatedIndicatorValue / maxIndicatorValue) * 100
    val sweepAngle by animateFloatAsState(
        targetValue = (2.4 * percentage).toFloat(),
        animationSpec = tween(
            durationMillis = 1000,
            delayMillis = 100,
        )
    )
    Column(
        modifier = Modifier.size(canvasSize).drawBehind {
            val componentSize = size / 1.25f
            backgroundIndicator(
                componentSize = componentSize,
                indicatorColor = backgroundIndicatorColor,
                indicatorStrokeWidth = backgroundIndicatorStrokeWidth
            )
            foregroundIndicator(
                componentSize = componentSize,
                indicatorColor = foregroundIndicatorColor,
                indicatorStrokeWidth = foregroundIndicatorStrokeWidth,
                sweepAngle = sweepAngle
            )
        }, verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Remaining",
            fontSize = 24.sp,
            fontWeight = MaterialTheme.typography.h2.fontWeight,
            color = Color.Blue,
        )
        Text(
            text = "$indicatorValue GB",
            fontSize = 24.sp,
            fontWeight = MaterialTheme.typography.h2.fontWeight,
            color = Color.Blue,
        )

    }

}

fun DrawScope.backgroundIndicator(
    componentSize: androidx.compose.ui.geometry.Size,
    indicatorColor: Color,
    indicatorStrokeWidth: Float
) {
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 150f,
        sweepAngle = 240f,
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Square
        ), useCenter = false,
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f,
        )
    )
}


fun DrawScope.foregroundIndicator(
    componentSize: androidx.compose.ui.geometry.Size,
    indicatorColor: Color,
    indicatorStrokeWidth: Float,
    sweepAngle: Float
) {
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 150f,
        sweepAngle = sweepAngle,
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Round
        ), useCenter = false,
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f,
        )
    )
}

@Composable
@Preview
fun CustomComponentPreview() {
    CustomComponent()
}