package com.rangecao.samples.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by caorange on 18-8-25.
 */

public class LineView extends View {

    private Path mPath;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public LineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPath = new Path();

        mPath.moveTo(0,500);
        //mPath.cubicTo(0,0,0,0,300,10);
        mPath.quadTo(0,0,300,10);
        //mPath.lineTo(300,10);

        //mPath.lineTo(500,500);
        mPath.quadTo(500,10,500,500);

        mPaint.setColor(0xFFFF0000);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(mPath,mPaint);
    }
}
