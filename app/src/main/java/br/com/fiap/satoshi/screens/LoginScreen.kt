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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.satoshi.R
import br.com.fiap.satoshi.components.ComponentOutlinedTextField
import br.com.fiap.satoshi.ui.theme.InterBold
import br.com.fiap.satoshi.ui.theme.InterRegular

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {

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
                modifier = Modifier.size(140.dp)
            )

            Text(
                text = stringResource(R.string.log_in_now),
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xffF7931A),
                fontFamily = InterBold
            )

            Text(
                text = stringResource(R.string.please_login),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xffFFFFFF),
                fontFamily = InterRegular
            )

            ComponentOutlinedTextField.ComponentLogin()

            Text(
                text = stringResource(R.string.forgot_password),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xffFFFFFF),
                fontFamily = InterRegular
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
                    text = stringResource(R.string.log_in),
                    fontSize = 16.sp,
                    color = Color(0xffFFFFFF)
                )
            }

            Row() {
                Text(
                    text = stringResource(R.string.dont_account),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xffFFFFFF),
                    fontFamily = InterRegular
                )

                Text(
                    text = stringResource(R.string.signup),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xffF7931A),
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
private fun LoginScreenPreview() {
    LoginScreen()
}
