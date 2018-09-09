package io.github.rfonzi.imgurbrowser.gallery.remote

import android.content.Context
import io.github.rfonzi.imgurbrowser.R

fun mockData(context: Context) = context.resources.openRawResource(R.raw.mock_gallery_response)
        .bufferedReader().use {
            it.readText()
        }