package io.github.rfonzi.imgurbrowser.gallery.remote

import io.github.rfonzi.imgurbrowser.gallery.ui.GalleryModel
import io.github.rfonzi.imgurbrowser.gallery.remote.stores.AlbumStore
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.async

class GalleryRepository(private val albumStore: AlbumStore) {

    suspend fun getFirstPage(): Deferred<GalleryModel> {

        val albumList = albumStore.getData().await()

        return CoroutineScope(Dispatchers.IO).async { GalleryModel(albumList) }

    }


}