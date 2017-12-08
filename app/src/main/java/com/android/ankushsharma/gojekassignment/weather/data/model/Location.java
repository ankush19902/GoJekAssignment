package com.android.ankushsharma.gojekassignment.weather.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Location implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("region")
    private String region;

    public String getName() {
        return name;
    }

    public void setName(String mName) {
        this.name = mName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String mRegion) {
        this.region = mRegion;
    }

}
