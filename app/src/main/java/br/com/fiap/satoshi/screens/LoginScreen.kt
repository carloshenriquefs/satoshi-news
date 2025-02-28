package br.com.fiap.satoshi.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import br.com.fiap.satoshi.components.ComponentOutlinedTextField
import br.com.fiap.satoshi.ui.theme.InterBold
import br.com.fiap.satoshi.ui.theme.InterRegular

@Composable
fun LoginScreen() {

    var password = remember {
        mutableStateOf(true)
    }

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
                modifier = Modifier.size(140.dp)
            )

            Text(
                text = stringResource(R.string.log_in_now),
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold,
                color = colorResource(id = R.color.yellow_bitcoin),
                fontFamily = InterBold
            )

            Text(
                text = stringResource(R.string.please_login),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = colorResource(id = R.color.white),
                fontFamily = InterRegular
            )

            ComponentOutlinedTextField.ComponentLogin()

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Checkbox(
                    checked = password.value,
                    onCheckedChange = { password.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.White,
                        uncheckedColor = Color.White
                    )
                )

                Text(
                    text = stringResource(R.string.forgot_password),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white),
                    fontFamily = InterRegular,
                    textAlign = TextAlign.Center
                )
            }


            Button(
                onClick = {},
                modifier = Modifier
                    .size(width = 280.dp, height = 45.dp),
                colors = ButtonDefaults.buttonColors(Color.Black),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = stringResource(R.string.log_in),
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.white)
                )
            }

            Row() {
                Text(
                    text = stringResource(R.string.dont_account),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white),
                    fontFamily = InterRegular
                )

                Text(
                    text = stringResource(R.string.signup),
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
private fun LoginScreenPreview() {
    LoginScreen()
}
