package com.rangecao.samples.widget;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import com.rangecao.samples.R;

/**
 * Created by caorange on 18-8-2.
 */

public class SeekBarA extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_seekbar);
        WindowManager windowManager = getWindowManager();

        //windowManager.getDefaultDisplay().densityDpi;
        //Log.e("range.cao","windowManager.getDefaultDisplay():"+windowManager.getDefaultDisplay().getClass());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);

//        Log.e("range.cao","displayMetrics.densityDpi:"+displayMetrics.densityDpi +"  density:"+displayMetrics.density
//        +"  displayMetrics"+displayMetrics.);
    }
}
