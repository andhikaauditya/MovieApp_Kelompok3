package com.example.movieproject.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieproject.R;
import com.example.movieproject.adapter.TvDiscoverAdapter;
import com.example.movieproject.model.tv.TvDiscoverResultsItem;
import com.example.movieproject.view.viemodel.TvViewModel;

import java.util.ArrayList;

public class tvFragment extends Fragment {

    private TvDiscoverAdapter TvDiscoverAdapter;
    private RecyclerView rvTvDiscover;
    private TvViewModel TvViewModel;


    public tvFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TvDiscoverAdapter = new TvDiscoverAdapter(getContext());
        TvDiscoverAdapter.notifyDataSetChanged();

        rvTvDiscover = view.findViewById(R.id.fragmenttv_rv);
        rvTvDiscover.setLayoutManager(new GridLayoutManager(getContext(), 2));

        TvViewModel = new ViewModelProvider(this).get(TvViewModel.class);
        TvViewModel.setTvDiscover();
        TvViewModel.getTvDiscover().observe(this,getTvDiscover);

        rvTvDiscover.setAdapter(TvDiscoverAdapter);
    }

    private Observer<ArrayList<TvDiscoverResultsItem>> getTvDiscover = new Observer<ArrayList<TvDiscoverResultsItem>>() {
        @Override
        public void onChanged(ArrayList<TvDiscoverResultsItem> TvDiscoverResultsItems) {
            if (TvDiscoverResultsItems != null){
                TvDiscoverAdapter.setData(TvDiscoverResultsItems);
            }
        }
    };
}
