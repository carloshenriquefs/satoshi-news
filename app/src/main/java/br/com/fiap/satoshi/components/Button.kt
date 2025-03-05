package br.com.fiap.satoshi.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.satoshi.R

class Button {

    companion object {

        @Composable
        fun ComponentLetsGetStarted() {
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(top = 32.dp)
                    .size(width = 280.dp, height = 45.dp),
                colors = ButtonDefaults.buttonColors(Color.Black),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = stringResource(R.string.lets_started),
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.white)
                )
            }
        }

        @Composable
        fun ComponentButtonLogin() {
            Button(
                onClick = {
                    //navController.navigate("menu")
                },
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
        }

        @Composable
        fun ComponentButtonSignUp() {
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(top = 32.dp)
                    .size(width = 280.dp, height = 45.dp),
                colors = ButtonDefaults.buttonColors(Color.Black),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = stringResource(R.string.signup),
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.white)
                )
            }
        }
    }
}

