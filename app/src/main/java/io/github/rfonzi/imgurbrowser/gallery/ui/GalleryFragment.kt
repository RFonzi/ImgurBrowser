package io.github.rfonzi.imgurbrowser.gallery.ui

import android.arch.lifecycle.ViewModelProviders
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Space
import io.github.rfonzi.imgurbrowser.R
import io.github.rfonzi.imgurbrowser.SpacesItemDecoration
import io.github.rfonzi.imgurbrowser.gallery.remote.GalleryRepository
import io.github.rfonzi.imgurbrowser.getFactoryFor
import kotlinx.android.synthetic.main.gallery_fragment.*
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance


class GalleryFragment : Fragment(), KodeinAware {
    override val kodein by lazy { (activity?.applicationContext as KodeinAware).kodein }


    private lateinit var galleryAdapter: GalleryAdapter
    private val galleryRepo: GalleryRepository by instance()
    private lateinit var vm: GalleryViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        galleryAdapter = GalleryAdapter()

        vm = ViewModelProviders.of(this, getFactoryFor(GalleryViewModel(galleryRepo))).get(GalleryViewModel::class.java)

        return inflater.inflate(R.layout.gallery_fragment, container, false)

    }

    override fun onResume() {
        super.onResume()

        galleryRecyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = galleryAdapter
        }

        CoroutineScope(Dispatchers.Main).launch {
            val model = vm.getModel().await()
            render(model)
        }

    }

    private fun render(model: GalleryModel) {
        galleryAdapter.submitList(model.gallery)
        galleryAdapter.notifyDataSetChanged()
    }

}
