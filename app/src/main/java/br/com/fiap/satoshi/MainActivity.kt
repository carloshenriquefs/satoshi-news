package br.com.fiap.satoshi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.satoshi.screens.AlertsCurrencyScreen
import br.com.fiap.satoshi.screens.ConversionScreen
import br.com.fiap.satoshi.screens.GraphsScreen
import br.com.fiap.satoshi.screens.HomeScreen
import br.com.fiap.satoshi.screens.LoginScreen
import br.com.fiap.satoshi.screens.NewsLetterScreen
import br.com.fiap.satoshi.screens.SatoshiNewsScreen
import br.com.fiap.satoshi.screens.SignUpScreen
import br.com.fiap.satoshi.ui.theme.SatoshiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SatoshiTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "satoshi"
                    ) {
                        composable(route = "satoshi") { SatoshiNewsScreen(navController) }
                        composable(route = "login") { LoginScreen(navController) }
                        composable(route = "signup") { SignUpScreen(navController) }
                        composable(route = "home") { HomeScreen(navController) }
                        composable(route = "graphs/{id}") {
                            val id = it.arguments?.getString("id")
                            GraphsScreen(navController, id!!) }
                        composable(route = "alerts") { AlertsCurrencyScreen(navController) }
                        composable(route = "newsletter") { NewsLetterScreen(navController) }
                        composable(route = "conversion") { ConversionScreen(navController) }
                    }
                }
            }
        }
    }
}
