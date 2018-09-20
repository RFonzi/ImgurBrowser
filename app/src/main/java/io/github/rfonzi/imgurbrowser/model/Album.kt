package io.github.rfonzi.imgurbrowser.model

/**
 * Created by Ryan on 2/27/2018.
 */
data class Album(
        val title: String,
        val submitter: String,
        val albumLink: String,
        val images: List<Image>,
        val upvotes: Int
)