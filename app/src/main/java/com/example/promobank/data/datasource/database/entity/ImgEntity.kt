package com.example.promobank.data.datasource.database.entity

import androidx.compose.runtime.Stable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "img_promo_table")
data class ImgEntity (

    @Stable
    @PrimaryKey
    @ColumnInfo(name = "id_img")
    val idImg: Int,

    @ColumnInfo(name = "id_promo")
    val idPromo: Int,

    @ColumnInfo(name = "baseWidth")
    val baseWidth: Int,

    @ColumnInfo(name = "baseHeight")
    val baseHeight: Int,

    @ColumnInfo(name = "baseUrl")
    val baseUrl: String

)