package com.example.hi08060204.testapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

/**
 * Created by hi08060204 on 2017/11/6.
 */

public class MovieinfoAdapter extends RecyclerView.Adapter<MovieInfoItemViewHolder> {

    private List<MovieInfoItem> movieInfoItems = Collections.EMPTY_LIST;

    public void bind(List<MovieInfoItem> movieInfoItems) {
        if (movieInfoItems == null) {
            return;
        }
        this.movieInfoItems = movieInfoItems;
        notifyDataSetChanged();
    }

    @Override
    public MovieInfoItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieInfoItemViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.movie_info_item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(MovieInfoItemViewHolder holder, int position) {
        holder.bind(movieInfoItems.get(position));
    }

    @Override
    public int getItemCount() {
        return movieInfoItems.size();
    }
}
