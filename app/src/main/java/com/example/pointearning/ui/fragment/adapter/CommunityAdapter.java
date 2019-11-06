package com.example.pointearning.ui.fragment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pointearning.R;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * created by shengfeiyu
 * on 2019/9/5
 * 社区页面上面横向Recyclerview的适配器
 */
public class CommunityAdapter  extends RecyclerView.Adapter {
    private  int[]  images;

    public CommunityAdapter(int[] images) {
        this.images = images;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.one_image_item,parent,false);
        SimpleViewHolder holder = new SimpleViewHolder(view);
        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((SimpleViewHolder)holder).imageView.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

   static class  SimpleViewHolder extends RecyclerView.ViewHolder {

         ImageView imageView;
        public SimpleViewHolder(@NonNull View itemView) {
            super(itemView);
            //适配
            AutoUtils.autoSize(itemView);
            imageView = itemView.findViewById(R.id.one_image_view);

        }
    }
}
