package io.github.rfonzi.imgurbrowser.gallery.ui

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import io.github.rfonzi.imgurbrowser.GlideApp
import io.github.rfonzi.imgurbrowser.R
import io.github.rfonzi.imgurbrowser.model.Album
import kotlinx.android.synthetic.main.gallery_item.view.*
import org.w3c.dom.Text

class GalleryAdapter : ListAdapter<Album, GalleryAdapter.GalleryViewHolder>(IMAGE_DIFF) {
    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val album = getItem(position)

        if (album.images.isNotEmpty()){
            GlideApp.with(holder.itemView)
                    .load(album.images[0].link)
                    .placeholder(R.drawable.ic_error_outline_black_24dp)
                    .dontTransform()
                    .into(holder.image)
        }
        else {
            GlideApp.with(holder.itemView)
                    .load(R.drawable.ic_error_outline_black_24dp)
                    .into(holder.image)
        }

        holder.title.text = album.title
        holder.submitter.text = album.submitter
        holder.upvotes.text = album.upvotes.toString()


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gallery_item, parent, false)
        return GalleryViewHolder(view)
    }

    class GalleryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.galleryThumbnail
        val title: TextView = itemView.galleryTitle
        val submitter: TextView = itemView.gallerySubmitter
        val upvotes: TextView = itemView.galleryUpvotes

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


