package com.example.promobank.data.datasource.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.promobank.data.datasource.database.entity.ImgEntity
import com.example.promobank.data.datasource.database.entity.PromoEntity
import com.example.promobank.data.datasource.database.entity.SmallImgEntity

@Dao
interface PromoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPromoEntity(promoEntity: PromoEntity)

    @Query("SELECT * FROM promo_table")
    fun getAllPromo(): LiveData<List<PromoEntity>>

    @Query("SELECT * FROM promo_table WHERE id_promo = :idPromo")
    fun getSpecificPromo(idPromo: Int): PromoEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addImgEntity(imgEntity: ImgEntity)

    @Query("SELECT * FROM img_promo_table")
    fun getAllImgEntity(): LiveData<List<ImgEntity>>

    @Query("SELECT * FROM img_promo_table WHERE id_promo = :idPromo")
    fun getImgPromoByIdPromo(idPromo: Int): ImgEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSmallImgEntity(smallImgEntity: SmallImgEntity)

    @Query("SELECT * FROM small_img_table")
    fun getAllSmallTable(): LiveData<List<SmallImgEntity>>

    @Query("SELECT * FROM small_img_table WHERE id_img = :idImg")
    fun getSmallImgByIdBaseImg(idImg: Int): SmallImgEntity

}