package com.pirinc.zlot.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface PlayerDao {

    @Insert
    void player(Player player);

    @Query("SELECT * FROM player ORDER BY ID DESC LIMIT 1")
    Player getPlayer();
}
