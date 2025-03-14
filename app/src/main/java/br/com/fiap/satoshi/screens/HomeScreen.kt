package br.com.fiap.satoshi.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.satoshi.R
import br.com.fiap.satoshi.components.Card.Companion.CryptoCard
import br.com.fiap.satoshi.components.Card.Companion.CryptoCardInfo
import br.com.fiap.satoshi.components.Menu.Companion.ComponentMenu
import br.com.fiap.satoshi.components.OutlinedTextField.Companion.ComponentSearch
import br.com.fiap.satoshi.factory.RetrofitFactory
import br.com.fiap.satoshi.model.CryptoProfitable
import br.com.fiap.satoshi.model.DataProfitable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun HomeScreen(navController: NavController) {

    var inputSearchMenu by remember {

        mutableStateOf(value = "")

    }

    var cryptoTopThree by remember {

        mutableStateOf(listOf<CryptoProfitable>())
    }

    val getCryptoTopThree = RetrofitFactory()
        .getCryptoService()
        .getTopProfitable(token = "Barear "+"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2N2M0ZWRmN2UyZDFlZGJiNjE0MWQ0MjgiLCJpYXQiOjE3NDE4Njc4MTMsImV4cCI6MTc0MTg3MTQxM30.4sbEIpUTD8KN1Vx_PHkpm-rm59zqkl5fxx0hx3_bbsE")

    getCryptoTopThree.enqueue(object: Callback<DataProfitable> {
        override fun onResponse(p0: Call<DataProfitable>, resultado: Response<DataProfitable>) {
            cryptoTopThree = resultado.body()!!.data!!.subList(0,3)
        }

        override fun onFailure(p0: Call<DataProfitable>, p1: Throwable) {
            Log.i("API ERROR","Falha de Authenticação: ${p1.message}")
        }
    })

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.primary))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(ScrollState(0))
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.secondary)),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.size(30.dp)
                    ) {
                        Image(painter = painterResource(R.drawable.notification_icon),
                            contentDescription = stringResource(R.string.notification_icon),
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(5.dp)
                                .clickable { })
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                ComponentSearch(label = stringResource(R.string.search))

                Spacer(modifier = Modifier.height(35.dp))

                Column(
                    modifier = Modifier
                        .padding(bottom = 25.dp)
                ) {
                    Text(
                        text = stringResource(R.string.top_three_cryptos),
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        fontSize = 15.sp
                    )
                }

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    items(cryptoTopThree){
                        CryptoCard(name = it.name, price = "22", percentage = "+"+"%.2f".format(it.percentChange)+"%", icon = it.image, onClick = {})
                    }
//                    CryptoCard("Bitcoin", "$27,130", "+2.35%", )
//                    CryptoCard("Ethereum", "$1,920", "+1.75%", R.drawable.ethereum)
//                    CryptoCard("XRP", "$0.55", "-0.85%", R.drawable.xrp)
                }

                Spacer(modifier = Modifier.height(35.dp))

                Image(
                    painter = painterResource(R.drawable.btc_news),
                    contentDescription = stringResource(R.string.crypto_news),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate("alerts")
                        }
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(25.dp)
                ) {
                    Text(
                        text = stringResource(R.string.other_crypto),
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        fontSize = 15.sp
                    )
                    Text(text = stringResource(R.string.see_all),
                        color = Color(0xffF7931A),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable { })
                }
                Row(
                    modifier = Modifier.horizontalScroll(ScrollState(0)),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CryptoCardInfo(
                        title = "Ethereum",
                        description = "Laucnhed in 2015 by Vitalik Buterin, " +
                                "Ethereum introduced smart contract functionality.",
                        image = R.drawable.ethereum_menu_other,
                        onClick = { navController.navigate("graphs") }
                    )

                    CryptoCardInfo(
                        title = "XRP",
                        description = "Unlike other cryptocurrencies, " +
                                "XRP is not mined; all coins were mined at lauch.",
                        image = R.drawable.xrp_coin,
                        onClick = { navController.navigate("graphs") }
                    )

                    CryptoCardInfo(
                        title = "XRP",
                        description = "Unlike other cryptocurrencies, " +
                                "XRP is not mined; all coins were mined at lauch.",
                        image = R.drawable.xrp_coin,
                        onClick = { navController.navigate("graphs") }
                    )

                    CryptoCardInfo(
                        title = "XRP",
                        description = "Unlike other cryptocurrencies, " +
                                "XRP is not mined; all coins were mined at lauch.",
                        image = R.drawable.xrp_coin,
                        onClick = { navController.navigate("graphs") }
                    )

                    CryptoCardInfo(
                        title = "XRP",
                        description = "Unlike other cryptocurrencies, " +
                                "XRP is not mined; all coins were mined at lauch.",
                        image = R.drawable.xrp_coin,
                        onClick = { navController.navigate("graphs") }
                    )
                }
            }

            Column(
                modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp)
                ) {
                    Text(
                        text = stringResource(R.string.green_crypto),
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Row {
                        Text(
                            text = stringResource(R.string.sustainable_future),
                            color = Color.White,
                            fontSize = 18.sp
                        )
                        Text(
                            text = " " + stringResource(R.string.coins),
                            color = Color(0xffF7931A),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(text = stringResource(R.string.invest_consciously), color = Color.White)
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

//@Preview(showSystemUi = true, device = "id:pixel_9")
//@Composable
//private fun HomeScreenPreview() {
//    HomeScreen()
//}

