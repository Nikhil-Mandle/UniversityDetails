package com.nikhilproject.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PageIndicator(
    isActive: Boolean
) {
    val color = if (isActive) {
        Color.Green
    } else {
        Color.Gray
    }
    Box(
        modifier = Modifier
            .padding(horizontal = 3.dp)
            .size(width = 12.dp, height = 3.dp)
            .background(color = color, shape = RoundedCornerShape(25.dp))
    )
}

@Preview
@Composable
fun PreviewPageIndicator() {
    PageIndicator(isActive = true)
}