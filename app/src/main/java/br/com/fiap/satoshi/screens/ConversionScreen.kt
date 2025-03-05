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
import br.com.fiap.satoshi.components.Card
import br.com.fiap.satoshi.components.Menu
import br.com.fiap.satoshi.components.OutlinedTextField
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

            OutlinedTextField.ComponentSearch()

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

                    Card.ConvertCard(R.drawable.binance, "Binance")

                    Spacer(modifier = Modifier.width(10.dp))

                    Card.ConvertCard(R.drawable.money, "USD")
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row() {

                    Card.ConvertCard("1")

                    Spacer(modifier = Modifier.width(10.dp))

                    Card.ConvertCard("2000")
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
                    Card.TopCryptoCard(
                        R.drawable.bitcoin,
                        "Bitcoin",
                        "$27,130",
                        "+2.35%",
                        "$3,124.22",
                        "0.1912343",
                        "BTC"
                    )

                    Card.TopCryptoCard(
                        R.drawable.binance,
                        "Binance",
                        "$27,130",
                        "+2.35%",
                        "$3,124.22",
                        "0.1912343",
                        "BNC"
                    )

                    Card.TopCryptoCard(
                        R.drawable.xrp,
                        "XRP",
                        "$27,130",
                        "+2.35%",
                        "$3,124.22",
                        "0.1912343",
                        "XRP"
                    )

                    Card.TopCryptoCard(
                        R.drawable.tether,
                        "Tether",
                        "$27,130",
                        "+2.35%",
                        "$3,124.22",
                        "0.1912343",
                        "Teather"
                    )

                    Card.TopCryptoCard(
                        R.drawable.tron,
                        "Tron",
                        "$27,130",
                        "+2.35%",
                        "$3,124.22",
                        "0.1912343",
                        "Tron"
                    )
                }
            }
        }
    }

    Menu.ComponentMenu(
        painterResource(R.drawable.left_icon_bottom_bar),
        painterResource(R.drawable.mid_icon_bottom_bar),
        painterResource(R.drawable.rigth_icon_bottom_bar)
    )

}

@Preview(showSystemUi = true)
@Composable
private fun ConversionScreenPreview() {
    ConversionScreen()
}