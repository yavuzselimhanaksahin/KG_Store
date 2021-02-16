package com.yavuzselimhanaksahin.loginappkgstore

import com.google.gson.annotations.SerializedName
import java.util.*

data class AppResponse (
        @SerializedName("code")
        val code:String,
        @SerializedName("message")
        val message:String,
        @SerializedName("model")
        val model:List<Model>
        )
