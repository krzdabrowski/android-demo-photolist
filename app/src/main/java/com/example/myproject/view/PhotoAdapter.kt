package com.example.myproject.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myproject.R
import com.example.myproject.model.Photo
import kotlinx.android.synthetic.main.item_photo.view.*

class PhotoAdapter(private val context: Context, private val items: List<Photo>) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(LayoutInflater.from(context).inflate(R.layout.item_photo, parent, false))
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class PhotoViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: Photo) {
            view.tv_id.text = data.id as String
            Glide.with(view.context).load(data.imageUrl).into(view.iv_photo)
        }
    }
}