package com.pirinc.zlot.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface SavePGDao {

    @Insert
    void savePg(SavePG savePG);

    @Query("SELECT * FROM savepg ORDER BY ID DESC LIMIT 1")
    SavePG getSavePG();

}
