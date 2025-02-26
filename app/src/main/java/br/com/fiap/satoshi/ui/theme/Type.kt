package br.com.fiap.satoshi.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.com.fiap.satoshi.R

var Marhey = FontFamily(Font(R.font.marhey_bold))

var Kotta = FontFamily(Font(R.font.kotta_one))

var InterMedium = FontFamily(Font(R.font.inter_medium))

var InterBold = FontFamily(Font(R.font.inter_bold))

var InterRegular = FontFamily(Font(R.font.inter_regular))

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)