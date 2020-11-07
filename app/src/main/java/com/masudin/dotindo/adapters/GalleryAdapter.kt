package com.masudin.dotindo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.masudin.dotindo.R
import com.masudin.dotindo.galeri.OnItemRecyclerClick
import com.masudin.dotindo.model.DataItem
import com.masudin.dotindo.model.ResponseGallery
import com.squareup.picasso.Picasso

class GalleryAdapter: RecyclerView.Adapter<GalleryAdapter.MyViewHolder>(){

    var items  =  ArrayList<DataItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.card_gallery,parent,false)
        return MyViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
        holder.img_view.setOnClickListener{
        }
    }


    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view){

        val img_view = view.findViewById<ImageView>(R.id.img_card_galery)

        fun bind(dataItem: DataItem){
            Picasso.get().load(dataItem.image).into(img_view)
        }
    }



}