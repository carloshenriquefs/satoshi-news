package br.com.fiap.satoshi.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import br.com.fiap.satoshi.R
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.satoshi.components.Back.Companion.ComponentBack
import br.com.fiap.satoshi.components.Button.Companion.ComponentButton
import br.com.fiap.satoshi.components.OutlinedTextField.Companion.ComponentInboxPassword
import br.com.fiap.satoshi.ui.theme.InterRegular
import br.com.fiap.satoshi.utils.RegexUtils

@Composable
fun ForgotPasswordScreen(navController: NavController) {

    var password by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf(false) }

    var passwordConfirmed by remember { mutableStateOf("") }
    var passwordConfirmedError by remember { mutableStateOf(false) }

    var resetPasswordError by remember { mutableStateOf<String?>(null) }

    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.background))
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 50.dp),
            contentAlignment = Alignment.TopStart

        ) {
            ComponentBack(
                stringResource(R.string.back_icon),
                onClick = {
                    if (navController.previousBackStackEntry != null) {
                        navController.popBackStack()
                    }
                }
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 40.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.Start

                ) {
                    Text(
                        text = stringResource(R.string.create_password),
                        fontSize = 26.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = colorResource(id = R.color.white),
                        fontFamily = InterRegular
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.Start

                ) {
                    Text(
                        text = stringResource(R.string.password_different),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = R.color.white),
                        fontFamily = InterRegular
                    )
                }

                Spacer(modifier = Modifier.height(25.dp))

                ComponentInboxPassword(
                    label = stringResource(R.string.password),
                    placeholder = stringResource(R.string.input_password),
                    value = password,
                    onValueChange = { password = it },
                    isError = passwordError,
                    errorMessage = stringResource(R.string.password_required)
                )

                Spacer(modifier = Modifier.height(10.dp))

                ComponentInboxPassword(
                    label = stringResource(R.string.confirm_password),
                    placeholder = stringResource(R.string.confirm_password),
                    value = passwordConfirmed,
                    onValueChange = { passwordConfirmed = it },
                    isError = passwordConfirmedError,
                    errorMessage = stringResource(R.string.confirm_password_required)
                )

                if (resetPasswordError != null) {
                    Text(
                        text = resetPasswordError!!,
                        color = Color.Red,
                        fontSize = 14.sp
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                ComponentButton(
                    label = stringResource(R.string.reset_password),
                    onClick = {
                        passwordError = !RegexUtils.isValidPassword(password)
                        passwordConfirmedError = !RegexUtils.isValidPassword(passwordConfirmed)

                        if (passwordError) {
                            resetPasswordError =
                                "\nPassword must be at least 8 characters \nand contain letters and."
                        } else if (passwordConfirmedError) {
                            resetPasswordError = "Passwords do not match"
                        } else {
                            resetPasswordError = null
                            navController.navigate("success")
                        }
                    }
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ForgotPasswordScreenPreview() {
    val fakeNavController = rememberNavController()
    ForgotPasswordScreen(navController = fakeNavController)
}
