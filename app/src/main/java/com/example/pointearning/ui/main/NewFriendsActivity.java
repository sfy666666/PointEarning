package com.example.pointearning.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.pointearning.R;
import com.example.pointearning.bean.NewFriendsEntity;
import com.example.pointearning.ui.BaseActivity;
import com.example.pointearning.ui.fragment.adapter.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 新的好友页面
 * created by shengfeiyu
 *  on 2019/9/11
 */
public class NewFriendsActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private List<NewFriendsEntity> mDataList;
    private BaseQuickAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_friends);
        ButterKnife.bind(this);
        //准备数据
        initData();
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new BaseQuickAdapter<NewFriendsEntity,BaseViewHolder>(R.layout.item_new_friend, mDataList) {



            @Override
            protected void convert(BaseViewHolder helper, NewFriendsEntity friends) {
                helper.setText(R.id.name,friends.getName());
                helper.setText(R.id.yanzhengxiaoxi,friends.getYanzhengxiaoxi());
                helper.setImageResource(R.id.icon,friends.getIcon());
                if(friends.isAgree()){
                    helper.setVisible(R.id.btn_agree,false);
                    helper.setVisible(R.id.yitongyi,true);
                }else{
                    helper.setVisible(R.id.btn_agree,true);
                    helper.setVisible(R.id.yitongyi,false);
                }
                helper.setOnClickListener(R.id.btn_agree, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //事件处理
                        mDataList.get(friends.getUserId()-1).setAgree(true);
                        mAdapter.notifyDataSetChanged();
                    }
                });

            }
        };
        recyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        mDataList = new ArrayList<>();
        mDataList.add(new NewFriendsEntity(1,R.drawable.yangyang, "洋洋", "你好，我是洋洋", false));
        mDataList.add(new NewFriendsEntity(2,R.drawable.yuyipeng, "徐毅鹏", "徐毅鹏", false));
        mDataList.add(new NewFriendsEntity(3,R.drawable.shenqianbuyi, "深浅不一的记忆", "我是深浅不一的记忆", false));
        mDataList.add(new NewFriendsEntity(4,R.drawable.lanwei, "澜蔚", "请同意我的申请", false));
        mDataList.add(new NewFriendsEntity(5,R.drawable.qin, "&亲", "我叫李平秋", true));
    }

    @OnClick({R.id.back, R.id.recycler_view})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;

        }
    }
}
