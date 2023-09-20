package com.example.promobank.ui.screen.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.promobank.data.repository.PromoRepository
import com.example.promobank.ui.navigation.AppDestinations.PROMO_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val promoRepository: PromoRepository
    ) : ViewModel() {

    private val promoId: Int = checkNotNull(savedStateHandle[PROMO_ID])
    var uiState by mutableStateOf(DetailUiState())
        private set


    init {
        viewModelScope.launch {
            try {
                getDataPromoById()
            } catch (e: IOException) {
                Timber.e("HomeViewModel error $e")
            }
        }
    }

    private suspend fun getDataPromoById() {
        if (promoId == 0) {
            uiState = DetailUiState(isSuccess = false, errorMessage = "Id promo tidak valid")
            return
        }
        val promo = promoRepository.getPromoById(promoId)
        val img = promoRepository.getImgPromoByIdPromo(promoId)
        val smallImg = promoRepository.getSmallImgByIdBaseImg(img.idImg)
        uiState = DetailUiState(
            promoDetail = promo,
            imgEntity = img,
            smallImgEntity = smallImg,
            isSuccess = true
        )
        if (promoId != promo.idPromo) {
            uiState = DetailUiState(isSuccess = false, errorMessage = "Id promo tidak sesuai!")
        }
    }

}