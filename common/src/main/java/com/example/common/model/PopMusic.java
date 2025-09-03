package com.example.common.model;

import androidx.annotation.NonNull;

import dora.db.constraint.Id;
import dora.db.migration.OrmMigration;
import dora.db.table.Column;
import dora.db.table.OrmTable;
import dora.db.table.Table;

@Table("pop_music")
public class PopMusic implements OrmTable {

    @Id
    long id;
    @Column("music_name")
    String musicName;
    @Column("music_artist")
    String musicArtist;

    public PopMusic(String name, String artist) {
        this.musicName = name;
        this.musicArtist = artist;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicArtist() {
        return musicArtist;
    }

    public void setMusicArtist(String musicArtist) {
        this.musicArtist = musicArtist;
    }

    @Override
    public boolean isUpgradeRecreated() {
        return false;
    }

    @NonNull
    @Override
    public OrmMigration[] getMigrations() {
        return new OrmMigration[0];
    }
}
