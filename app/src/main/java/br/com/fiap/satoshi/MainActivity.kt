package br.com.fiap.satoshi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.fiap.satoshi.screens.HomeScreen
import br.com.fiap.satoshi.screens.MenuScreen
import br.com.fiap.satoshi.ui.theme.SatoshiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SatoshiTheme {
                MenuScreen()
            }
        }
    }
}



