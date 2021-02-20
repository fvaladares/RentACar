package com.localizalabsacademy.mobile.rentacar.webapi

import com.localizalabsacademy.mobile.rentacar.model.Agency
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebService {
    private val api: AgencyApi =
        Retrofit.Builder()
            .baseUrl(endPointUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AgencyApi::class.java)

    suspend fun getAgencies(): Response<MutableList<Agency>> = api.getAll()

    companion object {

        private const val endPointUrl = "https://localiza-labs.eastus.cloudapp.azure.com/api/"
//        private const val endPointUrl = "http://52.188.27.221:5000"
    }
}