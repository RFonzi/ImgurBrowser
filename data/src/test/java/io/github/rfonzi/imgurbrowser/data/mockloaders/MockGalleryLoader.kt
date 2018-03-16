package io.github.rfonzi.imgurbrowser.data.mockloaders

import java.io.File

/**
 * Created by Ryan on 2/27/2018.
 */
class MockGalleryLoader {
    private val response: String = File("data/src/test/resources/mockGalleryResponse.json").readText()

    fun getMockData() : String {
        return response
    }
}