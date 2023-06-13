package com.example.dora.datacache.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dora.datacache.model.PopMusic;
import com.example.dora.datacache.service.MusicService;

import javax.inject.Inject;

import dora.cache.data.adapter.ListResultAdapter;
import dora.cache.data.fetcher.OnLoadStateListener;
import dora.cache.repository.DoraDatabaseCacheRepository;
import dora.db.builder.Condition;
import dora.http.DoraListCallback;
import dora.http.retrofit.RetrofitManager;
import dora.util.GlobalContext;

public class PopMusicRepository extends DoraDatabaseCacheRepository<PopMusic> {

    @Inject
    public PopMusicRepository() {
        super(GlobalContext.get());
    }

    /**
     * 告诉框架怎么加载这部分数据。
     *
     * @param callback
     */
    @Override
    protected void onLoadFromNetwork(@NonNull DoraListCallback<PopMusic> callback, @Nullable OnLoadStateListener listener) {
        RetrofitManager.INSTANCE.getService(MusicService.class).popMusicGet()
                .enqueue(new ListResultAdapter(callback));
    }

    /**
     * 数据过滤条件，从数据库查询出来之前会先过滤不要的数据。
     */
    @NonNull
    @Override
    protected Condition query() {
        return super.query();
    }
}
