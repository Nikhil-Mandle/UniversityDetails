package com.nikhilproject.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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
            .padding(horizontal = 5.dp)
            .size(width = 10.dp, height = 3.dp)
            .background(color = color, shape = RectangleShape)
    ) {

    }
}

@Preview
@Composable
fun PreviewBreadCrumb() {
    PageIndicator(isActive = true)
}