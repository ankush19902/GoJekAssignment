package com.android.ankushsharma.gojekassignment.weather.data.source;


import com.android.ankushsharma.gojekassignment.weather.data.model.WeatherModel;

/**
 * @author ankushsharma
 * @date 08/12/17
 */

public interface RepositoryDataSource {

    /**
     * @param query
     * @param days
     * @param callback
     */
    void getWeather(String query, String days,
                    IDataSource.LoadDataCallback<WeatherModel> callback);

}