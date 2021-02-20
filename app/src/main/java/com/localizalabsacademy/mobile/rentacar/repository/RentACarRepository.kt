package com.localizalabsacademy.mobile.rentacar.repository

import com.localizalabsacademy.mobile.rentacar.model.Agency

interface RentACarRepository {
    suspend fun searchAgencies(query: String): List<Agency>
}