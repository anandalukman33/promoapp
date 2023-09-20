package com.example.promobank.ui.screen.detail

import com.example.promobank.data.datasource.database.entity.ImgEntity
import com.example.promobank.data.datasource.database.entity.PromoEntity
import com.example.promobank.data.datasource.database.entity.SmallImgEntity

data class DetailUiState(
    var promoDetail: PromoEntity? = null,
    var imgEntity: ImgEntity? = null,
    var smallImgEntity: SmallImgEntity? = null,
    var isSuccess: Boolean = false,
    var errorMessage: String? = null
)