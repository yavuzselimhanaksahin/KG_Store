package com.yavuzselimhanaksahin.loginappkgstore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter2 (var mCtx:Context, var resources:Int, var items:List<AppModel>):ArrayAdapter<AppModel>(mCtx, resources, items){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater = LayoutInflater.from(mCtx)
        val view:View = layoutInflater.inflate(resources, null)

        val imageView:ImageView = view.findViewById(R.id.image1)
        val titleTextView:TextView = view.findViewById(R.id.textview999)
        val descriptionTextView:TextView = view.findViewById(R.id.textview998)


        var mItem:AppModel = items[position]
        imageView.setImageDrawable(mCtx.resources.getDrawable(mItem.img))
        titleTextView.text = mItem.name
        descriptionTextView.text = mItem.version
        return view
    }
}