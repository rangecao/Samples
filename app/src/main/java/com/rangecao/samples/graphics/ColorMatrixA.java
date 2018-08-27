package com.rangecao.samples.graphics;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.rangecao.samples.R;

/**
 * Created by caorange on 18-8-10.
 */

public class ColorMatrixA extends Activity {

    private ImageView mSrcImageView;
    private ImageView mMatrixImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_colormatrix);
        mSrcImageView = findViewById(R.id.src_imageview);
        mMatrixImageView = findViewById(R.id.matrix_image);
        Bitmap bitmap = getGrayBitmap();
        mMatrixImageView.setImageBitmap(bitmap);
    }


    // 图片灰化处理
    public Bitmap getGrayBitmap() {

        Log.e("range.cao","start....");

        Bitmap srcbitmap = BitmapFactory.decodeResource(getResources(), R.drawable.app_icon);
        Bitmap grayBitmap =
                Bitmap.createBitmap(srcbitmap.getWidth(), srcbitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas mCanvas = new Canvas(grayBitmap);
        Paint mPaint = new Paint();

        // 创建颜色变换矩阵
        ColorMatrix colorMatrix = new ColorMatrix();
        // 设置灰度影响范围
        colorMatrix.setSaturation(0);
        // 创建颜色过滤矩阵
        ColorMatrixColorFilter mColorFilter = new ColorMatrixColorFilter(colorMatrix);
        // 设置画笔的颜色过滤矩阵
        mPaint.setColorFilter(mColorFilter);
        // 使用处理后的画笔绘制图像
        mCanvas.drawBitmap(srcbitmap, 0, 0, mPaint);


        Bitmap bitmap2 =
                Bitmap.createBitmap(srcbitmap.getWidth(), srcbitmap.getHeight(), Bitmap.Config.ARGB_8888);
        float[] matrix = new float[]{
                1, 0, 0, 0, 0,
                0, 1, 0, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 0, 1, 0,
        };
        colorMatrix = new ColorMatrix(matrix);

        Paint paint2 = new Paint();
        mColorFilter = new ColorMatrixColorFilter(colorMatrix);

        mCanvas = new Canvas(bitmap2);

        paint2.setColorFilter(mColorFilter);
        mCanvas.drawBitmap(grayBitmap, 0, 0, paint2);

        Log.e("range.cao","end....");

        return bitmap2;

    }

}
