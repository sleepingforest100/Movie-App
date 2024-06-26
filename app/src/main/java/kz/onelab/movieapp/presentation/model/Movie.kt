package kz.onelab.movieapp.presentation.model
data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String,
    val releaseDate: String,
    var isFavorite: Boolean = false,
)