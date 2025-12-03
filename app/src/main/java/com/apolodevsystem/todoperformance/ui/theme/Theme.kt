package com.apolodevsystem.todoperformance.ui.theme
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.apolodevsystem.todoperformance.ui.theme.backgroundDark
import com.apolodevsystem.todoperformance.ui.theme.backgroundDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.backgroundDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.backgroundLight
import com.apolodevsystem.todoperformance.ui.theme.backgroundLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.backgroundLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.errorContainerDark
import com.apolodevsystem.todoperformance.ui.theme.errorContainerDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.errorContainerDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.errorContainerLight
import com.apolodevsystem.todoperformance.ui.theme.errorContainerLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.errorContainerLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.errorDark
import com.apolodevsystem.todoperformance.ui.theme.errorDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.errorDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.errorLight
import com.apolodevsystem.todoperformance.ui.theme.errorLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.errorLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.inverseOnSurfaceDark
import com.apolodevsystem.todoperformance.ui.theme.inverseOnSurfaceDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.inverseOnSurfaceDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.inverseOnSurfaceLight
import com.apolodevsystem.todoperformance.ui.theme.inverseOnSurfaceLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.inverseOnSurfaceLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.inversePrimaryDark
import com.apolodevsystem.todoperformance.ui.theme.inversePrimaryDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.inversePrimaryDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.inversePrimaryLight
import com.apolodevsystem.todoperformance.ui.theme.inversePrimaryLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.inversePrimaryLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.inverseSurfaceDark
import com.apolodevsystem.todoperformance.ui.theme.inverseSurfaceDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.inverseSurfaceDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.inverseSurfaceLight
import com.apolodevsystem.todoperformance.ui.theme.inverseSurfaceLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.inverseSurfaceLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.onBackgroundDark
import com.apolodevsystem.todoperformance.ui.theme.onBackgroundDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.onBackgroundDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.onBackgroundLight
import com.apolodevsystem.todoperformance.ui.theme.onBackgroundLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.onBackgroundLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.onErrorContainerDark
import com.apolodevsystem.todoperformance.ui.theme.onErrorContainerDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.onErrorContainerDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.onErrorContainerLight
import com.apolodevsystem.todoperformance.ui.theme.onErrorContainerLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.onErrorContainerLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.onErrorDark
import com.apolodevsystem.todoperformance.ui.theme.onErrorDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.onErrorDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.onErrorLight
import com.apolodevsystem.todoperformance.ui.theme.onErrorLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.onErrorLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.onPrimaryContainerDark
import com.apolodevsystem.todoperformance.ui.theme.onPrimaryContainerDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.onPrimaryContainerDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.onPrimaryContainerLight
import com.apolodevsystem.todoperformance.ui.theme.onPrimaryContainerLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.onPrimaryContainerLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.onPrimaryDark
import com.apolodevsystem.todoperformance.ui.theme.onPrimaryDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.onPrimaryDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.onPrimaryLight
import com.apolodevsystem.todoperformance.ui.theme.onPrimaryLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.onPrimaryLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.onSecondaryContainerDark
import com.apolodevsystem.todoperformance.ui.theme.onSecondaryContainerDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.onSecondaryContainerDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.onSecondaryContainerLight
import com.apolodevsystem.todoperformance.ui.theme.onSecondaryContainerLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.onSecondaryContainerLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.onSecondaryDark
import com.apolodevsystem.todoperformance.ui.theme.onSecondaryDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.onSecondaryDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.onSecondaryLight
import com.apolodevsystem.todoperformance.ui.theme.onSecondaryLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.onSecondaryLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.onSurfaceDark
import com.apolodevsystem.todoperformance.ui.theme.onSurfaceDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.onSurfaceDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.onSurfaceLight
import com.apolodevsystem.todoperformance.ui.theme.onSurfaceLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.onSurfaceLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.onSurfaceVariantDark
import com.apolodevsystem.todoperformance.ui.theme.onSurfaceVariantDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.onSurfaceVariantDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.onSurfaceVariantLight
import com.apolodevsystem.todoperformance.ui.theme.onSurfaceVariantLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.onSurfaceVariantLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.onTertiaryContainerDark
import com.apolodevsystem.todoperformance.ui.theme.onTertiaryContainerDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.onTertiaryContainerDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.onTertiaryContainerLight
import com.apolodevsystem.todoperformance.ui.theme.onTertiaryContainerLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.onTertiaryContainerLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.onTertiaryDark
import com.apolodevsystem.todoperformance.ui.theme.onTertiaryDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.onTertiaryDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.onTertiaryLight
import com.apolodevsystem.todoperformance.ui.theme.onTertiaryLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.onTertiaryLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.outlineDark
import com.apolodevsystem.todoperformance.ui.theme.outlineDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.outlineDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.outlineLight
import com.apolodevsystem.todoperformance.ui.theme.outlineLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.outlineLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.outlineVariantDark
import com.apolodevsystem.todoperformance.ui.theme.outlineVariantDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.outlineVariantDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.outlineVariantLight
import com.apolodevsystem.todoperformance.ui.theme.outlineVariantLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.outlineVariantLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.primaryContainerDark
import com.apolodevsystem.todoperformance.ui.theme.primaryContainerDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.primaryContainerDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.primaryContainerLight
import com.apolodevsystem.todoperformance.ui.theme.primaryContainerLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.primaryContainerLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.primaryDark
import com.apolodevsystem.todoperformance.ui.theme.primaryDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.primaryDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.primaryLight
import com.apolodevsystem.todoperformance.ui.theme.primaryLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.primaryLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.scrimDark
import com.apolodevsystem.todoperformance.ui.theme.scrimDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.scrimDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.scrimLight
import com.apolodevsystem.todoperformance.ui.theme.scrimLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.scrimLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.secondaryContainerDark
import com.apolodevsystem.todoperformance.ui.theme.secondaryContainerDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.secondaryContainerDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.secondaryContainerLight
import com.apolodevsystem.todoperformance.ui.theme.secondaryContainerLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.secondaryContainerLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.secondaryDark
import com.apolodevsystem.todoperformance.ui.theme.secondaryDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.secondaryDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.secondaryLight
import com.apolodevsystem.todoperformance.ui.theme.secondaryLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.secondaryLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceBrightDark
import com.apolodevsystem.todoperformance.ui.theme.surfaceBrightDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceBrightDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceBrightLight
import com.apolodevsystem.todoperformance.ui.theme.surfaceBrightLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceBrightLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerDark
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerHighDark
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerHighDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerHighDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerHighLight
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerHighLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerHighLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerHighestDark
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerHighestDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerHighestDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerHighestLight
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerHighestLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerHighestLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerLight
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerLowDark
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerLowDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerLowDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerLowLight
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerLowLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerLowLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerLowestDark
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerLowestDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerLowestDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerLowestLight
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerLowestLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceContainerLowestLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceDark
import com.apolodevsystem.todoperformance.ui.theme.surfaceDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceDimDark
import com.apolodevsystem.todoperformance.ui.theme.surfaceDimDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceDimDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceDimLight
import com.apolodevsystem.todoperformance.ui.theme.surfaceDimLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceDimLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceLight
import com.apolodevsystem.todoperformance.ui.theme.surfaceLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceVariantDark
import com.apolodevsystem.todoperformance.ui.theme.surfaceVariantDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceVariantDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceVariantLight
import com.apolodevsystem.todoperformance.ui.theme.surfaceVariantLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.surfaceVariantLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.tertiaryContainerDark
import com.apolodevsystem.todoperformance.ui.theme.tertiaryContainerDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.tertiaryContainerDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.tertiaryContainerLight
import com.apolodevsystem.todoperformance.ui.theme.tertiaryContainerLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.tertiaryContainerLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.tertiaryDark
import com.apolodevsystem.todoperformance.ui.theme.tertiaryDarkHighContrast
import com.apolodevsystem.todoperformance.ui.theme.tertiaryDarkMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.tertiaryLight
import com.apolodevsystem.todoperformance.ui.theme.tertiaryLightHighContrast
import com.apolodevsystem.todoperformance.ui.theme.tertiaryLightMediumContrast
import com.apolodevsystem.todoperformance.ui.theme.AppTypography

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
          val context = LocalContext.current
          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      
      darkTheme -> darkScheme
      else -> lightScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = AppTypography,
    content = content
  )
}

