package com.pirinc.zlot;

import static com.pirinc.zlot.GameFragmentPG.constrainGame;
import static com.pirinc.zlot.GameFragmentPG.imageViewMenu;
import static com.pirinc.zlot.GameFragmentPG.saveName;
import static com.pirinc.zlot.GameFragmentPG.textView;
import static com.pirinc.zlot.GameFragmentPG.textView2;
import static com.pirinc.zlot.GameFragmentPG.textView3;
import static com.pirinc.zlot.GameFragmentPG.textView4;
import static com.pirinc.zlot.GameFragmentPG.textViewName;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;

import com.pirinc.zlot.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static MainActivityViewModel mainActivityViewModel;
    public static NavController navControllerGame;
    public static Display display;
    public static int width;
    public static int height;
    public static ImageView imageView;
    int size;
    int a = 0;
    int b = 0;
    int c = 0;
    int v = 0;
    ArrayList<ImageView> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(1024);
        setContentView(R.layout.activity_main);
        RegaFragment.mainActivity = this;
        arrayList = new ArrayList<>();

        navControllerGame = Navigation.findNavController(this, R.id.nav_host_fragmentIGame);

        mainActivityViewModel = new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(MainActivityViewModel.class);
        display = getWindowManager().getDefaultDisplay();
        width = display.getWidth();
        height = display.getHeight();
        imageView = new ImageView(this);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    saveName = mainActivityViewModel.getData();
                    if (!saveName.equals("-")) {
                        imageViewMenu.setVisibility(View.INVISIBLE);
                        textViewName.setText(saveName);
                        textViewName.setVisibility(View.VISIBLE);
                    } else {
                        imageViewMenu.setVisibility(View.VISIBLE);
                        textViewName.setVisibility(View.INVISIBLE);
                    }
                } catch (Exception e) {

                }

            }
        }).start();

        size = MainActivity.width / 7;
        Handler handler = new Handler();
        dhd(handler);
        hdh(handler);
        jusv(handler);


    }

    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    private void dhd(Handler handler) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Log.d("weq", "wwww");
                Random random = new Random();
                int r = random.nextInt(4);
                ImageView imageView = new ImageView(MainActivity.this);
                ConstraintLayout.LayoutParams constrainGameLay = new ConstraintLayout.LayoutParams(size, size);
                imageView.setLayoutParams(constrainGameLay);
                GameFragmentPG.constrainGame.addView(imageView, constrainGameLay);
                switch (r) {
                    case 0:
                        imageView.setImageResource(R.drawable.slot1);
                        imageView.setTag(1);

                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.slot2);
                        imageView.setTag(2);

                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.slot3);
                        imageView.setTag(3);

                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.slot4);
                        imageView.setTag(4);
                        break;

                }
                imageView.setY(rnd(130, height - size));
                imageView.setX(rnd(0 + size, width - size));
                arrayList.add(imageView);

                handler.postDelayed(this::run, 500);
            }
        });
    }

    private void hdh(Handler handler) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arrayList.size(); i++) {
                    ImageView imageView = arrayList.get(i);

                    constrainGame.removeView(imageView);
                    arrayList.remove(i);
                }

                handler.postDelayed(this::run, 800);
            }
        });
    }

    private void jusv(Handler handler) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arrayList.size(); i++) {
                    ImageView imageView = arrayList.get(i);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int d = (int) imageView.getTag();
                            switch (d) {
                                case 1:
                                    a++;
                                    textView.setText(a + "");
                                    break;
                                case 2:
                                    b++;
                                    textView2.setText(b + "");
                                    break;
                                case 3:
                                    c++;
                                    textView3.setText(c + "");
                                    break;
                                case 4:
                                    v++;
                                    textView4.setText(v + "");
                                    break;
                            }
                            constrainGame.removeView(imageView);

                        }
                    });

                }

                handler.postDelayed(this::run, 1000);
            }
        });

    }


}