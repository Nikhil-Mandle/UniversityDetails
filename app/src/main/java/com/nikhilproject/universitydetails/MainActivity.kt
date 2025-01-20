package com.nikhilproject.universitydetails

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.nikhilproject.presentation.navigation.SetUpNavGraph
import com.nikhilproject.universitydetails.ui.theme.UniversityDetailsTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashscreen = installSplashScreen()
        var keepSplashScreen = true

        super.onCreate(savedInstanceState)

        splashscreen.setKeepOnScreenCondition { keepSplashScreen }
        lifecycleScope.launch {
            delay(3000)
            keepSplashScreen = false
        }

        setContent {
            UniversityDetailsTheme {
                Surface {
                    SetUpNavGraph()
                }
            }
        }
    }
}
