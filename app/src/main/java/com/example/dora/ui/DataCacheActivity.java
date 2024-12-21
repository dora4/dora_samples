package com.example.dora.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.dora.ARouterPath;
import com.example.dora.R;
import com.example.dora.SampleApp;
import com.example.dora.MessageEvent;
import com.example.dora.databinding.ActivityDataCacheBinding;
import com.example.dora.di.component.DaggerMenuComponent;
import com.example.dora.datacache.adapter.PopMusicAdapter;
import com.example.dora.datacache.repository.PopMusicRepository;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import dora.BaseActivity;
import dora.util.ViewUtils;

/**
 * 仅供体验大致写法，详细教程请参考 https://github.com/dora4/DoraCacheSample 。
 */
@Route(path = ARouterPath.ACTIVITY_DATA_CACHE)
public class DataCacheActivity extends BaseActivity<ActivityDataCacheBinding> {
    
    // Dagger方式注入
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
    public void initData(@Nullable Bundle savedInstanceState, @NonNull ActivityDataCacheBinding binding) {
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent msg) {
    }
}
