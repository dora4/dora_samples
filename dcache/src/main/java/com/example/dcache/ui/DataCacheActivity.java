package com.example.dcache.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.common.MessageEvent;
import com.example.dcache.R;
import com.example.dcache.databinding.ActivityDataCacheBinding;
import com.example.dcache.adapter.PopMusicAdapter;
import com.example.dcache.repository.PopMusicRepository;

import dora.BaseActivity;
import dora.util.ViewUtils;

/**
 * 仅供体验大致写法，详细教程请参考 https://github.com/dora4/DoraCacheSample 。
 */
//@Route(path = ARouterPath.ACTIVITY_DATA_CACHE)
public class DataCacheActivity extends BaseActivity<ActivityDataCacheBinding> {
    
    // Dagger方式注入
//    @Inject
    PopMusicRepository repository;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_data_cache;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        DaggerCacheComponent.builder().appComponent(((SampleApp)getApplication())
//                .getAppComponent()).build().inject(this);
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
                .observe(this, popMusics -> ViewUtils.configRecyclerView(binding.rvDataCache)
                        .setAdapter(new PopMusicAdapter(popMusics)));
    }
}
