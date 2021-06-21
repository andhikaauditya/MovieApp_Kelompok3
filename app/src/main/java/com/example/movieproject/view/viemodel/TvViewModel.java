package com.example.movieproject.view.viemodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movieproject.model.tv.TvDiscoverResponse;
import com.example.movieproject.model.tv.TvDiscoverResultsItem;
import com.example.movieproject.service.ApiMain2;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvViewModel extends ViewModel {
    private ApiMain2 apiMain2;

    private MutableLiveData<ArrayList<TvDiscoverResultsItem>> listDiscoverTv = new MutableLiveData<>();

    public void setTvDiscover(){
        if (this.apiMain2 == null){
            apiMain2 = new ApiMain2();
        }

        apiMain2.getApiTv().getTvDiscover().enqueue(new Callback<TvDiscoverResponse>() {
            @Override
            public void onResponse(Call<TvDiscoverResponse> call, Response<TvDiscoverResponse> response) {
                TvDiscoverResponse responseDiscover = response.body();
                if (responseDiscover != null && responseDiscover.getResults() != null){
                    ArrayList<TvDiscoverResultsItem> TvDiscoverItems = responseDiscover.getResults();
                    listDiscoverTv.postValue(TvDiscoverItems);

                }
            }

            @Override
            public void onFailure(Call<TvDiscoverResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<TvDiscoverResultsItem>> getTvDiscover(){
        return listDiscoverTv;
    }
}
