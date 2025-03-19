package br.com.fiap.satoshi.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.satoshi.R
import br.com.fiap.satoshi.components.Back.Companion.ComponentBack
import br.com.fiap.satoshi.components.Card.Companion.ComponentNewsLetter
import br.com.fiap.satoshi.components.OutlinedTextField.Companion.ComponentSearch
import br.com.fiap.satoshi.factory.RetrofitFactory
import br.com.fiap.satoshi.model.AlertsCurrency
import br.com.fiap.satoshi.model.AlertsCurrencyResponse
import br.com.fiap.satoshi.ui.theme.InterBold
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun AlertsCurrencyScreen(navController: NavController) {

    val alertsList = remember { mutableStateListOf<AlertsCurrency>() }

    val callAlerts = RetrofitFactory()
        .getCryptoService()
        .getAllAlerts(token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2N2M0ZWRmN2UyZDFlZGJiNjE0MWQ0MjgiLCJpYXQiOjE3NDIzNDEwMjgsImV4cCI6MTc0MjM0NDYyOH0.2EjIYkloRj-kFcvL1mJf6wsxuIAAOeJRgSmFwMSreBg")

    callAlerts.enqueue(object : Callback<AlertsCurrencyResponse> {
        override fun onResponse(
            call: Call<AlertsCurrencyResponse>,
            response: Response<AlertsCurrencyResponse>
        ) {
//            response.body()?.let { apiResponse ->
//                val safeAlerts = apiResponse.alerts ?: emptyList()
//                alertsList.clear()
//                alertsList.addAll(safeAlerts)
//            }
//            Log.i("FIAP", "onResponse: ${response.body()}")

            if (response.isSuccessful) {
                response.body()?.let { apiResponse ->
                    alertsList.clear() // Corrigido ✅
                    apiResponse.data?.let { alertsList.addAll(it) } // Corrigido ✅
                }
            } else {
                Log.e("API_ERROR", "Erro na API: ${response.errorBody()?.string()}")
            }
        }

        override fun onFailure(call: Call<AlertsCurrencyResponse>, t: Throwable) {
            Log.i("FIAP", "onResponse: ${t.message}")
        }
    })

    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.background))
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp)
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

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                items(alertsList) { alerts ->
                    Log.e("FIAP TESTE TELA ALERTS", alerts.toString())
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
    }
}

//@Preview(showSystemUi = true)
//@Composable
//private fun AlertsCurrencyScreenPreview() {
//    AlertsCurrencyScreen()
//}