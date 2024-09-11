package br.com.samuel.gym_app.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
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
import br.com.samuel.gym_app.ui.components.SimpleCard
import br.com.samuel.gym_app.ui.components.TrainingCard
import br.com.samuel.gym_app.ui.theme.Colors.OrangeLight
import br.com.samuel.gym_app.ui.theme.Colors.White

/**
 * Tela que exibe um campo de texto para inserir um CPF.
 */

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenDashboard() {
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
                IconButton(onClick = { /*TODO MINHA FREQUENCIA*/ }) {
                    Icon(
                        imageVector = Icons.Filled.DateRange,
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
            Spacer(
                modifier = Modifier
                    .padding(top = 32.dp)
            )
           TrainingCard(exerciseName = "Supino", sets = 3, reps = 12) {
               
           }
            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.End

            ) {
                FloatingActionButton(
                    onClick = { },
                    containerColor = OrangeLight
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
            Spacer(modifier = Modifier.padding(16.dp))

        }

    }
}

@Preview
@Composable
private fun ScreenDashboardPreview() {
    ScreenDashboard()

}

