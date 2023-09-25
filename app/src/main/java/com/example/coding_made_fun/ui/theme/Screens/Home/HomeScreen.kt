package com.example.coding_made_fun.ui.theme.Screens.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.coding_made_fun.R
import com.example.coding_made_fun.navigation.ROUTE_QUESTIONS
import com.example.coding_made_fun.navigation.ROUT_HOWTOPLAY
import com.example.coding_made_fun.navigation.ROUT_LOGIN
import com.google.android.engage.common.datamodel.Image

@Composable
fun Homescreen(navController: NavHostController) {
    val context = LocalContext.current
    val backgroundDrawable =
        painterResource(id = R.drawable.screen9) // Replace with your background image resource

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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var context = LocalContext.current


            Text(
                text = "WELCOME!",
                color = Color.Black,
                fontFamily = FontFamily.Monospace,
                fontSize = 50.sp
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

            Button(onClick = { navController.navigate(ROUT_HOWTOPLAY) }) {
                Text(text = "HOW TO PLAY")
            }


        }
    }


}
    @Preview
    @Composable
    fun Homepreview() {
        Homescreen(rememberNavController())


    }