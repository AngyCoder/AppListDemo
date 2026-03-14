package com.example.applistdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.applistdemo.data.DataSource
import com.example.applistdemo.domain.appdetails.AppDetails
import com.example.applistdemo.domain.appdetails.Category
import com.example.applistdemo.presentation.appdetails.AppDetailsScreen
import com.example.applistdemo.ui.navigation.APP_DETAILS_ROUTE
import com.example.applistdemo.ui.navigation.APP_LIST_ROUTE
import com.example.applistdemo.ui.navigation.appDetailsRoute
import com.example.applistdemo.ui.screens.AppListScreen
import com.example.applistdemo.ui.theme.AppListDemoTheme

// Главное для приложения, управление навигацией.

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppListDemoTheme {
                // Навигационный контроллер для управления переходами между экранами
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = APP_LIST_ROUTE // Стартовый экран - список приложений
                ) {
                    // Экран со списком приложений
                    composable(route = APP_LIST_ROUTE) {
                        AppListScreen(
                            apps = DataSource.appList,
                            onAppClick = { app ->
                                // При клике на приложение переходим на экран деталей
                                navController.navigate(appDetailsRoute(app.id))
                            }
                        )
                    }

                    // Экран с деталями приложения
                    composable(route = APP_DETAILS_ROUTE) { backStackEntry ->
                        // Извлекаем appId из аргументов навигации
                        val appId = backStackEntry.arguments?.getString("appId")?.toIntOrNull()
                        // Находим приложение по ID в источнике данных
                        val app = DataSource.appList.find { it.id == appId }

                        if (app != null) {
                            // Преобразуем App в AppDetails с дополнительной информацией
                            val appDetails = createAppDetails(app)
                            AppDetailsScreen(
                                appDetails = appDetails,
                                onBackClick = {
                                    navController.popBackStack() // Возврат на предыдущий экран
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

/**
 * Функция для создания объекта AppDetails из базового App
 * Добавляет дополнительную информацию, для детального просмотра
 */

private fun createAppDetails(app: com.example.applistdemo.data.App): AppDetails {
    return AppDetails(
        id = app.id.toString(),
        name = app.name,
        developer = when (app.id) {
            1 -> "Сбер"
            2 -> "Яндекс"
            3 -> "Mail.ru Group"
            4 -> "Яндекс"
            5 -> "МТС"
            6 -> "Яндекс"
            else -> "Разработчик"
        },
        category = when (app.category) {
            "Финансы" -> Category.FINANCE
            "Инструменты" -> Category.UTILITIES
            "Транспорт" -> Category.MAPS
            "Социальные сети" -> Category.SOCIAL
            "Магазин приложений" -> Category.APP
            else -> Category.APP
        },
        ageRating = when (app.id) {
            1 -> 18
            2 -> 12
            3 -> 12
            4 -> 6
            5 -> 12
            6 -> 12
            else -> 12
        },
        size = when (app.id) {
            1 -> 145.8f
            2 -> 89.3f
            3 -> 112.5f
            4 -> 156.2f
            5 -> 98.7f
            6 -> 67.4f
            else -> 100f
        },
        iconResId = app.iconResId,
        screenshotResIds = when (app.id) {
            1 -> listOf(
                R.drawable.sber_screenshot_1,
                R.drawable.sber_screenshot_2,
                R.drawable.sber_screenshot_3
            )
            2 -> listOf(
                R.drawable.browser_screenshot_1,
                R.drawable.browser_screenshot_2
            )
            3 -> listOf(
                R.drawable.mail_screenshot_1,
                R.drawable.mail_screenshot_2
            )
            4 -> listOf(
                R.drawable.navigator_screenshot_1,
                R.drawable.navigator_screenshot_2,
                R.drawable.navigator_screenshot_3
            )
            5 -> listOf(
                R.drawable.mts_screenshot_1,
                R.drawable.mts_screenshot_2
            )
            6 -> listOf(
                R.drawable.yandex_screenshot_1,
                R.drawable.yandex_screenshot_2
            )
            else -> listOf()
        },
        description = app.description
    )
}