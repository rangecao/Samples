package com.rangecao.samples.drawable;

import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.rangecao.samples.R;

/**
 * Created by caorange on 17-10-27.
 */

public class Transition extends AppCompatActivity implements View.OnClickListener{

    private View mView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transition_drawable_activity);
        mView = findViewById(R.id.view);
    }

    @Override
    public void onClick(View v) {
        TransitionDrawable drawable = (TransitionDrawable) mView.getBackground();
        drawable.startTransition(2000);
    }
}
