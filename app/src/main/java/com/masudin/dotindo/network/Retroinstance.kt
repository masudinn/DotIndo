package com.masudin.dotindo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retroinstance {
    companion object{
        fun getRetroInstance() : Retrofit{
           return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://dot-android-internship-test.web.app/")
                .build()
        }
    }
}