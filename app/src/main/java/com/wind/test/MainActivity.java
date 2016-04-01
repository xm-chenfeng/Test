package com.wind.test;

import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.wind.test.models.TestBody;
import com.wind.test.models.TestData;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        Log.e("Keith", "width: " + size.x);
        Log.e("Keith", "height: " + size.y);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int myHeight = 0;

        Log.e("Keith", "densityDpi: " + metrics.densityDpi);
        switch (metrics.densityDpi) {
            case DisplayMetrics.DENSITY_HIGH:
                Log.i("display", "high");
                myHeight = display.getHeight() - 48;
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                Log.i("display", "medium/default");
                myHeight = display.getHeight() - 32;
                break;
            case DisplayMetrics.DENSITY_LOW:
                Log.i("display", "low");
                myHeight = display.getHeight() - 24;
                break;
            default:
                Log.i("display", "Unknown density");
        }

        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        Log.e("Keith", "result: " + result);

        int hei = getResources().getDimensionPixelSize(R.dimen.notification_large_icon_height);
        int wid = getResources().getDimensionPixelSize(R.dimen.notification_large_icon_width);
        Log.e("Keith", "hei: " + hei + ", wid: " + wid);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void clickButton(View view) {
        Log.e("Keith", "MainActivity::clickButton()");
        TestData data = new TestData();
        data.setData_item(10);
        TestBody body = new TestBody(2, "activity", data);
        Log.e("Keith", "MainActivity::clickButton() body:" + body);
        body.save();

        Intent i = new Intent();
        i.setPackage("com.qisiemoji.inputmethod");
        i.setClassName(this, "com.qisi.ikeyboarduirestruct.NavigationActivity");
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }
}
