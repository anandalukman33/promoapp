package com.example.promobank.model

import com.example.promobank.data.datasource.database.entity.ImgEntity
import com.example.promobank.data.datasource.database.entity.PromoEntity
import com.example.promobank.data.datasource.database.entity.SmallImgEntity

fun PromosResponseItem.promoItemAsDatabaseModel(): PromoEntity =
    PromoEntity(
        idPromo = this.id ?: 0,
        titlePromo = this.nama.toString(),
        descPromo = this.desc.toString(),
        latitudePromo = this.latitude.toString(),
        longitudePromo = this.longitude.toString(),
        createdAtFormatted = this.createdAt.toString(),
        lokasi = this.lokasi.toString(),
        count = this.count ?: 0
    )

fun Img.imgItemAsDatabaseModel(idPromo: Int): ImgEntity =
    ImgEntity(
        idImg = this.id ?: 0,
        idPromo = idPromo,
        baseWidth = this.width ?: 0,
        baseHeight = this.height ?: 0,
        baseUrl = this.url.toString()
    )

fun Small.smallImgItemAsDatabaseModel(idPromo: Int, idImg: Int) : SmallImgEntity =
    SmallImgEntity(
        idImg = idImg,
        idPromo = idPromo,
        smallUrlImg = this.url.toString(),
        width = this.width ?: 0,
        height = this.height ?: 0
    )
