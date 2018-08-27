package com.rangecao.samples.theme;


import android.graphics.ColorMatrix;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.File;
import java.io.FileInputStream;

public class JoyTheme {
    private static JoyTheme sJoyTheme;
    public int mThemeId = -1;

    /* 最终输出图片大小 */
    private int mIconWidth;
    private int mIconHeight;

    /*三方图片加蒙版之前需要先缩放，缩放的尺寸 */
    private int mVendorIconZoomWidth;
    private int mVendorIconZoomHeight;


    /**
     * 图片处理方式
     * 1.原图 这个肯定有的
     * 2.原图+裁剪 （后面主题不建议有这个选项）
     * 3.三方图片裁剪
     * 4.三方图片加底板
     */
    private boolean mSystemIconClip;
    private boolean mVendorIconClip;
    private boolean mVendorIconMask;

    public boolean needClipIcon() {
        return mSystemIconClip;
    }

    public boolean needClipVendorIcon() {
        return mVendorIconClip;
    }

    public boolean needMaskVendorIcon() {
        return mVendorIconMask;
    }

    public static JoyTheme getInstance() {
        if(sJoyTheme == null){
            sJoyTheme = new JoyTheme();
        }
        return sJoyTheme;
    }

    public void init() {
        try {
            parseManifest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reset() {
        mThemeId = -1;
    }

    public int getThemeId() {
        return mThemeId;
    }

    public void setThemeId(int id){
        mThemeId = id;
    }

    public void parseManifest() throws Exception {
        File manifestFile = new File("/system/media/journeyui-theme/icons_2/manifest.xml");
        if (!manifestFile.exists()) {
            return;
        }
        FileInputStream is = null;
        try {
            is = new FileInputStream(manifestFile);
            XmlPullParser pullParser = Xml.newPullParser();
            pullParser.setInput(is, "UTF-8");
            int event = pullParser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {
                switch (event) {
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        if ("IconWidth".equals(pullParser.getName())) {
                            mIconWidth = Integer.valueOf(pullParser.nextText());
                        } else if ("IconHeight".equals(pullParser.getName())) {
                            mIconHeight = Integer.valueOf(pullParser.nextText());
                        } else if ("VendorIconZoomWidth".equals(pullParser.getName())) {
                            mVendorIconZoomWidth = Integer.valueOf(pullParser.nextText());
                        } else if ("VendorIconZoomHeight".equals(pullParser.getName())) {
                            mVendorIconZoomHeight = Integer.valueOf(pullParser.nextText());
                        } else if ("SystemIconClip".equals(pullParser.getName())) {
                            mSystemIconClip = Boolean.valueOf(pullParser.nextText());
                        } else if ("VendorIconClip".equals(pullParser.getName())) {
                            mVendorIconClip = Boolean.valueOf(pullParser.nextText());
                        } else if ("VendorIconMask".equals(pullParser.getName())) {
                            mVendorIconMask = Boolean.valueOf(pullParser.nextText());
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                }
                event = pullParser.next();
            }
//        if(pullParser instanceof KXmlParser){
//            ((KXmlParser) pullParser).close();
//        }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("mIconWidth:"+mIconWidth);
        sb.append(" mIconHeight:"+mIconHeight);
        sb.append("\n mVendorIconZoomWidth:"+mVendorIconZoomWidth);
        sb.append(" mVendorIconZoomHeight:"+mVendorIconZoomHeight);
        sb.append("\n mSystemIconClip:"+mSystemIconClip);
        sb.append(" mVendorIconClip:"+mVendorIconClip);
        sb.append(" mVendorIconMask:"+mVendorIconMask);
        return sb.toString();
    }
}
