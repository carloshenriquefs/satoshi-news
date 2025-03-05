package br.com.fiap.satoshi.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.fiap.satoshi.R

class Back {

    companion object {

        @Composable
        fun ComponentBack(icon: String) {
            Card(
                colors = CardDefaults.cardColors(containerColor = colorResource(R.color.secondary)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .size(30.dp)
            ) {
                Column(
                    modifier = Modifier.padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.back),
                        contentDescription = icon,
                        modifier = Modifier
                            .width(18.dp)
                            .height(18.dp)
                    )
                }
            }
        }
    }
}