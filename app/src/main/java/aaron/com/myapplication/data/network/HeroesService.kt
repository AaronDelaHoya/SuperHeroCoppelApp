package aaron.com.myapplication.data.network

import aaron.com.myapplication.core.HeroesRetrofit
import aaron.com.myapplication.data.model.HeroModel
import aaron.com.myapplication.data.model.Result
import aaron.com.myapplication.data.model.Url
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HeroesService {
    private val retrofitApi = HeroesRetrofit.getRetrofit()

    suspend fun getHeroesList():List<HeroModel>{
        return withContext(Dispatchers.IO){
            val response = retrofitApi.create(HeroesApiClient::class.java).getHeroes()
            response.body()?.data?.results ?: emptyList()
        }
    }

}