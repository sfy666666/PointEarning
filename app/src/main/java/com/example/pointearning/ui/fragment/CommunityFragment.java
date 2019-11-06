package com.example.pointearning.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.pointearning.R;
import com.example.pointearning.bean.CommunityEntity;
import com.example.pointearning.ui.MainActivity;
import com.example.pointearning.ui.fragment.adapter.BaseRecyclerViewAdapter;
import com.example.pointearning.ui.fragment.adapter.CommunityAdapter;
import com.example.pointearning.ui.fragment.adapter.CommunityAdapter2;
import com.example.pointearning.ui.main.CommunityDetailActivity;
import com.example.pointearning.ui.main.ShareIntoMomentsActivity;
import com.example.pointearning.utils.DialogGetPictureUtil;
import com.example.pointearning.utils.EndlessRecyclerOnScrollListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * created by shengfeiyu
 * on 2019/9/5
 *
 * 社区
 */
public class CommunityFragment extends  BaseFragment implements CommunityAdapter2.OnRecyclerViewListener {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerViewHorizontal;
    private RecyclerView recyclerViewVertical;
    private int[] images;
    private CommunityAdapter communityAdapter;

    private List<CommunityEntity> newsEntityList = new ArrayList<>();
    private CommunityAdapter2 communityAdapter2;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_community, container, false);
        //绑定控件
        bindView();
        //准备数据
        initHorizontal();
        initVertical();
        //推荐 顶部横向Recyclerview
        setHorizaontalAdapter();
        //动态  纵向Recyclerview
        setVerticalAdapter();
        //下拉刷新
        refresh();
        //上拉加载更多
        loadMore();
        return view;
    }

    private void loadMore() {
        // 设置加载更多监听
        recyclerViewVertical.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onLoadMore() {
                communityAdapter2.setLoadState(communityAdapter2.LOADING);

                if (newsEntityList.size() < 52) {
                    // 模拟获取网络数据，延时1s
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    initVertical();
                                    communityAdapter2.setLoadState(communityAdapter2.LOADING_COMPLETE);
                                }
                            });
                        }
                    }, 1000);
                } else {
                    // 显示加载到底的提示
                    communityAdapter2.setLoadState(communityAdapter2.LOADING_END);
                }
            }
        });

    }

    private void refresh() {

        // 设置刷新控件颜色
        swipeRefreshLayout.setColorSchemeColors(Color.parseColor("#4DB6AC"));
        // 设置下拉刷新
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // 刷新数据
                newsEntityList.clear();
                initHorizontal();
                initVertical();
                communityAdapter.notifyDataSetChanged();
                communityAdapter2.notifyDataSetChanged();

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

    }

    private void setVerticalAdapter() {
        //创建布局管理器
        LinearLayoutManager verticalManager = new LinearLayoutManager(getActivity());
        //设置管理器
        recyclerViewVertical.setLayoutManager(verticalManager);
        //创建适配器

        communityAdapter2 = new CommunityAdapter2(newsEntityList, getActivity());
        //设置适配器
        recyclerViewVertical.setAdapter(communityAdapter2);
        //设置条目点击监听
        communityAdapter2.setOnRecyclerViewListener(this);
    }

    private void setHorizaontalAdapter() {
        //创建布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        //设置横向排列
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //设置管理器
        recyclerViewHorizontal.setLayoutManager(linearLayoutManager);
        //创建适配器
        communityAdapter = new CommunityAdapter(images);

        //设置适配器
        recyclerViewHorizontal.setAdapter(communityAdapter);
    }

    private void bindView() {
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        recyclerViewHorizontal = view.findViewById(R.id.recycler_view_horizontal);
        recyclerViewVertical = view.findViewById(R.id.recycler_view_vertical);
        Button takePicture = view.findViewById(R.id.iv_take_picture);
        takePicture.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

//                Toast.makeText(getActivity(), "拍照", Toast.LENGTH_SHORT).show();
//                Log.ic_home_lcxm("SFY", "onClick: 拍照");
                new DialogGetPictureUtil(getActivity()){
                    @Override
                    public void takePicture() {
//                        Toast toast = Toast.makeText(getActivity(),null,Toast.LENGTH_SHORT);
//                        toast.setText("拍照");
//                        toast.show();
                        Intent intent = new Intent(getActivity(), ShareIntoMomentsActivity.class);
                        startActivity(intent);

                    }

                    @Override
                    public void getPictureFormPhone() {
//                        Toast toast = Toast.makeText(getActivity(),null,Toast.LENGTH_SHORT);
//                        toast.setText("选择照片");
//                        toast.show();
                        Intent intent = new Intent(getActivity(), ShareIntoMomentsActivity.class);
                        startActivity(intent);
                    }
                }.show();
            }
        });
    }

    private void initVertical() {
        CommunityEntity communityEntity1 = new CommunityEntity(R.drawable.tou, "rose", "50分钟前", "xsdfsdfds", R.drawable.one, R.drawable.two
                , R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six, 1);
        CommunityEntity communityEntity2 = new CommunityEntity(R.drawable.tou, "rose", "50分钟前", "xsdfsdfds", R.drawable.one, R.drawable.two
                , R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six, 2);
        CommunityEntity communityEntity3 = new CommunityEntity(R.drawable.tou, "rose", "50分钟前", "xsdfsdfds", R.drawable.one, R.drawable.two
                , R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six, 3);
        newsEntityList.add(communityEntity1);
        newsEntityList.add(communityEntity2);
        newsEntityList.add(communityEntity3);



    }

    private void initHorizontal() {
        images = new int[]{
                R.drawable.ta,R.drawable.tb,
                R.drawable.tc,R.drawable.td,R.drawable.sss,
                R.drawable.tou

        };
    }



    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), CommunityDetailActivity.class);
        intent.putExtra("newsEntity",newsEntityList.get(position));
        startActivity(intent);
    }

    @Override
    public boolean onItemLongClick(int position) {
        return false;
    }
}
