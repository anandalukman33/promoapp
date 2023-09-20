package com.example.promobank.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.promobank.R

// Set of Material typography styles to start with
private val jetbrainsMono = FontFamily(
    Font(R.font.j_light, FontWeight.Light),
    Font(R.font.j_regular, FontWeight.Normal),
    Font(R.font.j_medium, FontWeight.Medium),
    Font(R.font.j_semi_bold, FontWeight.SemiBold),
    Font(R.font.j_bold, FontWeight.Bold),
)

// Material typography styles
val Typography = Typography(

    h4 = TextStyle(
        fontFamily = jetbrainsMono,
        fontWeight = FontWeight.W700,
        fontSize = 32.sp
    ),
    h5 = TextStyle(
        fontFamily = jetbrainsMono,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp
    ),
    h6 = TextStyle(
        fontFamily = jetbrainsMono,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = jetbrainsMono,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = jetbrainsMono,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        fontFamily = jetbrainsMono,
        fontSize = 14.sp
    )
)