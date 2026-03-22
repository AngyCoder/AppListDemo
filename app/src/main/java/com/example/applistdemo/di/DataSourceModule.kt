package com.example.applistdemo.di

import com.example.applistdemo.data.datasource.AppListDataSource
import com.example.applistdemo.data.datasource.LocalAppDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideAppListDataSource(): AppListDataSource = AppListDataSource()

    @Provides
    @Singleton
    fun provideLocalAppDataSource(): LocalAppDataSource = LocalAppDataSource()
}