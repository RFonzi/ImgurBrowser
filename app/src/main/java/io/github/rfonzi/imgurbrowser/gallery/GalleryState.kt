package io.github.rfonzi.imgurbrowser.gallery

sealed class GalleryState {
    object Loading : GalleryState()
    object Idle : GalleryState()
}

sealed class GalleryTransition {
    object DataLoaded : GalleryTransition()
}