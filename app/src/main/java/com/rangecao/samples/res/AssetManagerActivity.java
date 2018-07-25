package com.rangecao.samples.res;

import android.content.res.AssetManager;
import android.content.res.Resources;
//import android.content.res.ResourcesImpl;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.rangecao.samples.R;

/**
 * Created by caorange on 17-11-23.
 */

public class AssetManagerActivity extends AppCompatActivity{

    private TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTextView = (TextView) findViewById(R.id.textview);
//        AssetManager assetManager = getResources().getAssets();
//        int result = assetManager.addAssetPath("/system/app/miui/miui.apk");
//        Log.e("range.cao","result:"+result);
//
//        float dimen = getResources().getDimension(0x100a0011);
//
//        Log.e("range.cao","dimen:"+dimen);


//        AssetManager assetManager = new AssetManager();
//        int result = assetManager.addAssetPath("/system/app/miui/miui.apk");
//        //int result2 = assetManager.addOverlayPath("/system/media/journeyui-theme/overlay/theme2/miui.apk");
//        Resources resources = new Resources(assetManager,null,getResources().getConfiguration());
//
//        float dimen22 = resources.getDimension(0x100a0011);
//
//        Log.e("range.cao","dimen overlay:"+dimen22);
//
//        testMessaging();
    }

    private void testMessaging(){
//        AssetManager assetManager = new AssetManager();
//        assetManager.addAssetPath("/system/priv-app/messaging/messaging.apk");
//        Resources resources = new Resources(assetManager,null,getResources().getConfiguration());
//        int color = resources.getColor(0x7f0d00a2);
//        Log.e("range.cao","color:"+ Integer.toHexString(color));
//
//        assetManager.addOverlayPath("/system/media/journeyui-theme/overlay/theme2/messaging.apk");
//        color = resources.getColor(0x7f0d00a2);
//        Log.e("range.cao","color overlay:"+ Integer.toHexString(color));

    }
}
