package kz.onelab.movieapp.data.mapper

import kz.onelab.movieapp.data.model.MovieDto
import kz.onelab.movieapp.data.model.PopularMoviesDto
import kz.onelab.movieapp.presentation.model.Movie
import kz.onelab.movieapp.presentation.model.PopularMovies

internal fun MovieDto.toMovie() = Movie(
    id = id,
    title = title,
    overview = overview,
    posterUrl = posterPath,
    releaseDate = releaseDate
)

internal fun PopularMoviesDto.toPopularMovies(): PopularMovies {
    return PopularMovies(
        popularMovieList = results.map { it.toMovie() }
    )
}