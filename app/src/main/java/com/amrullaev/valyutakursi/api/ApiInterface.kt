package com.amrullaev.valyutakursi.api

import com.amrullaev.valyutakursi.models.CurseDataItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("oz/arkhiv-kursov-valyut/json/")
    suspend fun getCurse():Response<List<CurseDataItem>>
}