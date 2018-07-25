package com.rangecao.samples.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by caorange on 18-7-25.
 */

public class ParentLayout extends LinearLayout{

    public ParentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("range.cao","Parent onTouchEvent");
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("range.cao","Parent onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }
}
