package io.github.rfonzi.imgurbrowser.gallery.remote

import io.github.rfonzi.imgurbrowser.gallery.ui.GalleryModel
import io.github.rfonzi.imgurbrowser.gallery.remote.stores.AlbumStore
import io.reactivex.Observable

class GalleryRepository(private val albumStore: AlbumStore) {

    fun getFirstPage(): Observable<GalleryModel> {

        return albumStore.getData()
                .map { GalleryModel(it) }

    }


}