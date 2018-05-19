package io.github.rfonzi.imgurbrowser.gallery

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.flexbox.*
import io.github.rfonzi.imgurbrowser.R
import io.github.rfonzi.imgurbrowser.stores.AlbumStore
import io.github.rfonzi.imgurbrowser.stores.MockAlbumStore
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.gallery_fragment.*


class GalleryFragment : Fragment() {

    private lateinit var galleryAdapter: GalleryAdapter
    private lateinit var albumStore: AlbumStore

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        galleryAdapter = GalleryAdapter()


        return inflater.inflate(R.layout.gallery_fragment, container, false)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        albumStore = MockAlbumStore(context)
    }

    override fun onResume() {
        super.onResume()

        galleryRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = galleryAdapter
        }

        val viewModel = interpret(Observable.just(Unit), albumStore)
        viewModel.gallery
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    galleryAdapter.submitList(it)
                }
    }

}
