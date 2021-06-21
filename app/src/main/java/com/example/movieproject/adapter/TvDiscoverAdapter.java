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
import com.example.movieproject.model.tv.TvDiscoverResultsItem;

import java.util.ArrayList;

public class TvDiscoverAdapter extends RecyclerView.Adapter<TvDiscoverAdapter.ViewHolder> {

    private ArrayList<TvDiscoverResultsItem> TvDiscoverItems = new ArrayList<>();
    private Context context;

    private static String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w185/";

    public TvDiscoverAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<TvDiscoverResultsItem> items){
        TvDiscoverItems.clear();
        TvDiscoverItems.addAll(items);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public TvDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvDiscoverAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(BASE_IMAGE_URL+TvDiscoverItems.get(position)
                .getPosterPath())
                .into(holder.ivThumb);

        holder.tvTitle.setText(TvDiscoverItems.get(position).getTitle());
        holder.tvRate.setText(String.valueOf(TvDiscoverItems.get(position).getVoteAverage()));

    }

    @Override
    public int getItemCount() {
        return TvDiscoverItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivThumb;
        TextView tvTitle,tvRate;
        CardView cvItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_itemlist);
            ivThumb = itemView.findViewById(R.id.itemlist_gambar);
            tvTitle = itemView.findViewById(R.id.itemlist_tv_title);
            tvRate = itemView.findViewById(R.id.itemlist_rate);
        }
    }
}
