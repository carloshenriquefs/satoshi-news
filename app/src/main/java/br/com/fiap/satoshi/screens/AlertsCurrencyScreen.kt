package br.com.fiap.satoshi.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.satoshi.R
import br.com.fiap.satoshi.components.Back.Companion.ComponentBack
import br.com.fiap.satoshi.components.Card.Companion.ComponentNewsLetter
import br.com.fiap.satoshi.components.Menu.Companion.ComponentMenu
import br.com.fiap.satoshi.components.OutlinedTextField.Companion.ComponentSearch
import br.com.fiap.satoshi.ui.theme.InterBold

@Composable
fun AlertsCurrencyScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.background))
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier.padding(40.dp)
        ) {
            ComponentBack(
                stringResource(R.string.back_icon),
                onClick = {
                    if (navController.previousBackStackEntry != null) {
                        navController.popBackStack()
                    }
                }
            )

            ComponentSearch(label = stringResource(R.string.search))

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = stringResource(R.string.newsletter),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.white),
                fontFamily = InterBold
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(ScrollState(0))
            ) {

                Spacer(modifier = Modifier.height(30.dp))

                ComponentNewsLetter(
                    alert = stringResource(R.string.alert),
                    date = stringResource(R.string.date),
                    coin = stringResource(R.string.coin),
                    onClick = { navController.navigate("newsletter") }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ComponentNewsLetter(
                    alert = stringResource(R.string.alert),
                    date = stringResource(R.string.date),
                    coin = stringResource(R.string.coin),
                    onClick = { navController.navigate("newsletter") }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ComponentNewsLetter(
                    alert = stringResource(R.string.alert),
                    date = stringResource(R.string.date),
                    coin = stringResource(R.string.coin),
                    onClick = { navController.navigate("newsletter") }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ComponentNewsLetter(
                    alert = stringResource(R.string.alert),
                    date = stringResource(R.string.date),
                    coin = stringResource(R.string.coin),
                    onClick = { navController.navigate("newsletter") }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ComponentNewsLetter(
                    alert = stringResource(R.string.alert),
                    date = stringResource(R.string.date),
                    coin = stringResource(R.string.coin),
                    onClick = { navController.navigate("newsletter") }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ComponentNewsLetter(
                    alert = stringResource(R.string.alert),
                    date = stringResource(R.string.date),
                    coin = stringResource(R.string.coin),
                    onClick = { navController.navigate("newsletter") }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ComponentNewsLetter(
                    alert = stringResource(R.string.alert),
                    date = stringResource(R.string.date),
                    coin = stringResource(R.string.coin),
                    onClick = { navController.navigate("newsletter") }
                )
            }
        }

        ComponentMenu(
            leftIcon = painterResource(R.drawable.left_icon_bottom_bar),
            midIcon = painterResource(R.drawable.mid_icon_bottom_bar),
            rightIcon = painterResource(R.drawable.rigth_icon_bottom_bar),
            onLeftClick = { navController.navigate("alerts") },
            onMidClick = { navController.navigate("home") },
            onRightClick = { navController.navigate("conversion") }
        )
    }
}

//@Preview(showSystemUi = true)
//@Composable
//private fun AlertsCurrencyScreenPreview() {
//    AlertsCurrencyScreen()
//}