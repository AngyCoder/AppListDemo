package com.example.applistdemo.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Цветовая схема приложения в светлой теме
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF2C71F4),        // Синий для категорий и акцентов
    onSurface = Color(0xFF000000),      // Чёрный для названий
    onSurfaceVariant = Color(0xFF666666), // Серый для описаний
    surface = Color(0xFFFFFFFF)          // Белый для карточек
)

@Composable
fun AppListDemoTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        content = content
    )
}