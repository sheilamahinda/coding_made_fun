package com.example.coding_made_fun.ui.theme.Screens.Questions

import android.app.VoiceInteractor.PickOptionRequest.Option
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coding_made_fun.data.Apiviewmodel
import com.example.coding_made_fun.data.QuizViewModel
import com.example.coding_made_fun.navigation.ROUTE_HOME
import com.example.coding_made_fun.navigation.ROUTE_RESULTS
import com.example.coding_made_fun.ui.theme.Screens.Result.ResultsPage


@Composable
fun QuizApp(navController: NavHostController){
    val navController = rememberNavController()
    val viewModel: QuizViewModel = viewModel()
    val currentQuestion = viewModel.getCurrentQuestion()
    var selectedOptionIndex by remember { mutableStateOf(-1)

    }
    // Check if the quiz is finished
    if (viewModel.isQuizFinished()) {
        // Navigate back to the home screen
        navController.navigate("ResultsPage")
    }

    val options = listOf(
        Option("London", isCorrect = false),
        Option("Berlin", isCorrect = false),
        Option("Paris", isCorrect = true),
        Option("Madrid", isCorrect = false)
    )




    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Question ${currentQuestion.id}",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = currentQuestion.questionText,
            modifier = Modifier.padding(bottom = 16.dp)
        )


        currentQuestion.options.forEachIndexed { index, option ->
            QuizOption(
                option = option,
                isSelected = index == selectedOptionIndex,
                isCorrect = option == currentQuestion.options[currentQuestion.correctAnswer],
                onOptionSelected = {
                    selectedOptionIndex = index
                }
            )
        }



        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val isCorrect = viewModel.checkAnswer(selectedOptionIndex)
                if (!isCorrect) {
                    // Handle incorrect answer (e.g., show a message)
                Color.Green
                }else{
                    Color.Red
                }
                selectedOptionIndex = -1 // Reset selected option
                if (!viewModel.isQuizFinished()) {
                    viewModel.moveToNextQuestion()
                } else {selectedOptionIndex != -1
                    // Handle quiz completion (e.g., show a score)
                    (viewModel.isQuizFinished())
                        navController.navigate(ROUTE_HOME)


                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Next")
        }
        Button(
            onClick = {
                // Handle the end of the quiz, e.g., navigate back to the home screen
                navController.navigate(ROUTE_HOME)
            }, modifier = Modifier.align(Alignment.Start)
        ) {
            Text("Back")
        }

    }
//    NavHost(
//        navController = navController,
//        startDestination = ROUTE_HOME
//    ) {
//        // ... Other routes ...
//
//        composable(ROUTE_RESULTS) {
//            ResultsPage(
//                navController = navController,
//                viewModel = viewModel,
//                onReturnHome = { navController.navigate(ROUTE_HOME) }
//            )
//        }
//    }

}



@Composable
fun QuizOption(
    option: String,
    isSelected: Boolean,

    onOptionSelected: () -> Unit
) {
    val backgroundColor = if (isSelected) Color.Gray else Color.White
    var onOptionSelected by remember { mutableStateOf<Option?>(null) }
    var isCorrect by remember { mutableStateOf(false)
    }



    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onOptionSelected() }
            .padding(8.dp)
            .background(backgroundColor)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = isSelected,
            onClick = { onOptionSelected()
               },
            colors = RadioButtonDefaults.colors(
                selectedColor = if (isSelected) {
                    if (isCorrect) Color.Green else Color.Red
                } else {
                    Color.Black
                }
            )
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = option

        )
    }
    Spacer(modifier = Modifier.height(16.dp))


    // Display a message based on whether the selected answer is correct or not
    if (onOptionSelected != null) {
        val message = if (isCorrect) "Correct Answer!" else "Wrong Answer!"
        Text(text = message, color = if (isCorrect) Color.Green else Color.Red)
    }
}
data class Option(val text: String, val isCorrect: Boolean)
@Preview
@Composable
fun QuizAppPreview() {

    QuizApp(rememberNavController())
}


