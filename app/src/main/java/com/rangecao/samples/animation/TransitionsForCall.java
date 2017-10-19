package com.rangecao.samples.animation;

import android.app.Activity;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;

import com.rangecao.samples.R;

/**
 * Created by caorange on 17-10-11.
 */

public class TransitionsForCall extends Activity implements View.OnClickListener {

    private View mAnswer1;
    private View mAnswer2;
    private View mEndCall;
    private View mFullScreen;
    private ViewGroup mContainner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transitions_for_call);
        mContainner = (ViewGroup) findViewById(R.id.buttons);
        mAnswer1 = findViewById(R.id.answer1);
        mAnswer1.setOnClickListener(this);
        mAnswer2 = findViewById(R.id.answer2);
        mAnswer2.setOnClickListener(this);
        mFullScreen = findViewById(R.id.fullscreen);
        mEndCall = findViewById(R.id.endcall);
    }

    @Override
    public void onClick(View v) {
        if(mAnswer1 ==  v){

            TransitionSet transitionSet = new TransitionSet();

            //这个是所有view的动画 都遵循这个规则
            AutoTransition autoTransition = new AutoTransition();
            autoTransition.setOrdering(transitionSet.ORDERING_TOGETHER);
            autoTransition.setDuration(2000);

            //给其中的一个view单独做动画
            autoTransition.excludeTarget(mFullScreen,true);
            AutoTransition full = new AutoTransition();
            full.setOrdering(transitionSet.ORDERING_TOGETHER);
            full.addTarget(mFullScreen);
            full.setDuration(1000);
            full.setStartDelay(1000);


            transitionSet.setOrdering(transitionSet.ORDERING_TOGETHER);
            transitionSet.addTransition(autoTransition);
            transitionSet.addTransition(full);


            TransitionManager.beginDelayedTransition(mContainner,transitionSet);

            mFullScreen.setVisibility(View.VISIBLE);
            setSize(mFullScreen, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);

            mAnswer1.setVisibility(View.INVISIBLE);
            setSize(mAnswer1,0,0);


            mAnswer2.setVisibility(View.INVISIBLE);
            setSize(mAnswer2, 0,0);
        }
    }

    private void setSize(View view, int width, int height) {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        view.setLayoutParams(layoutParams);
    }
}
