package com.masudin.dotindo.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.masudin.dotindo.model.ResponseProfile

class ProfileViewModel(private val respository: ProfileRespository) : ViewModel() {

    private val profile = MutableLiveData<ResponseProfile>()
    val mProfile : LiveData<ResponseProfile> get() = profile


    suspend fun getProfile(){
        val profil = respository.getProfile()
        profile.value = profil

    }

}