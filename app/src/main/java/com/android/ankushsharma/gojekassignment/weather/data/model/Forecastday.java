package com.android.ankushsharma.gojekassignment.weather.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Forecastday implements Serializable {


    @SerializedName("date")
    private String date;

    @SerializedName("day")
    private Day day = new Day();


    public String getDate() {
        return date;
    }

    public void setDate(String mDate) {
        this.date = mDate;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day mDay) {
        this.day = mDay;
    }

}
