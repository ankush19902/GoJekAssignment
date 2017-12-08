package com.android.ankushsharma.gojekassignment.weather.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Day implements Serializable {

    private static final long serialVersionUID = 1L;

    @SerializedName("avgtemp_c")
    public double avgtemp_c;

    public double getAvgtempC() {
        return avgtemp_c;
    }

    public void setAvgtempC(double mAvgtemp_c) {
        this.avgtemp_c = mAvgtemp_c;
    }


}
