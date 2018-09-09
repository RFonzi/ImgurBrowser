package io.github.rfonzi.imgurbrowser.gallery.remote.stores

import io.github.rfonzi.imgurbrowser.model.Album
import io.reactivex.Observable

interface AlbumStore {

    fun getData(): Observable<List<Album>>
}