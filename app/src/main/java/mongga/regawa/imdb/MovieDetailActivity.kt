package mongga.regawa.imdb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import mongga.regawa.imdb.model.Movie
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {
    private lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        movie = intent.getParcelableExtra("MOVIE")!!

        supportActionBar?.title = movie.movTitle
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        tv_movie_title.text = movie.movTitle
        tv_movie_genre.text = movie.movGenre
        tv_movie_time.text = movie.movTime
        tv_movie_year.text = movie.movYear.toString()
        tv_mpa_rating.text = movie.movMpaRating
        tv_movie_rating.text = "${movie.movRating}/10"
        tv_movie_synopsis.text = movie.movSynopsis
        img_movie.setImageResource(movie.movImage)
        lifecycle.addObserver(yp_movie_trailer)
        yp_movie_trailer.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(),
            YouTubePlayerListener {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = movie.movTrailer
                youTubePlayer.cueVideo(videoId, 0.toFloat())
            }

        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
