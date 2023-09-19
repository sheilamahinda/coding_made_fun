package com.example.coding_made_fun.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coding_made_fun.data.QuizViewModel
import com.example.coding_made_fun.ui.theme.Screens.Home.Homescreen
import com.example.coding_made_fun.ui.theme.Screens.Login.LoginScreen
import com.example.coding_made_fun.ui.theme.Screens.Questions.QuizApp
import com.example.coding_made_fun.ui.theme.Screens.Register.RegisterScreen

import com.example.coding_made_fun.ui.theme.Screens.Result.ResultsPage

@Composable
fun AppNavHost(modifier: Modifier=Modifier, navController: NavHostController= rememberNavController(),startDestination:String= ROUTE_HOME) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        composable(ROUT_LOGIN) {
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER) {
            RegisterScreen(navController)
        }
        composable(ROUTE_HOME) {
            Homescreen(navController)

        }
        composable(ROUTE_QUESTIONS) {
            QuizApp(navController)


        }
        composable(ROUTE_RESULTS) {
            ResultsPage(
                navController = navController, // Provide the navController
                viewModel = QuizViewModel(), // Provide the viewModel
                onReturnHome = { /* Define the behavior when returning to the home screen */navController.navigate(ROUTE_HOME) }
            )
        }




    }
    }

