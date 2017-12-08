package com.android.ankushsharma.gojekassignment.weather.adapters;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.ankushsharma.gojekassignment.R;
import com.android.ankushsharma.gojekassignment.util.DateUtil;
import com.android.ankushsharma.gojekassignment.weather.data.model.Forecastday;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author ankushsharma
 * @date 08/12/17
 */

public class WeatherForecastAdapter extends RecyclerView.Adapter<WeatherForecastAdapter.ViewHolder> {

    private List<Forecastday> forecastday;

    public WeatherForecastAdapter(List<Forecastday> forecastday) {
        this.forecastday = forecastday;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather_forecast_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Forecastday forecastday = this.forecastday.get(position);
        if (forecastday != null) {

            if (forecastday.getDay() != null) {
                double tempC = forecastday.getDay().getAvgtempC();
                String temp = String.valueOf((int) Math.ceil(tempC));
                holder.tvTemp.setText(temp + " C");
            }

            if (forecastday.getDate() != null) {
                String dayOfTheWeek = DateUtil.getDayFromDateString(forecastday.getDate());
                if (!TextUtils.isEmpty(dayOfTheWeek)) {
                    holder.tvDay.setText(dayOfTheWeek);
                }
            }

        }
    }

    @Override
    public int getItemCount() {
        return forecastday.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_day)
        AppCompatTextView tvDay;
        @BindView(R.id.tv_temp)
        AppCompatTextView tvTemp;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
