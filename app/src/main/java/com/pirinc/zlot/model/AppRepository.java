package com.pirinc.zlot.model;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

public class AppRepository {

    PlayerDao playerDao;

    public AppRepository(Application application) {
        PlayerDataBase database = PlayerDataBase.getInstance(application);
        playerDao = database.playerDao();
    }

    public Player getPlayer() {
        return playerDao.getPlayer();
    }

    public void insertPlayer(Player player) {
        new InsertPlayerAsyncTask(playerDao).execute(player);
    }

    private static class InsertPlayerAsyncTask extends AsyncTask<Player, Void, Void>{
        PlayerDao playerDao;
        public InsertPlayerAsyncTask(PlayerDao playerDao) {
            this.playerDao = playerDao;

        }

        @Override
        protected Void doInBackground(Player... players) {
            playerDao.player(players[0]);
            return null;
        }
    }


}
