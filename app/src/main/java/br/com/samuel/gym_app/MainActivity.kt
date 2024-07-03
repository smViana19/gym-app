package br.com.samuel.gym_app

import SignIn
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.samuel.gym_app.ui.screens.MainScreen
import br.com.samuel.gym_app.ui.screens.SignUpScreen
import br.com.samuel.gym_app.ui.theme.GymappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GymappTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "main/{user}") {
                        composable("main/{user}") { entry ->
                            entry.arguments?.getString("user")?.let { user ->
                                MainScreen(user = user)
                            } ?: LaunchedEffect(null) {
                                navController.navigate("signIn")
                            }
                        }
                        composable("signIn") {
                            SignIn(
                                onSignInClick = {user ->
                                    navController.navigate("main/${user.username}")
                                },
                                onSignUpClick = {
                                    navController.navigate("signUp")
                                }
                            )
                        }
                        composable("signUp") {
                            SignUpScreen(
                                onSignUpClick = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}





