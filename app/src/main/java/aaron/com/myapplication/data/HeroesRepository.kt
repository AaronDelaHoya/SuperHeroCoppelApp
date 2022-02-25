package aaron.com.myapplication.data

import aaron.com.myapplication.data.model.HeroModel
import aaron.com.myapplication.data.model.HeroesProvider
import aaron.com.myapplication.data.network.HeroesService

class HeroesRepository {
    private  val api = HeroesService()

    suspend fun getAllHeroes () : List<HeroModel>{
        val response = api.getHeroesList()
        HeroesProvider.heroes = response
        return response
    }


}