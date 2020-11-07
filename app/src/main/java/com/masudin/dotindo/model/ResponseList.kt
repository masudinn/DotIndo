package com.masudin.dotindo.model

import com.google.gson.annotations.SerializedName

data class ResponseList(
	@field:SerializedName("status_code")
	val statusCode: Int? = null,
	@field:SerializedName("message")
	val message: String? = null,
	@field:SerializedName("data")
	val data: Datas? = null
)
data class Datas(
	@field:SerializedName("header")
	val header: Header? = null,
	@field:SerializedName("content")
	val content: List<ContentItem?>? = null
)
data class Header(
	@field:SerializedName("subtitle")
	val subtitle: String? = null,
	@field:SerializedName("title")
	val title: String? = null
)

data class ContentItem(
	@field:SerializedName("image")
	val image: String? = null,
	@field:SerializedName("id")
	val id: Int? = null,
	@field:SerializedName("media")
	val media: List<Any?>? = null,
	@field:SerializedName("title")
	val title: String? = null,
	@field:SerializedName("type")
	val type: String? = null,
	@field:SerializedName("content")
	val content: String? = null
)
