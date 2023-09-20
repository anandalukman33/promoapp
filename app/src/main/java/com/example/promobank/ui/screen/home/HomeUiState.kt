package com.example.promobank.ui.screen.home

import com.example.promobank.model.PromosResponseItem

data class HomeUiState (
    var isFetching: Boolean = true,
    var tempPromoList: List<PromosResponseItem> = emptyList(),
    var isSuccess: Boolean = false,
    var errorMessage: String? = null
)