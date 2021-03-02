package com.example.dora.datacache.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.dora.R;
import com.example.dora.datacache.model.PopMusic;

import java.util.List;

public class PopMusicAdapter extends BaseQuickAdapter<PopMusic, PopMusicAdapter.PopMusicViewHolder> {

    public PopMusicAdapter(List<PopMusic> data) {
        super(R.layout.item_pop_music, data);
    }

    @Override
    protected void convert(PopMusicViewHolder holder, PopMusic entity) {
        holder.setText(R.id.tv_pop_music_index, String.valueOf(getItemPosition(entity)+1));
        holder.setText(R.id.tv_pop_music_name, entity.getMusicName());
        holder.setText(R.id.tv_pop_music_artist, entity.getMusicArtist());
    }

    static class PopMusicViewHolder extends BaseViewHolder {

        public PopMusicViewHolder(View view) {
            super(view);
        }
    }
}
