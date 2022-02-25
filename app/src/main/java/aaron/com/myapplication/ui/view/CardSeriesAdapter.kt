package aaron.com.myapplication.ui.view

import aaron.com.myapplication.R
import aaron.com.myapplication.data.model.ItemX
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_icon.view.*

class CardSeriesAdapter(private val values: List<ItemX>) :
    RecyclerView.Adapter<CardSeriesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.fragment_icon, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.render(item, position)
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
        fun render(item: ItemX, position: Int){
            view.item_number.text = position.toString()
            view.content.text = item.name
            println(item.name)
        }
    }


}