package com.rangecao.samples.widget;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by caorange on 17-11-24.
 */

public class LineView extends View {

    private Paint mPaint;
    private Shader mShader;
    Matrix mMaskMatrix = new Matrix();
    public LineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(0xFFFF0000);
        mPaint.setStrokeWidth(100);
        //mShader = new Shader();
        //mPaint.setShader()
        //BlurMaskFilter maskFilter = new BlurMaskFilter(10, BlurMaskFilter.Blur.SOLID);


        //mPaint.setMaskFilter(maskFilter);

        mShader = new LinearGradient(550,0,600,0,0x00000000,0xFFFF0000,Shader.TileMode.MIRROR);

        mPaint.setShader(mShader);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawLine(600,0,600,1800,mPaint);
        mMaskMatrix.setRotate(90);
        mShader.setLocalMatrix(mMaskMatrix);
        canvas.drawLine(0,600,1000,600,mPaint);


//        canvas.save();
//        canvas.rotate(45);
//        canvas.drawLine(600,0,600,1800,mPaint);
//        canvas.restore();
//
//        canvas.save();
//        canvas.translate(200,0);
//        canvas.drawLine(600,0,600,1800,mPaint);
//        canvas.restore();
//
//        canvas.save();
//        canvas.rotate(90);
//        canvas.drawLine(900,0,900,1800,mPaint);
//        canvas.restore();
    }
}
