package io.github.rfonzi.imgurbrowser.gallery.ui

import android.arch.lifecycle.ViewModel
import io.github.rfonzi.imgurbrowser.gallery.remote.GalleryRepository

class GalleryViewModel(private val galleryRepository: GalleryRepository) : ViewModel() {

    private fun getMockData() = galleryRepository.getFirstPage()

    fun getModel() = getMockData()

}