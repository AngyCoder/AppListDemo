package com.example.applistdemo.presentation.appdetails

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.applistdemo.R
import com.example.applistdemo.ui.theme.AppListDemoTheme

/**
 * Компонент для отображения списка скриншотов приложения
 * Поддерживает открытие полноэкранной галереи с пролистыванием
 */
@OptIn(ExperimentalMaterial3Api::class, androidx.compose.foundation.ExperimentalFoundationApi::class)
@Composable
fun ScreenshotsList(
    @DrawableRes screenshotResIds: List<Int>,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    // Состояние для управления полноэкранным режимом
    var showFullScreen by remember { mutableStateOf(false) }
    var selectedImageIndex by remember { mutableIntStateOf(0) }

    Column(modifier = modifier) {
        // Заголовок секции
        Text(
            text = "Скриншоты",
            modifier = Modifier.padding(contentPadding),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(12.dp))

        if (screenshotResIds.isEmpty()) {
            // Обработка пустого списка скриншотов
            Text(
                text = "Нет скриншотов",
                modifier = Modifier.padding(contentPadding),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        } else {
            // Горизонтальный список вертикальных скриншотов
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                itemsIndexed(screenshotResIds) { index, resId ->
                    Card(
                        modifier = Modifier
                            .width(130.dp)
                            .aspectRatio(9f / 16f)
                            .clickable {
                                selectedImageIndex = index
                                showFullScreen = true
                            },
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Image(
                            painter = painterResource(id = resId),
                            contentDescription = "Скриншот ${index + 1}",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }

    // Полноэкранный просмотр с горизонтальным скроллом
    if (showFullScreen) {
        FullScreenGallery(
            screenshotResIds = screenshotResIds,
            initialIndex = selectedImageIndex,
            onClose = { showFullScreen = false }
        )
    }
}

/**
 * Компонент полноэкранной галереи для просмотра скриншотов
 * Отображается в диалоговом окне с возможностью пролистывания
 */
@OptIn(androidx.compose.foundation.ExperimentalFoundationApi::class)
@Composable
fun FullScreenGallery(
    @DrawableRes screenshotResIds: List<Int>,
    initialIndex: Int,
    onClose: () -> Unit
) {
    val pagerState = rememberPagerState(
        initialPage = initialIndex,
        pageCount = { screenshotResIds.size }
    )

    Dialog(
        onDismissRequest = onClose,
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
            decorFitsSystemWindows = false
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Затемненный фон
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { }
            )

            // HorizontalPager для скролла между скриншотами
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = screenshotResIds[page]),
                        contentDescription = "Скриншот ${page + 1}",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxHeight(0.9f)
                            .aspectRatio(9f / 16f)
                            .clip(RoundedCornerShape(24.dp))
                    )
                }
            }

            // Кнопка закрытия
            IconButton(
                onClick = onClose,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp)
                    .size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Закрыть",
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            // Индикатор текущей позиции (счетчик) внизу экрана
            Text(
                text = "${pagerState.currentPage + 1} / ${screenshotResIds.size}",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ScreenshotsListPreview() {
    AppListDemoTheme {
        ScreenshotsList(
            screenshotResIds = listOf(
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground
            ),
            contentPadding = PaddingValues(horizontal = 16.dp)
        )
    }
}