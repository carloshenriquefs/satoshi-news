package br.com.fiap.satoshi.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.satoshi.R
import br.com.fiap.satoshi.ui.theme.Kotta
import br.com.fiap.satoshi.ui.theme.Marhey

@Composable
fun HomeScreen() {

    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.background))
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(R.drawable.bitcoin),
                contentDescription = stringResource(R.string.bitcoin_logo),
                modifier = Modifier.size(200.dp)
            )

            Text(
                text = stringResource(R.string.satoshi_news),
                fontSize = 28.sp,
                fontWeight = FontWeight.Medium,
                color = colorResource(id = R.color.yellow_bitcoin),
                modifier = Modifier.padding(bottom = 16.dp),
                fontFamily = Marhey
            )

            Text(
                text = stringResource(R.string.connect_finances),
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.yellow_bitcoin),
                modifier = Modifier.padding(top = 16.dp),
                fontFamily = Kotta
            )


            Button(
                onClick = {},
                modifier = Modifier
                    .padding(top = 32.dp)
                    .size(width = 280.dp, height = 45.dp),
                colors = ButtonDefaults.buttonColors(Color.Black),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = stringResource(R.string.lets_started),
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.white)
                )
            }

            Row(
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(
                    text = stringResource(R.string.already_account),
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.white)
                )
                Spacer(
                    modifier = Modifier.width(4.dp)
                )
                Text(
                    text = stringResource(R.string.signin),
                    color = colorResource(id = R.color.yellow_bitcoin),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { }
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}