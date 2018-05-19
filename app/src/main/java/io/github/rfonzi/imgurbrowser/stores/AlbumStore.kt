package io.github.rfonzi.imgurbrowser.stores

import io.github.rfonzi.imgurbrowser.model.Album

interface AlbumStore {

    fun getData(): List<Album>
}