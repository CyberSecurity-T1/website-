package com.cyberleveling.core.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val DarkCyberpunkColorScheme = darkColorScheme(
    primary = NeonCyan,
    onPrimary = SystemBlack,
    primaryContainer = NeonCyanSoft,
    onPrimaryContainer = PureWhite,
    secondary = ShadowPurple,
    onSecondary = PureWhite,
    secondaryContainer = ShadowPurple.copy(alpha = 0.2f),
    onSecondaryContainer = PureWhite,
    tertiary = TerminalGreen,
    onTertiary = SystemBlack,
    background = SystemBlack,
    onBackground = PureWhite,
    surface = SystemPanel,
    onSurface = PureWhite,
    surfaceVariant = SystemPanel,
    onSurfaceVariant = MutedSlate,
    error = ErrorRed,
    onError = PureWhite,
    outline = NeonCyan.copy(alpha = 0.6f),
    outlineVariant = ShadowPurple.copy(alpha = 0.4f),
    scrim = Color.Black
)

private val CyberTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp
    ),
    displayMedium = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 45.sp,
        lineHeight = 52.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 40.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp,
        lineHeight = 36.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.08.sp
    )
)

@Composable
fun CyberLevelingTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkCyberpunkColorScheme,
        typography = CyberTypography,
        content = content
    )
}
