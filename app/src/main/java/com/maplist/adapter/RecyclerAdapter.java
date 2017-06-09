package com.maplist.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.maplist.R;
import java.util.ArrayList;

/**
 * Created by santosh on 9/6/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private ArrayList<String> mResultList;

    public RecyclerAdapter(ArrayList<String> results) {
            mResultList = results;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.near_place_list, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        String result = mResultList.get(position);
        holder.mTextView.setText(result);

    }

    @Override
    public int getItemCount() {
        return mResultList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.placeName);
        }
    }
}
