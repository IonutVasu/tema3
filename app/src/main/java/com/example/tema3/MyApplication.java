package com.example.tema3;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext();
    }
    //ca sa pot face rost de context in chestii statice (aveam nevoie la onclick)
    public static Context getAppContext() {
        return MyApplication.context;
    }
}