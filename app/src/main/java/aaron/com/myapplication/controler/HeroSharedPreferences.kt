package aaron.com.myapplication.controler

import android.app.Application

class HeroSharedPreferences : Application() {

    companion object{
        lateinit var  prefs: Prefs
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}