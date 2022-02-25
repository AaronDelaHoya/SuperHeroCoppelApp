package aaron.com.myapplication.data.model

class HeroesProvider {
    companion object{
        var heroes:List<HeroModel> = emptyList()
        lateinit var hero : HeroModel
    }
}