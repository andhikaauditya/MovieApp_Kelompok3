package com.example.movieproject.service;

import com.example.movieproject.model.movie.MovieDiscoverResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieRepository {
    @GET("3/discover/movie?api_key=2919b8edbf2f284a17fbf9feb9f994ff")
    Call<MovieDiscoverResponse> getMovieDiscover();
}
