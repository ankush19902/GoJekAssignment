package com.android.ankushsharma.gojekassignment.weather.data.source;


import android.support.annotation.NonNull;

import com.android.ankushsharma.gojekassignment.weather.data.model.WeatherModel;
import com.android.ankushsharma.gojekassignment.weather.data.source.remote.RemoteDataSource;

/**
 * @author ankushsharma
 * @date 08/12/17
 */

public class Repository implements RepositoryDataSource {

    private static Repository INSTANCE = null;
    private final RemoteDataSource remoteDataSource;


    public static Repository getInstance(RemoteDataSource remoteDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new Repository(remoteDataSource);
        }
        return INSTANCE;
    }

    private Repository(@NonNull RemoteDataSource remoteDataSource) {

        this.remoteDataSource = remoteDataSource;
    }


    @Override
    public void getWeather(String query, String days, IDataSource.LoadDataCallback<WeatherModel> callback) {

        remoteDataSource.getWeather(query, days, callback);
    }
}