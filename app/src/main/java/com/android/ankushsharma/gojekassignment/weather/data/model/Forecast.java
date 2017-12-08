package com.android.ankushsharma.gojekassignment.weather.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Forecast implements Serializable {

    @SerializedName("forecastday")
    private ArrayList<Forecastday> forecastday = new ArrayList<Forecastday>();

    public ArrayList<Forecastday> getForecastday() {
        return forecastday;
    }

    public void setForecastday(ArrayList<Forecastday> mForecastday) {
        this.forecastday = mForecastday;
    }


}
