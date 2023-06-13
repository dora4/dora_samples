package com.example.dora.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.dora.ARouterPath;
import com.example.dora.R;
import com.example.dora.SampleApp;
import com.example.dora.databinding.ActivityDataCacheBinding;
import com.example.dora.di.component.DaggerMenuComponent;
import com.example.dora.datacache.adapter.PopMusicAdapter;
import com.example.dora.datacache.repository.PopMusicRepository;

import javax.inject.Inject;

import dora.BaseActivity;
import dora.util.ViewUtils;

/**
 * 代码参考datacache包。使用三级缓存框架需要先掌握Retrofit和DoraDb框架{@link OrmActivity}。
 */
@Route(path = ARouterPath.ACTIVITY_DATA_CACHE)
public class DataCacheActivity extends BaseActivity<ActivityDataCacheBinding> {

    @Inject
    PopMusicRepository repository;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_data_cache;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        DaggerMenuComponent.builder().appComponent(((SampleApp)getApplication())
                .getAppComponent()).build().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        // 数据库的初始化操作是必须的，由于使用了dagger的依赖注入，在这里初始化已经迟了，所以移动到SampleApp类中
//        val config = OrmConfig.Builder()
//                .database("orm_sample_2")
//                .version(2)
//                .tables(PopMusic::class.java)
//            .build()
//        Orm.init(this, config)
        repository.fetchListData("描述信息", null)
                .observe(this, popMusics -> ViewUtils.configRecyclerView(mBinding.rvDataCache)
                        .setAdapter(new PopMusicAdapter(popMusics)));
    }
}
