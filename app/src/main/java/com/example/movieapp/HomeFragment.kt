package com.example.movieapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

/*
    private val movie1: Movie = Movie(
        title = "The Queen's Gambit",
        description = "The Queen\'s Gambit follows the life of an orphan chess prodigy," +
                "Elizabeth Harmon, during her quest to become the world\'s greatest " +
                "chess player while struggling with emotional problems and drug and " +
                "alcohol dependency. The title of the series refers to a chess opening " +
                "of the same name. The story begins in the mid-1950s and proceeds into the 1960s. " +
                "The story begins in Lexington, Kentucky, where a nine-year-old Beth, having lost her " +
                "mother in a car crash, is taken to an orphanage where she is taught chess by the " +
                "building\'s custodian, Mr. Shaibel. As was common during the 1950s, the orphanage " +
                "dispenses daily tranquilizer pills to the girls, which turns into an addiction " +
                "for Beth. She quickly becomes a strong chess player due to her visualization skills, " +
                "which are enhanced by the tranquilizers. A few years later, Beth is adopted by Alma Wheatley " +
                "and her husband from Lexington. As she adjusts to her new home, Beth enters a chess tournament and " +
                "wins despite having no prior experience in competitive chess. She develops friendships with several people, " +
                "including former Kentucky State Champion Harry Beltik, United States National Champion Benny Watts, and journalist " +
                "and fellow player D.L. Townes. As Beth rises to the top of the chess world and reaps the financial benefits of her " +
                "success, her drug and alcohol dependency becomes worse.",
        rating = 4.5F,
        genres = listOf("Drama", "Sport"),
        creators = listOf("Scott Frank", "Alan Scott"),
        actors = listOf("Anya Taylor-Joy", "Chloe Pirrie"),
        picture = R.drawable.gambit
    )
*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager

        adapter = RecyclerAdapter()
        binding.recyclerView.adapter = adapter

/*
        binding.movie1 = movie1

        binding.seeDetailButton.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(
                    HomeFragmentDirections.actionHomeFragmentToDetailFragment(movie1)
                )
        }
*/

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}