package aaron.com.myapplication.ui.viewModel

import aaron.com.myapplication.controler.HeroSharedPreferences.Companion.prefs
import aaron.com.myapplication.data.model.HeroModel
import aaron.com.myapplication.data.model.Item
import aaron.com.myapplication.data.model.ItemX
import aaron.com.myapplication.domain.GetHeroesUseCase
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HeroViewModel : ViewModel() {

    val heroListModel = MutableLiveData<List<HeroModel>>()
    val isloading = MutableLiveData<Boolean>()
    val heroModel = MutableLiveData<HeroModel>()
    val comicsList = MutableLiveData<List<Item>>()
    val seriesList = MutableLiveData<List<ItemX>>()


    var getHeroesUseCase = GetHeroesUseCase()

    fun onCreate() {
        viewModelScope.launch {
        isloading.postValue(true)
         val result = getHeroesUseCase()
         if(!result.isNullOrEmpty()){
             heroListModel.postValue(result!!)
             isloading.postValue(false)
         }
        }
    }

    fun showUserInof(){
        viewModelScope.launch {
            val result = getHeroesUseCase()
            if(!result.isNullOrEmpty()){
                heroModel.postValue(result[prefs.getHeroPosition()])
                comicsList.postValue(result[prefs.getHeroPosition()].comics.items)
                seriesList.postValue(result[prefs.getHeroPosition()].series.items)
            }
        }
    }
}
