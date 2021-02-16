package com.yavuzselimhanaksahin.loginappkgstore

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
//import retrofit2.http.Headers

interface ApiService {

    @GET("app/all")
    fun fetchAllApps(@Header("Authorization") token: String): Call<AppResponse>
}