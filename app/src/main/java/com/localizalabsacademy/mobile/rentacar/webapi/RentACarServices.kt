package com.localizalabsacademy.mobile.rentacar.webapi

import com.localizalabsacademy.mobile.rentacar.model.Agency
import retrofit2.Response
import retrofit2.http.GET

interface RentACarServices {

    @GET("api/Agency")
    suspend fun getAllAgencies(): Response<List<Agency>>
}