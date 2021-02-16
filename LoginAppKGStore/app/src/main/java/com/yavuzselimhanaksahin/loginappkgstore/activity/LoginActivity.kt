package com.yavuzselimhanaksahin.loginappkgstore.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.yavuzselimhanaksahin.loginappkgstore.R
import com.yavuzselimhanaksahin.loginappkgstore.api.RetrofitClient
import com.yavuzselimhanaksahin.loginappkgstore.model.LoginResponse
import com.yavuzselimhanaksahin.loginappkgstore.model.SignInBody
import com.yavuzselimhanaksahin.loginappkgstore.storage.SharedPrefManager
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_profile.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonLogin.setOnClickListener {
            val username = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            if(username.isEmpty()){
                editTextEmail.error = "username required"
                editTextEmail.requestFocus()
                return@setOnClickListener
            }


            if(password.isEmpty()){
                editTextPassword.error = "Password required"
                editTextPassword.requestFocus()
                return@setOnClickListener
            }
            val signInInfo = SignInBody(username, password)

            RetrofitClient.instance.userLogin(signInInfo)
                .enqueue(object : Callback<LoginResponse> {
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                        if (response.body()?.accessToken != null) {
                            //println(response.body()!!.accessToken)

                            SharedPrefManager.getInstance(applicationContext).saveUser(response.body()?.user!!)

                            SharedPrefManager.getInstance(applicationContext).saveToken(response.body()?.accessToken!!)

                            //val sharedPreferences = getSharedPreferences("SHARED_PREF_NAME2", Context.MODE_PRIVATE)
                            //val stringanahtar = sharedPreferences.getString("accessToken", null)
                            val denemestring = response.body()?.accessToken!!
                            println(denemestring)

                            val editor = getSharedPreferences("my_shared_preff2", MODE_PRIVATE).edit()
                            editor.putString("accessToken", denemestring)
                            editor.apply()
                            val prefs = getSharedPreferences("my_shared_preff2", MODE_PRIVATE)
                            val acstkn = prefs.getString("accessToken", "No name defined")
                            println(acstkn)

                            val intent = Intent(applicationContext, ListActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                            startActivity(intent)


                        } else {
                            Toast.makeText(applicationContext, "olmadi", Toast.LENGTH_LONG).show()
                        }

                    }
                })
        }
    }
    /*override fun onStart() {
        super.onStart()

        if(SharedPrefManager.getInstance(this).isLoggedIn){
            val intent = Intent(applicationContext, ListActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
        }
    }*/
}