package io.github.rfonzi.imgurbrowser

import android.app.Application
import io.github.rfonzi.imgurbrowser.gallery.remote.GalleryRepository
import io.github.rfonzi.imgurbrowser.gallery.remote.stores.MockAlbumStore
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

class App : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        bind<GalleryRepository>() with singleton { GalleryRepository(MockAlbumStore(applicationContext)) }
    }


}