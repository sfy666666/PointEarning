package com.example.pointearning.ui.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pointearning.R;
import com.example.pointearning.bean.SortModel;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * created by shengfeiyu
 * on 2019/9/11
 */
public class ContactSortAdapter extends RecyclerView.Adapter {

    Context mContext;
    List<SortModel> mData;

    public ContactSortAdapter(Context mContext, List<SortModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.get(position).getType() == 0) {
            return 0;
        }
        if (mData.get(position).getType() == 1) {
            return 1;
        }
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        if (viewType == 1) {
            holder = new ContactViewHolder(LayoutInflater.from(mContext)
                    .inflate(R.layout.item_contact, parent, false));
        }
        if (viewType == 0) {
            holder = new ContactViewHolderOne(LayoutInflater.from(mContext)
                    .inflate(R.layout.item_contact2, parent, false));
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SortModel sortModel = mData.get(position);
        if (holder instanceof ContactViewHolder) {
            ((ContactViewHolder) holder).name.setText(sortModel.getName());
            ((ContactViewHolder) holder).icon.setImageResource(sortModel.getIcon());
            if(position==1||position==3){
                ((ContactViewHolder) holder).viewLine.setVisibility(View.GONE);
                ((ContactViewHolder) holder).xinde.setVisibility(View.GONE);
            }
            else if(position==0){
                ((ContactViewHolder) holder).viewLine.setVisibility(View.VISIBLE );
                ((ContactViewHolder) holder).xinde.setVisibility(View.VISIBLE);
            }

            else {
                ((ContactViewHolder) holder).viewLine.setVisibility(View.VISIBLE );
                ((ContactViewHolder) holder).xinde.setVisibility(View.GONE);

            }


        }
        if (holder instanceof ContactViewHolderOne) {
            ((ContactViewHolderOne) holder).tvLetter.setText(sortModel.getLetter());
        }
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public void initData(List<SortModel> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView icon;
        TextView name;
        View viewLine;
        Button xinde;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);
            icon = itemView.findViewById(R.id.icon);
            name = itemView.findViewById(R.id.name);
            viewLine = itemView.findViewById(R.id.view_line);
            xinde = itemView.findViewById(R.id.xinde);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mOnRecyclerViewListener!=null){
                mOnRecyclerViewListener.onItemClick(getAdapterPosition());
            }
        }
    }

    public class ContactViewHolderOne extends RecyclerView.ViewHolder {
        TextView tvLetter;

        public ContactViewHolderOne(@NonNull View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);
            tvLetter = itemView.findViewById(R.id.letter);
        }
    }


    // 采用接口回调的方式实现RecyclerView的ItemClick
    public OnRecyclerViewListener mOnRecyclerViewListener;


    // 接口回调第一步: 定义接口和接口中的方法
    public interface OnRecyclerViewListener {
        void onItemClick(int position);
    }

    // 接口回调第二步: 初始化接口的引用
    public void setOnRecyclerViewListener(OnRecyclerViewListener l) {
        this.mOnRecyclerViewListener = l;
    }

}
