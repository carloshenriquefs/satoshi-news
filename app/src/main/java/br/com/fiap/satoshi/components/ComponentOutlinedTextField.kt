package br.com.fiap.satoshi.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import br.com.fiap.satoshi.R

class ComponentOutlinedTextField {

    companion object {

        @Composable
        fun ComponentLogin(modifier: Modifier = Modifier) {
            var email = remember {
                mutableListOf("")
            }

            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.width(280.dp).height(50.dp),
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
                )
            )

            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.width(280.dp).height(50.dp),
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
                )
            )
        }

        @Composable
        fun ComponentSignUp(modifier: Modifier = Modifier) {
            var email = remember {
                mutableListOf("")
            }

            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.width(280.dp).height(50.dp),
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
                )
            )

            OutlinedTextField(
                value = "",
                onValueChange = {},
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
                )
            )

            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.width(280.dp).height(50.dp),
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
                )
            )
        }
    }
}

