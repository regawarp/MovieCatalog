package mongga.regawa.imdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mongga.regawa.imdb.R
import mongga.regawa.imdb.model.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(private val movieList: ArrayList<Movie>, private val onItemClickCallback: OnItemClickCallback) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageMovie: ImageView = itemView.img_movie
        val tvMovieTitle: TextView = itemView.tv_movie_title
        val tvMovieYear: TextView = itemView.tv_movie_year
        val tvMovieRating: TextView = itemView.tv_movie_rating
        val tvMpaRating: TextView = itemView.tv_mpa_rating
        val tvMovieTime: TextView = itemView.tv_movie_time
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)

        return MovieViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]

        holder.imageMovie.setImageResource(movie.movImage)
        holder.tvMovieTitle.text = movie.movTitle
        holder.tvMovieYear.text = movie.movYear.toString()
        holder.tvMovieRating.text = movie.movRating.toString()
        holder.tvMpaRating.text = movie.movMpaRating
        holder.tvMovieTime.text = movie.movTime

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(movieList[position]) }
    }

    interface OnItemClickCallback {
        fun onItemClicked(movie: Movie)
    }
}