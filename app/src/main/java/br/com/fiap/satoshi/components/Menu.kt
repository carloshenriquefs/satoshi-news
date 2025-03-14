package br.com.fiap.satoshi.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import br.com.fiap.satoshi.R


class Menu {

    companion object {

        @Composable
        fun ComponentMenu(
            leftIcon: Painter,
            midIcon: Painter,
            rightIcon: Painter,
            onLeftClick: () -> Unit,
            onMidClick: () -> Unit,
            onRightClick: () -> Unit,
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.height(20.dp))

                Card(
                    shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
                    colors = CardDefaults.cardColors(colorResource(R.color.secondary)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(7.dp)
                    ) {

                        Image(
                            painter = leftIcon,
                            contentDescription = "Dashboard icon",
                            modifier = Modifier
                                .size(40.dp)
                                .clickable { onLeftClick() }
                        )
                        Image(
                            painter = midIcon,
                            contentDescription = "Bitcoin Icon",
                            modifier = Modifier
                                .size(40.dp)
                                .clickable { onMidClick() }
                        )
                        Image(
                            painter = rightIcon,
                            contentDescription = "Conversion Icon",
                            modifier = Modifier
                                .size(40.dp)
                                .clickable { onRightClick() }
                        )
                    }
                }
            }
        }
    }
}

