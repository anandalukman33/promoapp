package com.example.promobank.data.datasource.network

import com.example.promobank.model.Formats
import com.example.promobank.model.Img
import com.example.promobank.model.Medium
import com.example.promobank.model.PromosResponseItem
import com.example.promobank.model.Small
import com.example.promobank.model.Thumbnail
import org.json.JSONArray
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JsonRemoteData @Inject constructor() {

    fun fetchListPromosJsonData(response: String): List<PromosResponseItem> {
        val promoList: MutableList<PromosResponseItem> = ArrayList()
        val baseJsonArray = JSONArray(response)

        for (notI: Int in 0 until baseJsonArray.length()) {
            val jsonObject = baseJsonArray.getJSONObject(notI)
            val id = jsonObject.getInt("id")
            val title = jsonObject.getString("Title")
            val publishedAt = jsonObject.getString("published_at")
            val createdAtFormatted = jsonObject.getString("created_at")
            val updatedAtFormatted = jsonObject.getString("updated_at")
            val namePromo = jsonObject.getString("name_promo")
            val descPromo = jsonObject.getString("desc_promo")
            val nama = jsonObject.getString("nama")
            val desc = jsonObject.getString("desc")
            val latitude = jsonObject.getString("latitude")
            val longitude = jsonObject.getString("longitude")
            val alt = jsonObject.getString("alt")
            val createdAt = jsonObject.getString("createdAt")
            val lokasi = jsonObject.getString("lokasi")
            val count = jsonObject.getInt("count")

            // Section Img
            val img = jsonObject.getJSONObject("img")
            val imgId = img.getInt("id")
            val imgName = img.getString("name")
            val alternativeText = img.getString("alternativeText")
            val caption = img.getString("caption")
            val width = img.getInt("width")
            val height = img.getInt("height")

            // Section Format
            val formats = img.getJSONObject("formats")

                // Section Small
                val small = formats.getJSONObject("small")
                val smallExt = small.getString("ext")
                val smallUrl = small.getString("url")
                val smallHash = small.getString("hash")
                val smallMime = small.getString("mime")
                val smallName = small.getString("name")
                val smallPath = small.getString("path")
                val smallSize = small.getDouble("size")
                val smallWidth = small.getInt("width")
                val smallHeight = small.getInt("height")

                // Section Small
                val medium = formats.getJSONObject("medium")
                val mediumExt = medium.getString("ext")
                val mediumUrl = medium.getString("url")
                val mediumHash = medium.getString("hash")
                val mediumMime = medium.getString("mime")
                val mediumName = medium.getString("name")
                val mediumPath = medium.getString("path")
                val mediumSize = medium.getDouble("size")
                val mediumWidth = medium.getInt("width")
                val mediumHeight = medium.getInt("height")

                // Thumbnail Small
                val thumbnail = formats.getJSONObject("thumbnail")
                val thumbnailExt = thumbnail.getString("ext")
                val thumbnailUrl = thumbnail.getString("url")
                val thumbnailHash = thumbnail.getString("hash")
                val thumbnailMime = thumbnail.getString("mime")
                val thumbnailName = thumbnail.getString("name")
                val thumbnailPath = thumbnail.getString("path")
                val thumbnailSize = thumbnail.getDouble("size")
                val thumbnailWidth = thumbnail.getInt("width")
                val thumbnailHeight = thumbnail.getInt("height")

            val baseHash = img.getString("hash")
            val baseExt = img.getString("ext")
            val baseMime = img.getString("mime")
            val baseSize = img.getDouble("size")
            val baseUrl = img.getString("url")
            val basePreviewUrl = img.getString("previewUrl")
            val provider = img.getString("provider")
            val providerMetaData = img.getString("provider_metadata")
            val baseCreatedAt = img.getString("created_at")
            val baseUpdatedAt = img.getString("updated_at")

            val smallData = Small(
                ext = smallExt,
                path = smallPath,
                size = smallSize,
                mime = smallMime,
                name = smallName,
                width = smallWidth,
                height = smallHeight,
                url = smallUrl,
                hash = smallHash
            )

            val mediumData = Medium(
                ext = mediumExt,
                path = mediumPath,
                size = mediumSize,
                mime = mediumMime,
                name = mediumName,
                width = mediumWidth,
                height = mediumHeight,
                url = mediumUrl,
                hash = mediumHash
            )

            val thumbnailData = Thumbnail(
                ext = thumbnailExt,
                path = thumbnailPath,
                size = thumbnailSize,
                mime = thumbnailMime,
                name = thumbnailName,
                width = thumbnailWidth,
                height = thumbnailHeight,
                url = thumbnailUrl,
                hash = thumbnailHash
            )

            val formatData = Formats(
                small = smallData,
                thumbnail = thumbnailData,
                medium = mediumData,
            )

            val imgData = Img(
                id = imgId,
                name = imgName,
                alternativeText = alternativeText,
                caption = caption,
                width = width,
                height = height,
                formats = formatData,
                hash = baseHash,
                ext = baseExt,
                mime = baseMime,
                size = baseSize,
                url = baseUrl,
                previewUrl = basePreviewUrl,
                provider = provider,
                providerMetadata = providerMetaData,
                createdAt = baseCreatedAt,
                updatedAt = baseUpdatedAt
            )

            val promosData = PromosResponseItem(
                id = id,
                title = title,
                publishedAt = publishedAt,
                createdAtFormatted = createdAtFormatted,
                updatedAt = updatedAtFormatted,
                namePromo = namePromo,
                descPromo = descPromo,
                nama = nama,
                desc = desc,
                latitude = latitude,
                longitude = longitude,
                alt = alt,
                createdAt = createdAt,
                lokasi = lokasi,
                count = count,
                img = imgData
            )
            promoList.add(promosData)
        }
        return promoList
    }

}