package br.com.fiap.satoshi.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.satoshi.R
import br.com.fiap.satoshi.components.Card.Companion.ConvertCard
import br.com.fiap.satoshi.components.Card.Companion.TopCryptoCard
import br.com.fiap.satoshi.components.Menu.Companion.ComponentMenu
import br.com.fiap.satoshi.components.OutlinedTextField.Companion.ComponentSearch
import br.com.fiap.satoshi.ui.theme.InterBold

@Composable
fun ConversionScreen() {

    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.background))
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier.padding(40.dp)
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = colorResource(R.color.secondary)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .size(30.dp)
            ) {
                Column(
                    modifier = Modifier.padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.back),
                        contentDescription = stringResource(R.string.back_icon),
                        modifier = Modifier
                            .width(18.dp)
                            .height(18.dp)
                    )
                }
            }

            ComponentSearch(label = stringResource(R.string.search))

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

                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {

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

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(ScrollState(0))
                ) {
                    TopCryptoCard(
                        icon = R.drawable.bitcoin,
                        name = "Bitcoin",
                        valueDolar = "$27,130",
                        priceChange = "+2.35%",
                        price = "$3,124.22",
                        amountOwned = "0.1912343",
                        tickerSymbol = "BTC"
                    )

                    TopCryptoCard(
                        icon = R.drawable.binance,
                        name = "Binance",
                        valueDolar = "$27,130",
                        priceChange = "+2.35%",
                        price ="$3,124.22",
                        amountOwned = "0.1912343",
                        tickerSymbol = "BNC"
                    )

                    TopCryptoCard(
                        icon = R.drawable.xrp,
                        name = "XRP",
                        valueDolar = "$27,130",
                        priceChange = "+2.35%",
                        price = "$3,124.22",
                        amountOwned = "0.1912343",
                        tickerSymbol = "XRP"
                    )

                    TopCryptoCard(
                        icon = R.drawable.tether,
                        name = "Tether",
                        valueDolar = "$27,130",
                        priceChange = "+2.35%",
                        price = "$3,124.22",
                        amountOwned = "0.1912343",
                        tickerSymbol = "Tether"
                    )

                    TopCryptoCard(
                        icon = R.drawable.tron,
                        name = "Tron",
                        valueDolar = "$27,130",
                        priceChange = "+2.35%",
                        price = "$3,124.22",
                        amountOwned = "0.1912343",
                        tickerSymbol = "Tron"
                    )
                }
            }
        }
    }

    ComponentMenu(
        leftIcon = painterResource(R.drawable.left_icon_bottom_bar),
        midIcon = painterResource(R.drawable.mid_icon_bottom_bar),
        rightIcon = painterResource(R.drawable.rigth_icon_bottom_bar)
    )

}

@Preview(showSystemUi = true)
@Composable
private fun ConversionScreenPreview() {
    ConversionScreen()
}