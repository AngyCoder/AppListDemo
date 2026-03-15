package com.example.applistdemo.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applistdemo.data.App

// Компонент для отображения элемента списка приложений (обновленный)
@Composable
fun AppListItem(
    app: App,
    onItemClick: () -> Unit,
    onLogoClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick() }
            .padding(horizontal = 16.dp, vertical = 6.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = app.iconResId),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clickable { onLogoClick() }
            )

            Spacer(modifier = Modifier.width(20.dp))

            Column {
                Text(text = app.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(text = app.description, fontSize = 15.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                Text(text = app.category, fontSize = 14.sp, color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}