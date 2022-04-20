package com.pirinc.zlot.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;


import com.pirinc.zlot.PG;
import com.pirinc.zlot.model.AppRepositoryPG;
import com.pirinc.zlot.model.ConnPG;
import com.pirinc.zlot.model.Dipp;
import com.pirinc.zlot.model.SavePG;

public class PGActivityViewModel extends AndroidViewModel {

    AppRepositoryPG appRepositoryPG;

    public PGActivityViewModel(@NonNull Application application) {
        super(application);
        appRepositoryPG = new AppRepositoryPG(application);

    }

    public void insertDataSave(SavePG savePG){
        appRepositoryPG.insertSave(savePG);
    }

    public String getDataSave(){
        return appRepositoryPG.getSave().getSaveStr();
    }

    public ConnPG getCon() {
        return appRepositoryPG.conPG();
    }

    public Dipp getDip(String fbId, PG pg) {
        return appRepositoryPG.dipp(fbId, pg);
    }
}
