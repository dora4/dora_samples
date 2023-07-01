package com.example.dora.datacache.service;

import com.example.dora.model.ApiResult;
import com.example.dora.datacache.model.PopMusic;

import java.util.List;

import dora.http.retrofit.ApiService;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MusicService extends ApiService {

    @GET("v1/popmusic")
    Call<ApiResult<List<PopMusic>>> popMusicGet();
}
