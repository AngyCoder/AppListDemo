package com.example.applistdemo.domain.usecase

import com.example.applistdemo.domain.appdetails.AppDetails
import com.example.applistdemo.domain.repository.AppDetailsRepository
import javax.inject.Inject

class GetAppDetailsUseCase @Inject constructor(
    private val repository: AppDetailsRepository
) {

    suspend operator fun invoke(appId: String): Result<AppDetails> = runCatching {
        val appDetails = repository.getAppDetails(appId)

        // Пример бизнес-логики: проверка возрастных ограничений
        if (appDetails.ageRating > 18) {
            throw IllegalStateException("Приложение имеет возрастное ограничение 18+")
        }

        appDetails
    }
}