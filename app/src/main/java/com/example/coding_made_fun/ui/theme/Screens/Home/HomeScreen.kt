package com.example.coding_made_fun.ui.theme.Screens.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.coding_made_fun.navigation.ROUTE_QUESTIONS
import com.example.coding_made_fun.navigation.ROUTE_RESULTS
import com.example.coding_made_fun.navigation.ROUT_LOGIN

@Composable
fun Homescreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var context = LocalContext.current


        Text(
            text = "Welcome to Coding_Made_Fun",
            color = Color.Cyan,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = { navController.navigate(ROUT_LOGIN) }) {
            Text(text = "LOGIN HERE")
        }

        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = { navController.navigate(ROUTE_QUESTIONS) }) {
            Text(text = "START QUESTIONS WITHOUT LOGGING IN")
        }

        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = { navController.navigate(ROUTE_RESULTS) }) {
            Text(text = "CHECK YOUR SCORE HERE")
        }


    }
}


@Preview
@Composable
fun Homepreview() {
    Homescreen(rememberNavController())


}