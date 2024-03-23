package kz.onelab.movieapp.data.api

import kz.onelab.movieapp.data.model.PopularMoviesDto
import retrofit2.http.GET

interface MoviesApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(): PopularMoviesDto
}