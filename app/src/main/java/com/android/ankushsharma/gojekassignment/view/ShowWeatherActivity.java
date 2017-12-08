package com.android.ankushsharma.gojekassignment.view;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.android.ankushsharma.gojekassignment.R;
import com.android.ankushsharma.gojekassignment.common.BaseActivity;

import butterknife.BindView;

/**
 * @author ankushsharma
 * @date 08/12/17
 */
public class ShowWeatherActivity extends BaseActivity {


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

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_show_weather;
    }
}
