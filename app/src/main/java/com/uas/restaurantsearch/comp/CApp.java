package com.uas.restaurantsearch.comp;

import android.app.Application;

import com.uas.restaurantsearch.networks.APIClient;

import retrofit2.Retrofit;

public class CApp extends Application {

    private static Retrofit apiClient;

    @Override
    public void onCreate()
    {
        super.onCreate();
        apiClient = APIClient.getClient();
    }

    public static Retrofit getAPIClient()
    {
        return apiClient;
    }
}
