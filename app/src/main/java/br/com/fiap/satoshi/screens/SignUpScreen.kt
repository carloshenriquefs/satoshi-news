package br.com.fiap.satoshi.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import br.com.fiap.satoshi.components.Button.Companion.ComponentButtonSignUp
import br.com.fiap.satoshi.components.OutlinedTextField.Companion.ComponentSignUp
import br.com.fiap.satoshi.ui.theme.InterBold
import br.com.fiap.satoshi.ui.theme.InterRegular

@Composable
fun SignUpScreen() {

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
                contentDescription = stringResource(R.string.bitcoin_logo),
                modifier = Modifier.size(140.dp)
            )

            Text(
                text = stringResource(R.string.sign_up),
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold,
                color = colorResource(id = R.color.yellow_bitcoin),
                fontFamily = InterBold
            )

            Text(
                text = stringResource(R.string.please_signup),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = colorResource(id = R.color.white),
                fontFamily = InterRegular
            )

            ComponentSignUp(
                stringResource(R.string.name),
                stringResource(R.string.email),
                stringResource(R.string.password)
            )

            ComponentButtonSignUp()

            Row() {
                Text(
                    text = stringResource(R.string.have_account),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white),
                    fontFamily = InterRegular
                )

                Text(
                    text = stringResource(R.string.login),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.yellow_bitcoin),
                    fontFamily = InterRegular
                )
            }

            Image(
                painter = painterResource(R.drawable.google),
                contentDescription = stringResource(R.string.google),
                modifier = Modifier.size(20.dp)
            )

        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun SignUpScreenPreview() {
    SignUpScreen()
}
