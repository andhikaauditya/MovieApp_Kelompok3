package com.example.movieproject.service;

import com.example.movieproject.model.tv.TvDiscoverResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TvRepository {
    @GET("3/discover/tv?api_key=05faacecb1bb8a123ad56542b1708bad")
    Call<TvDiscoverResponse> getTvDiscover();
}