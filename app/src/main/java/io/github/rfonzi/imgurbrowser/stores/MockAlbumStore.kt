package io.github.rfonzi.imgurbrowser.stores

import android.content.Context
import com.squareup.moshi.Moshi
import io.github.rfonzi.imgurbrowser.gallery.mockData
import io.github.rfonzi.imgurbrowser.model.Album
import io.github.rfonzi.imgurbrowser.model.ResponseModel
import io.github.rfonzi.imgurbrowser.model.toAlbum

class MockAlbumStore(private val context: Context) : AlbumStore {
    override fun getData(): List<Album> {
        val moshi = Moshi.Builder().build()
        val jsonAdapter = moshi.adapter(ResponseModel::class.java)


        val response = jsonAdapter.fromJson(mockData(context))
        val albums = response?.data?.map { it.toAlbum() } ?: emptyList()
        return albums.filter { it.images.isNotEmpty() }
    }
}