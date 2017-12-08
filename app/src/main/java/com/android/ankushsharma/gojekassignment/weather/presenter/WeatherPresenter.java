package com.android.ankushsharma.gojekassignment.weather.presenter;

import android.support.annotation.NonNull;

import com.android.ankushsharma.gojekassignment.mvp.BasePresenter;
import com.android.ankushsharma.gojekassignment.weather.data.model.WeatherModel;
import com.android.ankushsharma.gojekassignment.weather.data.source.RepositoryDataSource;
import com.android.ankushsharma.gojekassignment.weather.data.source.remote.IRemoteDataSource;


/**
 * @author ankushsharma
 * @date 08/12/17
 */

public class WeatherPresenter extends BasePresenter<WeatherContract.WeatherView> implements WeatherContract.WeatherPresenter {

    private RepositoryDataSource repository;

    public WeatherPresenter(@NonNull WeatherContract.WeatherView view, @NonNull RepositoryDataSource repository) {
        super(view);
        this.repository = repository;
    }

    @Override
    public void getWeatherDetail(String query, String days) {
        view.setLoadingIndicator(true);
        repository.getWeather(query, days, new IRemoteDataSource.LoadDataCallback<WeatherModel>() {
            @Override
            public void onDataLoaded(WeatherModel data) {
                view.updateViewWithWeather(data);
                view.setLoadingIndicator(false);
            }

            @Override
            public void onDataNotAvailable() {
                view.showError();
                view.setLoadingIndicator(false);
            }
        });
    }
}
