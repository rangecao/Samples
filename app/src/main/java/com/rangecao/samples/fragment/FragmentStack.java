package com.rangecao.samples.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.rangecao.samples.R;

/**
 * Created by caorange on 17-11-7.
 */

public class FragmentStack extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_stack);

        Fragment fragment1 = new fragment1();
        Fragment fragment2 = new fragment2();

        getFragmentManager().beginTransaction().replace(R.id.fragment,fragment1).commit();
        getFragmentManager().beginTransaction().replace(R.id.fragment,fragment2).addToBackStack("stack").commit();
    }
}
