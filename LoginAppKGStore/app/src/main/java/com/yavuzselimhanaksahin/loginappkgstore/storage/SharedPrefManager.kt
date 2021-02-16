package com.yavuzselimhanaksahin.loginappkgstore.storage

import android.content.Context
import com.yavuzselimhanaksahin.loginappkgstore.model.Token
import com.yavuzselimhanaksahin.loginappkgstore.model.User

class SharedPrefManager private constructor(private val mCtx: Context) {

    val isLoggedIn: Boolean
        get() {
            val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return sharedPreferences.getInt("id", -1) != -1
        }

    val user: User
        get() {
            val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return User(
                    sharedPreferences.getInt("id", -1),
                    sharedPreferences.getLong("created", -1),
                    sharedPreferences.getLong("updated", -1),
                    sharedPreferences.getBoolean("deleted",false),
                    sharedPreferences.getString("firstName",null)!!,
                    sharedPreferences.getString("lastName",null)!!,
                    sharedPreferences.getString("username", null)!!,
                    sharedPreferences.getString("pssrwd",null)!!,
                    sharedPreferences.getString("email",null)!!,
                    //sharedPreferences.getString("email", null),
                    sharedPreferences.getBoolean("enabled",false),
                    sharedPreferences.getString("ldapUser",null)!!,
                    sharedPreferences.getString("roleType",null)!!
            )
        }

    fun saveUser(user: User) {

        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putInt("id", user.id)
        editor.putLong("created", user.created)
        editor.putLong("updated", user.updated)
        editor.putBoolean("deleted", user.deleted)
        editor.putString("firstName", user.firstName)
        editor.putString("lastName", user.lastName)
        editor.putString("username", user.username)
        editor.putString("pssrwd", user.pssrwd)
        editor.putString("email", user.email)
        editor.putBoolean("enabled", user.enabled)
        editor.putString("ldapUser", user.ldapUser)
        editor.putString("roleType", user.roleType)

        editor.apply()

    }
    val token: Token
        get() {
            val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE)
            return Token(

                    sharedPreferences.getString("accessToken",null)!!
            )
        }

    fun saveToken(token: String) {

        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()


        editor.putString("accessToken", token)


        editor.apply()

    }


    fun clear() {
        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    companion object {
        private val SHARED_PREF_NAME = "my_shared_preff"
        private val SHARED_PREF_NAME2 = "my_shared_preff2"
        private var mInstance: SharedPrefManager? = null
        @Synchronized
        fun getInstance(mCtx: Context): SharedPrefManager {
            if (mInstance == null) {
                mInstance = SharedPrefManager(mCtx)
            }
            return mInstance as SharedPrefManager
        }
    }

}