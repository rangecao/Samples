package com.rangecao.samples.animation;

import android.app.Activity;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.transition.AutoTransition;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.rangecao.samples.R;

/**
 * Created by caorange on 17-10-9.
 * <p>
 * <p>
 * <p>
 * 还可以用在activity的转场
 * http://www.jianshu.com/p/0af52be90ae6
 * <p>
 * <p>
 * BTY:
 * Transitions-Everywhere：
 * http://www.jianshu.com/p/98f2ec280945
 * https://github.com/andkulikov/Transitions-Everywhere
 */

public class Transitions extends Activity implements View.OnClickListener {

    private ViewGroup mContainer;
    private View mTopButton;
    private View mResize;

    private ImageView mImageView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.transitions);

        mContainer = (ViewGroup) findViewById(R.id.container);
        mTopButton = findViewById(R.id.topbutton);

        mResize = findViewById(R.id.resize);

        mImageView = (ImageView) findViewById(R.id.imageview);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.topbutton: {

                AnimatedVectorDrawable anim = (AnimatedVectorDrawable) mImageView.getDrawable();
                anim.start();
                if(true){
                    return;
                }


                //AutoTransition autoTransition = new AutoTransition();
                //Fade autoTransition =  new Fade(Fade.OUT);
                //ChangeBounds autoTransition = new ChangeBounds();
                //autoTransition.setDuration(2000);
                //autoTransition.setInterpolator(new LinearInterpolator());

                TransitionSet transitionSet = new TransitionSet();

                Fade fade =  new Fade(Fade.OUT);
                fade.setDuration(1000);
                fade.addTarget(mTopButton);
//                ChangeBounds changeBounds2 = new ChangeBounds();
//                changeBounds2.setDuration(1000);
//                changeBounds2.addTarget(mTopButton);


                Fade fade2 =  new Fade(Fade.OUT);
                fade2.setDuration(2000);
                fade2.addTarget(mResize);

                ChangeBounds changeBounds = new ChangeBounds();
                changeBounds.setDuration(2000);
                //changeBounds.addTarget(mContainer);

                transitionSet.setOrdering(TransitionSet.ORDERING_TOGETHER);
                transitionSet.addTransition(fade);
                transitionSet.addTransition(fade2);
                transitionSet.addTransition(changeBounds);
                //transitionSet.addTransition(changeBounds2);

                TransitionManager.beginDelayedTransition(mContainer, transitionSet);

                mTopButton.setVisibility(View.INVISIBLE);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(0,0);
                mTopButton.setLayoutParams(layoutParams);

                mResize.setVisibility(View.GONE);
                break;
            }

            case R.id.resize: {
                AutoTransition autoTransition = new AutoTransition();
                autoTransition.setDuration(2000);
                TransitionManager.beginDelayedTransition(mContainer, autoTransition);

                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(1000,1000);
                mResize.setLayoutParams(layoutParams);
                break;
            }
            default:

                TransitionManager mTransitionManager;
                mTransitionManager = new TransitionManager();


                break;
        }
    }
}
