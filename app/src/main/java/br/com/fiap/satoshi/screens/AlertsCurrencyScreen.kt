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
import androidx.compose.runtime.mutableStateListOf
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
import br.com.fiap.satoshi.model.DataNewsLetter
import br.com.fiap.satoshi.model.Newsletter
import br.com.fiap.satoshi.ui.theme.InterBold
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Composable
fun AlertsCurrencyScreen(navController: NavController) {

    val alertsList = remember { mutableStateListOf<Newsletter>() }

    val callAlerts = RetrofitFactory()
        .getCryptoService()
        .getPost()

    callAlerts.enqueue(object : Callback<DataNewsLetter> {
        override fun onResponse(
            p0: Call<DataNewsLetter>,
            response: Response<DataNewsLetter>
        ) {
            if (response.isSuccessful) {
                response.body()?.let { apiResponse ->
                    alertsList.clear()
                    apiResponse.data?.let { alertsList.addAll(it) }
                }
            } else {
                Log.e("API_ERROR", "Erro na API: ${response.errorBody()?.string()}")
            }
        }

        override fun onFailure(p0: Call<DataNewsLetter>, t: Throwable) {
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
                    Spacer(modifier = Modifier.height(20.dp))

                    ComponentNewsLetter(
                        alert = alerts.authorName,
                        date = formatDate(alerts.updatedAt),
                        coin = alerts.title,
                        onClick = { navController.navigate("newsletter") }
                    )
                }
            }
        }
    }
}

fun formatDate(isDate: String): String {
    val instant = Instant.parse(isDate)
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        .withZone(ZoneId.systemDefault())

    return formatter.format(instant)
}

//@Preview(showSystemUi = true)
//@Composable
//private fun AlertsCurrencyScreenPreview() {
//    AlertsCurrencyScreen()
//}