package com.pirinc.zlot;

import android.app.Application;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.onesignal.OneSignal;

import java.util.Map;

public class AppPG extends Application {

    public static String hfsgds;
    public static String bcgsa = "-";
    public static String sads;
    public static String vbhs;
    public static String vbsga = "aWhzd245NGJla3p3amM5Q3QyaXlpOQ==";
    public static String bsgaw;
    public static String bcshw;
    public static String bfgatw;

    @Override
    public void onCreate() {
        super.onCreate();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sads = AdvertisingIdClient.getAdvertisingIdInfo(getApplicationContext()).getId();
                } catch (Exception e) {

                }
            }
        }).start();

        hfsgds = AppsFlyerLib.getInstance().getAppsFlyerUID(this);

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
        OneSignal.initWithContext(this);
        OneSignal.setAppId(PG.decoderPG("MmU2ODJkNGMtN2UzNS00ODI0LTlkZDEtYTE5NWVmZTkzYzE0"));


        AppsFlyerLib.getInstance().init(PG.decoderPG(vbsga), new AppsFlyerConversionListener() {
            @Override
            public void onConversionDataSuccess(Map<String, Object> map) {
                bcgsa = map.get(PG.decoderPG("YWZfc3RhdHVz")).toString();

                if (bcgsa.equals(PG.decoderPG("Tm9uLW9yZ2FuaWM="))) {

                    try {
                        bsgaw = map.get(PG.decoderPG("Y2FtcGFpZ24=")).toString();
                    } catch (Exception e) {

                    }

                    try {

                        bcshw = map.get(PG.decoderPG("bWVkaWFfc291cmNl")).toString();
                    } catch (Exception e) {

                    }

                    try {

                        bfgatw = map.get(PG.decoderPG("YWZfY2hhbm5lbA==")).toString();
                    } catch (Exception e) {

                    }

                    vbhs = PG.parserPG(bsgaw);

                }
            }

            @Override
            public void onConversionDataFail(String s) {

            }

            @Override
            public void onAppOpenAttribution(Map<String, String> map) {

            }

            @Override
            public void onAttributionFailure(String s) {

            }
        }, this);
        AppsFlyerLib.getInstance().start(this);
    }
}
