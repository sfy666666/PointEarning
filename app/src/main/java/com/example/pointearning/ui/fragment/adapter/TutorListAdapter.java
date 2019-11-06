package com.example.pointearning.ui.fragment.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;


import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pointearning.R;
import com.example.pointearning.bean.NewsEntity;
import com.example.pointearning.ui.main.JoinActivity;
import com.example.pointearning.ui.main.PointsForGiftsActivity;
import com.example.pointearning.ui.main.SearchActivity;
import com.example.pointearning.zxing.activity.CaptureActivity;
import com.example.pointearning.zxing.util.Constant;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * created by shengfeiyu
 * on 2019/9/4
 * 首页Fragment中的Recyclerview适配器
 */
public class TutorListAdapter extends RecyclerView.Adapter {

    //布局类型
    private static final int VIEW_TYPE_ONE = 1;
    private static final int VIEW_TYPE_TWO = 2;
    private static final int VIEW_TYPE_THREE = 300;
    private static final int VIEW_TYPE_FOUR = 400;

    // 普通布局
    private final int TYPE_ITEM = 3;
    // 脚布局
    private final int TYPE_FOOTER = 3;
    // 当前加载状态，默认为加载完成
    private int loadState = 4;
    // 正在加载
    public final int LOADING = 3;
    // 加载完成
    public final int LOADING_COMPLETE = 4;
    // 加载到底
    public final int LOADING_END = 5;


    private LayoutInflater inflater;
    private List<NewsEntity> mDataList;
    private Context mContext;

    // 采用接口回调的方式实现RecyclerView的ItemClick
    public OnRecyclerViewListener mOnRecyclerViewListener;


    // 接口回调第一步: 定义接口和接口中的方法
    public interface OnRecyclerViewListener {

        void onItemClick(int position, int viewType);

        boolean onItemLongClick(int position);
    }

    // 接口回调第二步: 初始化接口的引用
    public void setOnRecyclerViewListener(OnRecyclerViewListener l) {
        this.mOnRecyclerViewListener = l;
    }


    public TutorListAdapter(List<NewsEntity> mDataList, Context mContext) {
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
        } else if (mDataList.get(position).getType() == 3) {
            return VIEW_TYPE_THREE;
        } else if (mDataList.get(position).getType() == 4) {
            return VIEW_TYPE_FOUR;
        }
        return super.getItemViewType(position);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case VIEW_TYPE_ONE:
                viewHolder = new ViewHolderOne(inflater.inflate(R.layout.fragment_main, parent, false));
                break;
            case VIEW_TYPE_TWO:
                viewHolder = new ViewHolderTwo(inflater.inflate(R.layout.news_item2, parent, false));
                break;
            case VIEW_TYPE_THREE:
                viewHolder = new ViewHolderTutorTitle(inflater.inflate(R.layout.item_tutor_title, parent, false));
                break;
            case VIEW_TYPE_FOUR:
                viewHolder = new ViewHolderTutor(inflater.inflate(R.layout.item_tutor, parent, false));
                break;
            case TYPE_FOOTER:
                viewHolder = new FootViewHolder(inflater.inflate(R.layout.layout_refresh_footer, parent, false));
                break;

        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case VIEW_TYPE_ONE:
                Log.e("SFY", "投资理财");
                ((ViewHolderOne) holder).tvTouzilicai.setText("投资理财");
//                ((ViewHolderOne) holder).searchView.setFocusable(false);
//                ((ViewHolderOne) holder).searchView.setClickable(false);
//                ((ViewHolderOne) holder).searchView.findViewById()
                //设置搜索框内字体颜色
//                int id =  ((ViewHolderOne) holder).searchView.getResources().getIdentifier("android:id/search_src_text", null, null);
//                EditText textView = ((ViewHolderOne) holder).searchView.findViewById(id);
//                textView.setTextColor(Color.WHITE);
//                textView.setClickable(false);
//                textView.setFocusable(false);
                //搜索框
                ((ViewHolderOne) holder).searchView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mContext.startActivity(new Intent(mContext, SearchActivity.class));
                    }
                });
                //加入点赚通
                ((ViewHolderOne) holder).banner.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mContext.startActivity(new Intent(mContext, JoinActivity.class));
                    }
                });
                //积分换好礼
                ((ViewHolderOne) holder).ivPointForGifts.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mContext.startActivity(new Intent(mContext, PointsForGiftsActivity.class));
                    }
                });
                //扫描二维码
                ImageView imageView = ((ViewHolderOne) holder).qr_code;
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.height = AutoUtils.getPercentHeightSize(70);
                layoutParams.width = AutoUtils.getPercentWidthSize(70);
                imageView.setLayoutParams(layoutParams);


                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startQrCode();
                    }
                });


                break;
            case VIEW_TYPE_TWO:
                ((ViewHolderTwo) holder).tvTitle.setText(mDataList.get(position).getTitle());
                ((ViewHolderTwo) holder).tvContent.setText(mDataList.get(position).getContent());
                ((ViewHolderTwo) holder).tvCount.setText("参与人数：" + mDataList.get(position).getCount() + "人");
                ((ViewHolderTwo) holder).ivIcon.setImageDrawable(
                        mContext.getResources().getDrawable(mDataList.get(position).getIcon()));
                break;
            case VIEW_TYPE_THREE:
                break;
            case VIEW_TYPE_FOUR:
                ((ViewHolderTutor) holder).ivTIcon.setImageResource(mDataList.get(position).gettIcon());
                ((ViewHolderTutor) holder).tvName.setText(mDataList.get(position).gettName());
                ((ViewHolderTutor) holder).tvIntroduction.setText(mDataList.get(position).gettIntroduction());
                ((ViewHolderTutor) holder).tvHeat.setText("" + mDataList.get(position).gettHeat());
                ((ViewHolderTutor) holder).tvAttetion.setText("" + mDataList.get(position).gettAttention());
                ((ViewHolderTutor) holder).btnTutorType.setText(mDataList.get(position).getTutorType());
                ((ViewHolderTutor) holder).btnLevel.setText(mDataList.get(position).gettLevel());

                break;

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
        return mDataList != null ? mDataList.size() : 0;
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
            //适配
            AutoUtils.autoSize(itemView);
            pbLoading = itemView.findViewById(R.id.pb_loading);
            tvLoading = itemView.findViewById(R.id.tv_loading);
            llEnd = itemView.findViewById(R.id.ll_end);
        }
    }

    /**
     * 第一种布局类型ViewHolder
     */
    public static class ViewHolderOne extends RecyclerView.ViewHolder {
        TextView tvTouzilicai;
        RelativeLayout searchView;//搜索框
        ImageView banner;//加入点赚通
        ImageView ivPointForGifts;//积分换好礼
        ImageView qr_code;//二维码

        public ViewHolderOne(View itemView) {
            super(itemView);
            //适配
            AutoUtils.autoSize(itemView);
            tvTouzilicai = itemView.findViewById(R.id.tv_touzilicai);
            searchView = itemView.findViewById(R.id.search_view);
            banner = itemView.findViewById(R.id.banner);
            ivPointForGifts = itemView.findViewById(R.id.iv_points_for_gifts);
            qr_code = itemView.findViewById(R.id.qr_code);


        }
    }

    /**
     * 第二种布局类型ViewHolder
     */
    public class ViewHolderTwo extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        ImageView ivIcon;
        TextView tvTitle;
        TextView tvContent;
        TextView tvCount;

        public ViewHolderTwo(View view) {
            super(view);
            //适配
            AutoUtils.autoSize(view);
            ivIcon = view.findViewById(R.id.iv_icon);
            tvTitle = view.findViewById(R.id.tv_title);
            tvContent = view.findViewById(R.id.tv_content);
            tvCount = view.findViewById(R.id.tv_count);
            //设置点击监听
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);


        }

        @Override
        public void onClick(View v) {
            if (mOnRecyclerViewListener != null) {
                mOnRecyclerViewListener.onItemClick(getAdapterPosition(), 2);
            }

        }

        @Override
        public boolean onLongClick(View v) {
            if (mOnRecyclerViewListener != null) {
                mOnRecyclerViewListener.onItemLongClick(getAdapterPosition());
            }
            return false;
        }
    }

    /**
     * 第三种布局类型ViewHolder
     */
    public class ViewHolderTutorTitle extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView tvTutor;
        int viewType = 3;

        public ViewHolderTutorTitle(View view) {
            super(view);
            //适配
            AutoUtils.autoSize(view);
            tvTutor = view.findViewById(R.id.tv_tutor);
            // 巧妙的调用了View的点击方法
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);


        }

        // 接口回调第三步, 实现onClick, 方法中是调用了接口的onItemClick抽象方法, 所以这里之后肯定会被回调回来
        @Override
        public void onClick(View v) {
            if (mOnRecyclerViewListener != null) {
                mOnRecyclerViewListener.onItemClick(getAdapterPosition(), viewType);
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if (mOnRecyclerViewListener != null) {
                mOnRecyclerViewListener.onItemLongClick(getAdapterPosition());
            }
            return false;
        }
    }

    /**
     * 第四种布局类型ViewHolder
     */
    public class ViewHolderTutor extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        ImageView ivTIcon;//头像
        TextView tvName;//导师名
        TextView tvHeat;//热度
        TextView tvAttetion;//关注
        TextView tvIntroduction;//导师简介
        Button btnTutorType;//导师类别
        Button btnLevel;//导师级别

        int viewType = 4;

        public ViewHolderTutor(View view) {
            super(view);
            //适配
            AutoUtils.autoSize(view);
            ivTIcon = view.findViewById(R.id.iv_icon);
            tvName = view.findViewById(R.id.tv_name);
            tvHeat = view.findViewById(R.id.tv_heat);
            tvAttetion = view.findViewById(R.id.tv_attention);
            tvIntroduction = view.findViewById(R.id.tv_introduction);
            btnLevel = view.findViewById(R.id.btn_level);
            btnTutorType = view.findViewById(R.id.btn_tutor_type);

            //设置点击监听
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);


        }

        // 接口回调第三步, 实现onClick, 方法中是调用了接口的onItemClick抽象方法, 所以这里之后肯定会被回调回来
        @Override
        public void onClick(View v) {
            if (mOnRecyclerViewListener != null) {
                mOnRecyclerViewListener.onItemClick(getAdapterPosition(), viewType);
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if (mOnRecyclerViewListener != null) {
                mOnRecyclerViewListener.onItemLongClick(getAdapterPosition());
            }
            return false;
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

    public TutorListAdapter(List<NewsEntity> iconList) {
        mDataList = iconList;
    }


    /**
     * 开始扫码
     */
    private void startQrCode() {
        // 申请相机权限
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // 申请权限
            ActivityCompat.requestPermissions((Activity) mContext, new String[]{Manifest.permission.CAMERA}, Constant.REQ_PERM_CAMERA);
            return;
        }
        // 申请文件读写权限（部分朋友遇到相册选图需要读写权限的情况，这里一并写一下）
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // 申请权限
            ActivityCompat.requestPermissions((Activity) mContext, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, Constant.REQ_PERM_EXTERNAL_STORAGE);
            return;
        }
        // 二维码扫码
        Intent intent = new Intent(mContext, CaptureActivity.class);
        ((Activity) mContext).startActivityForResult(intent, Constant.REQ_QR_CODE);
    }

}
