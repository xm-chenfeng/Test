package com.wind.test;

import android.app.Application;
import android.util.Log;

import com.orm.SugarApp;
import com.orm.SugarContext;

/**
 * Created by xm009 on 15/11/7.
 */
public class TestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("Keith", "TestApplication::onCreate()");
        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}
