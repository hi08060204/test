package com.example.hi08060204.testapp;

import android.util.Log;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by hi08060204 on 2017/11/6.
 */
public class MovieInfoFetcher {

    public static final String REST_API_URL = "https://slack.com/api/users.list";
    public static final String ACCESS_TOKEN_HEADER = "token";
    public static final String ACCESS_TOKEN = "xoxp-5048173296-5048487710-19045732087-b5427e3b46";


    public interface Callback {
        void onFetched(List<MovieInfoItem> items);
    }

    private OkHttpClient client;
    private Request request;
    private Callback callback;

    public MovieInfoFetcher(Callback callback) {
        client = new OkHttpClient.Builder().addNetworkInterceptor(new StethoInterceptor()).build();
        HttpUrl url = HttpUrl.parse(REST_API_URL).newBuilder().addQueryParameter(ACCESS_TOKEN_HEADER, ACCESS_TOKEN).build();
        request = new Request.Builder()
                .url(url)
                .build();
        this.callback = callback;
    }

    public void cancel() {
    }

    public void doFetch() {
        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("slack_test", "onFailure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("slack_test", "onResponse");
                MovieInfoItems items = MovieInfoItems.parseJSON(response.body().string());
                Log.d("slack_test", items.items.get(0).getName());
            }
        });
    }
}
