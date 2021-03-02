package com.example.dora.datacache.model;

import dora.db.OrmTable;
import dora.db.PrimaryKeyEntity;
import dora.db.PrimaryKeyId;
import dora.db.table.Column;
import dora.db.table.Id;
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
    public PrimaryKeyEntity getPrimaryKey() {
        return new PrimaryKeyId(id);
    }

    @Override
    public boolean isUpgradeRecreated() {
        return false;
    }
}
