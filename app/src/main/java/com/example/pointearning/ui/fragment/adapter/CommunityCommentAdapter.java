package com.example.pointearning.ui.fragment.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pointearning.R;
import com.example.pointearning.bean.CommentEntity;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * created by shengfeiyu
 * on 2019/9/7   社区详情页底部评论Recyclerview适配器
 */
public class CommunityCommentAdapter extends RecyclerView.Adapter {

    List<CommentEntity> mDataList;



    // 脚布局
    private final int TYPE_FOOTER = 4;
    // 当前加载状态，默认为加载完成
    private int loadState = 4;
    // 正在加载
    public final int LOADING = 3;
    // 加载完成
    public final int LOADING_COMPLETE = 4;
    // 加载到底
    public final int LOADING_END = 5;

    public CommunityCommentAdapter(List<CommentEntity> mDataList) {
        this.mDataList = mDataList;
    }
    int TAB_TYPE; //1评论 2转发 3赞


    @Override
    public int getItemViewType(int position) {

        // 最后一个item设置为FooterView
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        }
        if(position + 2 == getItemCount()){
            return 500;
        }

        return super.getItemViewType(position);
    }


    public CommunityCommentAdapter(List<CommentEntity> mDataList, int TAB_TYPE) {
        this.mDataList = mDataList;
        this.TAB_TYPE = TAB_TYPE;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;



        if(viewType==TYPE_FOOTER){
                viewHolder = new FootViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_refresh_footer, parent, false));
         }else if(viewType == 500){
            viewHolder = new BottomBlankViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bottom_blank, parent, false));
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.community_comment_recyclerview_item, parent, false);
            viewHolder = new SimpleViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {



        if(holder instanceof SimpleViewHolder) {
            switch (TAB_TYPE) {
                case 1:
                    ((SimpleViewHolder) holder).ivIcon.setImageResource(mDataList.get(position).getIcon());
                    ((SimpleViewHolder) holder).tvUserName.setText(mDataList.get(position).getUserName());
                    ((SimpleViewHolder) holder).tvComment.setText(mDataList.get(position).getComment());
                    ((SimpleViewHolder) holder).tvTime.setText(mDataList.get(position).getTime());
                    break;
                case 2:
                    ((SimpleViewHolder) holder).ivIcon.setImageResource(mDataList.get(position).getIcon());
                    ((SimpleViewHolder) holder).tvUserName.setText(mDataList.get(position).getUserName());
                    ((SimpleViewHolder) holder).tvUserName.setTextColor(Color.BLACK);
                    ((SimpleViewHolder) holder).tvComment.setText(mDataList.get(position).getTime());
                    ((SimpleViewHolder) holder).tvComment.setTextSize(30);
                    ((SimpleViewHolder) holder).tvTime.setVisibility(View.GONE);
                    ((SimpleViewHolder) holder).ivComment.setVisibility(View.GONE);
                    ((SimpleViewHolder) holder).ivForward.setVisibility(View.GONE);
                    ((SimpleViewHolder) holder).ivLike.setVisibility(View.GONE);

                    break;
                case 3:
                    ((SimpleViewHolder) holder).ivIcon.setImageResource(mDataList.get(position).getIcon());
                    ((SimpleViewHolder) holder).tvUserName.setText(mDataList.get(position).getUserName());
                    ((SimpleViewHolder) holder).tvUserName.setTextColor(Color.BLACK);
                    ((SimpleViewHolder) holder).tvComment.setText("暂无介绍");
                    ((SimpleViewHolder) holder).tvComment.setTextSize(30);
                    ((SimpleViewHolder) holder).tvTime.setVisibility(View.GONE);
                    ((SimpleViewHolder) holder).ivComment.setVisibility(View.GONE);
                    ((SimpleViewHolder) holder).ivForward.setVisibility(View.GONE);
                    ((SimpleViewHolder) holder).ivLike.setVisibility(View.GONE);

                    break;
            }
        }

        if (holder instanceof FootViewHolder) {
            FootViewHolder footViewHolder = (FootViewHolder) holder;
            switch (loadState) {
                case LOADING: // 正在加载
                    footViewHolder.pbLoading.setVisibility(View.VISIBLE);
                    footViewHolder.tvLoading.setVisibility(View.VISIBLE);
                    footViewHolder.llEnd.setVisibility(View.GONE);
                    break;

                case LOADING_COMPLETE: // 加载完成
                    footViewHolder.pbLoading.setVisibility(View.INVISIBLE);
                    footViewHolder.tvLoading.setVisibility(View.INVISIBLE);
                    footViewHolder.llEnd.setVisibility(View.GONE);
                    break;

                case LOADING_END: // 加载到底
                    footViewHolder.pbLoading.setVisibility(View.GONE);
                    footViewHolder.tvLoading.setVisibility(View.GONE);
                    footViewHolder.llEnd.setVisibility(View.VISIBLE);
                    break;

                default:
                    break;
            }
        }

    }

    @Override
    public int getItemCount() {
        return mDataList!=null?mDataList.size():0;
    }

    /**
     * Footerview
     */
    private class FootViewHolder extends RecyclerView.ViewHolder {

        ProgressBar pbLoading;
        TextView tvLoading;
        LinearLayout llEnd;

        FootViewHolder(View itemView) {
            super(itemView);
            pbLoading = itemView.findViewById(R.id.pb_loading);
            tvLoading =  itemView.findViewById(R.id.tv_loading);
            llEnd =  itemView.findViewById(R.id.ll_end);
        }
    }

    public class SimpleViewHolder extends RecyclerView.ViewHolder {
        TextView tvComment;
        TextView tvTime;
        ImageView ivIcon;
        TextView tvUserName;
        ImageView ivComment;
        ImageView ivForward;
        ImageView ivLike;


        public SimpleViewHolder(@NonNull View itemView) {
            super(itemView);
            //适配
            AutoUtils.autoSize(itemView);
            ivIcon = itemView.findViewById(R.id.iv_icon);
            tvUserName = itemView.findViewById(R.id.tv_user_name);
            tvComment = itemView.findViewById(R.id.tv_comment);
            tvTime = itemView.findViewById(R.id.tv_time);
            ivComment = itemView.findViewById(R.id.iv_comment);
            ivForward = itemView.findViewById(R.id.iv_forward);
            ivLike = itemView.findViewById(R.id.iv_like);

        }
    }

    private  class BottomBlankViewHolder extends RecyclerView.ViewHolder{

        public BottomBlankViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


    /**
     * 设置上拉加载状态
     *
     * @param loadState 0.正在加载 1.加载完成 2.加载到底
     */
    public void setLoadState(int loadState) {
        this.loadState = loadState;
        notifyDataSetChanged();
    }
}
