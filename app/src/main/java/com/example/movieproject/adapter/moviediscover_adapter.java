package com.example.movieproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieproject.R;
import com.example.movieproject.model.movie.MovieDiscoverResultsItem;

import java.util.ArrayList;

public class moviediscover_adapter extends RecyclerView.Adapter<moviediscover_adapter.ViewHolder> {

    private ArrayList<MovieDiscoverResultsItem> movieDiscoverItems = new ArrayList<>();
    private Context context;
    private static String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w185";


    public moviediscover_adapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<MovieDiscoverResultsItem> items){
        movieDiscoverItems.clear();
        movieDiscoverItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public moviediscover_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull moviediscover_adapter.ViewHolder holder, int position) {
        Glide.with(context).load(BASE_IMAGE_URL+movieDiscoverItems.get(position).getPosterPath())
                .into(holder.Iv_gambar);

        holder.tvTitle.setText(movieDiscoverItems.get(position).getTitle());
        holder.tvrate.setText(movieDiscoverItems.get(position).getVoteAverage()+"");
    }

    @Override
    public int getItemCount() {
        return movieDiscoverItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView Iv_gambar;
        TextView tvTitle,tvrate;
        CardView cvItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Iv_gambar = itemView.findViewById(R.id.itemlist_gambar);
            tvTitle = itemView.findViewById(R.id.itemlist_tv_title);
            tvrate = itemView.findViewById(R.id.itemlist_rate);
            cvItem = itemView.findViewById(R.id.cv_itemlist);
        }
    }
}
