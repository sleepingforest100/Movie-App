//package kz.onelab.movieapp.presentation.viewmodel
//
//import android.util.Log
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.launch
//import kz.onelab.movieapp.data.api.MoviesApi
//import kz.onelab.movieapp.presentation.model.Movie
//
//class MovieDetailViewModel(private val apiService: MoviesApi) : ViewModel() {
//
//    private val _movieDetail = MutableLiveData<Movie>()
//    val movieDetail: LiveData<Movie> = _movieDetail
//
//    fun loadMovieDetails(movieId: Int) {
//        viewModelScope.launch {
//            try {
//                val movieDetailsResponse = apiService.getMovieDetails(movieId)
//                _movieDetail.postValue(movieDetailsResponse)
//            } catch (e: Exception) {
//                Log.e("MovieDetailVM", "Error loading movie details", e)
//                // Можно добавить обработку ошибок, например, обновление LiveData с ошибкой
//            }
//        }
//    }
//}
