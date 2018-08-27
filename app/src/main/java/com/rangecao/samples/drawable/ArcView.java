package com.rangecao.samples.drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by caorange on 18-8-15.
 */

public class ArcView extends View {
    private Paint mPaint;
    public ArcView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(0xFFFF0000);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(new RectF(0,0,500,500),
                30,100,true,mPaint);
    }
}
