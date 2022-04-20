package com.pirinc.zlot.model;

import static com.pirinc.zlot.PG.parserPG;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.Nullable;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.applinks.AppLinkData;
import com.pirinc.zlot.PG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AppRepositoryPG {

    SavePGDao savePGDao;

    public AppRepositoryPG(Application application) {
        SavePGDataBase savePGDataBase = SavePGDataBase.getInstance(application);
        savePGDao = savePGDataBase.savePGDao();
    }

    public SavePG getSave() {
        return savePGDao.getSavePG();
    }

    public void insertSave(SavePG savePG){
       new InsertSaverAsyncTask(savePGDao).execute(savePG);
    }

    private static class InsertSaverAsyncTask extends AsyncTask<SavePG, Void, Void>{
        SavePGDao savePGDao;

        public InsertSaverAsyncTask(SavePGDao savePGDao) {
            this.savePGDao = savePGDao;
        }

        @Override
        protected Void doInBackground(SavePG... savePGS) {

            savePGDao.savePg(savePGS[0]);
            return null;
        }
    }

    public ConnPG conPG() {

        ConnPG connPG = new ConnPG();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://206.54.183.71/PrincessGold.json").openConnection();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    connPG.setDae(bufferedReader.readLine());
                    connPG.setBgayw(bufferedReader.readLine());
                    connPG.setNhsa(bufferedReader.readLine());
                    connPG.setAsdw(bufferedReader.readLine());
                  ;
                } catch (Exception e) {

                }

            }
        }).start();
        return connPG;
    }

    public Dipp dipp(String fbId, PG pg) {

        Dipp dipp = new Dipp();
        FacebookSdk.setApplicationId(fbId);
        FacebookSdk.setAdvertiserIDCollectionEnabled(true);
        FacebookSdk.sdkInitialize(pg.getApplicationContext());
        FacebookSdk.fullyInitialize();
        FacebookSdk.setAutoInitEnabled(true);
        FacebookSdk.setAutoLogAppEventsEnabled(true);

        AppEventsLogger.activateApp(pg.getApplication());
        AppLinkData.fetchDeferredAppLinkData(pg.getApplicationContext(), new AppLinkData.CompletionHandler() {
            @Override
            public void onDeferredAppLinkDataFetched(@Nullable AppLinkData appLinkData) {
                if (appLinkData == null) {
                    appLinkData = AppLinkData.createFromActivity(pg);

                }
                if (appLinkData != null) {

                    String[] as = appLinkData.getTargetUri().toString().split("://");
                    String deep = as[1];
                    String strDeepLink = parserPG(deep);
                    dipp.setVdse(deep);
                    dipp.setQqwqa(strDeepLink);
                } else {

                }
            }
        });

        return dipp;
    }


}
