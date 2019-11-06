package com.example.pointearning.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.pointearning.R;
import com.example.pointearning.bean.NewsEntity;
import com.example.pointearning.contact.Contact2Activity;
import com.example.pointearning.ui.fragment.adapter.MessageAdapter;
import com.example.pointearning.ui.main.ChatActivity;
import com.example.pointearning.ui.main.CreateGroupChatActivity;
import com.example.pointearning.ui.main.NewFriendsActivity;
import com.example.pointearning.utils.DialogAddFriendUtil;
import com.example.pointearning.utils.EndlessRecyclerOnScrollListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * created by shengfeiyu
 * on 2019/9/4
 * 消息页面
 */
public class IMFragment extends Fragment implements View.OnClickListener, MessageAdapter.OnRecyclerViewItemClickListener {
    private List<NewsEntity> newsEntityList = new ArrayList<>();
    private MessageAdapter messageAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private SwipeMenuRecyclerView slideRv;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_im, container, false);
        //绑定控件

        bindView();
        //初始化数据
        init();
        //设置layoutmanager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        slideRv.setLayoutManager(linearLayoutManager);
        //设置item分割线为灰色
//        slideRv.addItemDecoration(new DefaultItemDecoration(Color.GRAY));
        //设置添加侧滑按钮
        slideRv.setSwipeMenuCreator(swipeMenuCreator);
        //设置滑动菜单item监听
        slideRv.setSwipeMenuItemClickListener(swipeMenuItemClickListener);
        //创建适配器  传入数据


        messageAdapter = new MessageAdapter(newsEntityList, getActivity());
        //设置适配器
        slideRv.setAdapter(messageAdapter);
        //设置条目监听
        messageAdapter.setOnRecyclerViewItemClickListener(this);
        //设置增删动画
//        slideRv.setItemAnimator(new DefaultItemAnimator());
        /*else{
        //刷新ui
            messageAdapter.notifyDataSetChanged();

        }*/


        // 设置刷新控件颜色
        swipeRefreshLayout.setColorSchemeColors(Color.parseColor("#4DB6AC"));
        // 设置下拉刷新
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // 刷新数据
                newsEntityList.clear();
                init();
                messageAdapter = new MessageAdapter(newsEntityList, getActivity());
                //设置适配器
                slideRv.setAdapter(messageAdapter);
                messageAdapter.notifyDataSetChanged();

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
        slideRv.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onLoadMore() {
                messageAdapter.setLoadState(messageAdapter.LOADING);

                if (newsEntityList.size() < 52) {
                    // 模拟获取网络数据，延时1s
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    init();
//                                    messageAdapter = new MessageAdapter(newsEntityList,getActivity());
//                                    //设置适配器
//                                    slideRv.setAdapter(messageAdapter);
                                    messageAdapter.setLoadState(messageAdapter.LOADING_COMPLETE);
                                }
                            });
                        }
                    }, 1000);
                } else {
                    // 显示加载到底的提示
                    messageAdapter.setLoadState(messageAdapter.LOADING_END);
                }
            }
        });


        return view;
    }

    private void bindView() {

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        slideRv = view.findViewById(R.id.slide_rv);
        ImageView btnFriend = (ImageView) view.findViewById(R.id.btn_friend);
        ImageView btnAdd = (ImageView) view.findViewById(R.id.btn_add);
        btnFriend.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
    }

    private void init() {
        for (int i = 0; i < 5; i++) {
            NewsEntity newsEntity = new NewsEntity("导师消息", "", 10, R.drawable.daoshixiaoxi, 1);
            newsEntityList.add(newsEntity);
        }
    }

    @Override
    public void onDestroy() {
//        newsEntityList.clear();
        super.onDestroy();

    }


    // 设置菜单监听器。
    SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator() {
        // 创建菜单：
        @Override
        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {
            int width = getResources().getDimensionPixelSize(R.dimen.dp_70);
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            SwipeMenuItem deleteItem = new SwipeMenuItem(getActivity())
                    .setBackground(R.drawable.shanchu)
                    .setTextColor(Color.WHITE)
                    .setText("删除")
                    .setWidth(width)
                    .setHeight(height);
            swipeRightMenu.addMenuItem(deleteItem);
        }
    };

    // 菜单点击监听。
    SwipeMenuItemClickListener swipeMenuItemClickListener = new SwipeMenuItemClickListener() {
        @Override
        public void onItemClick(SwipeMenuBridge menuBridge) {
            // 任何操作必须先关闭菜单，否则可能出现Item菜单打开状态错乱。
            menuBridge.closeMenu();

            int direction = menuBridge.getDirection();//左边还是右边菜单
            int adapterPosition = menuBridge.getAdapterPosition();//    ecyclerView的Item的position。
            int position = menuBridge.getPosition();// 菜单在RecyclerView的Item中的Position。

            if (direction == SwipeMenuRecyclerView.RIGHT_DIRECTION) {
                newsEntityList.remove(adapterPosition);//删除item
                messageAdapter.notifyDataSetChanged();
//                Toast.makeText(getActivity(), "list第" + adapterPosition + "; 右侧菜单第" + position, Toast.LENGTH_SHORT).show();
                Toast toast = Toast.makeText(getActivity(), null, Toast.LENGTH_SHORT);
                toast.setText("已删除");
                toast.show();
            }

        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_friend:
                startActivity(new Intent(getActivity(), Contact2Activity.class));
                break;
            case R.id.btn_add:
                //设置弹框
                DialogAddFriendUtil dialog = new DialogAddFriendUtil(getActivity()) {
                    @Override
                    public void addFriend() {
//                        Toast toast = Toast.makeText(getActivity(),null,Toast.LENGTH_SHORT);
//                        toast.setText("添加好友");
//                        toast.show();
//                        this.cancel();
                        startActivity(new Intent(getActivity(), NewFriendsActivity.class));
                    }

                    @Override
                    public void createGroupChat() {
//                        Toast toast = Toast.makeText(getActivity(),null,Toast.LENGTH_SHORT);
//                        toast.setText("创建群聊");
//                        toast.show();
//                        this.cancel();
                        startActivity(new Intent(getActivity(), CreateGroupChatActivity.class));
                    }
                };
                dialog.show();

//                WindowManager windowManager = getActivity().getWindowManager();
//                Display display = windowManager.getDefaultDisplay();
//                WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
//                lp.height = (int)(display.getHeight()*0.8);
//                //设置宽度
//                dialog.getWindow().setAttributes(lp);
                break;
        }
    }

    @Override
    public void onItemClick(int position) {

        startActivity(new Intent(getActivity(), ChatActivity.class));
    }
}
