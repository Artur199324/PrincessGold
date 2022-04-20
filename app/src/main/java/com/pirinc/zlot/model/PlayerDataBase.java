package com.pirinc.zlot.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Player.class}, version = 1)
public abstract class PlayerDataBase extends RoomDatabase {
    public abstract PlayerDao playerDao();
    private static PlayerDataBase instance;

    public static synchronized PlayerDataBase getInstance(Context context) {

        if (instance == null) {

            instance = Room.databaseBuilder(context.getApplicationContext(),
                    PlayerDataBase.class, "moviesDB")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }
}
