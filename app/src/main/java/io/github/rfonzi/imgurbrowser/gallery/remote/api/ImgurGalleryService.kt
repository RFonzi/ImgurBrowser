package io.github.rfonzi.imgurbrowser.gallery.remote.api

import io.github.rfonzi.imgurbrowser.gallery.remote.model.ResponseModel
import io.reactivex.Observable
import retrofit2.http.*

interface ImgurGalleryService {

    @GET("gallery/hot//{page}")
    fun getHot(@Header("Authorization") clientId: String? = null, @Path("page") page: Int = 1): Observable<ResponseModel>

}