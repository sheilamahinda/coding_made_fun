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
import com.example.coding_made_fun.ui.theme.Screens.How_To_Play.HowToPlayScreen
import com.example.coding_made_fun.ui.theme.Screens.Login.LoginScreen
import com.example.coding_made_fun.ui.theme.Screens.Questions.QuizApp
import com.example.coding_made_fun.ui.theme.Screens.Register.RegisterScreen

import com.example.coding_made_fun.ui.theme.Screens.Result.ResultsPage
import com.example.coding_made_fun.ui.theme.Screens.splash.SplashScreen

@Composable
fun AppNavHost(modifier: Modifier=Modifier, navController: NavHostController= rememberNavController(),startDestination:String= ROUT_SPLASH) {
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

        composable(ROUT_SPLASH) {
            SplashScreen(navController)

        }
        composable(ROUT_HOWTOPLAY) {
            HowToPlayScreen(navController)

        }

    }
    }

