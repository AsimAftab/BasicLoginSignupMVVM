package com.example.basicloginsignupmvvm.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, logo: Painter) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp) // No padding to ensure full-screen image
            .background(Color.White)
    ) {
        Image(
            painter = logo,
            contentDescription = "App Logo",
            modifier = Modifier
                .fillMaxSize() // Make the image fill the entire screen
        )
    }

    // Simulate loading and then navigate to the onboarding screen
    LaunchedEffect(Unit) {
        delay(3000) // Simulate a 3-second splash screen
        navController.navigate("onboarding") {
            // Clear splash screen from the back stack
            popUpTo("splash") { inclusive = true }
        }
    }
}
