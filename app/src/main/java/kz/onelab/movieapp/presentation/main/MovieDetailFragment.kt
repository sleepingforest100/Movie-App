//package kz.onelab.movieapp.presentation.main
//
//import android.annotation.SuppressLint
//import android.os.Bundle
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.ViewModelProvider
//import kz.onelab.movieapp.R
//import kz.onelab.movieapp.databinding.FragmentMovieDetailBinding
//import kz.onelab.movieapp.presentation.model.Movie
//import kz.onelab.movieapp.presentation.viewmodel.MovieDetailViewModel
//
//class MovieDetailFragment : Fragment() {
//    private var _binding: FragmentMovieDetailBinding? = null
//    private val binding get() = _binding!!
//    private lateinit var viewModel: MovieDetailViewModel
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
//        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val movieId = arguments?.getInt("movieId") ?: throw IllegalStateException("Movie ID is required")
//
//        val apiService = // Инициализируйте ваш Retrofit сервис здесь
//            viewModel = ViewModelProvider(this, MovieDetailViewModelFactory(apiService))[MovieDetailViewModel::class.java]
//
//        viewModel.loadMovieDetails(movieId)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewModel.movieDetail.observe(viewLifecycleOwner) { movieDetail ->
//            // Обновите UI здесь
//        }
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val movieId = arguments?.getInt("movieId") ?: throw IllegalStateException("Movie ID is required")
//
//        loadMovieDetails(movieId)
//    }
//
//    private fun loadMovieDetails(movieId: Int) {
//        viewModelScope.launch {
//            try {
//                val movieDetail = apiService.getMovieDetails(movieId) // Используйте ваш MoviesApi для запроса
//                updateUI(movieDetail)
//            } catch (e: Exception) {
//                Log.e("MovieDetailFragment", "Error loading movie details", e)
//                // Обработка ошибки загрузки данных
//            }
//        }
//    }
//
//    @SuppressLint("StringFormatInvalid")
//    private fun updateUI(movieDetail: Movie) {
//        with(binding) {
//            movieTitle.text = movieDetail.title
//            movieReleaseDate.text = getString(R.string.release_date_format, movieDetail.releaseDate)
//            movieOverview.text = movieDetail.overview
//            // Загрузите изображение постера, используя Glide или Coil
//        }
//    }
//
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null // Освобождаем ресурсы View Binding
//    }
//
//}
