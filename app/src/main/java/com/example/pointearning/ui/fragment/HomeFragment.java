package com.example.pointearning.ui.fragment;

/**
 * created by shengfeiyu
 * on 2019/9/5
 * <ic_home_qbds>
 * 首页
 */


import android.content.Intent;
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
import com.example.pointearning.bean.NewsEntity;
import com.example.pointearning.ui.TutorListActivity;
import com.example.pointearning.ui.fragment.adapter.HomeAdapter;
import com.example.pointearning.ui.main.ProgramDetailActivity;
import com.example.pointearning.ui.main.TutorDetailActivity;
import com.example.pointearning.utils.EndlessRecyclerOnScrollListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends BaseFragment implements HomeAdapter.OnRecyclerViewListener {

    private RecyclerView mRecyclerView;
    private List<NewsEntity> newsEntityList = new ArrayList<>();
    private HomeAdapter newsAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    private View inflate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        inflate = inflater.inflate(R.layout.fragment_main2, container, false);
        //初始化
        init();
        swipeRefreshLayout = inflate.findViewById(R.id.swipe_refresh_layout);

        // 设置刷新控件颜色
        swipeRefreshLayout.setColorSchemeColors(Color.parseColor("#4DB6AC"));

        //获取recyclerview实例
        mRecyclerView = inflate.findViewById(R.id.rv);
        //创建一个layoutmanager  Linear线性类似listview
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        //完后layoutmanager设置
        mRecyclerView.setLayoutManager(layoutManager);
        //创建并把集合传入适配器
        newsAdapter = new HomeAdapter(newsEntityList, getActivity());
        mRecyclerView.setAdapter(newsAdapter);


        // 设置下拉刷新
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // 刷新数据
                newsEntityList.clear();
                init();
                newsAdapter.notifyDataSetChanged();

                // 延时1s关闭下拉刷新
                swipeRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (swipeRefreshLayout != null && swipeRefreshLayout.isRefreshing()) {
                            swipeRefreshLayout.setRefreshing(false);
                        }
                    }
                }, 1000);
            }
        });

        // 设置加载更多监听
        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onLoadMore() {
                newsAdapter.setLoadState(newsAdapter.LOADING);

                if (newsEntityList.size() < 15) {
                    // 模拟获取网络数据，延时1s
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    getData();
                                    newsAdapter.setLoadState(newsAdapter.LOADING_COMPLETE);
                                }
                            });
                        }
                    }, 1000);
                } else {
                    // 显示加载到底的提示
                    newsAdapter.setLoadState(newsAdapter.LOADING_END);
                }
            }
        });

        //设置条目点击监听
        newsAdapter.setOnRecyclerViewListener(this);


        return inflate;
    }

    private void init() {
        newsEntityList.add(new NewsEntity("星时代金融投资", "简介：嘻嘻嘻嘻嘻嘻嘻嘻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻", 20, R.drawable.qq, 1));
        NewsEntity a = new NewsEntity("星时代金融投资", "简介：由多位老师整体把握项目经验，整体运营规划", 20, R.drawable.qq, 2);
        newsEntityList.add(a);
        NewsEntity b = new NewsEntity("云翳科技融资", "简介：由多位老师整体把握项目经验，整体运营规划", 30, R.drawable.yunyi, 2);
        newsEntityList.add(b);
        NewsEntity tutorTitle = new NewsEntity(R.drawable.ewnwu, "白雅晴", "一级导师", "风投分析", "简介：这是一位有着丰富经验的老司机,投资和理财是她的强项", 23456, 234, 3);
        newsEntityList.add(tutorTitle);
        NewsEntity tutor1 = new NewsEntity(R.drawable.ewnwu, "白雅晴", "一级导师", "风投分析", "简介：这是一位有着丰富经验的老司机,投资和理财是她的强项", 23456, 234, 4);
        newsEntityList.add(tutor1);
        NewsEntity tutor2 = new NewsEntity(R.drawable.re, "李元", "一级导师", "数据分析", "简介：1999年从事金融至今，帮助多名企业家", 67890, 345, 4);
        newsEntityList.add(tutor2);
    }

    private void getData() {
        for (int i = 0; i < 5; i++) {
//            NewsEntity a = new NewsEntity("星时代金融投资", "简介：嘻嘻嘻嘻嘻嘻嘻嘻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻",20,R.drawable.qq,2);
//            newsEntityList.add(a);
//            NewsEntity b = new NewsEntity("云翳科技融资", "简介：嘻嘻嘻嘻嘻嘻嘻嘻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻",30,R.drawable.yunyi,2);
//            newsEntityList.add(b);

            NewsEntity tutor1 = new NewsEntity(R.drawable.ewnwu, "白雅晴", "一级导师", "风投分析", "简介：这是一位有着丰富经验的老司机,投资和理财是她的强项", 23456, 234, 4);
            newsEntityList.add(tutor1);
            NewsEntity tutor2 = new NewsEntity(R.drawable.re, "李元", "一级导师", "数据分析", "简介：这是一位有着丰富经验的老司机,投资和理财是她的强项", 67890, 345, 4);
            newsEntityList.add(tutor2);
        }
    }

    @Override
    public void onDestroy() {
        newsEntityList.clear();
        super.onDestroy();
    }

    /**
     * @param position
     * @param viewType 2.项目详情 3 导师列表  4 导师详情
     */


    @Override
    public void onItemClick(int position, int viewType) {
        switch (viewType) {
            case 2:
                //跳转到项目详情
                startActivity(new Intent(getActivity(), ProgramDetailActivity.class));
                break;
            case 3:
                //跳转到导师列表
                startActivity(new Intent(getActivity(), TutorListActivity.class));
                break;
            case 4:
                //跳转到导师详情
                Intent intent = new Intent(getActivity(), TutorDetailActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public boolean onItemLongClick(int position) {
        return false;
    }
}

