package com.wind.test;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.wind.test.models.TestBody;
import com.wind.test.models.TestData;

/**
 * Created by xm009 on 15/11/7.
 */
public class TestService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("Keith", "TestService::onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("Keith", "TestService::onStartCommand()");

        TestData data = new TestData();
        data.setData_item(11);
        TestBody body = new TestBody(1, "service", data);
        body.save();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("Keith", "TestService::onDestroy()");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
