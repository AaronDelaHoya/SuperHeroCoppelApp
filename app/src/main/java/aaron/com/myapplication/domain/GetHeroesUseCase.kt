package aaron.com.myapplication.domain

import aaron.com.myapplication.data.HeroesRepository
import aaron.com.myapplication.data.model.HeroModel
import aaron.com.myapplication.data.model.HeroesProvider

class GetHeroesUseCase {

    private  val repository = HeroesRepository()

    suspend operator fun invoke():List<HeroModel>?{
        return repository.getAllHeroes()
    }

}