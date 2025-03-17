package br.com.fiap.satoshi.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.satoshi.R
import br.com.fiap.satoshi.components.Button.Companion.ComponentButton
import br.com.fiap.satoshi.components.OutlinedTextField.Companion.ComponentInbox
import br.com.fiap.satoshi.ui.theme.InterBold
import br.com.fiap.satoshi.ui.theme.InterRegular

@Composable
fun SignUpScreen(navController: NavController) {

    var name by remember { mutableStateOf("") }
    var nameError by remember { mutableStateOf(false) }

    var email by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf(false) }

    var password by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf(false) }

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

            ComponentInbox(
                label = stringResource(R.string.name),
                placeholder = stringResource(R.string.input_name),
                value = name,
                onValueChange = { name = it },
                isError = nameError,
                errorMessage = "Name Required"
            )

            ComponentInbox(
                label = stringResource(R.string.email),
                placeholder = stringResource(R.string.input_email),
                value = email,
                onValueChange = { email = it },
                isError = emailError,
                errorMessage = "E-mail Required"
            )

            ComponentInbox(
                label = stringResource(R.string.password),
                placeholder = stringResource(R.string.input_password),
                value = password,
                onValueChange = { password = it },
                isError = passwordError,
                errorMessage = "Password Required"
            )

            ComponentButton(
                label = stringResource(R.string.sign_up),
                onClick = {
                    nameError = name.isBlank()
                    emailError = email.isBlank()
                    passwordError = password.isBlank()

                    if (!nameError && !emailError && !passwordError) {
                        navController.navigate("login")
                    }
                }
            )

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
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.yellow_bitcoin),
                    fontFamily = InterBold,
                    modifier = Modifier.clickable {
                        navController.navigate("login")
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
//private fun SignUpScreenPreview() {
//    SignUpScreen()
//}
