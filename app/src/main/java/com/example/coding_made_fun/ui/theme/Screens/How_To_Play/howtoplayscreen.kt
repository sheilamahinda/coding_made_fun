package com.example.coding_made_fun.ui.theme.Screens.How_To_Play

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.coding_made_fun.R
import com.example.coding_made_fun.navigation.ROUTE_HOME
import com.example.coding_made_fun.navigation.ROUTE_QUESTIONS
import com.example.coding_made_fun.ui.theme.Screens.splash.SplashScreen


@Composable
fun HowToPlayScreen(navController: NavHostController) {
    var context = LocalContext.current
    val backgroundDrawable =
        painterResource(id = R.drawable.screen6) // Replace with your background image resource

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = backgroundDrawable,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        // Define your UI elements here
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "How to Play",
                modifier = Modifier.padding(16.dp),
                fontFamily = FontFamily.Monospace,
                color = Color.Black,
                fontSize = 40.sp
            )

            // Add explanations, images, or any other information about how to play the quiz.

            Text(
                text = "Welcome to the Quiz App!",
                modifier = Modifier.padding(bottom = 16.dp),
                fontFamily = FontFamily.Monospace,
                color = Color.Black,
                fontSize = 30.sp
            )

            Text(
                text = "Instructions:",
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "1. These are easy questions with choices.",
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "2. You have all the time to answer each question.",
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "3. Read each question carefully to give the right answer",
                color = Color.Black,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Have fun",
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "And good luck",
                color = Color.Black,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // You can add more instructions and information about the quiz rules here.

            Button(
                onClick = {
                    run { navController.navigate(ROUTE_HOME) }
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "BACK")
            }
        }
    }
}
@Preview
@Composable
fun HowToPlayScreenPreview() {
    HowToPlayScreen(rememberNavController())

}
