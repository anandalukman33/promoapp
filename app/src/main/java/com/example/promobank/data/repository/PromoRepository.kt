package com.example.promobank.data.repository

import com.example.promobank.data.datasource.database.DatabaseDataSource
import com.example.promobank.data.datasource.database.entity.ImgEntity
import com.example.promobank.data.datasource.database.entity.PromoEntity
import com.example.promobank.data.datasource.database.entity.SmallImgEntity
import com.example.promobank.data.datasource.network.NetworkDataSource
import com.example.promobank.model.Img
import com.example.promobank.model.PromosResponseItem
import com.example.promobank.model.Small
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PromoRepository @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val databaseDataSource: DatabaseDataSource
) {

    suspend fun getPromoList(): List<PromosResponseItem> = networkDataSource.getListPromos()

    suspend fun addPromo(promosResponseItem: PromosResponseItem) {
        databaseDataSource.addPromoItem(promosResponseItem)
    }

    suspend fun addImgPromo(img: Img, idPromo: Int) {
        databaseDataSource.addImgPromo(img, idPromo)
    }

    suspend fun addSmallImgPromo(small: Small, idPromo: Int, idImg: Int) {
        databaseDataSource.addSmallImgPromo(small, idPromo, idImg)
    }

    suspend fun getPromoById(promoId: Int): PromoEntity = databaseDataSource.getPromoById(promoId)

    suspend fun getImgPromoByIdPromo(promoId: Int): ImgEntity = databaseDataSource.getImgPromoByIdPromo(promoId)

    suspend fun getSmallImgByIdBaseImg(idBaseImg: Int): SmallImgEntity = databaseDataSource.getSmallImgByIdBaseImg(idBaseImg)

}