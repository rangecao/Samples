package com.rangecao.samples.widget;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.rangecao.samples.R;

/**
 * Created by caorange on 18-7-26.
 * edittext选中文字的效果
 *
 */

public class EditTextA extends Activity implements View.OnClickListener{

    private static final ComponentName CELLULAR_SETTING_COMPONENT = new ComponentName(
            "com.android.settings", "com.android.settings.Settings$DataUsageSummaryActivity");

    private static final Intent CELLULAR_SETTINGS =
            new Intent().setComponent(CELLULAR_SETTING_COMPONENT);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_edit_text);

        startActivity(CELLULAR_SETTINGS);

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,"测试22222",Toast.LENGTH_LONG).show();
    }
}
