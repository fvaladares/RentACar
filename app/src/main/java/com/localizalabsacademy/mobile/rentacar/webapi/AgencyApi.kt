package com.localizalabsacademy.mobile.rentacar.webapi

import com.localizalabsacademy.mobile.rentacar.model.Agency
import retrofit2.Response
import retrofit2.http.GET

interface AgencyApi {
    @GET("/api/Agency")
    suspend fun getAll(): Response<MutableList<Agency>>
// Response - Allows us to check HTTP response
}