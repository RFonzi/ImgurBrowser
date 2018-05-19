package io.github.rfonzi.imgurbrowser.gallery

import android.content.Context
import com.squareup.moshi.Moshi
import io.github.rfonzi.imgurbrowser.model.Album
import io.github.rfonzi.imgurbrowser.model.ResponseModel
import io.github.rfonzi.imgurbrowser.model.toAlbum
import io.reactivex.Observable

data class GalleryUiModel(val gallery: Observable<List<Album>>)

fun interpret(loadRequest: Observable<Unit>, context: Context): GalleryUiModel {
    val gallery = loadRequest
            .map { getData(context) }
            .map { it }

    return GalleryUiModel(gallery)
}

private fun getData(context: Context): List<Album> {
    val moshi = Moshi.Builder().build()
    val jsonAdapter = moshi.adapter(ResponseModel::class.java)


    val response = jsonAdapter.fromJson(mockData(context))
    val albums = response?.data?.map { it.toAlbum() } ?: emptyList()
    return albums.filter { it.images.isNotEmpty() }
}

