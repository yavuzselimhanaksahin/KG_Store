package com.yavuzselimhanaksahin.loginappkgstore.api

import com.yavuzselimhanaksahin.loginappkgstore.model.LoginResponse
import com.yavuzselimhanaksahin.loginappkgstore.model.SignInBody
import retrofit2.Call
import retrofit2.http.*

interface Api {


    /*@Headers("Content-Type:application/json")
    @POST("/KG-Store/api/login")
    fun userLogin
            (
                    @Field("username") username:String,
                    @Field("pswrd") pssrwd:String

            ): Call<LoginResponse>*/
    @Headers("Content-Type:application/json")
    @POST("login")
    fun userLogin(@Body info: SignInBody): Call<LoginResponse>



    /*@FormUrlEncoded
    @POST("/KG-Store/api/login")
    fun userLogin(
        @Field("username") username:String,
        @Field("pswrd") pssrwd:String
    ): Call<LoginResponse>*/
}