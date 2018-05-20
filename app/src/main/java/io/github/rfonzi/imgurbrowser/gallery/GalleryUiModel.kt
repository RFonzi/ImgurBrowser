package io.github.rfonzi.imgurbrowser.gallery

import android.content.Context
import com.squareup.moshi.Moshi
import io.github.rfonzi.imgurbrowser.model.Album
import io.github.rfonzi.imgurbrowser.model.ResponseModel
import io.github.rfonzi.imgurbrowser.model.toAlbum
import io.github.rfonzi.imgurbrowser.stores.AlbumStore
import io.reactivex.Observable

data class GalleryUiModel(val gallery: Observable<List<Album>>)
