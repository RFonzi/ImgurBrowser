package io.github.rfonzi.imgurbrowser.gallery

import android.content.Context
import com.squareup.moshi.Moshi
import io.github.rfonzi.imgurbrowser.model.Album
import io.github.rfonzi.imgurbrowser.model.Gallery
import io.github.rfonzi.imgurbrowser.model.ResponseModel
import io.github.rfonzi.imgurbrowser.model.toAlbum
import io.reactivex.Observable

data class GalleryViewModel(val gallery: Observable<List<Album>>)

fun interpret(loadRequest: Observable<Unit>, context: Context): GalleryViewModel {
    val gallery = loadRequest
            .map { getData(context) }
            .map { it }

    return GalleryViewModel(gallery)
}

private fun getData(context: Context): List<Album> {
    val moshi = Moshi.Builder().build()
    val jsonAdapter = moshi.adapter(ResponseModel::class.java)


    val response = jsonAdapter.fromJson(mockData(context))
    val albums = response?.data?.map { it.toAlbum() } ?: emptyList()
    return albums.filter { it.images.isNotEmpty() }
}

