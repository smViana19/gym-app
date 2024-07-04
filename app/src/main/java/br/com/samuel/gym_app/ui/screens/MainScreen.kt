package br.com.samuel.gym_app.ui.screens

import SignInScreen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen(user: String) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "register") {
        composable("register") { SignUpScreen(viewModel = hiltViewModel(), onRegisterSuccess = { navController.navigate("login") }) }
        composable("login") { SignInScreen(viewModel = hiltViewModel(), onLoginSuccess = { /* Do something on login success */ }) }
    }
}