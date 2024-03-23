package kz.onelab.movieapp.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import kz.onelab.movieapp.core.functional.Resource
import kz.onelab.movieapp.databinding.FragmentMainBinding
import kz.onelab.movieapp.presentation.adapter.PopularMoviesAdapter
import kz.onelab.movieapp.presentation.model.Movie
import kz.onelab.movieapp.presentation.viewmodel.PopularMovieViewModel

class MainFragment : Fragment() {

    private var _binding : FragmentMainBinding? = null
    private val binding
        get() = _binding!!

    private val popularMoviesAdapter by lazy(LazyThreadSafetyMode.NONE) {
        PopularMoviesAdapter()
    }

    private val viewModel: PopularMovieViewModel by viewModels { PopularMovieViewModel.Factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
        viewModel.getPopularMovies()
    }

    private fun initViews() {
        with(binding) {
            popularMovieRecyclerView.adapter = popularMoviesAdapter
            popularMovieRecyclerView.layoutManager = LinearLayoutManager(context)
        }
    }

    private fun initObservers() {
        viewModel.popularMoviesLiveData.observe(viewLifecycleOwner, ::onGetPopularMovies)
    }

    private fun onGetPopularMovies(popularMoviesResource: Resource<List<Movie>>) {
        val isLoading = popularMoviesResource is Resource.Loading
        binding.popularMovieRecyclerView.isVisible = isLoading.not()
        binding.progress.isVisible = isLoading
        when (popularMoviesResource) {
            is Resource.Success -> {
                popularMoviesAdapter.submitList(popularMoviesResource.data)
            }
            is Resource.Error -> {
                Log.e("MainFragmentTag", "Failed to load popular movies", popularMoviesResource.exception)
            }
            else -> Unit
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}