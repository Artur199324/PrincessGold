package com.pirinc.zlot;

import static com.pirinc.zlot.MainActivity.mainActivityViewModel;
import static com.pirinc.zlot.MainActivity.navControllerGame;

import android.content.Context;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pirinc.zlot.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.Random;

public class GameFragmentPG extends Fragment {

    public static ConstraintLayout constrainGame;
    public static TextView textView, textView2,textView3,textView4,textViewName;
    public static ImageView imageViewMenu;
    public static String saveName = "-";




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_game_p_g, container, false);

        constrainGame = view.findViewById(R.id.constrainGame);
        textView = view.findViewById(R.id.textView);
        textView2 = view.findViewById(R.id.textView2);
        textView3 = view.findViewById(R.id.textView3);
        textView4 = view.findViewById(R.id.textView4);
        imageViewMenu = view.findViewById(R.id.imageViewMenu);
        textViewName = view.findViewById(R.id.textViewName);

        imageViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navControllerGame.navigate(R.id.regaFragment);
            }
        });

        return view;
    }
}