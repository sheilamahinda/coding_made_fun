package com.example.coding_made_fun.ui.theme.Screens.Result

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.coding_made_fun.data.QuizViewModel
import com.example.coding_made_fun.ui.theme.Screens.Home.Homescreen

@Composable
fun ResultsPage(navController: NavHostController,  viewModel: QuizViewModel, onReturnHome: () -> Unit) {
    val navController = rememberNavController()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "RESULTS HERE",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Your Score: ${viewModel.getScore()} / ${viewModel.getTotalQuestions()}",
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Button(
            onClick = { onReturnHome() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Return to Home")
        }
    }
}

@Preview
@Composable
fun ResultsPagePreview() {
    val navController = rememberNavController() // Create a NavController instance
    val viewModel = QuizViewModel() // Create a ViewModel instance

    // Call the ResultsPage composable with the required parameters
    ResultsPage(
        navController = navController,
        viewModel = viewModel,
        onReturnHome = {}
    )
}



