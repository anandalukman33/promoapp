package com.example.promobank.di

import android.content.Context
import androidx.room.Room
import com.example.promobank.data.datasource.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val DATABASE_NAME = "promo_database"

    @Provides
    @Singleton
    fun getDatabaseInstance (@ApplicationContext context: Context) : AppDatabase {
        return Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
}