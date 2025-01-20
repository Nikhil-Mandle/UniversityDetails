package com.nikhilproject.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.nikhilproject.presentation.components.BottomSheet
import com.nikhilproject.presentation.components.HomeScreenView
import com.nikhilproject.presentation.utils.UIState
import com.nikhilproject.presentation.viewmodel.UniversityDetailsViewModel
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: UniversityDetailsViewModel = koinViewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    val bottomSheetState = rememberModalBottomSheetState()
    var isBottomSheetVisible by rememberSaveable { mutableStateOf(false) }

    val universities = when (uiState) {
        is UIState.Success -> (uiState as UIState.Success).data
        else -> emptyList()
    }

    // Carousel images and their corresponding courses
    val carouselImages = universities.map { it.coverImage }

    // Pager state for carousel
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { carouselImages.size }
    )

    // Track current university index
    val currentUniversityIndex by remember {
        derivedStateOf { pagerState.currentPage }
    }
    var userQuery by remember { mutableStateOf("") }

    LaunchedEffect(currentUniversityIndex) {
        userQuery = ""
    }

    // Dynamically update the course list
    val currentCourses = universities.getOrNull(currentUniversityIndex)?.universities.orEmpty()


    // Filter search list
    val filteredCourses = currentCourses.filter {
        it.name.contains(userQuery, ignoreCase = true) ||
                it.professor.contains(userQuery, ignoreCase = true)
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.calculateCharacterOccurrencesFromList(currentCourses)
                    isBottomSheetVisible = true
                }
            ) {
                Icon(imageVector = Icons.Default.Info, contentDescription = "Info Icon")
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { innerPadding ->

        HomeScreenView(
            modifier = Modifier.padding(innerPadding),
            pagerState = pagerState,
            carouselImage = carouselImages,
            courseList = filteredCourses,
            userQuery = userQuery,
            onSearchChange = { query -> userQuery = query }
        )
    }

    if (isBottomSheetVisible) {
        val bottomSheetData by viewModel.bottomSheetDetails.collectAsState()
        BottomSheet(
            bottomSheetDetails = bottomSheetData,
            onDismiss = { isBottomSheetVisible = false },
            modalBottomSheetState = bottomSheetState
        )
    }
}

