package com.rangecao.samples.drawable;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.rangecao.samples.R;

/**
 * Created by caorange on 18-7-25.
 */

public class AnimatedVectorDrawable extends Activity implements View.OnClickListener{

    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_animated_vector);
        mImageView = findViewById(R.id.imageview);
    }


    @Override
    public void onClick(View v) {
        android.graphics.drawable.AnimatedVectorDrawable anim = (android.graphics.drawable.AnimatedVectorDrawable) mImageView.getDrawable();
        anim.start();
    }
}
