package com.rangecao.samples.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by caorange on 18-7-25.
 */

public class ChildLayout extends LinearLayout {
    public ChildLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("range.cao","Child onTouchEvent");
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("range.cao","Child onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }
}
