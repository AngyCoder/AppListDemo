package com.example.applistdemo.di

import com.example.applistdemo.data.repository.AppDetailsRepositoryImpl
import com.example.applistdemo.data.repository.AppListRepositoryImpl
import com.example.applistdemo.domain.repository.AppDetailsRepository
import com.example.applistdemo.domain.repository.AppListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAppListRepository(
        impl: AppListRepositoryImpl
    ): AppListRepository

    @Binds
    @Singleton
    abstract fun bindAppDetailsRepository(
        impl: AppDetailsRepositoryImpl
    ): AppDetailsRepository
}