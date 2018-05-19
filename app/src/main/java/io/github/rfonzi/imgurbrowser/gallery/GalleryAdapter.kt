package io.github.rfonzi.imgurbrowser.gallery

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import io.github.rfonzi.imgurbrowser.R
import io.github.rfonzi.imgurbrowser.model.Album
import io.github.rfonzi.imgurbrowser.model.Image
import kotlinx.android.synthetic.main.gallery_item.view.*

class GalleryAdapter : ListAdapter<Album, GalleryAdapter.ImageViewHolder>(IMAGE_DIFF) {
    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val thumbnailUrl: String = getItem(position).images[0].link

        Glide.with(holder.itemView)
                .load(thumbnailUrl)
                .into(holder.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gallery_item, parent, false)
        return ImageViewHolder(view)
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.galleryItem

    }


    companion object {
        val IMAGE_DIFF = object : DiffUtil.ItemCallback<Album>() {
            override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
                return oldItem.images[0].link == newItem.images[0].link
            }

            override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
                return oldItem.images[0].link == newItem.images[0].link
            }

        }
    }
}


