package com.example.applistdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import com.example.applistdemo.data.model.App
import com.example.applistdemo.presentation.appdetails.AppDetailsScreen
import com.example.applistdemo.presentation.applist.AppListScreen
import com.example.applistdemo.ui.navigation.APP_DETAILS_ROUTE
import com.example.applistdemo.ui.navigation.APP_LIST_ROUTE
import com.example.applistdemo.ui.navigation.appDetailsRoute
import com.example.applistdemo.ui.theme.AppListDemoTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppListDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = APP_LIST_ROUTE
                    ) {
                        // Экран со списком приложений
                        composable(route = APP_LIST_ROUTE) {
                            AppListScreen(
                                onAppClick = { app: App ->
                                    navController.navigate(appDetailsRoute(app.id))
                                }
                            )
                        }

                        // Экран с деталями приложения
                        composable(route = APP_DETAILS_ROUTE) { backStackEntry ->
                            // Получаем appId из аргументов навигации
                            val appId = backStackEntry.arguments?.getString("appId") ?: ""
                            AppDetailsScreen(
                                appId = appId,
                                onBackClick = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}