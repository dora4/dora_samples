package com.example.dora.datacache.repository;

import com.example.dora.datacache.model.PopMusic;
import com.example.dora.datacache.retrofit.RetrofitManager;
import com.example.dora.datacache.service.MusicService;

import javax.inject.Inject;

import dora.cache.repository.BaseDatabaseCacheRepository;
import dora.db.builder.WhereBuilder;
import dora.http.DoraListCallback;

public class PopMusicRepository extends BaseDatabaseCacheRepository<PopMusic> {

    @Inject
    public PopMusicRepository() {
        super(PopMusic.class);
    }
    /**
     * 告诉框架怎么加载这部分数据。
     *
     * @param callback
     */
    @Override
    protected void onLoadFromNetwork(DoraListCallback<PopMusic> callback) {
        RetrofitManager.getService(MusicService.class).popMusicGet().enqueue(callback);
    }

    /**
     * 数据过滤条件，从数据库查询出来之前会先过滤不要的数据。
     */
    @Override
    protected WhereBuilder where() {
        return super.where();
    }
}
