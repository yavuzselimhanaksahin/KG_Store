package com.yavuzselimhanaksahin.loginappkgstore.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.yavuzselimhanaksahin.loginappkgstore.*
import com.yavuzselimhanaksahin.loginappkgstore.storage.SharedPrefManager
import kotlinx.android.synthetic.main.activity_profile.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        val retrofit = Retrofit.Builder()
            .baseUrl("http://142.93.132.49:8080/KG-Store/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)

        val prefs = getSharedPreferences("my_shared_preff2", MODE_PRIVATE)
        val acstkn = prefs.getString("accessToken", "No name defined")
        //textView.text = acstkn
        println(acstkn)



        api.fetchAllApps("Bearer ${acstkn}").enqueue(object : Callback<AppResponse> {
            override fun onResponse(call: Call<AppResponse>, response: Response<AppResponse>) {
                println(response.body())

                val layoutManager = LinearLayoutManager(this@ProfileActivity)
                recyclerView.layoutManager = layoutManager


                var List: List<Model>? = null
                List = response?.body()!!.model

                //adapter  oluştur recyclerView.adapter a eşitle
                recyclerView.adapter = MyAdapter(List)
            }
            override fun onFailure(call: Call<AppResponse>, t: Throwable) {
                println(t.message)
            }
        })

        /*val prefs = getSharedPreferences("my_shared_preff2", MODE_PRIVATE)
        val acstkn = prefs.getString("accessToken", "No name defined")
        textView.text = acstkn*/


    }
    /*override fun onStart() {
        super.onStart()

        if(!SharedPrefManager.getInstance(this).isLoggedIn){
            val intent = Intent(applicationContext, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
        }

    }*/

}