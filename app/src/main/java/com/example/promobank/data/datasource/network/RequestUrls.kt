package com.example.promobank.data.datasource.network

import java.net.URL
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RequestUrls @Inject constructor() {
    fun getPromos(): URL = URL("https://content.digi46.id/promos")
}