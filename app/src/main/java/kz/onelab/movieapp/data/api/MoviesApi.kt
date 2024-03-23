package kz.onelab.movieapp.data.api

import kz.onelab.movieapp.data.model.PopularMoviesDto
import kz.onelab.movieapp.presentation.model.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(): PopularMoviesDto

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(@Path("movie_id") movieId: Int): Response<Movie>
}