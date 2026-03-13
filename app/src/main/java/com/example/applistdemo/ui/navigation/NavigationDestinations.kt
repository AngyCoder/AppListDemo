package com.example.applistdemo.ui.navigation

const val APP_LIST_ROUTE = "app_list"
const val APP_DETAILS_ROUTE = "app_details/{appId}"

fun appDetailsRoute(appId: Int): String = "app_details/$appId"