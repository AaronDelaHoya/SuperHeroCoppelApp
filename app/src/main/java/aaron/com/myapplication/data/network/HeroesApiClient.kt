package aaron.com.myapplication.data.network

import retrofit2.Response
import retrofit2.http.GET
import aaron.com.myapplication.data.model.Result
import retrofit2.http.Path
import retrofit2.http.Url

const val URL = "?ts=1&apikey=8c1130ff60050fe3053f7de59a031339&hash=1efaff2a686fb95057cc797ac097402b"
interface HeroesApiClient {

    @GET("v1/public/characters${URL}")
    suspend fun getHeroes(): Response<Result>

}