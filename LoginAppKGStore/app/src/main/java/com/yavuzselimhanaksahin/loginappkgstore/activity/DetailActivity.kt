package com.yavuzselimhanaksahin.loginappkgstore.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yavuzselimhanaksahin.loginappkgstore.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val prefs2 = getSharedPreferences("detay", MODE_PRIVATE)
        val idno = prefs2.getString("idno", "No name defined")
        val name = prefs2.getString("name", "No name defined")
        val version = prefs2.getString("version", "No name defined")
        val size = prefs2.getString("size", "No name defined")
        val stage = prefs2.getString("stage", "No name defined")
        val appType = prefs2.getString("appType", "No name defined")
        val node = prefs2.getString("node", "No name defined")
        ilk.text = "id no : " + idno
        ilk2.text = "name : " + name
        ilk3.text = "versiyon : " + version
        ilk4.text = "size : " + size
        ilk5.text = "stage : " + stage
        ilk6.text = "appType : " + appType
        ilk7.text = "node : " + node








    }
}