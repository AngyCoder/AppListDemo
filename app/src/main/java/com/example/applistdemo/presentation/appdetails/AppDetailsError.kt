package com.example.applistdemo.presentation.appdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.applistdemo.ui.theme.AppListDemoTheme

/**
 * Компонент для отображения состояния ошибки
 * Показывает сообщение об ошибке и кнопку для повторной попытки загрузки
 */
@Composable
fun AppDetailsError(
    onRefreshClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Ошибка загрузки",
            style = MaterialTheme.typography.headlineMedium,
        )
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = onRefreshClick,
        ) {
            Text(text = "Обновить")
        }
    }
}

@Preview
@Composable
private fun Preview() {
    AppListDemoTheme {
        AppDetailsError(
            onRefreshClick = {},
            modifier = Modifier.fillMaxSize(),
        )
    }
}