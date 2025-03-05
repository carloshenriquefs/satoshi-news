package br.com.fiap.satoshi.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.fiap.satoshi.R

class Icons {

    companion object {

        @Composable
        fun FloatingCryptoIcons() {
            Box() {
                Image(
                    painter = painterResource(id = R.drawable.binance),
                    contentDescription = "Binance Icon",
                    modifier = Modifier
                        .size(50.dp)
                        .absoluteOffset(x = 190.dp, y = 16.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.tron),
                    contentDescription = "Tron Icon",
                    modifier = Modifier
                        .size(55.dp)
                        .absoluteOffset(x = -185.dp, y = -20.dp)
                        .align(Alignment.TopEnd)
                )
                Image(
                    painter = painterResource(id = R.drawable.doge),
                    contentDescription = "Doge Icon",
                    modifier = Modifier
                        .size(55.dp)
                        .absoluteOffset(x = 190.dp, y = -130.dp)
                        .align(Alignment.BottomStart)
                )
                Image(
                    painter = painterResource(id = R.drawable.xrp),
                    contentDescription = "XRP Icon",
                    modifier = Modifier
                        .size(55.dp)
                        .absoluteOffset(x = -185.dp, y = -180.dp)
                        .align(Alignment.BottomEnd)
                )
                Image(
                    painter = painterResource(id = R.drawable.chainlink),
                    contentDescription = "Chainlink Icon",
                    modifier = Modifier
                        .size(60.dp)
                        .absoluteOffset(x = 186.dp, y = -300.dp)
                        .align(Alignment.BottomStart)
                )
                Image(
                    painter = painterResource(id = R.drawable.ethereum),
                    contentDescription = "Ethereum Icon",
                    modifier = Modifier
                        .size(50.dp)
                        .absoluteOffset(x = -190.dp, y = -350.dp)
                        .align(Alignment.BottomEnd)
                )
                Image(
                    painter = painterResource(id = R.drawable.tether),
                    contentDescription = "Tether Icon",
                    modifier = Modifier
                        .size(55.dp)
                        .absoluteOffset(x = 1.dp, y = -410.dp)
                        .align(Alignment.TopEnd)
                )
            }
        }
    }
}
