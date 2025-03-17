package br.com.fiap.satoshi.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.satoshi.R
import br.com.fiap.satoshi.components.Back.Companion.ComponentBack
import br.com.fiap.satoshi.components.Card.Companion.ComponentNewsLetter
import br.com.fiap.satoshi.components.Menu.Companion.ComponentMenu
import br.com.fiap.satoshi.components.OutlinedTextField.Companion.ComponentSearch
import br.com.fiap.satoshi.factory.RetrofitFactory
import br.com.fiap.satoshi.model.AlertsCurrency
import br.com.fiap.satoshi.model.AlertsResult
import br.com.fiap.satoshi.ui.theme.InterBold
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun AlertsCurrencyScreen(navController: NavController) {

    val alertsList by remember {
        mutableStateOf(listOf<AlertsCurrency>())
    }

    val callAlerts = RetrofitFactory()
        .getCryptoService()
        .getAllAlerts()

    callAlerts.enqueue(object : Callback<AlertsResult> {
        override fun onResponse(call: Call<AlertsResult>, response: Response<AlertsResult>) {
            Log.i("FIAP", "onResponse: ${response.body()}")
        }

        override fun onFailure(call: Call<AlertsResult>, t: Throwable) {
            Log.i("FIAP", "onResponse: ${t.message}")
        }
    })

    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.background))
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier.padding(40.dp)
        ) {
            ComponentBack(
                stringResource(R.string.back_icon),
                onClick = {
                    if (navController.previousBackStackEntry != null) {
                        navController.popBackStack()
                    }
                }
            )

            ComponentSearch(label = stringResource(R.string.search))

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = stringResource(R.string.newsletter),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.white),
                fontFamily = InterBold
            )

            LazyColumn {
                items(alertsList) { alerts ->

                    Spacer(modifier = Modifier.height(30.dp))

                    ComponentNewsLetter(
                        alert = alerts.title,
                        date = alerts.updatedAt,
                        coin = alerts.subtitle,
                        onClick = { navController.navigate("newsletter") }
                    )

                }
            }
        }

        ComponentMenu(
            leftIcon = painterResource(R.drawable.left_icon_bottom_bar),
            midIcon = painterResource(R.drawable.mid_icon_bottom_bar),
            rightIcon = painterResource(R.drawable.rigth_icon_bottom_bar),
            onLeftClick = { navController.navigate("alerts") },
            onMidClick = { navController.navigate("home") },
            onRightClick = { navController.navigate("conversion") }
        )
    }
}

//@Preview(showSystemUi = true)
//@Composable
//private fun AlertsCurrencyScreenPreview() {
//    AlertsCurrencyScreen()
//}