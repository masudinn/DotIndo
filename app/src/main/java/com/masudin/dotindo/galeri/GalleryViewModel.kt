package com.masudin.dotindo.galeri

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.masudin.dotindo.model.DataItem
import com.masudin.dotindo.model.ResponseGallery
import com.masudin.dotindo.model.ResponseProfile
import com.masudin.dotindo.network.Api
import com.masudin.dotindo.network.Retroinstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GalleryViewModel : ViewModel() {
    var galeriData = MutableLiveData<ResponseGallery>()

    init {
        galeriData = MutableLiveData()
    }

    fun getGalleriRecycler(): MutableLiveData<ResponseGallery> {
        return galeriData
    }

    fun callApi() {
        val retro = Retroinstance.getRetroInstance().create(Api::class.java)
        val call = retro.getGallery()
        call.enqueue(object : Callback<ResponseGallery> {

            override fun onFailure(call: Call<ResponseGallery>, t: Throwable) {
                galeriData.postValue(null)

            }

            override fun onResponse(
                call: Call<ResponseGallery>,
                response: Response<ResponseGallery>
            ) {
                if (response.isSuccessful) {
                    galeriData.postValue(response.body())
                } else {
                    galeriData.postValue(null)
                }
            }

        })
    }
}