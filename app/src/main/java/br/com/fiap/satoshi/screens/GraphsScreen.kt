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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.satoshi.R
import br.com.fiap.satoshi.components.Back.Companion.ComponentBack
import br.com.fiap.satoshi.components.Graphs
import br.com.fiap.satoshi.components.Menu.Companion.ComponentMenu
import br.com.fiap.satoshi.factory.RetrofitFactory
import br.com.fiap.satoshi.model.CryptoDetail
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Composable
fun GraphsScreen(navController: NavController, id: String) {

    var cryptoDetails by remember { mutableStateOf<CryptoDetail?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val getDetails = RetrofitFactory()
        .getCryptoService()
        .getDetail(
            token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2N2M0ZWRmN2UyZDFlZGJiNjE0MWQ0MjgiLCJpYXQiOjE3NDIzMjk2MTAsImV4cCI6MTc0MjMzMzIxMH0.1BlGGIKhQm0F2GGNZBAKWWkIM-IUqnngIby_4UP3NOM" +
                    "", coinId = id
        )
    getDetails.enqueue(object : Callback<CryptoDetail> {
        override fun onResponse(p0: Call<CryptoDetail>, resultado: Response<CryptoDetail>) {
            isLoading = false
            if (resultado.isSuccessful) {
                cryptoDetails = resultado.body()

            } else Log.e(
                "FIAP",
                "Erro na API: ${resultado.message()} - Código: ${resultado.code()}"
            )
        }

        override fun onFailure(p0: Call<CryptoDetail>, p1: Throwable) {
            isLoading = false
            errorMessage = "Falha na requisição: ${p1.message}"
        }
    })

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .height(180.dp),
                colors = CardDefaults.cardColors(containerColor = colorResource(R.color.secondary))
            ) {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 25.dp)
                                .align(Alignment.Start)
                        ) {
                            ComponentBack(
                                stringResource(R.string.back_icon),
                                onClick = {
                                    if (navController.previousBackStackEntry != null) {
                                        navController.popBackStack()
                                    }
                                }
                            )
                        }
                        AsyncImage(
                            model = cryptoDetails?.coinInfo?.image?.large,
                            contentDescription = "Coin Logo",
                            modifier = Modifier.clip(shape = CircleShape)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            if (isLoading) Graphs.LoadingScreen(true) else {
                errorMessage?.let {
                    Text(text = it, color = Color.Red, fontWeight = FontWeight.Bold)
                }

                cryptoDetails?.let { details ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 5.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = details.coinInfo.name,
                                fontSize = 25.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "$${details.coinInfo.tickers[0].last}",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(50.dp))

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 20.dp)
                                .verticalScroll(rememberScrollState())
                        ) {
                            Text(
                                text = "Description",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            Text(
                                text = details.coinInfo.description.en,
                                color = Color.White
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Card(
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = colorResource(R.color.secondary)),
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.chart_title),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    cryptoDetails?.marketChart?.let { chartData ->
                        Graphs.LineGraph(modifier = Modifier.padding(8.dp), marketChart = chartData)
                    } ?: run {
                        Text(
                            text = "Dados do gráfico indisponíveis",
                            color = Color.Red,
                            fontWeight = FontWeight.Bold
                        )
                    }

                }
            }
            Spacer(modifier = Modifier.height(60.dp))
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




