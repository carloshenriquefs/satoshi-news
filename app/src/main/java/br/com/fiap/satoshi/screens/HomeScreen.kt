package br.com.fiap.satoshi.screens

import android.app.Application
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.fiap.satoshi.R
import br.com.fiap.satoshi.components.Card.Companion.CryptoCard
import br.com.fiap.satoshi.components.Card.Companion.CryptoCardInfo
import br.com.fiap.satoshi.components.Graphs.Companion.LoadingScreen
import br.com.fiap.satoshi.components.Menu.Companion.ComponentMenu
import br.com.fiap.satoshi.components.OutlinedTextField.Companion.ComponentSearch
import br.com.fiap.satoshi.factory.HomeViewModelFactory
import br.com.fiap.satoshi.viewmodel.HomeViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = viewModel()) {

    val cryptoTopThree by viewModel.cryptoTopThree
    val cryptoSustainable by viewModel.cryptoSustainable
    val isLoading by viewModel.isLoading
    val authError by viewModel.authError

    val context = LocalContext.current
    val application = LocalContext.current.applicationContext as Application
    val homeViewModel: HomeViewModel = viewModel(
        factory = HomeViewModelFactory(application)
    )

    LaunchedEffect(Unit) {
        viewModel.loadCryptoData()
    }

    LaunchedEffect(authError) {
        if (authError) {
            Log.e("AUTH ERROR", "Token expirado, redirecionando...")
            navController.navigate("login") {
                popUpTo("home") { inclusive = true }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.primary))
    ) {
        when {
            isLoading -> {
                LoadingScreen(true)
            }

            else -> {

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
                                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            items(cryptoTopThree) {
                                CryptoCard(
                                    name = it.name,
                                    price = "%.2f".format(it.currentPrice),
                                    percentage = "+" + "%.2f".format(it.percentChange) + "%",
                                    icon = it.image,
                                    onClick = { navController.navigate("graphs/${it.id}") })
                            }

                        }

                        Spacer(modifier = Modifier.height(35.dp))

                        Image(
                            painter = painterResource(R.drawable.crypto_news),
                            contentDescription = stringResource(R.string.crypto_news),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    navController.navigate("alerts")
                                }
                                .clip(shape = RoundedCornerShape(8.dp))
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
                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            items(cryptoSustainable) {
                                CryptoCardInfo(
                                    title = it.name,
                                    image = it.image,
                                    esgScore = it.esgScore,
                                    currentPrice = it.currentPrice,
                                    marketCap = it.marketCap,
                                    onClick = { navController.navigate("graphs/${it.id}") })
                                Spacer(modifier = Modifier.width(20.dp))

                            }
                        }
                    }

                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween
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
                            Text(
                                text = stringResource(R.string.invest_consciously),
                                color = Color.White
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(50.dp))
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

