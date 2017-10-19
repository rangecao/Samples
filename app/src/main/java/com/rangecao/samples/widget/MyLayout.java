package com.rangecao.samples.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.rangecao.samples.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caorange on 17-10-13.
 */

public class MyLayout extends ViewGroup implements View.OnClickListener {

    //private String[] mData;

    private ArrayList<TextView> mChilds = new ArrayList<>();
    private static final int CHILD_SIZE = 10;
    private Button mNextPageButton;
    private Button mPreviousPageButton;
    private int mCurrentPage = 0;
    private int mPageCount = 0;

    private ArrayList<CharSequence> mData = new ArrayList<>();
    private ArrayList<Integer> mSelected = new ArrayList<>();

    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        for (int i = 0; i < CHILD_SIZE; i++) {
            TextView child = (TextView) LayoutInflater.from(context).inflate(R.layout.tag_buttons,this,false);
            child.setTag(i);
            child.setOnClickListener(this);
            mChilds.add(child);
            addView(child);
        }

        mNextPageButton = new Button(context);
        mNextPageButton.setText("Next");
        mNextPageButton.setOnClickListener(this);
        addView(mNextPageButton);

        mPreviousPageButton = new Button(context);
        mPreviousPageButton.setText("Previous");
        mPreviousPageButton.setOnClickListener(this);
        addView(mPreviousPageButton);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        for (int index = 0; index < getChildCount(); index++) {
            View child = getChildAt(index);
            ViewGroup.LayoutParams lp = child.getLayoutParams();

            final int childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec,
                    0, lp.width);
            final int childHeightMeasureSpec = getChildMeasureSpec(widthMeasureSpec,
                    0, lp.height);
            child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        }


        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec),
                getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childIndex = 0;
        //int column = 2;
        int top = 0;
        int height = b - t;
        int width = r - l;
        for (TextView child : mChilds) {
            final int childwidth = child.getMeasuredWidth();
            final int childheight = child.getMeasuredHeight();

            if(childIndex % 2 == 0){
                child.layout(0, top * childheight, childwidth, (top + 1) * childheight);
            } else {
                child.layout(width - childwidth, top * childheight, width, (top + 1) * childheight);
                top ++;
            }

            childIndex++;
        }


        mPreviousPageButton.layout(0, height - mNextPageButton.getMeasuredHeight(), mNextPageButton.getMeasuredWidth(), height);
        mNextPageButton.layout(width - mNextPageButton.getMeasuredWidth(), height - mNextPageButton.getMeasuredHeight(), width, height);
    }

    public void setData(ArrayList<CharSequence> data) {
        mData = data;
        mPageCount = (mData.size() - 1) / CHILD_SIZE + 1;
        setPage(0);
    }

    private void setPage(int page) {
        mCurrentPage = page;

        if(mCurrentPage + 1 >= mPageCount){
            mNextPageButton.setVisibility(View.GONE);
        } else {
            mNextPageButton.setVisibility(View.VISIBLE);
        }

        if(mCurrentPage > 0 && mPageCount > 1){
            mPreviousPageButton.setVisibility(View.VISIBLE);
        } else {
            mPreviousPageButton.setVisibility(View.GONE);
        }

        int viewIndex = 0;
        for (TextView child : mChilds) {
            CharSequence text = null;
            int dataIndex = page * CHILD_SIZE + viewIndex;
            if (dataIndex >= mData.size()) {
                text = null;
            } else {
                text = mData.get(dataIndex);
            }
            child.setText(text);
            child.setTag(dataIndex);
            if (text == null || !mSelected.contains(dataIndex)) {
                child.setSelected(false);
            } else {
                child.setSelected(true);
            }
            viewIndex ++;
        }
        requestLayout();
        invalidate();
    }

    @Override
    public void onClick(View v) {
        if (mNextPageButton == v) {
            setPage(mCurrentPage + 1);
            return;
        } else if (mPreviousPageButton == v) {
            setPage(mCurrentPage -1);
            return;
        }

        TextView textView = (TextView) v;
        int dataIndex = (int) textView.getTag();
        if (textView.isSelected()) {
            textView.setSelected(false);
            mSelected.remove(dataIndex);
        } else {
            textView.setSelected(true);
            mSelected.add(dataIndex);
        }
    }


    public List<CharSequence> getSelectData(){
        for(int index:mSelected){
            mData.get(index);
        }
        return null;
    }
}
