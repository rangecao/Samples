package com.rangecao.samples.widget;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rangecao.samples.R;

/**
 * Created by caorange on 18-8-27.
 */

public class RecylerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private final ItemTouchHelper mItemTouchHelper;

    private static final int SELECTION_GAINED = 1;
    private static final int SELECTION_LOST = 0;
    private static final int SELECTION_UNCHANGED = -1;
    private int mSelectionStatus = SELECTION_UNCHANGED;

    public RecylerViewAdapter() {
        mItemTouchHelper = new ItemTouchHelper(mCallback);
    }

    public void setRecylerView(RecyclerView recylerView){
        mItemTouchHelper.attachToRecyclerView(recylerView);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTextView.setText("position:"+position);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    private Callback mCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, 0 /* no swipe */){

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source, RecyclerView.ViewHolder target) {
            Log.e("range.cao","onMove。。。。");

            notifyItemMoved(source.getAdapterPosition(), target.getAdapterPosition());
            return true;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            // Swipe is disabled, this is intentionally empty.
        }

        @Override
        public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                float dX, float dY, int actionState, boolean isCurrentlyActive) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            // We change the elevation if selection changed
            if (mSelectionStatus != SELECTION_UNCHANGED) {
                viewHolder.itemView.setElevation(
                        mSelectionStatus == SELECTION_GAINED ? 10/*dragElevation*/ : 0);
                mSelectionStatus = SELECTION_UNCHANGED;
            }
        }

        @Override
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
            super.onSelectedChanged(viewHolder, actionState);
            if (actionState == ItemTouchHelper.ACTION_STATE_DRAG) {
                mSelectionStatus = SELECTION_GAINED;
            } else if (actionState == ItemTouchHelper.ACTION_STATE_IDLE) {
                mSelectionStatus = SELECTION_LOST;
            }
        }
    };
}
