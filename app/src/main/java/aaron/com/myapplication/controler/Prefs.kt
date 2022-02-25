package aaron.com.myapplication.controler

import android.content.Context

class Prefs(val context : Context) {

    val SHARED_NAME = "HeroData"
    val HERO_POSITION = "HeroPosition"

    val storage = context.getSharedPreferences(SHARED_NAME, 0)

    fun saveHeroPosition(Position:Int){
        storage.edit().putInt(HERO_POSITION, Position).apply()
    }

    fun getHeroPosition():Int{
        return storage.getInt(HERO_POSITION, 0)!!
    }
    fun cleanHeroPosition() {
        storage.edit().putInt(HERO_POSITION, 0).apply()
    }
}