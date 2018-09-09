package io.github.rfonzi.imgurbrowser.gallery.remote.stores

import android.content.Context
import com.squareup.moshi.Moshi
import io.github.rfonzi.imgurbrowser.gallery.remote.mockData
import io.github.rfonzi.imgurbrowser.model.Album
import io.github.rfonzi.imgurbrowser.model.ResponseModel
import io.github.rfonzi.imgurbrowser.model.toAlbum
import io.reactivex.Observable

class MockAlbumStore(private val context: Context) : AlbumStore {
    override fun getData(): Observable<List<Album>> {
        val moshi = Moshi.Builder().build()
        val jsonAdapter = moshi.adapter(ResponseModel::class.java)


        val response = jsonAdapter.fromJson(mockData(context))
        val albums = response?.data?.map { it.toAlbum() } ?: emptyList()
        return Observable.just(albums.filter { it.images.isNotEmpty() })
    }
}