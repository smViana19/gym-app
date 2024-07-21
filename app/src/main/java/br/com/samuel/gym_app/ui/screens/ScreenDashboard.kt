package br.com.samuel.gym_app.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import br.com.samuel.gym_app.utils.CpfVisualTransformation
import br.com.samuel.gym_app.utils.PhoneVisualTransformation

/**
 * Tela que exibe um campo de texto para inserir um CPF.
 */
@Composable
fun ScreenDashboard() {
    var phone by remember {
        mutableStateOf("")
    }
    TextField(
        value = phone,
        onValueChange = { newValue ->
            // Aceita apenas números e limita o comprimento
            if (newValue.all { it.isDigit() } && newValue.length < 12) {
                phone = newValue
            }
        },
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        label = {
            Text(text = "CPF")
        },
        visualTransformation = PhoneVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )

}

