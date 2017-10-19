package com.rangecao.samples.widget;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.PathInterpolator;

import com.rangecao.samples.R;

import java.util.ArrayList;

/**
 * Created by caorange on 17-10-13.
 */

public class ShowDataActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_data_activity);
        ArrayList<CharSequence> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrayList.add(String.valueOf(i));
        }
        MyLayout myLayout = (MyLayout) findViewById(R.id.my_layout);
        myLayout.setData(arrayList);

//        ValueAnimator valueAnimator = ValueAnimator.ofInt(0,255);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
//
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                int value = (int) animation.getAnimatedValue();
//                Log.d("range.cao","value:"+value);
//            }
//        });
//        valueAnimator.setInterpolator(new PathInterpolator(0.1f,0.1f,0.1f,0.1f));
//        valueAnimator.setDuration(2000);
//        valueAnimator.start();
    }
}
