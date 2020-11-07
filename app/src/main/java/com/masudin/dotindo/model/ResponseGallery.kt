package com.masudin.dotindo.model

import com.google.gson.annotations.SerializedName

data class ResponseGallery(

	@field:SerializedName("status_code")
	val statusCode: Int? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("data")
	val data: List<DataItem?>? = null

)

data class DataItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("caption")
	val caption: String? = null
)
