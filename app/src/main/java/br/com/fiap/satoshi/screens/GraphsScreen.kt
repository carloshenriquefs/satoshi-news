package br.com.fiap.satoshi.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.satoshi.R
import br.com.fiap.satoshi.components.Back
import br.com.fiap.satoshi.components.Graphs
import br.com.fiap.satoshi.components.OutlinedTextField


@Composable
fun GraphsScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background))
    ) {

        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp)
            ) {

                Back.ComponentBack(
                    stringResource(R.string.back_icon)
                )

            }

            OutlinedTextField.ComponentSearch()

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .horizontalScroll(rememberScrollState()),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Card(
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(containerColor = colorResource(R.color.secondary))
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Image(
                            painter = painterResource(R.drawable.bitcoin),
                            contentDescription = "Coin Logo",
                            modifier = Modifier
                                .size(50.dp)
                                .padding(5.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.width(17.dp))

                Card(
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(containerColor = colorResource(R.color.secondary))
                ) {
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .width(140.dp)
                    )
                    {


                        Graphs.ProgressBar("Category", 0.3f, showPercent = false)
                        Text(text = "7.2h of 8h", color = Color.LightGray, fontSize = 13.sp)

                    }
                }

                Spacer(modifier = Modifier.width(17.dp))

                Card(
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(containerColor = colorResource(R.color.secondary))
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {

                        Graphs.MiniLineGraph()
                    }
                }


            }

            Spacer(modifier = Modifier.height(10.dp))

            Card(
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = colorResource(R.color.secondary))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .horizontalScroll(ScrollState(0)),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column() {
                        Text(
                            text = stringResource(R.string.challenge),
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(text = "XX Of Total XX", color = Color.LightGray, fontSize = 13.sp)
                    }

                    Graphs.CircularProgressBar(0.2f, modifier = Modifier.size(100.dp))
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = colorResource(R.color.secondary))
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

                    Graphs.LineGraph(modifier = Modifier.size(300.dp))


                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Card(
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = colorResource(R.color.secondary))
            ) {

                Box(contentAlignment = Alignment.Center, modifier = Modifier.height(100.dp)) {
                    Graphs.ProgressBar("Challenge1", 0.35f)
                }
            }

        }
    }

}


@Preview(showSystemUi = true, device = "id:pixel_9")
@Composable
private fun GraphScreenPreview() {
    GraphsScreen()
}