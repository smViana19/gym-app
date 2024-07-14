package br.com.samuel.gym_app.ui.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "register") {
        composable("welcome") { WelcomeScreen(username = "User") } // Passar o username corretamente
    }
}