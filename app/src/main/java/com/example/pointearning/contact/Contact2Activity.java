package com.example.pointearning.contact;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.pointearning.R;
import com.example.pointearning.ui.BaseActivity;
import com.example.pointearning.ui.main.ChatActivity;
import com.example.pointearning.ui.main.CreateGroupChatActivity;
import com.example.pointearning.ui.main.NewFriendsActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 联系人列表2
 */
public class Contact2Activity extends BaseActivity implements ContactSortAdapter.OnContactRecyclerViewItemCLickListener {
    @BindView(R.id.back)
    ImageView back;
    private List<SortModel> mDataList=new ArrayList<>();
    private ContactSortAdapter mAdapter;
    private EditText ed_search;
    private ContactRecyclerView contact_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact2);
        ButterKnife.bind(this);
        initView();
        initData();


    }

    private void initData() {
        mDataList.add(new SortModel(R.drawable.ali, "阿利导师", "a",1));
        mDataList.add(new SortModel(R.drawable.ali, "a", "a",1));
        mDataList.add(new SortModel(R.drawable.ali, "asd", "a",1));
        mDataList.add(new SortModel(R.drawable.benben, "本本", "b",1));
        mDataList.add(new SortModel(R.drawable.baikaishui, "白开水", "b",1));
        mDataList.add(new SortModel(R.drawable.baige, "白鸽_", "b",1));
        mDataList.add(new SortModel(R.drawable.bajiu, "八九", "b",1));
        mDataList.add(new SortModel(R.drawable.baobao, "宝宝", "b",1));
        mDataList.add(new SortModel(R.drawable.baobao, "cd", "c",1));
        mDataList.add(new SortModel(R.drawable.baobao, "陈轸", "c",1));
        mDataList.add(new SortModel(R.drawable.baobao, "c1", "c",1));
        mDataList.add(new SortModel(R.drawable.baobao, "c2", "c",1));
        mDataList.add(new SortModel(R.drawable.baobao, "曹安民", "c",1));
        mDataList.add(new SortModel(R.drawable.baobao, "大宝", "d",1));
        mDataList.add(new SortModel(R.drawable.baobao, "董承", "d",1));
        mDataList.add(new SortModel(R.drawable.baobao, "Danny", "d",1));
        mDataList.add(new SortModel(R.drawable.baobao, "d232", "d",1));
        mDataList.add(new SortModel(R.drawable.baobao, "Daenerys Targaryen", "d",1));
        mDataList.add(new SortModel(R.drawable.baobao, "eason", "ic_home_wz",1));
        mDataList.add(new SortModel(R.drawable.baobao, "弗兰克林", "f",1));
        mDataList.add(new SortModel(R.drawable.baobao, "范雎", "f",1));
        mDataList.add(new SortModel(R.drawable.baobao, "高斯林", "g",1));
        mDataList.add(new SortModel(R.drawable.baobao, "公孙衍", "g",1));
        mDataList.add(new SortModel(R.drawable.baobao, "公输班", "g",1));
        mDataList.add(new SortModel(R.drawable.baobao, "黄家驹", "h",1));
        mDataList.add(new SortModel(R.drawable.baobao, "韩聂", "h",1));
        mDataList.add(new SortModel(R.drawable.baobao, "island", "ic_home_lcxm",1));
        mDataList.add(new SortModel(R.drawable.ali, "12345", "a",1));
        mDataList.add(new SortModel(R.drawable.benben, "JayChou", "j",1));
        mDataList.add(new SortModel(R.drawable.baikaishui, "快递", "k",1));
        mDataList.add(new SortModel(R.drawable.baige, "lol", "l",1));
        mDataList.add(new SortModel(R.drawable.baige, "李淳风", "l",1));
        mDataList.add(new SortModel(R.drawable.baige, "李克勤", "l",1));
        mDataList.add(new SortModel(R.drawable.bajiu, "孟轲", "m",1));
//        mDataList.add(new SortModel(R.drawable.bajiu, "祢衡", "m",1));
//        mDataList.add(new SortModel(R.drawable.bajiu, "芈原", "m",1));

        mDataList.add(new SortModel(R.drawable.baobao, "南乡子", "n",1));
        mDataList.add(new SortModel(R.drawable.baobao, "overlord", "ic_home_zjds",1));
        mDataList.add(new SortModel(R.drawable.baobao, "彭德怀", "ic_home_qbds",1));
        mDataList.add(new SortModel(R.drawable.baobao, "钱学森", "ic_home_tzlc",1));
        mDataList.add(new SortModel(R.drawable.baobao, "任我行", "ic_home_jz",1));
        mDataList.add(new SortModel(R.drawable.baobao, "苏秦", "s",1));
        mDataList.add(new SortModel(R.drawable.baobao, "弗兰克林", "ic_home_jrds",1));
        mDataList.add(new SortModel(R.drawable.baobao, "弗兰克林", "ic_home_tzxf",1));
        mDataList.add(new SortModel(R.drawable.baobao, "弗兰克林", "v",1));
        mDataList.add(new SortModel(R.drawable.baobao, "卫鞅", "ic_home_gpzq",1));
//        mDataList.add(new SortModel(R.drawable.baobao, "嬴师隰", "ic_home_wzds",1));
//        mDataList.add(new SortModel(R.drawable.baobao, "嬴渠梁", "ic_home_wzds",1));
//        mDataList.add(new SortModel(R.drawable.baobao, "嬴驷", "ic_home_wzds",1));
//        mDataList.add(new SortModel(R.drawable.baobao, "嬴荡", "ic_home_wzds",1));
//        mDataList.add(new SortModel(R.drawable.baobao, "嬴稷", "ic_home_wzds",1));
        mDataList.add(new SortModel(R.drawable.baobao, "叶剑英", "ic_home_wzds",1));
//        mDataList.add(new SortModel(R.drawable.baobao, "嬴柱", "ic_home_wzds",1));
//        mDataList.add(new SortModel(R.drawable.baobao, "嬴子楚", "ic_home_wzds",1));
//        mDataList.add(new SortModel(R.drawable.baobao, "嬴政", "ic_home_wzds",1));
        mDataList.add(new SortModel(R.drawable.baobao, "袁隆平", "ic_home_wzds",1));
        mDataList.add(new SortModel(R.drawable.baobao, "袁崇焕", "ic_home_wzds",1));
        mDataList.add(new SortModel(R.drawable.baobao, "周培公", "z",1));
        mDataList.add(new SortModel(R.drawable.baobao, "周恩来", "z",1));
        mDataList.add(new SortModel(R.drawable.baobao, "张仪", "z",1));
        String[] arrayData = {"a", "bd", "ced", "de", "as", "东皇太一", "宫本武藏", "王昭君", "李元芳", "刘禅", "后裔", "许爱明", "无名", "流海"
                , "亚瑟", "吕布", "秋雅", "夏洛", "公孙离", "张良", "孙尚香", "我", "你", "啊", "哈哈", "嘿"
                , "无名", "流海", "亚瑟", "吕布", "夏洛", "公孙离", "张良", "孙尚香", "无名", "流海", "亚瑟", "吕布", "刘备", "夏洛", "公孙离", "张良", "孙尚香"
                , "无名", "流海", "亚瑟", "嬴政","祢衡","芈原","吕布", "秋雅", "夏洛", "公孙离", "张良", "孙尚香", "无名", "流海", "亚瑟", "吕布", "秋雅", "夏洛", "公孙离", "张良", "孙尚香"};
        List<String> data = new ArrayList<>();

        for (String i : arrayData) {
            data.add(i);
        }

        mAdapter = new ContactSortAdapter();
        RecyclerViewUtil.initNoDecoration(this, contact_view.getRecycler(), mAdapter);
        //用名字进行排序 拿到新的集合
        List<SortModel>  stlist = contact_view.sortData(mDataList);
        //排序后没有头像 遍历新的集合 与老集合名字匹配的把头像赋值给新集合
        for (SortModel s:stlist) {
            for (SortModel s1:mDataList) {
                if(s.getName().equals(s1.getName())){
                    s.setIcon(s1.getIcon());
                }
            }

        }
        contact_view.initData(stlist);
        mAdapter.initData(stlist);
        //设置条目点击监听
        mAdapter.setOnContactRecyclerViewItemCLickListener(this);
    }

    private void initView() {
        ed_search = findViewById(R.id.ed_search);
        contact_view = findViewById(R.id.contact_view);
        ed_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (TextUtils.isEmpty(s.toString().trim())) {
                    contact_view.initData(mDataList);
                    mAdapter.initData(mDataList);

                } else {
                    mAdapter.initData(contact_view.updateData(s.toString()));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void OnItemClick(int position) {
        if(position==0) {
            //新的好友
            startActivity(new Intent(this, NewFriendsActivity.class));
        }else if(position==1){
            //创建群聊
            startActivity(new Intent(this, CreateGroupChatActivity.class));
        }else {
            //聊天
            startActivity(new Intent(this, ChatActivity.class));
        }
    }
}
