package com.rangecao.samples.app;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.rangecao.samples.R;

/**
 * Created by caorange on 18-7-30.
 */

public class TestActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_test);
//
//        getWindow().getDecorView().setSystemUiVisibility(
//                getWindow().getDecorView().getSystemUiVisibility()
//        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);


//        Cursor cursor = getContentResolver().query(CallLog.Calls.CONTENT_URI,null,null,null,null);
//
//        while (cursor.moveToNext()){
//            String number = cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER));
//            Log.e("range.cao","number:"+number);
//        }
//
//        cursor.close();

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
    }
}
