package com.example.movieproject.view.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movieproject.R;
import com.example.movieproject.adapter.moviediscover_adapter;
import com.example.movieproject.model.movie.MovieDiscoverResultsItem;
import com.example.movieproject.view.viemodel.MovieViewModel;

import java.util.ArrayList;

public class movieFragment extends Fragment {

    private moviediscover_adapter moviediscover_adapter;
    private RecyclerView rvMovieDiscover;
    private MovieViewModel movieViewModel;

    public movieFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @SuppressLint("FragmentLiveDataObserve")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        moviediscover_adapter = new moviediscover_adapter(getContext());
        moviediscover_adapter.notifyDataSetChanged();

        rvMovieDiscover = view.findViewById(R.id.frag_movie_rv);
        rvMovieDiscover.setLayoutManager(new GridLayoutManager(getContext(),2));

        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        movieViewModel.setMovieDiscover();
        movieViewModel.getMovieDiscover().observe(this,getMovieDiscover);

        rvMovieDiscover.setAdapter(moviediscover_adapter);
    }
    private Observer<ArrayList<MovieDiscoverResultsItem>> getMovieDiscover = new Observer<ArrayList<MovieDiscoverResultsItem>>() {
        @Override
        public void onChanged(ArrayList<MovieDiscoverResultsItem> movieDiscoverResultsItems) {
            if (movieDiscoverResultsItems != null){
                moviediscover_adapter.setData(movieDiscoverResultsItems);
            }
        }
    };
}