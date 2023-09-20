package com.example.promobank.data.datasource.database

import com.example.promobank.model.Img
import com.example.promobank.model.PromosResponseItem
import com.example.promobank.model.Small
import com.example.promobank.model.imgItemAsDatabaseModel
import com.example.promobank.model.promoItemAsDatabaseModel
import com.example.promobank.model.smallImgItemAsDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseDataSource @Inject constructor(
    private val database: AppDatabase
) {

    suspend fun addPromoItem(promosResponseItem: PromosResponseItem) {
        return withContext(Dispatchers.IO) {
            with(promosResponseItem.promoItemAsDatabaseModel()) {
                database.promoDao.addPromoEntity(promoEntity = this)
            }
        }
    }

    suspend fun addImgPromo(img: Img, idPromo: Int) {
        return withContext(Dispatchers.IO) {
            with(img.imgItemAsDatabaseModel(idPromo)) {
                database.promoDao.addImgEntity(imgEntity = this)
            }
        }
    }

    suspend fun addSmallImgPromo(small: Small, idPromo: Int, idImg: Int) {
        return withContext(Dispatchers.IO) {
            with(small.smallImgItemAsDatabaseModel(idPromo, idImg)) {
                database.promoDao.addSmallImgEntity(smallImgEntity = this)
            }
        }

    }

    suspend fun getPromoById(promoId: Int) = withContext(Dispatchers.IO) {
        database.promoDao.getSpecificPromo(promoId)
    }

    suspend fun getImgPromoByIdPromo(promoId: Int) = withContext(Dispatchers.IO) {
        database.promoDao.getImgPromoByIdPromo(promoId)
    }

    suspend fun getSmallImgByIdBaseImg(idBaseImg: Int) = withContext(Dispatchers.IO) {
        database.promoDao.getSmallImgByIdBaseImg(idBaseImg)
    }
}