package com.rangecao.samples.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


public class InflaterFactory implements LayoutInflater.Factory{

    private static InflaterFactory sMe = null;

    public static InflaterFactory getInstance(){
        if(sMe == null){
            sMe = new InflaterFactory();
        }
        return sMe;
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        View view = null;
        switch (name){
            case "TextView":
                view =  new ThemeTextView(context,attrs);
                break;
            default:
                break;
        }
        return view;
    }
}
