package com.example.pointearning.ui.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.pointearning.R;
import com.example.pointearning.bean.CommunityEntity;
import com.example.pointearning.zxing.util.Constant;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * created by shengfeiyu
 * on 2019/9/5
 * 社区分类布局适配器
 */
public class CommunityAdapter2 extends RecyclerView.Adapter {

    //布局类型
    private static final int VIEW_TYPE_ONE = 100;
    private static final int VIEW_TYPE_TWO = 200;
    private static final int VIEW_TYPE_THREE = 300;

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

    private LayoutInflater inflater;
    private List<CommunityEntity> mDataList;
    private Context mContext;



    // 采用接口回调的方式实现RecyclerView的ItemClick
    public OnRecyclerViewListener mOnRecyclerViewListener;


    // 接口回调第一步: 定义接口和接口中的方法
    public interface OnRecyclerViewListener {

        void onItemClick(int position);

        boolean onItemLongClick(int position);
    }

    // 接口回调第二步: 初始化接口的引用
    public void setOnRecyclerViewListener(OnRecyclerViewListener l) {
        this.mOnRecyclerViewListener = l;
    }



    /*public CommunityAdapter2(List<CommunityEntity> mDataList, Context mContext, SwipeRefreshLayout swipeRefreshLayout) {
        this.mDataList = mDataList;
        this.mContext = mContext;
        this.mSwipeRefreshLayout=swipeRefreshLayout;
        inflater = LayoutInflater.from(mContext);
    }*/


    public CommunityAdapter2(List<CommunityEntity> mDataList, Context mContext) {
        this.mDataList = mDataList;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemViewType(int position) {

        // 最后一个item设置为FooterView
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        }
        if (mDataList.get(position).getType() == 1) {
            return VIEW_TYPE_ONE;
        } else if (mDataList.get(position).getType() == 2) {
            return VIEW_TYPE_TWO;
        }else if (mDataList.get(position).getType() == 3) {
            return VIEW_TYPE_THREE;
        }
        return super.getItemViewType(position);
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case VIEW_TYPE_ONE:
                viewHolder = new ViewHolderOne(inflater.inflate(R.layout.community_recyclerview_vertical_item1, parent, false));
                break;
            case VIEW_TYPE_TWO:
                viewHolder = new ViewHolderTwo(inflater.inflate(R.layout.community_recyclerview_vertical_item2, parent, false));
                break;
            case VIEW_TYPE_THREE:
                viewHolder = new ViewHolderTwo(inflater.inflate(R.layout.community_recyclerview_item3, parent, false));
                break;
            case TYPE_FOOTER:
                viewHolder = new FootViewHolder(inflater.inflate(R.layout.layout_refresh_footer, parent, false));
                break;

        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof ViewHolderOne){
            ViewHolderOne viewHolderOne= (ViewHolderOne) holder;

            String string = mContext.getResources().getString(R.string.contene_one);

            viewHolderOne.tvContent.setText(string);

        }

        if(holder instanceof  ViewHolderTwo){
            ViewHolderTwo viewHolderTwo =(ViewHolderTwo) holder;

            BaseQuickAdapter adapter = new BaseQuickAdapter<Integer, BaseViewHolder>(R.layout.item_image) {
                @Override
                protected void convert(BaseViewHolder helper, Integer item) {
                    helper.setImageResource(R.id.image, item);
                }
            };
            if(null!=viewHolderTwo&&null!=viewHolderTwo.rv_grid&&null!=mContext) {
                viewHolderTwo.rv_grid.setLayoutManager(new GridLayoutManager(mContext, 3){
                    @Override
                    public boolean canScrollVertically() {
                        //禁止垂直滑动解决与SwipeRefreshLayout的滑动冲突
                        return false;
                    }
                });
                viewHolderTwo.rv_grid.setAdapter(adapter);
                adapter.setNewData(Constant.getImage());
//                viewHolderTwo.rv_grid.addOnScrollListener(new RecyclerView.OnScrollListener() {
//                    @Override
//                    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                        super.onScrolled(recyclerView, dx, dy);
//                        //解决mRecyclerView与mSwipeRefreshLayout在部分机型上滑动冲突
//                        mSwipeRefreshLayout.setEnabled(recyclerView.getChildCount() == 0 || recyclerView.getChildAt(0).getTop() >= 0);
//                    }
//                });


            }

        }



        if (holder instanceof FootViewHolder) {
            FootViewHolder footViewHolder = (FootViewHolder) holder;
            switch (loadState) {
                case LOADING: // 正在加载
                    footViewHolder.pbLoading.setVisibility(View.VISIBLE);
                    footViewHolder.tvLoading.setVisibility(View.VISIBLE);
                    footViewHolder.load_view.setVisibility(View.VISIBLE);
                    footViewHolder.llEnd.setVisibility(View.GONE);
                    footViewHolder.view.setVisibility(View.GONE);
                    break;

                case LOADING_COMPLETE: // 加载完成
                    footViewHolder.pbLoading.setVisibility(View.INVISIBLE);
                    footViewHolder.tvLoading.setVisibility(View.INVISIBLE);
                    footViewHolder.load_view.setVisibility(View.INVISIBLE);
                    footViewHolder.llEnd.setVisibility(View.GONE);
                    footViewHolder.view.setVisibility(View.GONE);
                    break;

                case LOADING_END: // 加载到底
                    footViewHolder.pbLoading.setVisibility(View.GONE);
                    footViewHolder.tvLoading.setVisibility(View.GONE);
                    footViewHolder.load_view.setVisibility(View.GONE);
                    footViewHolder.llEnd.setVisibility(View.VISIBLE);
                    footViewHolder.view.setVisibility(View.VISIBLE);
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
        View  view;
        View  load_view;

        FootViewHolder(View itemView) {
            super(itemView);
            pbLoading = itemView.findViewById(R.id.pb_loading);
            tvLoading =  itemView.findViewById(R.id.tv_loading);
            llEnd =  itemView.findViewById(R.id.ll_end);
            view =  itemView.findViewById(R.id.view);
            load_view =  itemView.findViewById(R.id.load_view);
        }
    }

    /**
     * 第一种布局类型ViewHolder
     */
    public class ViewHolderOne extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        // 注意这里的position与CustomViewHolder是对应的关系, 每个CustomViewHolder都有mTextName和mTextAge, 还有它的mPosition
        public int mPosition;
        ImageView ivIcon;
        TextView tvContent;
        public ViewHolderOne(View view) {
            super(view);
            //适配
            AutoUtils.autoSize(view);
            ivIcon = view.findViewById(R.id.iv_icon);
            tvContent = view.findViewById(R.id.tv_content);

            // 巧妙的调用了View的点击方法
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);

        }

        // 接口回调第三步, 实现onClick, 方法中是调用了接口的onItemClick抽象方法, 所以这里之后肯定会被回调回来
        @Override
        public void onClick(View v) {

            if (mOnRecyclerViewListener != null) {
                mOnRecyclerViewListener.onItemClick(mPosition);
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if (mOnRecyclerViewListener != null) {
                return mOnRecyclerViewListener.onItemLongClick(mPosition);
            }

            return false;
        }
    }

    /**
     * 第二种布局类型ViewHolder
     */
    public  class ViewHolderTwo extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        RecyclerView rv_grid;
        ImageView ivIcon;
        public ViewHolderTwo(View view) {
            super(view);
            //适配
            AutoUtils.autoSize(view);
            ivIcon = view.findViewById(R.id.iv_icon);
            rv_grid = view.findViewById(R.id.rv_grid);
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
        }

        // 接口回调第三步, 实现onClick, 方法中是调用了接口的onItemClick抽象方法, 所以这里之后肯定会被回调回来
        @Override
        public void onClick(View v) {

            if (mOnRecyclerViewListener != null) {
                mOnRecyclerViewListener.onItemClick(getAdapterPosition());
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if (mOnRecyclerViewListener != null) {
                return mOnRecyclerViewListener.onItemLongClick(getAdapterPosition());
            }

            return false;
        }
    }
    /**
     * 第三种布局类型ViewHolder
     */
    public static class ViewHolderThree extends RecyclerView.ViewHolder {

        ImageView ivCommunityInviteFriend;
        public ViewHolderThree(View view) {
            super(view);
            //适配
            AutoUtils.autoSize(view);
            ivCommunityInviteFriend = view.findViewById(R.id.iv_community_invite_friend);
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
