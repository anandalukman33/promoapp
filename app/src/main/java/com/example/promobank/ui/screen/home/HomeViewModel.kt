package com.example.promobank.ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.promobank.data.repository.PromoRepository
import com.example.promobank.model.PromosResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: PromoRepository
): ViewModel() {


    var uiState by mutableStateOf(HomeUiState())
        private set


    init {
        viewModelScope.launch {
            try {
                startFetchingPromo()
            } catch (e: IOException) {
                Timber.e("HomeViewModel error $e")
            }
        }
    }

    private suspend fun startFetchingPromo() {
        uiState = HomeUiState(isFetching = false, isSuccess = true, tempPromoList = repository.getPromoList())
        val promosResponseItem: List<PromosResponseItem> = uiState.tempPromoList
        if (promosResponseItem.isNotEmpty()) {
            promosResponseItem.forEach { i ->
                repository.addPromo(i)
                if (i.img != null && i.id != 0) {
                    repository.addImgPromo(i.img, i.id ?: 0)
                    if (i.img.formats != null) {
                        if (i.img.formats.small != null) {
                            val smallImgPromo = i.img.formats.small
                            repository.addSmallImgPromo(smallImgPromo, i.id ?: 0, i.img.id ?: 0)
                        }
                    }
                }
            }
        } else {
            uiState = HomeUiState(isFetching = false, emptyList(), false, "promo item list is empty $promosResponseItem")
            Timber.e("promo item list is empty $promosResponseItem")
        }
    }
}