package com.rangecao.samples.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.rangecao.samples.R;

/**
 * Created by caorange on 18-8-27.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView mTextView;
    public MyViewHolder(View itemView) {
        super(itemView);
        mTextView = (TextView) itemView.findViewById(R.id.text);
    }
}
