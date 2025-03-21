package br.com.fiap.satoshi.components

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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.satoshi.R
import br.com.fiap.satoshi.ui.theme.InterBold
import br.com.fiap.satoshi.ui.theme.InterRegular
import coil.compose.AsyncImage

class Card {

    companion object {

        @Composable
        fun ConvertCard(icon: Int, coin: String) {
            Card(
                colors = CardDefaults.cardColors(containerColor = colorResource(R.color.black_focus)),
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier.size(width = 150.dp, height = 65.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.align(Alignment.End)
                ) {

                    Image(
                        modifier = Modifier.size(35.dp),
                        painter = painterResource(icon),
                        contentDescription = "$icon Icon"
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = coin,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = InterBold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Card(
                        modifier = Modifier
                            .background(Color.Red)
                            .size(width = 35.dp, height = 65.dp),
                        shape = RoundedCornerShape(bottomEnd = 15.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(50.dp)
                                    .padding(top = 20.dp),
                                painter = painterResource(R.drawable.down),
                                contentDescription = "Down Icon"
                            )
                        }
                    }
                }
            }
        }

        @Composable
        fun ConvertCard(value: String) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .background(colorResource(R.color.black_focus))
                    .size(width = 150.dp, height = 65.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = value,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = InterBold,
                    color = Color.White
                )
            }
        }

        @Composable
        fun TopCryptoCard(
            icon: String,
            name: String,
            valueDolar: String,
            priceChange: String,
            price: String,
            amountOwned: String,
            tickerSymbol: String
        ) {
            Spacer(modifier = Modifier.height(15.dp))

            Card(
                colors = CardDefaults.cardColors(containerColor = colorResource(R.color.black_focus)),
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .size(width = 310.dp, height = 65.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    AsyncImage(
                        model = icon,
                        contentDescription = stringResource(R.string.bitcoin_logo),
                        modifier = Modifier
                            .size(40.dp)
                            .padding(start = 8.dp)
                    )

                    Spacer(modifier = Modifier.width(15.dp))

                    Column() {
                        Text(
                            text = name,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontFamily = InterBold
                        )

                        Row() {
                            Text(
                                text = valueDolar,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Light,
                                color = Color.White,
                                fontFamily = InterRegular
                            )

                            Row(
                                modifier = Modifier.padding(start = 10.dp)
                            ) {
                                Text(
                                    text = priceChange,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Green,
                                    fontFamily = InterBold
                                )
                            }
                        }
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 10.dp),
                        horizontalAlignment = Alignment.End
                    ) {

                        Text(
                            text = amountOwned + tickerSymbol,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontFamily = InterBold
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            text = price,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Light,
                            color = Color.White,
                            fontFamily = InterRegular
                        )
                    }
                }
            }
        }

        @Composable
        fun ComponentNewsLetter(
            alert: String,
            date: String,
            coin: String,
            onClick: () -> Unit
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = colorResource(R.color.black_focus)),
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
                    .clickable { onClick() }
            ) {

                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = alert,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = colorResource(id = R.color.white),
                            fontFamily = InterBold
                        )

                        Text(
                            text = date,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = colorResource(id = R.color.white),
                            fontFamily = InterRegular
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = coin,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Light,
                        color = colorResource(id = R.color.white),
                        fontFamily = InterRegular
                    )
                }
            }
        }

        @Composable
        fun ComponentCardUser(user: String, name: String, text: String) {
            Card(
                colors = CardDefaults.cardColors(containerColor = colorResource(R.color.background)),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 30.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AsyncImage(
                            model = user,
                            contentDescription = "Author Image",
                            modifier = Modifier
                                .size(60.dp)
                                .clip(shape = CircleShape),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = name,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.white),
                            fontFamily = InterBold
                        )

                        Spacer(modifier = Modifier.weight(1f))
                        IconButton(onClick = {}) {
                            Icon(
                                Icons.Default.Favorite,
                                contentDescription = "Curtir",
                                tint = Color.Red
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            text = text,
                            fontSize = 14.sp,
                            color = Color.White,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            }
        }

        @Composable
        fun CryptoCard(
            name: String,
            price: String,
            percentage: String,
            icon: String,
            onClick: () -> Unit
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = colorResource(R.color.secondary)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .size(width = 110.dp, height = 100.dp)
                    .clickable { onClick() }
            ) {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                            .padding(bottom = 10.dp)
                            .align(Alignment.Start)
                    ) {
                        AsyncImage(
                            model = icon,
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
        fun CryptoCardInfo(
            title: String,
            image: String,
            esgScore: Int,
            currentPrice: Double,
            marketCap: Long,
            onClick: () -> Unit
        ) {

            Card(
                colors = CardDefaults.cardColors(colorResource(R.color.secondary)),
                modifier = Modifier
                    .size(width = 150.dp, height = 160.dp)
                    .clickable { onClick() }
            ) {

                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .verticalScroll(ScrollState(0)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        model = image,
                        contentDescription = "$image Image",
                        modifier = Modifier
                            .clickable {
                                onClick()
                            }
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = title,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        fontSize = 20.sp,

                        )
                    Spacer(modifier = Modifier.height(10.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(R.string.esg_title) + " ",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                        )
                        Text(
                            text = esgScore.toString(),
                            color = Color(0xffF7931A),
                            fontWeight = FontWeight.Bold,
                            lineHeight = 10.sp
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(R.string.currentprice_title) + " ",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                        Text(
                            text = "$" + "%.2f".format(currentPrice),
                            color = Color(0xffF7931A),
                            fontWeight = FontWeight.Bold,
                            lineHeight = 10.sp
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(R.string.marketcap_title) + " ",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                        var marketCapF: String = when {
                            marketCap > 999_999_999 -> "%.1f".format(marketCap.toDouble() / 1000000000.0) + "B"
                            marketCap > 999_999 -> "%.1f".format(marketCap.toDouble() / 1000000.0) + "M"
                            else -> "%.1f".format(marketCap.toDouble() / 1000.0) + "K"
                        }

                        Text(
                            text = marketCapF,
                            color = Color(0xffF7931A),
                            fontWeight = FontWeight.Bold,
                            lineHeight = 10.sp
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                    }

                }
            }
        }
    }

    @Preview
    @Composable
    private fun Aa() {
        CryptoCardInfo(
            title = "Algorand",
            image = "sss",
            esgScore = 20,
            currentPrice = 2222.2,
            marketCap = 2222,
            onClick = {})
    }
}
