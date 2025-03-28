package br.com.fiap.satoshi.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.satoshi.R
import br.com.fiap.satoshi.components.Button.Companion.ComponentButton
import br.com.fiap.satoshi.ui.theme.InterRegular

@Composable
fun SuccessPasswordScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.background))
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .size(width = 160.dp, height = 160.dp),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.secondary)
                )
            ) {

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.password),
                        contentDescription = stringResource(R.string.bitcoin_logo),
                        modifier = Modifier.size(120.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = stringResource(R.string.congratulations),
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = colorResource(id = R.color.white),
                fontFamily = InterRegular
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(R.string.password_updated),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = colorResource(id = R.color.white),
                fontFamily = InterRegular
            )

            Spacer(modifier = Modifier.height(40.dp))

            ComponentButton(
                label = stringResource(R.string.login),
                onClick = { navController.navigate("login") }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun SuccessPasswordScreenPreview() {
    val fakeNavController = rememberNavController()
    SuccessPasswordScreen(navController = fakeNavController)
}
