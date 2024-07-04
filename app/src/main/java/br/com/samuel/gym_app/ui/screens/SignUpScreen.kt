package br.com.samuel.gym_app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.samuel.gym_app.viewmodel.UserViewModel

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    viewModel: UserViewModel, onRegisterSuccess: () -> Unit
) {
    Column {
        var username by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
//        var confirmPassword by remember {
//            mutableStateOf("")
//        }
        TextField(
            value = username,
            onValueChange = {
                username = it
            },
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            label = {
                Text("Usuario")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "pessoa que representa usuario"
                )
            }
        )
        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            label = {
                Text("Senha")
            },
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "representacao da senh"
                )
            }
        )
//        TextField(
//            value = confirmPassword,
//            onValueChange = {
//                confirmPassword = it
//            },
//            Modifier
//                .padding(8.dp)
//                .fillMaxWidth(),
//            label = {
//                Text("Confirmar senha")
//            },
//            visualTransformation = PasswordVisualTransformation(),
//            leadingIcon = {
//                Icon(
//                    imageVector = Icons.Default.Lock,
//                    contentDescription = "representação de senha"
//                )
//            }
//        )
        Button(
            onClick = {
                viewModel.registerUser(username, password)
                onRegisterSuccess()
            },
            Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Cadastrar")
        }
    }

}

@Preview
@Composable
private fun SignUpScreenPreview() {

}