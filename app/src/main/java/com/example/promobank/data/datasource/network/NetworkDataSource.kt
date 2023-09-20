package com.example.promobank.data.datasource.network

import com.example.promobank.model.PromosResponseItem
import com.example.promobank.util.NetworkQueryUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkDataSource @Inject constructor(
    private val requestUrls: RequestUrls,
    private val jsonRemoteData: JsonRemoteData,
    private val queryUtils: NetworkQueryUtils
) {
    suspend fun getListPromos(): List<PromosResponseItem> = withContext(Dispatchers.IO) {
        val url = requestUrls.getPromos()
        val response: String = queryUtils.getResponseFromHttpUrl(url)
        jsonRemoteData.fetchListPromosJsonData(response)
    }
}