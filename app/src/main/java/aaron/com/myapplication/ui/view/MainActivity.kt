package aaron.com.myapplication.ui.view

import aaron.com.myapplication.R
import aaron.com.myapplication.ui.viewModel.HeroViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: HeroesAdapter
    private  val heroViewModel : HeroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        heroViewModel.onCreate()

        heroViewModel.heroListModel.observe(this, Observer { currentHeros->
            adapter = HeroesAdapter(currentHeros)
            rvHeroes.layoutManager = LinearLayoutManager(this)
            rvHeroes.adapter = adapter
            adapter.notifyDataSetChanged()
        })

        heroViewModel.isloading.observe(this, Observer {
            progress_circular.isVisible = it
        })

    }
}