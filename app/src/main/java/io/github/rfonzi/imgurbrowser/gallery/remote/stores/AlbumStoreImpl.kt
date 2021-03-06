package io.github.rfonzi.imgurbrowser.gallery.remote.stores

import io.github.rfonzi.imgurbrowser.gallery.remote.api.ImgurGalleryService
import io.github.rfonzi.imgurbrowser.gallery.remote.model.ResponseModel
import io.github.rfonzi.imgurbrowser.gallery.remote.model.toAlbum
import io.github.rfonzi.imgurbrowser.model.Album
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.async

class AlbumStoreImpl(private val galleryService: ImgurGalleryService, private val clientId: String) : AlbumStore {
    override suspend fun getData(): Deferred<List<Album>> {
        val response = galleryService.getHot(clientId = clientId).await()

        return CoroutineScope(Dispatchers.IO).async { response.toAlbumList() }
    }

    private fun ResponseModel.toAlbumList() = this.data.map { it.toAlbum().changeLinksToMediumThumbnail() }

    private fun Album.changeLinksToMediumThumbnail(): Album {
        val changedLinks = this.images.map {
            val split = it.link.split(".").toMutableList()
            val lastIndex = split.lastIndex - 1
            split[lastIndex] += "m"
            it.copy(link = split.joinToString("."))
        }

        return this.copy(images = changedLinks)
    }
}
