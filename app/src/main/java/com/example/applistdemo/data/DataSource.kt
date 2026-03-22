package com.example.applistdemo.data

import com.example.applistdemo.R

// Источник данных, содержащий предопределенный список приложений для демонстрации
object DataSource {
    val appList = listOf(
        App(1, "СберБанк Онлайн – с Салютом", "Больше чем банк", "Финансы", R.drawable.ic_sberbank),
        App(2, "Яндекс.Браузер — с Алисой", "Быстрый и безопасный браузер", "Инструменты", R.drawable.ic_yandex_browser),
        App(3, "Почта Mail.ru", "Почтовый клиент для любых ящиков", "Инструменты", R.drawable.ic_mail),
        App(4, "Яндекс Навигатор", "Парковки и заправки – по пути", "Транспорт", R.drawable.ic_navigator),
        App(5, "Мой МТС", "Мой МТС — центр экосистемы МТС", "Инструменты", R.drawable.ic_mts),
        App(6, "Яндекс — с Алисой", "Яндекс — поиск всегда под рукой", "Инструменты", R.drawable.ic_yandex)
    )
}