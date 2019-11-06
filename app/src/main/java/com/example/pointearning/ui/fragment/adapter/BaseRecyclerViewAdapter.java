package com.example.pointearning.ui.fragment.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * created by shengfeiyu
 * on 2019/9/6
 */
public class BaseRecyclerViewAdapter extends RecyclerView.Adapter {

    //点击
    public OnItemClickListener mOnItemClickListener;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    //点击监听接口
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
}
