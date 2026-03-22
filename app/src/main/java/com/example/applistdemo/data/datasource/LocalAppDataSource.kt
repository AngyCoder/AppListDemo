package com.example.applistdemo.data.datasource

import com.example.applistdemo.R
import com.example.applistdemo.data.dto.AppDetailsDto

/**
 * Локальный источник данных с хардкодными данными
 * В будущем может быть заменен на API или БД
 */
class LocalAppDataSource {

    private val apps = mapOf(
        "1" to AppDetailsDto(
            id = "1",
            name = "СберБанк Онлайн – с Салютом",
            developer = "Сбер",
            category = "Финансы",
            ageRating = 18,
            size = 145.8f,
            iconResId = R.drawable.ic_sberbank,
            screenshotResIds = listOf(
                R.drawable.sber_screenshot_1,
                R.drawable.sber_screenshot_2,
                R.drawable.sber_screenshot_3
            ),
            description = "Больше чем банк"
        ),
        "2" to AppDetailsDto(
            id = "2",
            name = "Яндекс.Браузер — с Алисой",
            developer = "Яндекс",
            category = "Инструменты",
            ageRating = 12,
            size = 89.3f,
            iconResId = R.drawable.ic_yandex_browser,
            screenshotResIds = listOf(
                R.drawable.browser_screenshot_1,
                R.drawable.browser_screenshot_2
            ),
            description = "Быстрый и безопасный браузер"
        ),
        "3" to AppDetailsDto(
            id = "3",
            name = "Почта Mail.ru",
            developer = "Mail.ru Group",
            category = "Инструменты",
            ageRating = 12,
            size = 112.5f,
            iconResId = R.drawable.ic_mail,
            screenshotResIds = listOf(
                R.drawable.mail_screenshot_1,
                R.drawable.mail_screenshot_2
            ),
            description = "Почтовый клиент для любых ящиков"
        ),
        "4" to AppDetailsDto(
            id = "4",
            name = "Яндекс Навигатор",
            developer = "Яндекс",
            category = "Транспорт",
            ageRating = 6,
            size = 156.2f,
            iconResId = R.drawable.ic_navigator,
            screenshotResIds = listOf(
                R.drawable.navigator_screenshot_1,
                R.drawable.navigator_screenshot_2,
                R.drawable.navigator_screenshot_3
            ),
            description = "Парковки и заправки – по пути"
        ),
        "5" to AppDetailsDto(
            id = "5",
            name = "Мой МТС",
            developer = "МТС",
            category = "Инструменты",
            ageRating = 12,
            size = 98.7f,
            iconResId = R.drawable.ic_mts,
            screenshotResIds = listOf(
                R.drawable.mts_screenshot_1,
                R.drawable.mts_screenshot_2
            ),
            description = "Мой МТС — центр экосистемы МТС"
        ),
        "6" to AppDetailsDto(
            id = "6",
            name = "Яндекс — с Алисой",
            developer = "Яндекс",
            category = "Инструменты",
            ageRating = 12,
            size = 67.4f,
            iconResId = R.drawable.ic_yandex,
            screenshotResIds = listOf(
                R.drawable.yandex_screenshot_1,
                R.drawable.yandex_screenshot_2
            ),
            description = "Яндекс — поиск всегда под рукой"
        )
    )

    /**
     * Получить детальную информацию о приложении по ID
     */
    suspend fun getAppDetails(appId: String): AppDetailsDto? {
        // Имитация задержки загрузки
        kotlinx.coroutines.delay(500)
        return apps[appId]
    }
}