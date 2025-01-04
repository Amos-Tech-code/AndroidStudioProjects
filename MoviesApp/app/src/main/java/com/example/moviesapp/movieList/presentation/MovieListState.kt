package com.example.moviesapp.movieList.presentation

import com.example.moviesapp.movieList.domain.model.Movie

data class MovieListState(

    val isLoading: Boolean = false,

    val popularMovieListPage: Int = 1,
    val upcomingMovieListPage: Int = 1,

    val isCurrentPopularScreen: Boolean = true,

    val popularMoviesList: List<Movie> = emptyList(),
    val upcomingMoviesList: List<Movie> = emptyList()
)
