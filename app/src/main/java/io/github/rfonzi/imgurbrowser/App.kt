package io.github.rfonzi.imgurbrowser

import android.app.Application
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import io.github.rfonzi.imgurbrowser.gallery.remote.GalleryRepository
import io.github.rfonzi.imgurbrowser.gallery.remote.api.ImgurGalleryService
import io.github.rfonzi.imgurbrowser.gallery.remote.stores.AlbumStore
import io.github.rfonzi.imgurbrowser.gallery.remote.stores.AlbumStoreImpl
import io.github.rfonzi.imgurbrowser.gallery.remote.stores.MockAlbumStore
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class App : Application(), KodeinAware {

    val clientId = BuildConfig.IMGUR_CLIENT_ID
    val retrofit = Retrofit.Builder()
            .baseUrl("https://api.imgur.com/3/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

    override val kodein: Kodein = Kodein.lazy {
        bind<ImgurGalleryService>() with singleton { retrofit.create(ImgurGalleryService::class.java) }
        bind<AlbumStore>() with singleton { AlbumStoreImpl(instance(), "Client-ID $clientId") }
        bind<GalleryRepository>() with singleton { GalleryRepository(instance()) }
    }


}