package com.localizalabsacademy.mobile.rentacar.repository

import com.localizalabsacademy.mobile.rentacar.model.Agency

class RentACarRepositoryImpl : RentACarRepository {
    override suspend fun searchAgencies(): List<Agency> {
        return searchAgencies()
    }
}