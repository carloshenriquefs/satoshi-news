package br.com.fiap.satoshi.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.satoshi.R
import br.com.fiap.satoshi.components.Back.Companion.ComponentBack
import br.com.fiap.satoshi.components.Card.Companion.ComponentCardUser
import br.com.fiap.satoshi.components.Menu.Companion.ComponentMenu
import br.com.fiap.satoshi.ui.theme.InterBold

@Composable
fun NewsLetterScreen() {

    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.black))
            .fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {

            ComponentBack(
                stringResource(R.string.back_icon)
            )
        }

        Image(
            painter = painterResource(R.drawable.bitcoin_coin),
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Bitcoin",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.white),
                fontFamily = InterBold
            )

            Text(
                text = "$96.443,3",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.white),
                fontFamily = InterBold
            )
        }

        ComponentCardUser(
            user = painterResource(R.drawable.speacialist),
            name = "Palmer Willians",
            text = "Mussum Ipsum, cacilds vidis litro abertis..."
        )
    }

    ComponentMenu(
        leftIcon = painterResource(R.drawable.left_icon_bottom_bar),
        midIcon = painterResource(R.drawable.mid_icon_bottom_bar),
        rightIcon = painterResource(R.drawable.rigth_icon_bottom_bar)
    )
}

@Preview(showSystemUi = true)
@Composable
private fun NewsLetterScreenPreview() {
    NewsLetterScreen()
}