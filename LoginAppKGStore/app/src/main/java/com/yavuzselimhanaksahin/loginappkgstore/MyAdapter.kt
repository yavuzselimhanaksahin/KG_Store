package com.yavuzselimhanaksahin.loginappkgstore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.deneme123.view.*
import kotlinx.android.synthetic.main.row_layout.view.*

class MyAdapter(val myList: List<Model>): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    //myList = emptyList<Model>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.textView.text = myList[position].name
        //holder.itemView.uygulamabilgisi2.text = myList[position].name
        /*holder.itemView.textView2.text = "created: " + myList[position].created.toString()
        holder.itemView.textView3.text = "updated : " + myList[position].updated.toString()
        holder.itemView.textView4.text = "deleted : " + myList[position].deleted.toString()
        holder.itemView.textView5.text = "name : " + myList[position].name
        holder.itemView.textView6.text = "version : " + myList[position].version
        holder.itemView.textView7.text = "size : " + myList[position].size.toString()
        holder.itemView.textView8.text = "description : " + myList[position].description
        holder.itemView.textView9.text = "downloadLink : " + myList[position].downloadLink
        holder.itemView.textView10.text = "iconLink : " + myList[position].iconLink
        holder.itemView.textView11.text = "stage : " + myList[position].stage
        holder.itemView.textView12.text = "appType : " + myList[position].appType
        holder.itemView.textView13.text = "status : " + myList[position].status
        holder.itemView.textView14.text = "node : " + myList[position].node*/

    }
}