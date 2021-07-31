package mongga.regawa.imdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import mongga.regawa.imdb.adapter.MovieAdapter
import mongga.regawa.imdb.model.Movie
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(), MovieAdapter.OnItemClickCallback, View.OnClickListener {
    private val TAG = "MainActivity"
    private val movieList = generateMovieList()
    private val movieAdapter = MovieAdapter(movieList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val movieList = generateMovieList()

//        rv_movie.adapter = MovieAdapter(movieList, this)
        rv_movie.adapter = movieAdapter
        rv_movie.layoutManager = LinearLayoutManager(this)
        btn_insert.setOnClickListener(this)
        btn_delete.setOnClickListener(this)
    }

    private fun generateMovieList(): ArrayList<Movie> {
        val movieList = ArrayList<Movie>()

        movieList.add(
            Movie(
                "Raya and the Last Dragon", R.drawable.poster1,
                2021,
                7.4,
                "PG",
                "1h 57m",
                "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
                "Fantasy",
                "1VIZ89FEjYI"
            )
        )
        movieList.add(
            Movie(
                "Zack Snyder's Justice League",
                R.drawable.poster2,
                2021,
                8.1,
                "R",
                "4h 2m",
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                "Action",
                "vM-Bja2Gy04"
            )
        )
        movieList.add(
            Movie(
                "Monster Hunter",
                R.drawable.poster3,
                2020,
                5.3,
                "PG-13",
                "1h 44m",
                "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
                "Fantasy",
                "3od-kQMTZ9M"
            )
        )
        movieList.add(
            Movie(
                "Below Zero",
                R.drawable.poster4,
                2021,
                6.2,
                "R",
                "1h 46m",
                "When a prisoner transfer van is attacked, the cop in charge must fight those inside and outside while dealing with a silent foe: the icy temperatures.",
                "Action",
                "hSMokfUerVY"
            )
        )
        movieList.add(
            Movie(
                "Tom & Jerry",
                R.drawable.poster5,
                2021,
                5.3,
                "PG",
                "1h 41m",
                "Tom the cat and Jerry the mouse get kicked out of their home and relocate to a fancy New York hotel, where a scrappy employee named Kayla will lose her job if she can’t evict Jerry before a high-class wedding at the hotel. Her solution? Hiring Tom to get rid of the pesky mouse.",
                "Family",
                "kP9TfCWaQT4"
            )
        )

        return movieList
    }

    override fun onItemClicked(movie: Movie) {
        Log.d(TAG, "onItemClicked: $movie")
        val myIntent = Intent(this, MovieDetailActivity::class.java)
        myIntent.putExtra("MOVIE", movie)
        startActivity(myIntent)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_insert -> insertRandomMovie()
            R.id.btn_delete -> deleteRandomMovie()
        }
    }

    private fun deleteRandomMovie() {
        Log.d(TAG, "deleteRandomMovie: ")
        val index: Int = Random.nextInt(4)
        movieList.removeAt(index)
        movieAdapter.notifyItemRemoved(index)
    }

    private fun insertRandomMovie() {
        val index: Int = Random.nextInt(4)
        val newMovie = Movie(
            "New Added Movie", R.drawable.poster1,
            2021,
            7.4,
            "PG",
            "1h 57m",
            "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
            "Fantasy",
            "1VIZ89FEjYI"
        )
        movieList.add(index, newMovie)
        movieAdapter.notifyItemInserted(index)
    }

}


