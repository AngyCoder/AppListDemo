package com.example.applistdemo.presentation.appdetails

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.applistdemo.ui.theme.AppListDemoTheme

// Кнопка установки приложения
@Composable
fun InstallButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        contentPadding = PaddingValues(vertical = 12.dp),
        modifier = modifier
    ) {
        Text(
            text = "Установить",
            style = MaterialTheme.typography.bodyLarge,
            color = androidx.compose.ui.graphics.Color.White
        )
    }
}

@Preview
@Composable
fun InstallButtonPreview() {
    AppListDemoTheme {
        InstallButton(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}