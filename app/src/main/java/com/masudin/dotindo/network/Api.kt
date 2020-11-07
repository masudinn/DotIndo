package com.masudin.dotindo.network

import com.masudin.dotindo.model.ResponseGallery
import com.masudin.dotindo.model.ResponseList
import com.masudin.dotindo.model.ResponseProfile
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Api {
    @GET("user.json")
    suspend fun getProfile() : Response<ResponseProfile>

    @GET("gallery.json")
    fun getGallery() : Call<ResponseGallery>

    @GET("place.json")
    fun getList() : Call<ResponseList>

    companion object{
        operator fun invoke() : Api{
           return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://dot-android-internship-test.web.app/")
                .build()
                .create(Api::class.java)
        }
    }
}