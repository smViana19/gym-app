package br.com.samuel.gym_app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.com.samuel.gym_app.ui.theme.GymappTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GymappTheme {

            }
        }
    }
}

//public Products(@Nonnull ApiDatabase apiDatabase) {
//    try {
//        this.codigo = Integer.parseInt(apiDatabase.getCodigo());
//    } catch (NumberFormatException e) {
//        this.codigo = null; // ou algum valor padrão, como 0
//    }
//    this.descricao = apiDatabase.getDescricao();
//}



