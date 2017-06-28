package com.mxt.mxt;

import android.app.Application;

/**
 * Created by Administrator on 2017/6/26.
 */

public class App extends Application {

    private static App sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = (App) getApplicationContext();
    }

    public static App getContext() {
        return sContext;
    }
}
