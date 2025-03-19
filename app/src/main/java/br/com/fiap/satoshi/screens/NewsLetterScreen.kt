package br.com.fiap.satoshi.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.satoshi.R
import br.com.fiap.satoshi.components.Back.Companion.ComponentBack
import br.com.fiap.satoshi.components.Card.Companion.ComponentCardUser
import br.com.fiap.satoshi.components.Menu.Companion.ComponentMenu
import br.com.fiap.satoshi.factory.RetrofitFactory
import br.com.fiap.satoshi.model.DataNewsLetter
import br.com.fiap.satoshi.model.Newsletter
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun NewsLetterScreen(navController: NavController) {

    var postData by remember {
        mutableStateOf<Newsletter?>(null)
    }

    val getPostData = RetrofitFactory()
        .getCryptoService()
        .getPost()

    getPostData.enqueue(object : Callback<DataNewsLetter> {
        override fun onResponse(p0: Call<DataNewsLetter>, p1: Response<DataNewsLetter>) {
            if (p1.code() == 401) navController.navigate("login")
            if (p1.body() == null) Log.e("FIAP", "RETORNO NULO") else postData =
                p1.body()?.data?.get(1)
            Log.i("FIAP", "Reusltado da API: ${p1.body()}")
            Log.i("FIAP", "Código: ${p1.code()}")
        }

        override fun onFailure(p0: Call<DataNewsLetter>, p1: Throwable) {
            println("Erro na chamada: ${p1.message}")
        }
    })

    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.black))
            .fillMaxWidth()
            .verticalScroll(ScrollState(0))
    ) {

        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {

            ComponentBack(
                stringResource(R.string.back_icon),
                onClick = {
                    if (navController.previousBackStackEntry != null) {
                        navController.popBackStack()
                    }
                }
            )
        }

        AsyncImage(
            model = postData?.image,
            contentDescription = "Conversion Icon",
            modifier = Modifier
                .fillMaxWidth()
                .size(300.dp)
                .clip(RoundedCornerShape(30.dp))
                .padding(horizontal = 16.dp),
            contentScale = ContentScale.Crop
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(R.drawable.ethereum_coin),
                contentDescription = "Carrousel Image",
                modifier = Modifier.size(60.dp)
            )

            Image(
                painter = painterResource(R.drawable.xrp_coin),
                contentDescription = "Carrousel Image",
                modifier = Modifier.size(60.dp)
            )

            Image(
                painter = painterResource(R.drawable.coin),
                contentDescription = "Carrousel Image",
                modifier = Modifier.size(60.dp)
            )

            Image(
                painter = painterResource(R.drawable.dogecoin),
                contentDescription = "Carrousel Image",
                modifier = Modifier.size(60.dp)
            )

            Image(
                painter = painterResource(R.drawable.cardano_coin),
                contentDescription = "Carrousel Image",
                modifier = Modifier.size(60.dp)
            )

        }

        postData?.let {
            ComponentCardUser(
                user = it.authorImage,
                name = it.authorName,
                text = it.article
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

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
