package com.yavuzselimhanaksahin.loginappkgstore.model

data class LoginResponse (
    val accessToken:String,
    val tokenType:String,
    val user:User
    )
