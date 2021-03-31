package com.example.movieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

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
    private val movie2: Movie = Movie(
        title = "Avengers 4: Endgame",
        description = "After the devastating events of Avengers 3: Infinity War (2018), " +
                "the universe is in ruins. With the help of remaining allies, the Avengers assemble" +
                " once more in order to reverse Thanos' actions and restore balance to the universe.",
        rating = 4.5F,
        genres = listOf("Action", "Adventure", "Drama"),
        creators = listOf("Anthony Russo", "Joe Russo"),
        actors = listOf(" Robert Downey Jr.", "Chris Evans", "Mark Ruffalo"),
        //TODO:
        picture = R.drawable.avengers
    )
    private val movie3: Movie = Movie(
        title = "Joker",
        description = "In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and " +
                "mistreated by society. He then embarks on a downward spiral of revolution and " +
                "bloody crime. This path brings him face-to-face with his alter-ego: the Joker.",
        rating = 4.0F,
        genres = listOf("Crime", "Drama", "Thriller"),
        creators = listOf("Todd Phillips", "Scott Silver"),
        actors = listOf("Joaquin Phoenix", "Robert De Niro", "Zazie Beetz"),
        picture = R.drawable.joker
    )
    private val movie4: Movie = Movie(
        title = "Deadpool",
        description = "A wisecracking mercenary gets experimented on and becomes immortal but ugly, " +
                "and sets out to track down the man who ruined his looks.",
        rating = 3.5F,
        genres = listOf("Action", "Adventure", "Comedy"),
        creators = listOf("Rhett Reese", "Paul Wernick"),
        actors = listOf("Ryan Reynolds", "Morena Baccarin", "T.J. Miller"),
        picture = R.drawable.deadpool
    )

    private val movies = arrayOf(movie1, movie2, movie3, movie4)
    private val titles = arrayOf(movie1.title, movie2.title, movie3.title, movie4.title)
    private val creators =
        arrayOf(movie1.creators, movie2.creators, movie3.creators, movie4.creators)
    private val actors = arrayOf(movie1.actors, movie2.actors, movie3.actors, movie4.actors)


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var cardTitle: TextView = itemView.findViewById(R.id.card_title)
        var cardCreators: TextView = itemView.findViewById(R.id.card_creators)
        var cardActors: TextView = itemView.findViewById(R.id.card_actors)
        var detailButton: Button = itemView.findViewById(R.id.seeDetail_button)

    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.cardTitle.text = titles[position]
        viewHolder.cardCreators.text =
            creators[position].toString().replace("[", "").replace("]", "")
        viewHolder.cardActors.text = actors[position].toString().replace("[", "").replace("]", "")
            viewHolder.detailButton.setOnClickListener { view: View ->
                view.findNavController()
                    .navigate(
                        HomeFragmentDirections.actionHomeFragmentToDetailFragment(movies[position])
                    )
            }

    }


    override fun getItemCount(): Int {
        return titles.size
    }
}