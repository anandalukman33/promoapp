package com.example.promobank.di

import com.example.promobank.data.datasource.database.AppDatabase
import com.example.promobank.data.datasource.database.dao.PromoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {

    @Provides
    fun providePromoDao(database: AppDatabase): PromoDao = database.promoDao
}