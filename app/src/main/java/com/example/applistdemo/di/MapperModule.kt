package com.example.applistdemo.di

import com.example.applistdemo.data.mapper.AppDetailsMapper
import com.example.applistdemo.data.mapper.CategoryMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    @Singleton
    fun provideCategoryMapper(): CategoryMapper = CategoryMapper()

    @Provides
    @Singleton
    fun provideAppDetailsMapper(
        categoryMapper: CategoryMapper
    ): AppDetailsMapper = AppDetailsMapper(categoryMapper)
}