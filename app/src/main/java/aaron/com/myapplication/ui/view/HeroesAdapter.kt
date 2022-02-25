package aaron.com.myapplication.ui.view

import aaron.com.myapplication.R
import aaron.com.myapplication.controler.HeroSharedPreferences.Companion.prefs
import aaron.com.myapplication.data.model.HeroModel
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.heroes_card.view.*
import okhttp3.OkHttpClient
import okhttp3.Protocol
import java.util.*


class HeroesAdapter (val items: List<HeroModel>) : RecyclerView.Adapter<HeroesAdapter.HeroesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroesViewHolder(layoutInflater.inflate(R.layout.heroes_card, parent, false))
    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        val item : HeroModel = items[position]
        holder.render(item, position)
    }

    override fun getItemCount(): Int = items.size

    class HeroesViewHolder (val view : View) : RecyclerView.ViewHolder(view) {

        fun render(item: HeroModel, position : Int) {
            view.tvHeroName.text = item.name
            Picasso.get().load((item.thumbnail.path+"."+item.thumbnail.extension).replace("http", "https")).into(view.ivHeroImage)

            view.setOnClickListener{
                prefs.saveHeroPosition(position)
                val intentInfoHero = Intent(view.context, HeroFullInfoActivity::class.java)
                view.context.startActivity(intentInfoHero)
            }
        }
    }
}