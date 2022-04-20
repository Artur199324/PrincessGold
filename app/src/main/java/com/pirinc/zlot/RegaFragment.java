package com.pirinc.zlot;

import static com.pirinc.zlot.MainActivity.mainActivityViewModel;
import static com.pirinc.zlot.MainActivity.navControllerGame;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pirinc.zlot.model.Player;


public class RegaFragment extends Fragment {

    EditText editTextTextPersonName;
    Button buttonOk;
    String saved;
    public static MainActivity mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_rega, container, false);
        editTextTextPersonName = view.findViewById(R.id.editTextTextPersonName);
        buttonOk = view.findViewById(R.id.buttonOk);
         saved = "-";


        editTextTextPersonName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                saved = editable.toString();
            }
        });

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!saved.equals("-")){
                    Player player = new Player(saved);
                    mainActivityViewModel.insertData(player);
                    mainActivity.startActivity(new Intent(mainActivity.getApplicationContext(),MainActivity.class));
                    mainActivity.finishAffinity();
                }else {
                    Toast toast = Toast.makeText(mainActivity.getApplicationContext(), "Enter your name", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });

        return view;
    }
}