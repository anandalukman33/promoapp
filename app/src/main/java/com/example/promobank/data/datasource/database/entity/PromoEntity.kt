package com.example.promobank.data.datasource.database.entity

import androidx.compose.runtime.Stable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "promo_table")
data class PromoEntity(

    @Stable
    @PrimaryKey
    @ColumnInfo(name = "id_promo")
    val idPromo: Int,

    @ColumnInfo(name = "title_promo")
    val titlePromo: String,

    @ColumnInfo(name = "desc_promo")
    val descPromo: String,

    @ColumnInfo(name = "latitude")
    val latitudePromo: String,

    @ColumnInfo(name = "longitude")
    val longitudePromo: String,

    @ColumnInfo(name = "created_at_formatted")
    val createdAtFormatted: String,

    @ColumnInfo(name = "lokasi")
    val lokasi: String,

    @ColumnInfo(name = "count_view")
    val count: Int
)