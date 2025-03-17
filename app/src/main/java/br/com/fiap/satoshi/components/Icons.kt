package br.com.fiap.satoshi.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.fiap.satoshi.R
import kotlinx.coroutines.delay

class Icons {
    companion object {
        @Composable
        fun FloatingCryptoIcons() {
            val cryptoIcons = listOf(
                Triple(R.drawable.binance, 370.dp, 445.dp),
                Triple(R.drawable.tron, -15.dp, 425.dp),
                Triple(R.drawable.doge, 370.dp, 265.dp),
                Triple(R.drawable.xrp, -15.dp, 240.dp),
                Triple(R.drawable.chainlink, 370.dp, 110.dp),
                Triple(R.drawable.ethereum, -15.dp, 80.dp),
                Triple(R.drawable.tether, 180.dp, 1.dp)
            )

            var isVisible by remember { mutableStateOf(false) }

            LaunchedEffect(Unit) {
                delay(400)
                isVisible = true
            }

            Box(modifier = Modifier.fillMaxSize()) {
                cryptoIcons.forEachIndexed { index, (icon, targetX, targetY) ->
                    AnimatedCryptoIcon(icon, targetX, targetY, isVisible, index * 200)
                }
            }
        }

        @Composable
        fun AnimatedCryptoIcon(iconRes: Int, targetX: Dp, targetY: Dp, isVisible: Boolean, delayTime: Int) {
            val startX = when {
                targetX > 0.dp -> targetX + 200.dp // Ícones à direita entram da direita
                targetX < 0.dp -> targetX - 200.dp // Ícones à esquerda entram da esquerda
                else -> targetX // Ícones centrais não movem na horizontal
            }

            val animatedX by animateDpAsState(
                targetValue = if (isVisible) targetX else startX,
                animationSpec = tween(durationMillis = 1000, delayMillis = delayTime, easing = FastOutSlowInEasing),
                label = "X Animation"
            )

            val animatedY by animateDpAsState(
                targetValue = if (isVisible) targetY else targetY - 200.dp, // Todos descem de cima
                animationSpec = tween(durationMillis = 1000, delayMillis = delayTime, easing = FastOutSlowInEasing),
                label = "Y Animation"
            )

            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .absoluteOffset(x = animatedX, y = animatedY)
            )
        }
    }
}
