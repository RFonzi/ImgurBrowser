package io.github.rfonzi.imgurbrowser.gallery.remote.model
import com.squareup.moshi.Json
import io.github.rfonzi.imgurbrowser.model.Album
import io.github.rfonzi.imgurbrowser.model.Image


data class ResponseModel(
        @Json(name = "data") val data: List<ResponseAlbum> = listOf(),
        @Json(name = "success") val success: Boolean = false,
        @Json(name = "status") val status: Int = 0
)

data class ResponseAlbum(
        @Json(name = "id") val id: String = "",
        @Json(name = "title") val title: String = "",
        @Json(name = "description") val description: Any = Any(),
        @Json(name = "datetime") val datetime: Int = 0,
        @Json(name = "cover") val cover: String = "",
        @Json(name = "cover_width") val coverWidth: Int = 0,
        @Json(name = "cover_height") val coverHeight: Int = 0,
        @Json(name = "account_url") val accountUrl: String = "",
        @Json(name = "account_id") val accountId: Int = 0,
        @Json(name = "privacy") val privacy: String = "",
        @Json(name = "layout") val layout: String = "",
        @Json(name = "views") val views: Int = 0,
        @Json(name = "link") val link: String = "",
        @Json(name = "ups") val ups: Int = 0,
        @Json(name = "downs") val downs: Int = 0,
        @Json(name = "points") val points: Int = 0,
        @Json(name = "score") val score: Int = 0,
        @Json(name = "is_album") val isAlbum: Boolean = false,
        @Json(name = "vote") val vote: Any = Any(),
        @Json(name = "favorite") val favorite: Boolean = false,
        @Json(name = "nsfw") val nsfw: Boolean = false,
        @Json(name = "section") val section: String = "",
        @Json(name = "comment_count") val commentCount: Int = 0,
        @Json(name = "favorite_count") val favoriteCount: Int = 0,
        @Json(name = "topic") val topic: String = "",
        @Json(name = "topic_id") val topicId: Int = 0,
        @Json(name = "images_count") val imagesCount: Int = 0,
        @Json(name = "in_gallery") val inGallery: Boolean = false,
        @Json(name = "is_ad") val isAd: Boolean = false,
        @Json(name = "tags") val tags: List<Any> = listOf(),
        @Json(name = "ad_type") val adType: Int = 0,
        @Json(name = "ad_url") val adUrl: String = "",
        @Json(name = "in_most_viral") val inMostViral: Boolean = false,
        @Json(name = "images") val images: List<ResponseImage> = listOf(),
        @Json(name = "type") val type: String = "",
        @Json(name = "animated") val animated: Boolean = false,
        @Json(name = "width") val width: Int = 0,
        @Json(name = "height") val height: Int = 0,
        @Json(name = "size") val size: Int = 0,
        @Json(name = "bandwidth") val bandwidth: Long = 0,
        @Json(name = "has_sound") val hasSound: Boolean = false,
        @Json(name = "mp4") val mp4: String = "",
        @Json(name = "gifv") val gifv: String = "",
        @Json(name = "mp4_size") val mp4Size: Int = 0,
        @Json(name = "looping") val looping: Boolean = false
)

data class ResponseImage(
    @Json(name = "id") val id: String = "",
    @Json(name = "title") val title: Any = Any(),
    @Json(name = "description") val description: Any = Any(),
    @Json(name = "datetime") val datetime: Int = 0,
    @Json(name = "type") val type: String = "",
    @Json(name = "animated") val animated: Boolean = false,
    @Json(name = "width") val width: Int = 0,
    @Json(name = "height") val height: Int = 0,
    @Json(name = "size") val size: Int = 0,
    @Json(name = "views") val views: Int = 0,
    @Json(name = "bandwidth") val bandwidth: Long = 0,
    @Json(name = "vote") val vote: Any = Any(),
    @Json(name = "favorite") val favorite: Boolean = false,
    @Json(name = "nsfw") val nsfw: Any = Any(),
    @Json(name = "section") val section: Any = Any(),
    @Json(name = "account_url") val accountUrl: Any = Any(),
    @Json(name = "account_id") val accountId: Any = Any(),
    @Json(name = "is_ad") val isAd: Boolean = false,
    @Json(name = "in_most_viral") val inMostViral: Boolean = false,
    @Json(name = "has_sound") val hasSound: Boolean = false,
    @Json(name = "tags") val tags: List<Any> = listOf(),
    @Json(name = "ad_type") val adType: Int = 0,
    @Json(name = "ad_url") val adUrl: String = "",
    @Json(name = "in_gallery") val inGallery: Boolean = false,
    @Json(name = "link") val link: String = "",
    @Json(name = "mp4") val mp4: String = "",
    @Json(name = "gifv") val gifv: String = "",
    @Json(name = "mp4_size") val mp4Size: Int = 0,
    @Json(name = "looping") val looping: Boolean = false,
    @Json(name = "comment_count") val commentCount: Any = Any(),
    @Json(name = "favorite_count") val favoriteCount: Any = Any(),
    @Json(name = "ups") val ups: Any = Any(),
    @Json(name = "downs") val downs: Any = Any(),
    @Json(name = "points") val points: Any = Any(),
    @Json(name = "score") val score: Any = Any()
)

fun ResponseImage.toImage() = Image(link = link)

fun ResponseAlbum.toAlbum() = Album(images = images.map { it.toImage() })