package com.rangecao.samples.layout;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by caorange on 17-10-31.
 */

public class ThemeTextView extends TextView {
    public ThemeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
