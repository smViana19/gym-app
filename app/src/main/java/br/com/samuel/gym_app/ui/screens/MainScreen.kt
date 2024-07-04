package br.com.samuel.gym_app.ui.screens

import SignInScreen
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "register") {
        composable("register") { SignUpScreen(viewModel = hiltViewModel(), onRegisterSuccess = { navController.navigate("login") }) }
        composable("login") { SignInScreen(viewModel = hiltViewModel(), navController = navController) }
        composable("welcome") { WelcomeScreen(username = "User") } // Passar o username corretamente
    }
}