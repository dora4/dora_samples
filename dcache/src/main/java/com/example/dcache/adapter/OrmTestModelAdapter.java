package com.example.dcache.adapter;

import android.view.View;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.dcache.R;
import com.example.dcache.model.OrmTestModel;

public class OrmTestModelAdapter extends BaseQuickAdapter<OrmTestModel, OrmTestModelAdapter.OrmTestModelViewHolder> {

    public OrmTestModelAdapter() {
        super(R.layout.item_test_model);
    }

    @Override
    protected void convert(@NonNull OrmTestModelViewHolder holder, OrmTestModel model) {
        holder.setText(R.id.tv_test_model_index, String.valueOf(getItemPosition(model) + 1));
        holder.setText(R.id.tv_test_model_string, "string值："+model.getStringVal());
        holder.setText(R.id.tv_test_model_int, "int值："+model.getIntVal());
    }

    static class OrmTestModelViewHolder extends BaseViewHolder {

        public OrmTestModelViewHolder(View view) {
            super(view);
        }
    }
}
