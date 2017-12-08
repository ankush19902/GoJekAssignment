package com.android.ankushsharma.gojekassignment.weather.data.source.remote;


import com.android.ankushsharma.gojekassignment.weather.data.model.WeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author ankushsharma
 * @date 08/12/17
 */

public interface ApiService {

    /**
     * @param queryParam parameter on which weather is fetched
     * @param days       no of days to be fetched
     * @return
     */
    @GET("forecast.json?")
    Call<WeatherModel> doGetCityWeather(@Query("q") String queryParam, @Query("days") String days);

}