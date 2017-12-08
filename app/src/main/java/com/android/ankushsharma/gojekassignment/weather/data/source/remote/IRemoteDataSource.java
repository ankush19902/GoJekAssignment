package com.android.ankushsharma.gojekassignment.weather.data.source.remote;

import android.support.annotation.NonNull;

import com.android.ankushsharma.gojekassignment.weather.data.model.WeatherModel;
import com.android.ankushsharma.gojekassignment.weather.data.source.IDataSource;

/**
 * @author ankushsharma
 * @date 08/12/17
 */
public interface IRemoteDataSource extends IDataSource {


    /**
     * @param query    parameter on which weather is fetched
     * @param days     no of days to be fetched
     * @param callback response of api
     */
    void getWeather(@NonNull String query, String days, @NonNull LoadDataCallback<WeatherModel> callback);
}