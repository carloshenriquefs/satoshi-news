package br.com.fiap.satoshi.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import br.com.fiap.satoshi.R

class OutlinedTextField {

    companion object {

        @Composable
        fun ComponentLogin(emailField: String, passwordField: String) {
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
                    Text(
                        text = emailField,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.input_email),
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                },
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White

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
                textStyle = TextStyle(color = Color.White),
                singleLine = true,
                label = {
                    Text(
                        text = passwordField,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.input_password),
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.eye),
                        contentDescription = stringResource(R.string.icon_password),
                        Modifier
                            .width(30.dp)
                            .padding(end = 7.dp),
                        tint = Color(255, 255, 255, 255),
                    )
                },
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White

                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
        }

        @Composable
        fun ComponentSignUp(nameField: String, emailField: String, passwordField: String) {
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
                    Text(
                        text = nameField,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.input_name),
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                },
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
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
                    Text(
                        text = emailField,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.input_email),
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                },
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
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
                    Text(
                        text = passwordField,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.input_password),
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                },
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
        }

        @Composable
        fun ComponentSearch() {
            var inputSearchMenu by remember {

                mutableStateOf(value = "")

            }

            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = inputSearchMenu,
                onValueChange = { inputSearchMenu = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Search") },
                trailingIcon = {
                    Image(
                        painter = painterResource(R.drawable.search_icon),
                        contentDescription = "Search Icon",
                        modifier = Modifier.clickable { }
                    )
                },
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    unfocusedContainerColor = colorResource(R.color.secondary),
                    focusedContainerColor = colorResource(R.color.secondary),
                    unfocusedLabelColor = Color.White,
                    focusedLabelColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words)
            )
        }
    }
}

