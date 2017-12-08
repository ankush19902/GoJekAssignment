package com.android.ankushsharma.gojekassignment.weather.data.source;

/**
 * @author ankushsharma
 * @date 08/12/17
 */

public interface IDataSource {

    interface LoadDataCallback<T> {

        /**
         * @param data will carry the model
         */
        void onDataLoaded(T data);

        /**
         * if api doesnt return result
         */
        void onDataNotAvailable();
    }
}