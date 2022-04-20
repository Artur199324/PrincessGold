package com.pirinc.zlot.viewmodel;

import android.app.Application;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.pirinc.zlot.model.AppRepository;
import com.pirinc.zlot.model.Player;

import java.util.ArrayList;

public class MainActivityViewModel extends AndroidViewModel {

    AppRepository appRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        appRepository = new AppRepository(application);
    }

    public void insertData(Player player){
        appRepository.insertPlayer(player);
    }

    public String getData(){
       return appRepository.getPlayer().getName();
    }


}
