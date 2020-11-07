package com.masudin.dotindo.profile

import com.masudin.dotindo.network.Api
import com.masudin.dotindo.network.SafeApiRequest

class ProfileRespository(
    private val api: Api
) : SafeApiRequest() {

    suspend fun getProfile() = apiReq { api.getProfile() }
}