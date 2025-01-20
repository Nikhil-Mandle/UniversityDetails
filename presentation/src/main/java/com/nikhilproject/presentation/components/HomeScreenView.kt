package com.nikhilproject.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.nikhilproject.domain.model.Course

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreenView(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    carouselImage: List<Int>,
    courseList: List<Course>,
    userQuery: String,
    onSearchChange: (String) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    LazyColumn(
        modifier = modifier
            .wrapContentHeight()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus() // Clear focus from text fields
                    keyboardController?.hide() // Hide the keyboard
                })
            }
    ) {
        item {
            CardCarousel(
                carouselItems = carouselImage,
                pagerState = pagerState
            )
        }

        stickyHeader {
            Surface(
                modifier = Modifier
                    .background(color = Color.Transparent)
                    .padding(end = 8.dp)
            ) {
                SearchBar(userQuery) { value ->
                    onSearchChange(value)
                }
            }
        }

        items(courseList) { course ->
            CardItemView(course)
        }
    }
}


