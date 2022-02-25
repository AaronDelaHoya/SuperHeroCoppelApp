package aaron.com.myapplication.ui.view

import aaron.com.myapplication.R
import aaron.com.myapplication.ui.view.fragment.ComicListFragment
import aaron.com.myapplication.ui.view.fragment.OnFragmentActionsListener
import aaron.com.myapplication.ui.viewModel.HeroViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_hero_full_info2.*

class HeroFullInfoActivity : AppCompatActivity(), OnFragmentActionsListener {

    private  val heroViewModel : HeroViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_full_info2)

        heroViewModel.showUserInof()

        heroViewModel.heroModel.observe(this, {hero ->
            tbInfoHero.title = hero.name
            tvheroDescription.text = hero.description
        })


    }

    override fun onClickFragmentButton() {
        Toast.makeText(this, "El botón ha sido pulsado", Toast.LENGTH_SHORT).show()
    }
}