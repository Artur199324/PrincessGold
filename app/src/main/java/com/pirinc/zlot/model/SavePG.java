package com.pirinc.zlot.model;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

@androidx.room.Entity(tableName = "savepg")
public class SavePG {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "saveStr")
    String saveStr;

    public SavePG(String saveStr) {
        this.saveStr = saveStr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSaveStr() {
        return saveStr;
    }

    public void setSaveStr(String saveStr) {
        this.saveStr = saveStr;
    }
}
