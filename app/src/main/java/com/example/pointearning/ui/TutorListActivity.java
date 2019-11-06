package com.example.pointearning.ui;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.pointearning.R;
import com.example.pointearning.bean.NewsEntity;
import com.example.pointearning.ui.fragment.adapter.TutorListAdapter;
import com.example.pointearning.ui.main.SearchActivity;
import com.example.pointearning.ui.main.TutorDetailActivity;
import com.example.pointearning.utils.EndlessRecyclerOnScrollListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TutorListActivity extends BaseActivity implements View.OnClickListener , TutorListAdapter.OnRecyclerViewListener {

    private RecyclerView mRecyclerView;
    List<NewsEntity> newsEntityList = new ArrayList<>();
    private TutorListAdapter mRVAdater;

    SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_list);
        //绑定控件
        bindView();
        //准备数据
        initData();

        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        //设置适配器
        mRVAdater = new TutorListAdapter(newsEntityList,this);
        mRecyclerView.setAdapter(mRVAdater);


        // 设置下拉刷新
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // 刷新数据
                newsEntityList.clear();
                initData();
                mRVAdater.notifyDataSetChanged();

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

        //上拉加载更多
        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onLoadMore() {
                mRVAdater.setLoadState(mRVAdater.LOADING);

                if (newsEntityList.size() < 52) {
                    // 模拟获取网络数据，延时1s
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    initData();
                                    mRVAdater.setLoadState(mRVAdater.LOADING_COMPLETE);
                                }
                            });
                        }
                    }, 1000);
                } else {
                    // 显示加载到底的提示
                    mRVAdater.setLoadState(mRVAdater.LOADING_END);
                }
            }
        });

        //设置条目监听
        mRVAdater.setOnRecyclerViewListener(this);
    }

    private void initData() {

        for (int i = 0; i <5 ; i++) {
            NewsEntity tutor1 = new NewsEntity(R.drawable.ewnwu, "白雅晴", "一级导师", "风投分析", "简介：这是一位有着丰富经验的老司机,投资和理财是她的强项", 23456, 234, 4);
            newsEntityList.add(tutor1);
            NewsEntity tutor2 = new NewsEntity(R.drawable.re, "李元", "一级导师", "数据分析", "简介：1999年从事金融至今，帮助多名企业家", 67890, 345, 4);
            newsEntityList.add(tutor2);
        }


    }

    private void bindView() {
        mRecyclerView = findViewById(R.id.recycler_view);

        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        // 设置刷新控件颜色
        swipeRefreshLayout.setColorSchemeColors(Color.parseColor("#4DB6AC"));

        ImageView back = findViewById(R.id.back);
        ImageView search = findViewById(R.id.search);

        back.setOnClickListener(this);
        search.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:finish();break;
            case R.id.search:
                startActivity(new Intent(TutorListActivity.this, SearchActivity.class));

                break;
        }
    }

    @Override
    public void onItemClick(int position, int viewType) {
        switch (viewType){
            case 4:
                Intent intent = new Intent(TutorListActivity.this, TutorDetailActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public boolean onItemLongClick(int position) {
        return false;
    }
}
