package br.com.fiap.satoshi.screens

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.satoshi.R

@Composable
fun MenuScreen() {

    var inputSearchMenu by remember {

        mutableStateOf(value = "")

    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.primary))
    ) {
        Column(modifier = Modifier.fillMaxSize().verticalScroll(ScrollState(0))) {
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
                        Image(
                            painter = painterResource(R.drawable.notification_icon),
                            contentDescription = "Notification Icon",
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(5.dp)
                                .clickable { }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = inputSearchMenu,
                    onValueChange = { inputSearchMenu = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Search") },
                    trailingIcon = {
                        Image(
                            painter = painterResource(R.drawable.search_icon),
                            contentDescription = "Search Icon",
                            modifier = Modifier.clickable {  }
                        )
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        unfocusedContainerColor = colorResource(R.color.secondary),
                        focusedContainerColor = colorResource(R.color.secondary),
                        unfocusedLabelColor = Color.White,
                        focusedLabelColor = Color.White,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White
                    ),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words)
                )

                Spacer(modifier = Modifier.height(35.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CryptoCard("Bitcoin", "$27,130", "+2.35%", R.drawable.bitcoin)
                    CryptoCard("Ethereum", "$1,920", "+1.75%", R.drawable.ethereum)
                    CryptoCard("XRP", "$0.55", "-0.85%", R.drawable.xrp)
                }

                Spacer(modifier = Modifier.height(35.dp))

                Image(
                    painter = painterResource(R.drawable.btc_news),
                    contentDescription = "Bitcoin News Image",
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
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
                    Text(
                        text = stringResource(R.string.see_all),
                        color = Color(0xffF7931A),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable {  }
                    )
                }
                Row(
                    modifier = Modifier
                        .horizontalScroll(ScrollState(0)),
                    horizontalArrangement = Arrangement.SpaceEvenly
                )
                {
                    CryptoCardInfo(
                        "Ethereum",
                        "Laucnhed in 2015 by Vitalik Buterin, Ethereum introduced smart contract functionality.",
                        R.drawable.ethereum_menu_other
                    )
                    CryptoCardInfo(
                        "XRP",
                        "Unlike other cryptocurrencies, XRP is not mined; all coins were mined at lauch.",
                        R.drawable.xrp_coin
                    )
                    CryptoCardInfo(
                        "XRP",
                        "Unlike other cryptocurrencies, XRP is not mined; all coins were mined at lauch.",
                        R.drawable.xrp_coin
                    )
                    CryptoCardInfo(
                        "XRP",
                        "Unlike other cryptocurrencies, XRP is not mined; all coins were mined at lauch.",
                        R.drawable.xrp_coin
                    )
                    CryptoCardInfo(
                        "XRP",
                        "Unlike other cryptocurrencies, XRP is not mined; all coins were mined at lauch.",
                        R.drawable.xrp_coin
                    )
                }
            }

            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 25.dp)) {
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
                        Text(text = " " + stringResource(R.string.coins),
                            color = Color(0xffF7931A),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(text = stringResource(R.string.invest_consciously), color = Color.White)
                }

                Card(
                    shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
                    colors = CardDefaults.cardColors(colorResource(R.color.secondary)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(7.dp)
                    ) {

                        Image(
                            painter = painterResource(R.drawable.left_icon_bottom_bar),
                            contentDescription = "Dashboard icon",
                            modifier = Modifier.size(40.dp).clickable {  }
                        )
                        Image(
                            painter = painterResource(R.drawable.mid_icon_bottom_bar),
                            contentDescription = "Bitcoin Icon",
                            modifier = Modifier.size(40.dp).clickable {  }
                        )
                        Image(
                            painter = painterResource(R.drawable.rigth_icon_bottom_bar),
                            contentDescription = "Conversion Icon",
                            modifier = Modifier.size(40.dp).clickable {  }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CryptoCard(name: String, price: String, percentage: String, icon: Int) {
    Card(
        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.secondary)),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.size(width = 110.dp, height = 100.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .padding(bottom = 10.dp)
                    .align(Alignment.Start)
            ) {
                Image(
                    painter = painterResource(icon),
                    contentDescription = "$name Icon",
                    modifier = Modifier
                        .size(20.dp)
                        .clip(shape = CircleShape)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = name,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.horizontalScroll(ScrollState(0))
                )
            }
            Text(text = price, color = Color.White)
            Text(text = percentage, color = Color.Green)
        }
    }
}

@Composable
fun CryptoCardInfo(title: String, description: String, image: Int) {

    Card(
        colors = CardDefaults.cardColors(colorResource(R.color.secondary)),
        modifier = Modifier.size(width = 150.dp, height = 160.dp)
    ) {

        Column(modifier = Modifier.padding(10.dp)
            .verticalScroll(ScrollState(0)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "Ethereum Image"
            )

            Text(
                text = title,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Start)
            )
            Text(
                text = description,
                color = Color.White
            )
        }
    }
    Spacer(modifier = Modifier.width(30.dp))

}


@Preview(showSystemUi = true, device = "id:Galaxy Nexus")
@Composable
private fun MenuScreenPreview() {
    MenuScreen()
}

