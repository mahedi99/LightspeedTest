package com.example.lightspeedtest.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lightspeedtest.R
import com.example.lightspeedtest.data.model.Photo

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    private var photoList: List<Photo> = emptyList()

    // Describes an item view and its place within the RecyclerView
    class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val bookIV: ImageView = itemView.findViewById(R.id.bookPhotoIV)
        private val authorTV: TextView = itemView.findViewById(R.id.author_TV)

        fun bind(photo: Photo) {
            authorTV.text = photo.author
            Glide.with(itemView.context)
                .load(photo.download_url) // image url
                .placeholder(R.drawable.ic_launcher_foreground) // any placeholder to load at start
                .override(200, 200) // resizing
                .centerCrop()
                .into(bookIV);
        }
    }

    // Returns a new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_item, parent, false)

        return PhotoViewHolder(view)
    }

    // Returns size of data list
    override fun getItemCount(): Int {
        return photoList.size
    }

    fun addItems(items: List<Photo>) {
        photoList = items
    }

    // Displays data at a certain position
    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photoList[position])
    }
}