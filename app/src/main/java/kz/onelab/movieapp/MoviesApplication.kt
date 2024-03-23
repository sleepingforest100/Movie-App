package kz.onelab.movieapp

import android.app.Application
import kz.onelab.movieapp.data.RetrofitHelper
import kz.onelab.movieapp.data.repository.PopularMoviesRepository

class MoviesApplication : Application() {

    val moviesRepository: PopularMoviesRepository by lazy(LazyThreadSafetyMode.NONE) {
        PopularMoviesRepository(RetrofitHelper.getMoviesApi)
    }
}