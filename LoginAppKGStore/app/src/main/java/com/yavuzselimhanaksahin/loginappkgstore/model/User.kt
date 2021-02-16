package com.yavuzselimhanaksahin.loginappkgstore.model

import com.google.gson.annotations.SerializedName

data class User (
        //@SerializedName("id")
        val id:Int,
        //@SerializedName("created")
        val created:Long,
        //@SerializedName("updated")
        val updated:Long,
        //@SerializedName("deleted")
        val deleted:Boolean,
        //@SerializedName("firstName")
        val firstName:String,
        //@SerializedName("lastName")
        val lastName:String,
        //@SerializedName("username")
        val username:String,
        //@SerializedName("pssrwd")
        val pssrwd:String,
        //@SerializedName("email")
        val email:String,
        //@SerializedName("enabled")
        val enabled:Boolean,
        //@SerializedName("ldapUser")
        val ldapUser:String,
        //@SerializedName("roleType")
        val roleType:String,


    )
