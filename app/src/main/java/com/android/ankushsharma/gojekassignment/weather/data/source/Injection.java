package com.android.ankushsharma.gojekassignment.weather.data.source;


import com.android.ankushsharma.gojekassignment.weather.data.source.remote.ApiClient;
import com.android.ankushsharma.gojekassignment.weather.data.source.remote.ApiService;
import com.android.ankushsharma.gojekassignment.weather.data.source.remote.RemoteDataSource;

/**
 * @author ankushsharma
 * @date 08/12/17
 */

public class Injection {

    public static Repository provideRepository() {

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        return Repository.getInstance(RemoteDataSource.getInstance(apiService));
    }
}