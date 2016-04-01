package com.wind.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by xm009 on 15/11/7.
 */
public class TestReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Keith", "TestReceiver::onReceive()");

        Intent i = new Intent();
        i.setAction("Action");
        i.setClass(context, TestService.class);
        context.startService(i);
        Log.e("Keith", "TestReceiver::onReceive() after startService()");
    }
}
