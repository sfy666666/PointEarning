package com.example.pointearning.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.pointearning.R;
import com.example.pointearning.bean.NewsEntity;
import com.example.pointearning.bean.SortModel;
import com.example.pointearning.ui.BaseActivity;
import com.example.pointearning.ui.fragment.adapter.ContactSortAdapter;
import com.github.library.BaseMultiItemAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 通讯录页面
 * created by shengfeiyu
 * on 2019/9/11
 *
 */
public class ContactActivity extends BaseActivity implements ContactSortAdapter.OnRecyclerViewListener {

    BaseMultiItemAdapter mAdapter;
    List<SortModel> mDataList = new ArrayList<>();
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.search_view)
    EditText searchView;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ButterKnife.bind(this);
        initView();
        //准备数据
        initData();
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        //设置适配器
        ContactSortAdapter contactSortAdapter = new ContactSortAdapter(this,mDataList);
        recyclerView.setAdapter(contactSortAdapter);
        //设置条目监听
        contactSortAdapter.setOnRecyclerViewListener(this);

        /*recyclerView.setAdapter(mAdapter = new BaseMultiItemAdapter<SortModel>(this, mDataList) {


            @Override
            protected void convert(com.github.library.BaseViewHolder helper, SortModel item) {
                switch (helper.getItemViewType()) {
                    case 1:
                        if(item.getIcon()!=0) {
                            helper.setImageResource(R.id.icon, item.getIcon());
                            helper.setText(R.id.name, item.getName());
                        }

                        //helper.setImageBitmap(R.id.chat_send_icon,getRoundCornerBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.from_head), 16));
                        break;
                    case 0:
                        if(item.getIcon()==0){
                            helper.setText(R.id.letter, item.getLetter());
                        }

                        //helper.setImageBitmap(R.id.chat_from_icon,getRoundCornerBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.chat_head), 16));
                        break;

                }
            }

            @Override
            protected void addItemLayout() {

                addItemType(1, R.layout.item_contact);
                addItemType(0, R.layout.item_contact2);
            }
        });*/
    }

    private void initView() {


    }

    private void initData() {
        mDataList.add(new SortModel(R.drawable.haoyou, "新的好友", "",1));
        mDataList.add(new SortModel(R.drawable.qunliao, "创建群聊", "",1));
        mDataList.add(new SortModel(0, "", "A",0));
        mDataList.add(new SortModel(R.drawable.ali, "阿利导师", "a",1));
        mDataList.add(new SortModel(0, "", "B",0));
        mDataList.add(new SortModel(R.drawable.benben, "本本", "b",1));
        mDataList.add(new SortModel(R.drawable.baikaishui, "白开水", "b",1));
        mDataList.add(new SortModel(R.drawable.baige, "白鸽_", "b",1));
        mDataList.add(new SortModel(R.drawable.bajiu, "八九", "b",1));
        mDataList.add(new SortModel(R.drawable.baobao, "宝宝", "b",1));
        mDataList.add(new SortModel(R.drawable.baobao, "柴九", "c",1));
        mDataList.add(new SortModel(R.drawable.baobao, "大宝", "d",1));
        mDataList.add(new SortModel(R.drawable.baobao, "eason", "ic_home_wz",1));
        mDataList.add(new SortModel(R.drawable.baobao, "弗兰克林", "f",1));
        mDataList.add(new SortModel(R.drawable.baobao, "高斯林", "g",1));
        mDataList.add(new SortModel(R.drawable.baobao, "黄家驹", "h",1));
        mDataList.add(new SortModel(R.drawable.baobao, "island", "ic_home_lcxm",1));


    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void onItemClick(int position) {
        if(position==0) {
            startActivity(new Intent(this, NewFriendsActivity.class));
        }else if(position==1){
            startActivity(new Intent(this, CreateGroupChatActivity.class));
        }else {
            startActivity(new Intent(this, ChatActivity.class));
        }
    }
}
