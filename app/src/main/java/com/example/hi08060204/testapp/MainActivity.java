package com.example.hi08060204.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String MODEL_STATE = "MODELSTATE";

    private RecyclerView mRecyclerView;
    private MovieinfoAdapter mMovieInfoAdapter;
    private MovieInfoFetcher mMovieInfoFetcher;
    private final MovieInfoFetcher.Callback mFetchCallback = new MovieInfoFetcher.Callback() {
        @Override
        public void onFetched(List<MovieInfoItem> items) {
            mMovieInfoAdapter.bind(items);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRecyclerView();
        mMovieInfoFetcher = new MovieInfoFetcher(mFetchCallback);
        mMovieInfoFetcher.doFetch();
    }

    private void setRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.list_view);
        mMovieInfoAdapter = new MovieinfoAdapter();
        mRecyclerView.setAdapter(mMovieInfoAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mMovieInfoFetcher.cancel();
        mMovieInfoFetcher = null;
    }
}
