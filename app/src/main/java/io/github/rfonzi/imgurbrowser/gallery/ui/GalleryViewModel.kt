package io.github.rfonzi.imgurbrowser.gallery.ui

import android.arch.lifecycle.ViewModel
import io.github.rfonzi.imgurbrowser.gallery.remote.GalleryRepository

class GalleryViewModel(private val galleryRepository: GalleryRepository) : ViewModel() {

    suspend fun getModel() = galleryRepository.getFirstPage()

}