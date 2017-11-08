package com.example.hi08060204.testapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hi08060204 on 2017/11/6.
 */
public class MovieInfoItem {
    @SerializedName("id")
    private String id;
    @SerializedName("profile")
    private ProfileItem profile;

    public String getId() {
        return this.id;
    }

    public String getName() {
        return profile.firstname;
    }
}
