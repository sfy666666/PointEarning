package com.example.pointearning.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.pointearning.R;
import com.example.pointearning.bean.CommentEntity;
import com.example.pointearning.bean.NewsEntity;
import com.example.pointearning.ui.fragment.adapter.CommunityCommentAdapter;
import com.example.pointearning.utils.EndlessRecyclerOnScrollListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * created by shengfeiyu
 * on 2019/9/8
 *
 * 导师详情中的评价
 */
public class TutorEvaluationFragment extends BaseFragment {

    private View view;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    List<CommentEntity> mDataList  = new ArrayList<>();

    private CommunityCommentAdapter mRVAdapter;
    int TAB_TYPE;

    public TutorEvaluationFragment(int TAB_TYPE) {
        this.TAB_TYPE = TAB_TYPE;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tutorevaluation, container, false);
        //绑定控件
        bindView();
        //准备数据
        initData();

        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity()){
            @Override
            public boolean canScrollVertically() {
                //禁止垂直滑动解决与父层ScrollView的滑动冲突
                return false;
            }
        };
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //创建适配器并设置
        mRVAdapter = new CommunityCommentAdapter(mDataList,TAB_TYPE);

        //设置适配器
        mRecyclerView.setAdapter(mRVAdapter);


        // 设置刷新控件颜色
        mSwipeRefreshLayout.setColorSchemeColors(Color.parseColor("#4DB6AC"));
        // 设置下拉刷新
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // 刷新数据
                mDataList.clear();
                initData();
                mRVAdapter.notifyDataSetChanged();

                // 延时1s关闭下拉刷新
                mSwipeRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (mSwipeRefreshLayout != null && mSwipeRefreshLayout.isRefreshing()) {
                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                    }
                }, 1000);
            }
        });

        // 设置加载更多监听
        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onLoadMore() {
                mRVAdapter.setLoadState(mRVAdapter.LOADING);

                if (mDataList.size() < 52) {
                    // 模拟获取网络数据，延时1s
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    initData();
                                    mRVAdapter.setLoadState(mRVAdapter.LOADING_COMPLETE);
                                }
                            });
                        }
                    }, 1000);
                } else {
                    // 显示加载到底的提示
                    mRVAdapter.setLoadState(mRVAdapter.LOADING_END);
                }
            }
        });


        return view;
    }

    private void initData() {
        for (int i = 0; i < 3; i++) {
            CommentEntity a = new CommentEntity(R.drawable.tou, "Rose you", "导师真才实学，感觉理财方面受益颇多", "8-21 1:23");
            mDataList.add(a);
            CommentEntity b = new CommentEntity(R.drawable.ta, "宋嘉树", "说得很好，哈哈", "8-21  3:21");
            mDataList.add(b);
            CommentEntity c = new CommentEntity(R.drawable.tb, "赵亮", "的确是这个样子的", "8-21  3:33");
            mDataList.add(c);
            CommentEntity d = new CommentEntity(R.drawable.tc, "吴昕", "现在理财的种类越来越多了", "8-21  3:55  ");
            mDataList.add(d);
        }
    }

    private void bindView() {
        mSwipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        mRecyclerView = view.findViewById(R.id.recycler_view);

    }
}
