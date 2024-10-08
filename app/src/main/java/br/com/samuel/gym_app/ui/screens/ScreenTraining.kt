package br.com.samuel.gym_app.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.samuel.gym_app.constants.ConstantsApp.APP_NAME
import br.com.samuel.gym_app.ui.theme.Colors.OrangeLight
import br.com.samuel.gym_app.ui.theme.Colors.Primary
import br.com.samuel.gym_app.ui.theme.Colors.White

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScreenTraining() {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = OrangeLight)
                    .statusBarsPadding(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /*TODO BACK DASHBOARD*/ }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = "",
                        tint = White
                    )
                }
                Text(
                    text = APP_NAME,
                    fontSize = 18.sp,
                    color = White,
                    fontWeight = FontWeight.Bold
                )

                IconButton(onClick = { /*TODO DIALOG OPÇÕES DO APP*/ }) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "",
                        tint = White
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(text = "Bem Vindo, Usuário!")


//                Button(
//                    onClick = { /*TODO*/ },
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    shape = RoundedCornerShape(4.dp),
//                    colors = ButtonDefaults.buttonColors(Primary),
//                    elevation = ButtonDefaults.elevatedButtonElevation(5.dp)
//                ) {
//                    Text(text = "TREINO A | PEITO")
//                }
            }


        }
    }
}


@Preview
@Composable
private fun ScreenTrainingPreview() {
    ScreenTraining()
}