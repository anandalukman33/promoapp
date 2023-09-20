package com.example.promobank.data.datasource.database.entity

import androidx.compose.runtime.Stable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "small_img_table")
data class SmallImgEntity(

    @Stable
    @PrimaryKey
    @ColumnInfo(name = "id_img")
    val idImg: Int,

    @ColumnInfo(name = "id_promo")
    val idPromo: Int,

    @ColumnInfo(name = "small_url_img")
    val smallUrlImg: String,

    @ColumnInfo(name = "width")
    val width: Int,

    @ColumnInfo(name = "height")
    val height: Int
)
