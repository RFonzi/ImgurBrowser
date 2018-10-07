package io.github.rfonzi.imgurbrowser.gallery.remote.stores

import io.github.rfonzi.imgurbrowser.model.Album
import kotlinx.coroutines.experimental.Deferred

interface AlbumStore {

    suspend fun getData(): Deferred<List<Album>>
}