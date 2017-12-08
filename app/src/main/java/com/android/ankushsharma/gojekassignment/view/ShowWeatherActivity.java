package com.android.ankushsharma.gojekassignment.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.android.ankushsharma.gojekassignment.R;
import com.android.ankushsharma.gojekassignment.common.BaseActivity;
import com.android.ankushsharma.gojekassignment.util.AnimUtil;
import com.android.ankushsharma.gojekassignment.weather.adapters.WeatherForecastAdapter;
import com.android.ankushsharma.gojekassignment.weather.data.model.Forecastday;
import com.android.ankushsharma.gojekassignment.weather.data.model.WeatherModel;
import com.android.ankushsharma.gojekassignment.weather.data.source.Injection;
import com.android.ankushsharma.gojekassignment.weather.presenter.WeatherContract;
import com.android.ankushsharma.gojekassignment.weather.presenter.WeatherPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author ankushsharma
 * @date 08/12/17
 */
public class ShowWeatherActivity extends BaseActivity implements WeatherContract.WeatherView {


    @BindView(R.id.imgv_progress)
    ImageView imgvProgress;
    @BindView(R.id.tv_currentWeather)
    AppCompatTextView tvCurrentWeather;
    @BindView(R.id.tv_cityName)
    AppCompatTextView tvCityName;
    @BindView(R.id.rcv_weatherForcast)
    RecyclerView rcaWeatherForecast;
    @BindView(R.id.constLayout_mainContent)
    ConstraintLayout constLayoutMainContent;
    @BindView(R.id.constLayout_error)
    ConstraintLayout constLayoutError;
    @BindView(R.id.constLayout_progress)
    ConstraintLayout constLayoutProgress;
    private WeatherContract.WeatherPresenter presenter;
    private String NO_OF_DAYS = "5";
    private String query = "auto:ip";
    private WeatherForecastAdapter adapter;
    private List<Forecastday> weatherForecastList = new ArrayList<>();

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_show_weather;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
        adapter = new WeatherForecastAdapter(weatherForecastList);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcaWeatherForecast.setLayoutManager(linearLayoutManager);
        rcaWeatherForecast.setAdapter(adapter);
        DividerItemDecoration itemDecorator = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider));
        rcaWeatherForecast.addItemDecoration(itemDecorator);
        rcaWeatherForecast.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    protected void onResume() {
        super.onResume();
        getWeather();
    }

    @Override
    public void updateViewWithWeather(WeatherModel model) {

        if (model != null) {

            if (model.getCurrent() != null) {

                double tempC = model.getCurrent().getTempC();
                String temp = String.valueOf((int) Math.ceil(tempC));
                tvCurrentWeather.setText(temp + (char) 0x00B0);
            }

            if (model.getLocation() != null && !TextUtils.isEmpty(model.getLocation().getName())) {

                tvCityName.setText(model.getLocation().getName());
            }

            constLayoutMainContent.setVisibility(View.VISIBLE);

            weatherForecastList.clear();
            weatherForecastList.addAll(model.getForecast().getForecastday());
            weatherForecastList.remove(0);
            adapter.notifyDataSetChanged();

            AnimUtil.slideUp(rcaWeatherForecast, this);
        }
    }


    @Override
    public void setLoadingIndicator(boolean isActive) {
        if (isActive) {
            constLayoutProgress.setVisibility(View.VISIBLE);
            constLayoutError.setVisibility(View.GONE);
            AnimUtil.rotate(imgvProgress, this);
        } else {
            constLayoutProgress.setVisibility(View.GONE);
            AnimUtil.stopAnimation(imgvProgress);
        }
    }

    @Override
    public void showError() {
        constLayoutError.setVisibility(View.VISIBLE);
        constLayoutMainContent.setVisibility(View.GONE);
    }


    protected void initPresenter() {
        presenter = new WeatherPresenter(this, Injection.provideRepository());
    }

    @OnClick(R.id.btn_retry)
    protected void getWeather() {
        presenter.getWeatherDetail(query, NO_OF_DAYS);
    }
}
