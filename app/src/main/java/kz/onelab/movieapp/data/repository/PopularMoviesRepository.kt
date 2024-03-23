package kz.onelab.movieapp.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kz.onelab.movieapp.core.BaseRepository
import kz.onelab.movieapp.core.functional.State
import kz.onelab.movieapp.data.api.MoviesApi
import kz.onelab.movieapp.data.mapper.toPopularMovies
import kz.onelab.movieapp.presentation.model.PopularMovies

class PopularMoviesRepository(
    private val moviesApi: MoviesApi
) : BaseRepository() {

    suspend fun getPopularMovies(): State<Throwable, PopularMovies> = apiCall {
        withContext(Dispatchers.IO) {
            moviesApi.getPopularMovies().toPopularMovies()
        }
    }
}