package com.yavuzselimhanaksahin.loginappkgstore.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.yavuzselimhanaksahin.loginappkgstore.*
import kotlinx.android.synthetic.main.activity_profile.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

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

                /*val layoutManager = LinearLayoutManager(this@ListActivity)
                recyclerView.layoutManager = layoutManager


                var List: List<Model>? = null
                List = response?.body()!!.model

                //adapter  oluştur recyclerView.adapter a eşitle
                recyclerView.adapter = MyAdapter(List)*/

                //----------------

                var List1: List<Model>? = null
                List1 = response?.body()!!.model


                var listview = findViewById<ListView>(R.id.listView)

                var list = mutableListOf<AppModel>()

                for (i in List1.indices) {
                    list.add(
                        AppModel(
                            List1.get(i).id,
                            List1.get(i).name,
                            List1.get(i).version,
                            List1.get(i).size,
                            R.drawable.ic_launcher_background
                        )
                    )
                }

                listview.adapter = MyAdapter2(this@ListActivity, R.layout.row, list)
                listview.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->

                    val editor2 = getSharedPreferences("detay", MODE_PRIVATE).edit()
                    editor2.putString("idno", List1.get(position).id.toString())
                    editor2.putString("name", List1.get(position).name)
                    editor2.putString("version", List1.get(position).version)
                    editor2.putString("size", List1.get(position).size.toString())
                    editor2.putString("stage", List1.get(position).stage)
                    editor2.putString("appType", List1.get(position).appType)
                    editor2.putString("node", List1.get(position).node)
                    editor2.apply()
                    val prefs2 = getSharedPreferences("detay", MODE_PRIVATE)
                    val idno = prefs2.getString("idno", "No name defined")
                    val name = prefs2.getString("name", "No name defined")
                    val version = prefs2.getString("version", "No name defined")
                    val size = prefs2.getString("size", "No name defined")
                    val stage = prefs2.getString("stage", "No name defined")
                    val appType = prefs2.getString("appType", "No name defined")
                    val node = prefs2.getString("node", "No name defined")

                    println(idno)
                    println(name)
                    println(version)
                    println(size)
                    val intent = Intent(applicationContext, DetailActivity::class.java)
                    //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)

                }


                //----------------
            }

            override fun onFailure(call: Call<AppResponse>, t: Throwable) {
                println(t.message)

            }
        })


        //---------





    }

}