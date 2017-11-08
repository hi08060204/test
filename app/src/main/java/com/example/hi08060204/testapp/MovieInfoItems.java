package com.example.hi08060204.testapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hi08060204 on 2017/11/8.
 */

public class MovieInfoItems {
    @SerializedName("members")
    public List<MovieInfoItem> items;

    public MovieInfoItems() {
        items = new ArrayList<>();
    }

    public static MovieInfoItems parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(response, MovieInfoItems.class);
    }
}
