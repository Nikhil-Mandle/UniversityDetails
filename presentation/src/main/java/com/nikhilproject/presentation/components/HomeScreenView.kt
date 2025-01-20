package com.nikhilproject.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
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
                    focusManager.clearFocus()
                    keyboardController?.hide()
                })
            }
            .animateContentSize()
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
            AnimatedVisibility(
                visible = true,
                enter = fadeIn(animationSpec = tween(durationMillis = 3000)) +
                        slideInVertically(animationSpec = tween(durationMillis = 3000)) { it / 2 },
                exit = fadeOut(animationSpec = tween(durationMillis = 3000)) +
                        slideOutVertically(animationSpec = tween(durationMillis = 3000)) { it / 2 }
            ) {
                CardItemView(course)
            }
        }
    }
}