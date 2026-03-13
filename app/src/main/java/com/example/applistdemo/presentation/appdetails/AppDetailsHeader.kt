package com.example.applistdemo.presentation.appdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applistdemo.R
import com.example.applistdemo.domain.appdetails.AppDetails
import com.example.applistdemo.domain.appdetails.Category
import com.example.applistdemo.ui.theme.AppListDemoTheme
import kotlin.math.roundToInt

@Composable
fun AppDetailsHeader(
    appDetails: AppDetails,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Иконка из ресурсов
        Icon(
            painter = painterResource(id = appDetails.iconResId),
            contentDescription = null,
            modifier = Modifier
                .size(96.dp)
                .clip(RoundedCornerShape(16.dp)),
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = appDetails.name,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                lineHeight = 24.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = appDetails.developer,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.width(IntrinsicSize.Min)) {
                    Text(
                        text = "${appDetails.ageRating}+",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Возраст",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = "${appDetails.size.roundToInt()} МБ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Размер",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun AppDetailsHeaderPreview() {
    val appDetails = AppDetails(
        id = "1",
        name = "СберБанк Онлайн",
        developer = "Сбер",
        category = Category.FINANCE,
        ageRating = 18,
        size = 145.8f,
        iconResId = R.drawable.ic_launcher_foreground,
        screenshotResIds = listOf(),
        description = "Мобильный банк"
    )
    AppListDemoTheme {
        AppDetailsHeader(
            appDetails = appDetails,
            modifier = Modifier.padding(16.dp)
        )
    }
}