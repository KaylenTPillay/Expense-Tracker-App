package com.kaylen.pillay.expensetracker.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val LightPrimaryColor = Color(0xFF6200EE)
val LightPrimaryVariantColor = Color(0xFF3700B3)
val LightSecondaryColor = Color(0xFF03DAC6)
val LightSecondaryVariantColor = Color(0xFF018786)
val LightBackgroundColor = Color(0xFFFFFFFF)
val LightSurfaceColor = Color(0xFFFFFFFF)
val LightErrorColor = Color(0xFFB00020)
val LightOnPrimaryColor = Color(0xFFFFFFFF)
val LightOnSecondaryColor = Color(0xFF000000)
val LightOnBackgroundColor = Color(0xFF000000)
val LightOnSurfaceColor = Color(0xFF000000)

val DarkPrimaryColor = Color(0xFFBB86FC)
val DarkPrimaryVariantColor = Color(0xFF3700B3)
val DarkSecondaryColor = Color(0xFF03DAC6)
val DarkSecondaryVariantColor = Color(0xFF03DAC6)
val DarkBackgroundColor = Color(0xFF121212)
val DarkSurfaceColor = Color(0xFF121212)
val DarkErrorColor = Color(0xFFCF6679)
val DarkOnPrimaryColor = Color(0xFF000000)
val DarkOnSecondaryColor = Color(0xFF000000)
val DarkOnBackgroundColor = Color(0xFFFFFFFF)
val DarkOnSurfaceColor = Color(0xFFFFFFFF)

val LightColorScheme = lightColorScheme(
    primary = LightPrimaryColor,
    onPrimary = LightOnPrimaryColor,
    primaryContainer = LightPrimaryVariantColor,
    secondary = LightSecondaryColor,
    onSecondary = LightOnSecondaryColor,
    secondaryContainer = LightSecondaryVariantColor,
    background = LightBackgroundColor,
    onBackground = LightOnBackgroundColor,
    surface = LightSurfaceColor,
    onSurface = LightOnSurfaceColor,
    error = LightErrorColor,
    onError = LightOnPrimaryColor
)

val DarkColorScheme = darkColorScheme(
    primary = DarkPrimaryColor,
    onPrimary = DarkOnPrimaryColor,
    primaryContainer = DarkPrimaryVariantColor,
    secondary = DarkSecondaryColor,
    onSecondary = DarkOnSecondaryColor,
    secondaryContainer = DarkSecondaryVariantColor,
    background = DarkBackgroundColor,
    onBackground = DarkOnBackgroundColor,
    surface = DarkSurfaceColor,
    onSurface = DarkOnSurfaceColor,
    error = DarkErrorColor,
    onError = DarkOnPrimaryColor
)
