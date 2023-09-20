package com.example.promobank.model

import com.google.gson.annotations.SerializedName

@Suppress("unused")
data class PromosResponse(

	@field:SerializedName("PromosResponse")
	val promosResponse: List<PromosResponseItem?>? = null
)

data class Thumbnail(

	@field:SerializedName("ext")
	val ext: String? = null,

	@field:SerializedName("path")
	val path: Any? = null,

	@field:SerializedName("size")
	val size: Double? = null,

	@field:SerializedName("mime")
	val mime: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("hash")
	val hash: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)

data class Formats(

	@field:SerializedName("small")
	val small: Small? = null,

	@field:SerializedName("thumbnail")
	val thumbnail: Thumbnail? = null,

	@field:SerializedName("medium")
	val medium: Medium? = null,

	@field:SerializedName("large")
	val large: Large? = null
)

data class Large(

	@field:SerializedName("ext")
	val ext: String? = null,

	@field:SerializedName("path")
	val path: Any? = null,

	@field:SerializedName("size")
	val size: Double? = null,

	@field:SerializedName("mime")
	val mime: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("hash")
	val hash: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)

data class Img(

	@field:SerializedName("ext")
	val ext: String? = null,

	@field:SerializedName("formats")
	val formats: Formats? = null,

	@field:SerializedName("previewUrl")
	val previewUrl: Any? = null,

	@field:SerializedName("mime")
	val mime: String? = null,

	@field:SerializedName("caption")
	val caption: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("size")
	val size: Double? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("provider")
	val provider: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("provider_metadata")
	val providerMetadata: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("alternativeText")
	val alternativeText: String? = null,

	@field:SerializedName("hash")
	val hash: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)

data class PromosResponseItem(

	@field:SerializedName("img")
	val img: Img? = null,

	@field:SerializedName("latitude")
	val latitude: String? = null,

	@field:SerializedName("alt")
	val alt: String? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("Title")
	val title: Any? = null,

	@field:SerializedName("created_at")
	val createdAtFormatted: String? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("name_promo")
	val namePromo: Any? = null,

	@field:SerializedName("lokasi")
	val lokasi: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("published_at")
	val publishedAt: String? = null,

	@field:SerializedName("desc_promo")
	val descPromo: Any? = null,

	@field:SerializedName("desc")
	val desc: String? = null,

	@field:SerializedName("longitude")
	val longitude: String? = null
)

data class Medium(

	@field:SerializedName("ext")
	val ext: String? = null,

	@field:SerializedName("path")
	val path: Any? = null,

	@field:SerializedName("size")
	val size: Double? = null,

	@field:SerializedName("mime")
	val mime: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("hash")
	val hash: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)

data class Small(

	@field:SerializedName("ext")
	val ext: String? = null,

	@field:SerializedName("path")
	val path: Any? = null,

	@field:SerializedName("size")
	val size: Double? = null,

	@field:SerializedName("mime")
	val mime: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("hash")
	val hash: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)


