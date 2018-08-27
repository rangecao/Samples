package com.rangecao.samples.content;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.rangecao.samples.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caorange on 18-7-31.
 */

public class PackageManagerA extends Activity implements View.OnClickListener {

    private View mVQueryIntent;
    private PackageManager mPackageManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_pm);

        mVQueryIntent = findViewById(R.id.query_intent);
        mVQueryIntent.setOnClickListener(this);

        mPackageManager = getPackageManager();
    }

    @Override
    public void onClick(View v) {
        if(v == mVQueryIntent){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("application/vnd.android.package-archive");
            //intent.setType("image/png");
            List<ResolveInfo> list =  mPackageManager.queryIntentActivities(intent,PackageManager.MATCH_DEFAULT_ONLY);
            Log.e("range.cao","list:"+list.size());
            for(ResolveInfo resolveInfo : list){
                Log.e("range.cao","resolveInfo:"+resolveInfo);
            }
        }
    }
}
