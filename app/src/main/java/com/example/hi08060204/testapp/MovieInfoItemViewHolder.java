package com.example.hi08060204.testapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hi08060204 on 2017/11/6.
 */
public class MovieInfoItemViewHolder extends RecyclerView.ViewHolder {

    private TextView mMovieTitle;
    private TextView mMovieScore;
    private ImageView mMoviePoster;

    private Context mContext;

    public MovieInfoItemViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        mMovieTitle = (TextView) itemView.findViewById(R.id.movie_title);
        mMovieScore = (TextView) itemView.findViewById(R.id.movie_score);
        mMoviePoster = (ImageView) itemView.findViewById(R.id.poster);
    }

    public void bind(MovieInfoItem item) {
//        mMovieTitle.setText(item.getTitle());
//        mMovieScore.setText(Double.toString(item.getScore()));
//        Picasso.with(mContext).load(item.getPosterUrl()).into(mMoviePoster);
    }
}
