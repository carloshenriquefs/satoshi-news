package br.com.fiap.satoshi.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.satoshi.R
import br.com.fiap.satoshi.components.Button.Companion.ComponentButton
import br.com.fiap.satoshi.components.OutlinedTextField.Companion.ComponentInbox
import br.com.fiap.satoshi.components.OutlinedTextField.Companion.ComponentInboxPassword
import br.com.fiap.satoshi.ui.theme.InterBold
import br.com.fiap.satoshi.ui.theme.InterRegular

@Composable
fun LoginScreen(navController: NavController) {

    var email by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf(false) }

    var password by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf(false) }

    var rememberPassword by remember { mutableStateOf(false) }

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

            ComponentInbox(
                label = stringResource(R.string.email),
                placeholder = stringResource(R.string.input_email),
                value = email,
                onValueChange = { email = it },
                isError = emailError,
                errorMessage = "E-mail Required"
            )

            ComponentInboxPassword(
                label = stringResource(R.string.password),
                placeholder = stringResource(R.string.input_password),
                value = password,
                onValueChange = { password = it },
                isError = passwordError,
                errorMessage = "Password Required"
            )

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Checkbox(
                    checked = rememberPassword,
                    onCheckedChange = { rememberPassword = it },
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

            ComponentButton(
                label = stringResource(R.string.log_in),
                onClick = {
                    emailError = email.isBlank()
                    passwordError = password.isBlank()

                    if (!emailError && !passwordError) {
                        navController.navigate("home")
                    }
                }
            )

            Row() {
                Text(
                    text = stringResource(R.string.dont_account),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white),
                    fontFamily = InterRegular
                )

                Text(
                    text = stringResource(R.string.signup),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.yellow_bitcoin),
                    fontFamily = InterBold,
                    modifier = Modifier.clickable {
                        navController.navigate("signup")
                    }
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

//@Preview(showSystemUi = true)
//@Composable
//private fun LoginScreenPreview() {
//    LoginScreen()
//}
