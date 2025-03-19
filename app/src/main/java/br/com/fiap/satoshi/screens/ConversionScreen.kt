package br.com.fiap.satoshi.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
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
import br.com.fiap.satoshi.components.Card.Companion.ConvertCard
import br.com.fiap.satoshi.components.Card.Companion.TopCryptoCard
import br.com.fiap.satoshi.components.Menu.Companion.ComponentMenu
import br.com.fiap.satoshi.factory.RetrofitFactory
import br.com.fiap.satoshi.model.CryptoSustainable
import br.com.fiap.satoshi.model.DataCryptoSustainable
import br.com.fiap.satoshi.ui.theme.InterBold
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun ConversionScreen(navController: NavController) {

    val conversionList = remember { mutableStateListOf<CryptoSustainable>() }

    val callConversion = RetrofitFactory()
        .getCryptoService()
        .getAllConversion()

    callConversion.enqueue(object : Callback<DataCryptoSustainable> {
        override fun onResponse(
            call: Call<DataCryptoSustainable>,
            response: Response<DataCryptoSustainable>
        ) {
            if (response.isSuccessful) {
                response.body()?.let { crypto ->
                    conversionList.clear()
                    crypto.data?.let { conversionList.addAll(it) }
                }
            } else {
                Log.e("API_ERROR", "Erro na API: ${response.errorBody()?.string()}")
            }
        }

        override fun onFailure(p0: Call<DataCryptoSustainable>, t: Throwable) {
            Log.e("API_ERROR", "Falha na requisição: ${t.message}")
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

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = stringResource(R.string.convert_currency),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.white),
                    fontFamily = InterBold
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row() {

                    ConvertCard(
                        icon = R.drawable.binance,
                        coin = "Binance"
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    ConvertCard(
                        icon = R.drawable.money,
                        coin = "USD"
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    ConvertCard(value = "1")

                    Spacer(modifier = Modifier.width(10.dp))

                    ConvertCard(value = "2000")
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = stringResource(R.string.top_crypto),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.white),
                    fontFamily = InterBold
                )

                Spacer(modifier = Modifier.height(10.dp))

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()

                        .weight(1f)

                ) {
                    items(conversionList) { conversion ->
                        TopCryptoCard(
                            icon = conversion.image,
                            name = conversion.name,
                            valueDolar = "$27,130",
                            priceChange = "+2.35%",
                            price = "${conversion.marketCap}",
                            amountOwned = "${conversion.currentPrice}",
                            tickerSymbol = conversion.symbol
                        )
                    }
                }
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

//@Preview(showSystemUi = true)
//@Composable
//private fun ConversionScreenPreview() {
//    ConversionScreen()
//}