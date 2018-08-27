package com.rangecao.samples.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;

/**
 * Created by caorange on 18-8-2.
 */

public class ProgressDrawable extends Drawable {

    private Paint mPaint;
    public ProgressDrawable(){
        mPaint = new Paint();
        mPaint.setColor(0xFFFF0000);
    }

    @Override
    public void draw(Canvas canvas) {
        new RuntimeException().printStackTrace();
        canvas.drawRect(getBounds(),mPaint);
    }

    @Override
    public void setAlpha(int i) {

    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        Log.e("range.cao","bounds:"+bounds);
        new RuntimeException().printStackTrace();
    }


}
