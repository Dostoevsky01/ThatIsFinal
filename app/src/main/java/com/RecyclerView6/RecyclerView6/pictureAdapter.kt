package com.RecyclerView6.RecyclerView6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.RecyclerView6.R

class pictureAdapter (private val androidPictures: List<Pictures>) :RecyclerView.Adapter<pictureAdapter.pictureViewHolder>() {

    class pictureViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val  imageview: ImageView = itemView.findViewById(R.id.imageView)

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): pictureViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.pictures_activity, parent,false)
        return pictureViewHolder(view)
    }


    override fun onBindViewHolder(holder: pictureViewHolder, position: Int) {
        val p = androidPictures[position]
        Glide.with(holder.imageview.context)

            .load(p.links)
            .centerCrop()
            .into(holder.imageview)
    }

    override fun getItemCount(): Int = androidPictures.size


}