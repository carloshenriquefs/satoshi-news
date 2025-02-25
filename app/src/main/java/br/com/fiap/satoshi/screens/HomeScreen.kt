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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.satoshi.R

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .background(color = Color(0xff131E2E))
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
                contentDescription = "Bitcoin Logo",
                modifier = Modifier.size(180.dp)
            )


            Text(
                text = "SatoshiNews",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xffF7931A),
                modifier = Modifier.padding(bottom = 16.dp),
                //fontFamily = Marhey
            )


            Text(
                text = "Conectando você ao futuro\ndas finanças !",
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                color = Color(0xffF7931A),
                modifier = Modifier.padding(top = 16.dp),
                //fontFamily = Kotta
            )


            Button(
                onClick = {},
                modifier = Modifier
                    .padding(top = 32.dp),
                colors = ButtonDefaults.buttonColors(Color.Black),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Let's Get Started",
                    fontSize = 16.sp,
                    color = Color(0xffFFFFFF)
                )
            }


            Row (
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(
                    text = "Already have account ? ",
                    fontSize = 14.sp,
                    color = Color(0xffFFFFFF)
                )
                Spacer(
                    modifier = Modifier.width(4.dp)
                )
                Text(
                    text = "Sign In",
                    color = Color(0xffF7931A),
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