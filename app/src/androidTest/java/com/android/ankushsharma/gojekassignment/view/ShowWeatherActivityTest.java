package com.android.ankushsharma.gojekassignment.view;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.android.ankushsharma.gojekassignment.R;
import com.android.ankushsharma.gojekassignment.weather.data.model.WeatherModel;
import com.android.ankushsharma.gojekassignment.weather.data.source.IDataSource;
import com.android.ankushsharma.gojekassignment.weather.data.source.Injection;
import com.android.ankushsharma.gojekassignment.weather.data.source.RepositoryDataSource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertNotNull;

/**
 * Created by ankushsharma on 09/12/17.
 */
public class ShowWeatherActivityTest {

    @Rule
    public ActivityTestRule<ShowWeatherActivity> activityTestRule = new ActivityTestRule<>(ShowWeatherActivity.class);

    ShowWeatherActivity activity;
    private WeatherModel data;
    private final CountDownLatch latch = new CountDownLatch(1);
    private RepositoryDataSource repository;

    @Before
    public void setUp() throws Exception {

        repository = Injection.provideRepository();
    }

    @Test
    public void testIfActivityLacunched() {
        activity = activityTestRule.getActivity();
        View view = activity.findViewById(R.id.constLayout_progress);
        assertNotNull(view);

    }

    @Test
    public void testIfApiIsAvailable() throws InterruptedException {

        Assert.assertNotNull(repository);


        repository.getWeather("delhi", "5", new IDataSource.LoadDataCallback<WeatherModel>() {

            @Override
            public void onDataLoaded(WeatherModel data1) {
                data = data1;
                latch.countDown();
            }

            @Override
            public void onDataNotAvailable() {
                latch.countDown();
            }
        });

        latch.await();
        Assert.assertNotNull(this.data);

    }

    @After
    public void tearDown() throws Exception {
    }

}