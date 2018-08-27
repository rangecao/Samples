package com.rangecao.samples.contacts;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by caorange on 17-11-13.
 */

public class ContactsList extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Cursor cursor = getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI,
//                new String[]{ContactsContract.RawContacts.ACCOUNT_NAME,
//                        ContactsContract.RawContacts.ACCOUNT_TYPE,
//                        ContactsContract.RawContacts.DISPLAY_NAME_PRIMARY},null,null,null);
//        while (cursor.moveToNext()) {
//            Log.i("range.cao", "account_name:" + cursor.getString(0) +" account_tyle:"+cursor.getString(1)+ "name:"+cursor.getString(2));
//        }
//        cursor.close();


        Cursor cursor = getContentResolver().query(CallLog.Calls.CONTENT_URI, null,null,null,null);
        Log.i("range.cao", "cursor.getCount():"+cursor.getCount());
        cursor.close();
    }
}
