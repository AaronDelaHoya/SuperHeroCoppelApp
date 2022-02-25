package aaron.com.myapplication.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import aaron.com.myapplication.R
import aaron.com.myapplication.ui.view.CardSeriesAdapter
import aaron.com.myapplication.ui.view.MycardcomisRecyclerViewAdapter
import aaron.com.myapplication.ui.viewModel.HeroViewModel
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_comic_list.view.*
import kotlinx.android.synthetic.main.fragment_series_list.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SeriesListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SeriesListFragment : Fragment() {
    private lateinit var adapter: CardSeriesAdapter
    private  val heroViewModel : HeroViewModel by viewModels()
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_series_list, container, false)

        heroViewModel.seriesList.observe(this, { currentComic->
            adapter = CardSeriesAdapter(currentComic)
            adapter.notifyDataSetChanged()
            view.rvlistSeries.layoutManager = LinearLayoutManager(view.context)
            view.rvlistSeries.adapter = adapter
        })
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SeriesListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SeriesListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}