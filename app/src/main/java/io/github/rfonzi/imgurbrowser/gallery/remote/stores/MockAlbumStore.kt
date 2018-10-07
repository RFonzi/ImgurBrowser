package io.github.rfonzi.imgurbrowser.gallery.remote.stores

import android.content.Context
import com.squareup.moshi.Moshi
import io.github.rfonzi.imgurbrowser.gallery.remote.mockData
import io.github.rfonzi.imgurbrowser.model.Album
import io.github.rfonzi.imgurbrowser.gallery.remote.model.ResponseModel
import io.github.rfonzi.imgurbrowser.gallery.remote.model.toAlbum
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.async

class MockAlbumStore(private val context: Context) : AlbumStore {
    override suspend fun getData(): Deferred<List<Album>> {
        val moshi = Moshi.Builder().build()
        val jsonAdapter = moshi.adapter(ResponseModel::class.java)


        val response = jsonAdapter.fromJson(mockData(context))
        val albums = response?.data?.map { it.toAlbum() } ?: emptyList()
        return CoroutineScope(Dispatchers.IO).async { albums.filter { it.images.isNotEmpty() } }
    }
}