package com.pirinc.zlot.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {SavePG.class}, version = 2)
public abstract class SavePGDataBase extends RoomDatabase {
    public abstract SavePGDao savePGDao();
    private static SavePGDataBase savePGDataBase;

    public static synchronized SavePGDataBase getInstance(Context context){
        if (savePGDataBase == null) {

            savePGDataBase = Room.databaseBuilder(context.getApplicationContext(),
                    SavePGDataBase.class, "saveDB")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return savePGDataBase;
    }
}
