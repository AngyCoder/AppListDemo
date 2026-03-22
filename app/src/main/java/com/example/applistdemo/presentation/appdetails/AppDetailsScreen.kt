package com.example.applistdemo.presentation.appdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.applistdemo.R
import com.example.applistdemo.domain.appdetails.AppDetails
import com.example.applistdemo.domain.appdetails.Category
import com.example.applistdemo.ui.theme.AppListDemoTheme
import kotlinx.coroutines.flow.collectLatest

@Composable
fun AppDetailsScreen(
    appId: String,
    onBackClick: () -> Unit,
    viewModel: AppDetailsViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val descriptionCollapsed by viewModel.descriptionCollapsed.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(appId) {
        viewModel.loadAppDetails(appId)
    }

    LaunchedEffect(Unit) {
        viewModel.events.collectLatest { event ->
            when (event) {
                is AppDetailsEvent.ShowError -> {
                    snackbarHostState.showSnackbar(
                        message = event.message,
                        withDismissAction = true
                    )
                }
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        when (val currentState = state) {
            is AppDetailsState.Loading -> {
                AppDetailsLoading(
                    modifier = Modifier.fillMaxSize()
                )
            }
            is AppDetailsState.Error -> {
                AppDetailsError(
                    onRefreshClick = { viewModel.loadAppDetails(appId) },
                    modifier = Modifier.fillMaxSize()
                )
            }
            is AppDetailsState.Content -> {
                AppDetailsContent(
                    appDetails = currentState.appDetails,
                    descriptionCollapsed = descriptionCollapsed,
                    onBackClick = onBackClick,
                    onShareClick = { /* Поделиться */ },
                    onInstallClick = { /* Установить */ },
                    onReadMoreClick = { viewModel.toggleDescription() },
                    onDeveloperClick = { /* Открыть профиль разработчика */ },
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding()
                        .padding(paddingValues)
                )
            }
        }
    }
}

@Composable
fun AppDetailsContent(
    appDetails: AppDetails,
    descriptionCollapsed: Boolean,
    onBackClick: () -> Unit,
    onShareClick: () -> Unit,
    onInstallClick: () -> Unit,
    onReadMoreClick: () -> Unit,
    onDeveloperClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        Toolbar(
            onBackClick = onBackClick,
            onShareClick = onShareClick
        )

        Spacer(modifier = Modifier.height(8.dp))

        AppDetailsHeader(
            appDetails = appDetails,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        InstallButton(
            onClick = onInstallClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        ScreenshotsList(
            screenshotResIds = appDetails.screenshotResIds,
            contentPadding = PaddingValues(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        AppDescription(
            description = appDetails.description,
            collapsed = descriptionCollapsed,
            onReadMoreClick = onReadMoreClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 16.dp),
            color = MaterialTheme.colorScheme.outlineVariant
        )

        Spacer(modifier = Modifier.height(12.dp))

        Developer(
            name = appDetails.developer,
            onClick = onDeveloperClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppDetailsScreenPreview() {
    val mockAppDetails = AppDetails(
        id = "1",
        name = "СберБанк Онлайн",
        developer = "Сбер",
        category = Category.FINANCE,
        ageRating = 18,
        size = 145.8f,
        iconResId = R.drawable.ic_launcher_foreground,
        screenshotResIds = listOf(
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground
        ),
        description = "Мобильный банк с расширенным функционалом."
    )

    AppListDemoTheme {
        AppDetailsContent(
            appDetails = mockAppDetails,
            descriptionCollapsed = true,
            onBackClick = {},
            onShareClick = {},
            onInstallClick = {},
            onReadMoreClick = {},
            onDeveloperClick = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}