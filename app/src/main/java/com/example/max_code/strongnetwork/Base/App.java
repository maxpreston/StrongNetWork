package com.example.max_code.strongnetwork.Base;

import android.app.Application;

/**
 * Created by max-code on 2016/9/4.
 */
public class App extends Application {
    public static App appinstance;

    public static App getAppinstance() {
        return appinstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appinstance = this;
    }
}
