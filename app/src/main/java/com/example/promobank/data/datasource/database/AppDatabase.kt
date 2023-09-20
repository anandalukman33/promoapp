package com.example.promobank.data.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.promobank.data.datasource.database.dao.PromoDao
import com.example.promobank.data.datasource.database.entity.ImgEntity
import com.example.promobank.data.datasource.database.entity.PromoEntity
import com.example.promobank.data.datasource.database.entity.SmallImgEntity


@Database(
    entities = [PromoEntity::class, ImgEntity::class, SmallImgEntity::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase: RoomDatabase() {
    abstract val promoDao: PromoDao
}