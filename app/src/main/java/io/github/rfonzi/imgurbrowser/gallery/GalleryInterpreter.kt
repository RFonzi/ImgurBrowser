package io.github.rfonzi.imgurbrowser.gallery

import io.github.rfonzi.imgurbrowser.stores.AlbumStore
import io.reactivex.Observable

class GalleryInterpreter(private val albumStore: AlbumStore) {

    fun interpret(loadRequest: Observable<Unit>): GalleryUiModel {
        val gallery = loadRequest
                .map { albumStore.getData() }
                .map { it }

        return GalleryUiModel(gallery)
    }
}