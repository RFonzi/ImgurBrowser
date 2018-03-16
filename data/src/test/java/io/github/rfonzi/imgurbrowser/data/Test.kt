import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import io.github.rfonzi.imgurbrowser.data.local.Album
import io.github.rfonzi.imgurbrowser.data.remote.ResponseModel
import io.github.rfonzi.imgurbrowser.data.mockloaders.MockGalleryLoader
import org.junit.Test

/**
 * Created by Ryan on 2/27/2018.
 */
class Test {

    val moshi = Moshi.Builder()
            .build()

    @Test
    fun shouldLoadResponse() {
        val responseModel = ResponseModel(emptyList())


        val jsonAdapter: JsonAdapter<ResponseModel> = moshi.adapter(ResponseModel::class.java)

        val list: List<Album> = jsonAdapter.fromJson(MockGalleryLoader().getMockData())?.data ?: emptyList()

        list.forEach { println(it) }
    }

}