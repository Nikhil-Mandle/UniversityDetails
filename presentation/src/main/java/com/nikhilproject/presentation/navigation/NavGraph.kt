package com.nikhilproject.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nikhilproject.presentation.screens.HomeScreen

@Composable
fun SetUpNavGraph() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Home) {
        composable<Home> {
            HomeScreen()
        }
    }
}
