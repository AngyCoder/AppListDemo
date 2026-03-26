package com.example.applistdemo.presentation.appdetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.applistdemo.domain.appdetails.AppDetails

@Composable
fun AppDetailsScreen(
    appId: String,
    onBackClick: () -> Unit,
    viewModel: AppDetailsViewModel = viewModel()
) {
    // Временно просто показываем загрузку
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("App Details Screen: $appId")
    }
}