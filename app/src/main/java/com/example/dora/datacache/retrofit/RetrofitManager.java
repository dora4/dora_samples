package com.example.dora.datacache.retrofit;

import com.example.dora.datacache.service.MusicService;

import dora.http.log.RequestInterceptor;
import dora.http.retrofit.BaseRetrofitManager;
import okhttp3.OkHttpClient;

public class RetrofitManager extends BaseRetrofitManager {

    static RetrofitManager retrofitManager;

    @Override
    protected void initBaseUrl() {
        registerBaseUrl(MusicService.class,"http://doramusic.site:8080/");
    }

    @Override
    protected OkHttpClient createHttpClient() {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(new RequestInterceptor())
//                .addNetworkInterceptor(new TokenInterceptor())
                .build();
    }

    public static <T> T getService(Class<T> clazz) {
        if (retrofitManager == null) {
            synchronized (RetrofitManager.class) {
                if (retrofitManager == null) retrofitManager = new RetrofitManager();
            }
        }
        return retrofitManager._getService(clazz);
    }
}
