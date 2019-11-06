package com.example.pointearning.ui.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pointearning.R;
import com.example.pointearning.bean.NewsEntity;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * created by shengfeiyu
 * on 2019/9/4
 */
public class MessageAdapter extends RecyclerView.Adapter{
    private List<NewsEntity> newsEntityList;
    private Context context;
    private LayoutInflater inflater;

    //布局类型
    private static final int VIEW_TYPE_ONE = 1;
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

    OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;
    public  interface OnRecyclerViewItemClickListener{
        void onItemClick(int position);
    }
    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener l){
        this.mOnRecyclerViewItemClickListener=l;
    }
    /**
     * 构造器
     * @param newsEntityList
     * @param context
     */
    public MessageAdapter(List<NewsEntity> newsEntityList, Context context) {
        this.newsEntityList = newsEntityList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        // 最后一个item设置为FooterView
        if(position+1==getItemCount()){
            return  TYPE_FOOTER;
        }
        if(newsEntityList.get(position).getType()==1){
            return VIEW_TYPE_ONE;
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case VIEW_TYPE_ONE:
                viewHolder = new ViewHolderOne(inflater.inflate(R.layout.message_item, parent, false));
                break;

            case TYPE_FOOTER:
                viewHolder = new FootViewHolder(inflater.inflate(R.layout.layout_refresh_footer, parent, false));
                break;

        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof  ViewHolderOne){
            ViewHolderOne viewHolderOne = (ViewHolderOne) holder;
            viewHolderOne.ivIcon.setImageResource(newsEntityList.get(position).getIcon());
            viewHolderOne.tvTitle.setText(newsEntityList.get(position).getTitle());
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
        return newsEntityList.size();
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
    /**
     * 第一种布局类型ViewHolder
     */
    public  class ViewHolderOne extends RecyclerView.ViewHolder implements View.OnClickListener {

        public  ImageView ivIcon;//头像
        public TextView tvTitle;//标题
        public ViewHolderOne(View view) {
            super(view);

            //适配
            AutoUtils.autoSize(view);
            //绑定控件
            ivIcon = view.findViewById(R.id.iv_icon);
            tvTitle = view.findViewById(R.id.tv_title);
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if(mOnRecyclerViewItemClickListener!=null){
                mOnRecyclerViewItemClickListener.onItemClick(getAdapterPosition());
            }
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


    /**
     * 构造方法一
     * @param iconList
     */
    public MessageAdapter(List<NewsEntity> iconList){
        newsEntityList = iconList;
    }
}
