package com.example.pointearning.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.pointearning.R;
import com.example.pointearning.bean.NewFriendsEntity;
import com.example.pointearning.bean.SortModel;
import com.example.pointearning.ui.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创建群聊页面
 * created by shengfeiyu
 * on 2019/9/11
 */
public class CreateGroupChatActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.search_view)
    EditText searchView;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    List<NewFriendsEntity> mDataList = new ArrayList<>();
    private BaseQuickAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group_chat);
        ButterKnife.bind(this);
        initData();
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new BaseQuickAdapter<NewFriendsEntity, BaseViewHolder>(R.layout.item_create_group_chat, mDataList) {



            @Override
            protected void convert(BaseViewHolder helper, NewFriendsEntity friends) {
                helper.setText(R.id.name,friends.getName());
                helper.setImageResource(R.id.icon,friends.getIcon());
                if(friends.isAgree()){
                    helper.setChecked(R.id.checkbox,true);
                }else{
                    helper.setChecked(R.id.checkbox,false);

                }
                helper.setOnCheckedChangeListener(R.id.checkbox,new CompoundButton.OnCheckedChangeListener(){
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                        mDataList.get(friends.getUserId()-1).setAgree(isChecked);
//                        mAdapter.notifyDataSetChanged();
                    }
                });


            }
        };
        recyclerView.setAdapter(mAdapter);

    }


    private void initData() {

        for (int i = 0; i <5 ; i++) {
            mDataList.add(new NewFriendsEntity(1,R.drawable.yangyang, "洋洋", "你好，我是洋洋", false));
            mDataList.add(new NewFriendsEntity(2,R.drawable.yuyipeng, "徐毅鹏", "徐毅鹏", false));
            mDataList.add(new NewFriendsEntity(3,R.drawable.shenqianbuyi, "深浅不一的记忆", "我是深浅不一的记忆", false));
            mDataList.add(new NewFriendsEntity(4,R.drawable.lanwei, "澜蔚", "请同意我的申请", false));
            mDataList.add(new NewFriendsEntity(5,R.drawable.qin, "&亲", "我叫李平秋", true));

        }


    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }


}
