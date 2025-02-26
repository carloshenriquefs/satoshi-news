package br.com.fiap.satoshi.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import br.com.fiap.satoshi.R

class ComponentOutlinedTextField {

    companion object {

        @Composable
        fun ComponentLogin() {
            var email by remember {
                mutableStateOf("")
            }

            var password by remember {
                mutableStateOf("")
            }

            OutlinedTextField(
                value = email,
                onValueChange = { letra ->
                    email = letra
                },
                modifier = Modifier
                    .width(280.dp)
                    .height(50.dp),
                singleLine = true,
                label = {
                    Text(text = stringResource(R.string.email))
                },
                placeholder = {
                    Text(text = stringResource(R.string.input_email))
                },
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedTextColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { letra ->
                    password = letra
                },
                modifier = Modifier
                    .width(280.dp)
                    .height(50.dp),
                singleLine = true,
                label = {
                    Text(text = stringResource(R.string.password))
                },
                placeholder = {
                    Text(text = stringResource(R.string.input_password))
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.eye),
                        contentDescription = "ícone de senha",
                        Modifier.width(30.dp)
                    )
                },
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedTextColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
        }

        @Composable
        fun ComponentSignUp() {
            var name by remember {
                mutableStateOf("")
            }

            var email by remember {
                mutableStateOf("")
            }

            var password by remember {
                mutableStateOf("")
            }

            OutlinedTextField(
                value = name,
                onValueChange = { letra ->
                    name = letra
                },
                modifier = Modifier
                    .width(280.dp)
                    .height(50.dp),
                singleLine = true,
                label = {
                    Text(text = stringResource(R.string.name))
                },
                placeholder = {
                    Text(text = stringResource(R.string.input_name))
                },
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedTextColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words)
            )

            OutlinedTextField(
                value = email,
                onValueChange = { letra ->
                    email = letra
                },
                modifier = Modifier
                    .width(280.dp)
                    .height(50.dp),
                singleLine = true,
                label = {
                    Text(text = stringResource(R.string.email))
                },
                placeholder = {
                    Text(text = stringResource(R.string.input_email))
                },
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedTextColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { letra ->
                    password = letra
                },
                modifier = Modifier
                    .width(280.dp)
                    .height(50.dp),
                singleLine = true,
                label = {
                    Text(text = stringResource(R.string.password))
                },
                placeholder = {
                    Text(text = stringResource(R.string.input_password))
                },
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedTextColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
        }
    }
}

