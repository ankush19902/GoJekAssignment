package com.android.ankushsharma.gojekassignment.weather.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Current implements Serializable {


    @SerializedName("temp_c")
    private double temp_c;

    public double getTempC() {
        return temp_c;
    }

    public void setTempC(Double mTempC) {
        this.temp_c = mTempC;
    }


}
