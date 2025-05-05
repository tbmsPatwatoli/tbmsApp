package com.complete.tbmsapp.ui.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import kotlin.math.absoluteValue

@Composable
fun TextComponent(text: String) {
    Box(
        Modifier
            .background(Color.Blue)
            .padding(10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.Red)
            .animateContentSize { initialValue, targetValue ->
                val sizeChange = (targetValue.height - initialValue.height).absoluteValue

                val duration = when {
                    sizeChange > 500 -> 700
                    sizeChange > 200 -> 500
                    else -> 300
                }

                tween<IntSize>(durationMillis = duration)
            }) {
        Text(text, modifier = Modifier)
    }
}

@Preview
@Composable
private fun TextComponent1() {
    TextComponent("ABC")
}