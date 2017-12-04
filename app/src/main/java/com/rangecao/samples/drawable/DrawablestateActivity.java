package com.rangecao.samples.drawable;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.rangecao.samples.R;

/**
 * Created by caorange on 17-10-26.
 */

public class DrawablestateActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView mImageView1;
    private ImageView mImageView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawable_state_activity);
        mImageView1 = (ImageView) findViewById(R.id.imageview1);
        mImageView2 = (ImageView) findViewById(R.id.imageview2);
    }

    @Override
    public void onClick(View v) {
        getResources().getDrawable(R.drawable.float_window_answer).setColorFilter(0xFFFF0000, PorterDuff.Mode.SRC_IN);
        mImageView1.invalidate();
        mImageView2.invalidate();
    }
}
