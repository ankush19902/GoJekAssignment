package com.android.ankushsharma.gojekassignment.weather.data.source.remote;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author ankushsharma
 * @date 08/12/17
 */

public class ApiClient {

    public ApiClient() {
    }

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            synchronized (Retrofit.class) {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

                OkHttpClient client = new OkHttpClient.Builder()
                        .addInterceptor(interceptor)
                        .readTimeout(10, TimeUnit.SECONDS)
                        .connectTimeout(10, TimeUnit.SECONDS)
                        .retryOnConnectionFailure(true)
                        .addInterceptor(new ApiInterceptor()).build();

                retrofit = new Retrofit.Builder()
                        .baseUrl("http://api.apixu.com/v1/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(client)
                        .build();
            }
        }
        return retrofit;
    }

}
