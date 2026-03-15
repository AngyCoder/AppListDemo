package com.example.applistdemo.presentation.appdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.applistdemo.R
import com.example.applistdemo.domain.appdetails.AppDetails
import com.example.applistdemo.domain.appdetails.Category
import com.example.applistdemo.ui.theme.AppListDemoTheme

/**
 * Главный экран с детальной информацией о приложении
 * Собирает все компоненты в единый интерфейс с возможностью прокрутки
 */
@Composable
fun AppDetailsScreen(
    appDetails: AppDetails,
    onBackClick: () -> Unit
) {
    var descriptionCollapsed by remember { mutableStateOf(true) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) { paddingValues ->
        // Основной контейнер с вертикальной прокруткой
        Column(
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            // Верхняя панель с кнопками назад и поделиться
            Toolbar(
                onBackClick = onBackClick,
                onShareClick = { /* Поделиться */ }
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Заголовок с иконкой, названием, разработчиком
            AppDetailsHeader(
                appDetails = appDetails,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Кнопка установки
            InstallButton(
                onClick = { /* Установить */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Скриншоты
            ScreenshotsList(
                screenshotResIds = appDetails.screenshotResIds,
                contentPadding = PaddingValues(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Описание
            AppDescription(
                description = appDetails.description,
                collapsed = descriptionCollapsed,
                onReadMoreClick = { descriptionCollapsed = !descriptionCollapsed },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp),
                color = MaterialTheme.colorScheme.outlineVariant
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Разработчик
            Developer(
                name = appDetails.developer,
                onClick = { /* Открыть профиль разработчика */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppDetailsScreenPreview() {
    val appDetails = AppDetails(
        id = "1",
        name = "СберБанк Онлайн",
        developer = "Сбер",
        category = Category.FINANCE,
        ageRating = 18,
        size = 145.8f,
        iconResId = R.drawable.ic_launcher_foreground,
        screenshotResIds = listOf(
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground
        ),
        description = "Мобильный банк"
    )
    AppListDemoTheme {
        AppDetailsScreen(
            appDetails = appDetails,
            onBackClick = {}
        )
    }
}