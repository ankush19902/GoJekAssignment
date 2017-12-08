package com.android.ankushsharma.gojekassignment.weather.presenter;


import com.android.ankushsharma.gojekassignment.weather.data.model.WeatherModel;

/**
 *
 * @author ankushsharma
 * @date 08/12/17
 */

public interface WeatherContract {

    interface WeatherView {

        void updateViewWithWeather(WeatherModel model);

        void setLoadingIndicator(boolean isActive);

        void showError();
    }

    interface WeatherPresenter {

        void getWeatherDetail(String query, String days);

    }
}
