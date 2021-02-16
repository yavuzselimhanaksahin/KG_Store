package com.yavuzselimhanaksahin.loginappkgstore

data class Model  (
    val id:Int,
    val created:Long,
    val updated:Long,
    val deleted:Boolean,
    val name:String,
    val version:String,
    val size:Long,
    val description:String,
    val downloadLink:String,
    val iconLink:String,
    val stage:String,
    val appType:String,
    val status:String,
    val node:String
        )
