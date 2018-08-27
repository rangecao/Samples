package com.rangecao.samples.theme;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.rangecao.samples.R;

import org.w3c.dom.Text;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/**
 * Created by caorange on 18-8-8.
 */

public class JoyThemeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_joy_theme);
        TextView textView = findViewById(R.id.textview);
        JoyTheme.getInstance().init();

        textView.setText(JoyTheme.getInstance().toString());
    }

    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        super.dump(prefix, fd, writer, args);
    }
}
