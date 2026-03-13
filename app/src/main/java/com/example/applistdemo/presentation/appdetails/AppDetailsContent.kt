package com.example.applistdemo.presentation.appdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.applistdemo.R
import com.example.applistdemo.domain.appdetails.AppDetails
import com.example.applistdemo.domain.appdetails.Category
import com.example.applistdemo.ui.theme.AppListDemoTheme

@Composable
fun AppDetailsContent(
    content: AppDetailsState.Content,
    onBackClick: () -> Unit,
    onShareClick: () -> Unit,
    onInstallClick: () -> Unit,
    onReadMoreClick: () -> Unit,
    onDeveloperClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val appDetails = content.appDetails
    val descriptionCollapsed = content.descriptionCollapsed

    Column(modifier) {
        Toolbar(
            onBackClick = onBackClick,
            onShareClick = onShareClick,
        )

        Spacer(modifier = Modifier.height(8.dp))

        AppDetailsHeader(
            appDetails = appDetails,
            modifier = Modifier.padding(horizontal = 16.dp),
        )

        Spacer(modifier = Modifier.height(16.dp))

        InstallButton(
            onClick = onInstallClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Используем screenshotResIds вместо screenshotUrlList
        ScreenshotsList(
            screenshotResIds = appDetails.screenshotResIds,
            contentPadding = PaddingValues(horizontal = 16.dp),
        )

        Spacer(modifier = Modifier.height(12.dp))

        AppDescription(
            description = appDetails.description,
            collapsed = descriptionCollapsed,
            onReadMoreClick = onReadMoreClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        )

        Spacer(modifier = Modifier.height(12.dp))

        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 16.dp),
            color = MaterialTheme.colorScheme.outlineVariant,
        )

        Spacer(modifier = Modifier.height(12.dp))

        Developer(
            name = appDetails.developer,
            onClick = onDeveloperClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
        )
    }
}

@Preview
@Composable
private fun Preview() {
    val appDetails = AppDetails(
        id = "1",
        name = "Гильдия Героев: Экшен ММО РПГ",
        developer = "VK Play",
        category = Category.GAME,
        ageRating = 12,
        size = 223.7f,
        iconResId = R.drawable.ic_launcher_foreground,  // Исправлено: iconResId вместо iconUrl
        screenshotResIds = listOf(                       // Исправлено: screenshotResIds вместо screenshotUrlList
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground
        ),
        description = "Описание игры"
    )
    AppListDemoTheme {
        AppDetailsContent(
            content = AppDetailsState.Content(
                appDetails = appDetails,
                descriptionCollapsed = true,
            ),
            onReadMoreClick = {},
            onBackClick = {},
            onShareClick = {},
            onInstallClick = {},
            onDeveloperClick = {},
            modifier = Modifier.fillMaxSize(),
        )
    }
}