package com.example.pointearning.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pointearning.R;
import com.example.pointearning.bean.ChatEntity;
import com.example.pointearning.ui.BaseActivity;
import com.example.pointearning.ui.main.adapter.MultipleItemQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 聊天页面
 */
public class ChatActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.more)
    ImageView more;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    MultipleItemQuickAdapter mAdapter;

    static final int VIEWTYPETIME = 10001;
    static final int VIEWTYPERIGHT = 10002;
    static final int VIEWTYPELEFT = 10003;
    List<ChatEntity> mDataList = new ArrayList<>();
    @BindView(R.id.bottom_view)
    RelativeLayout bottomView;
    @BindView(R.id.root)
    RelativeLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);
        //准备数据
        initData();
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter = new MultipleItemQuickAdapter(mDataList));




    }

    private void initData() {
        mDataList.add(new ChatEntity(0, 0, "9月12日   09:29", VIEWTYPETIME));
        mDataList.add(new ChatEntity(1, R.drawable.gg, "你看过那个项目了吗？", VIEWTYPERIGHT));
        mDataList.add(new ChatEntity(2, R.drawable.hhh, "是的，感觉还不错", VIEWTYPELEFT));
        mDataList.add(new ChatEntity(3, R.drawable.gg, "太好了", VIEWTYPERIGHT));
    }

    @OnClick({R.id.back, R.id.more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.more:
                startActivity(new Intent(this, ChatDetailActivity.class));
                break;
        }
    }



}
