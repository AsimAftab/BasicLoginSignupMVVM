package com.example.basicloginsignupmvvm.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.basicloginsignupmvvm.R
import kotlinx.coroutines.delay

@Composable
fun OnboardingScreen(navController: NavController) {
    // Define your image resources
    val images = listOf(
        painterResource(id = R.drawable.img1), // Replace with your image resource IDs
        painterResource(id = R.drawable.img2),
        painterResource(id = R.drawable.img3)
    )

    // Define your onboarding text for each image
    val texts = listOf(
        "Welcome to Our App!",
        "Discover amazing features!",
        "Enjoy a seamless experience!"
    )

    // State to keep track of the current image index
    var currentImageIndex by remember { mutableStateOf(0) }

    // Coroutine to change the image every 3 seconds
    LaunchedEffect(Unit) {
        while (true) {
            delay(3000) // 3 seconds delay
            currentImageIndex = (currentImageIndex + 1) % images.size
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        // Display the current image
        Image(
            painter = images[currentImageIndex],
            contentDescription = "Onboarding Image",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // Allow the image to take up available space
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Display the current onboarding text
        Text(
            text = texts[currentImageIndex],
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 16.dp),
            color = Color.Black,

        )

        Spacer(modifier = Modifier.height(16.dp))

        // Dot indicators
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            images.forEachIndexed { index, _ ->
                Box(
                    modifier = Modifier
                        .size(12.dp) // Increased size for better visibility
                        .padding(4.dp)
                        .background(
                            color = if (index == currentImageIndex) Color.Blue else Color.Gray,
                            shape = CircleShape
                        )
                )
            }
        }

        // Button to navigate to SignInScreen
        Button(onClick = {
            // Navigate to SignInScreen
            navController.navigate("sign_in") {
                // Clear onboarding screen from the back stack
                popUpTo("onboarding") { inclusive = true }
            }
        }) {
            Text(text = "Get Started")
        }
    }
}
