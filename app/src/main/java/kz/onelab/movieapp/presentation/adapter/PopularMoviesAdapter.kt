package kz.onelab.movieapp.presentation.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.transform.CircleCropTransformation
import kz.onelab.movieapp.R
import kz.onelab.movieapp.databinding.ItemMovieBinding
import kz.onelab.movieapp.presentation.model.Movie

class PopularMoviesAdapter(private val onFavoriteClick: (Movie, Boolean) -> Unit) : ListAdapter<Movie, MovieViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(layoutInflater, parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)

        holder.binding.favoriteIcon.setOnClickListener {
            movie.isFavorite = !movie.isFavorite
             val isFavorite = onFavoriteClick(movie, movie.isFavorite)
            holder.binding.favoriteIcon.setImageResource(if (movie.isFavorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_border)
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }
}

class MovieViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        with(binding) {
            title.text = movie.title
            releaseDateValue.text = movie.releaseDate
            desctiptionValue.text = movie.overview
            poster
                .load("https://image.tmdb.org/t/p/original${movie.posterUrl}")
                {
                    crossfade(true)
                    transformations(CircleCropTransformation())
                    placeholder(R.drawable.ic_launcher_background)
                    scale(Scale.FIT)
                }
        }
    }
}