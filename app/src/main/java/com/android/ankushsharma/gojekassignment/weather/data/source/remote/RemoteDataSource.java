package com.android.ankushsharma.gojekassignment.weather.data.source.remote;

import android.support.annotation.NonNull;

import com.android.ankushsharma.gojekassignment.weather.data.model.WeatherModel;
import com.android.ankushsharma.gojekassignment.weather.data.source.IDataSource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author ankushsharma
 * @date 08/12/17
 */

public class RemoteDataSource implements IRemoteDataSource {

    private static RemoteDataSource INSTANCE;
    private ApiService service;

    private RemoteDataSource(ApiService service) {
        this.service = service;
    }

    public static RemoteDataSource getInstance(ApiService service) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource(service);
        }
        return INSTANCE;
    }

    @Override
    public void getWeather(@NonNull String query, String days, @NonNull final IDataSource.LoadDataCallback<WeatherModel> callback) {

        Call<WeatherModel> weatherModelCall = service.doGetCityWeather(query, days);
        weatherModelCall.enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                if (response.body() != null) {
                    callback.onDataLoaded(response.body());
                } else {
                    callback.onDataNotAvailable();
                }
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {
                callback.onDataNotAvailable();
            }
        });
    }
}
