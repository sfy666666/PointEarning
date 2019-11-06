package com.example.pointearning.ui.main;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.pointearning.R;
import com.example.pointearning.bean.AttentionEntity;
import com.example.pointearning.ui.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 关注文章
 */
public class FocusOnArticleActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    List<AttentionEntity> mDataList;
    BaseQuickAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus_on_article);
        ButterKnife.bind(this);
        initData();
        bindView();
    }


    private void initData() {
        mDataList=new ArrayList<>();
        mDataList.add(new AttentionEntity(0,R.drawable.hhh,"Rose",getResources().getString(R.string.contene_one),true,R.drawable.iii,"31分钟前"));
        mDataList.add(new AttentionEntity(0,R.drawable.hhh,"阳光的阳光",getResources().getString(R.string.contene_two),true,R.drawable.iii,"41分钟前"));
        mDataList.add(new AttentionEntity(0,R.drawable.hhh,"改变",getResources().getString(R.string.contene_one),false,R.drawable.iii,"51分钟前"));
        mDataList.add(new AttentionEntity(0,R.drawable.hhh,"只可远观",getResources().getString(R.string.contene_two),true,R.drawable.iii,"1小时前"));
        mDataList.add(new AttentionEntity(0,R.drawable.hhh,"出人头地",getResources().getString(R.string.contene_one),true,R.drawable.iii,"3小时前"));
        mDataList.add(new AttentionEntity(0,R.drawable.hhh,"Matilda",getResources().getString(R.string.contene_two),false,R.drawable.iii,"5小时前"));
        mDataList.add(new AttentionEntity(0,R.drawable.hhh,"Matilda",getResources().getString(R.string.contene_one),false,R.drawable.iii,"10小时前"));
        mDataList.add(new AttentionEntity(0,R.drawable.hhh,"Matilda",getResources().getString(R.string.contene_two),true,R.drawable.iii,"1天前"));
        mDataList.add(new AttentionEntity(0,R.drawable.hhh,"Matilda",getResources().getString(R.string.contene_one),true,R.drawable.iii,"9月18日12:00"));

    }

    private void bindView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter = new BaseQuickAdapter<AttentionEntity, BaseViewHolder>(R.layout.item_focus_on_article,mDataList) {
            @Override
            protected void convert(BaseViewHolder helper, AttentionEntity item) {
                helper.setImageResource(R.id.icon,item.getIcon())
                        .setImageResource(R.id.big_img,item.getBigImg())
                        .setText(R.id.name,item.getName())
                        .setText(R.id.content,item.getContent())
                        .setText(R.id.time,item.getTime());
                if(item.isStatus()){
                    helper.setText(R.id.btn_attention,"取消关注")
                    .setTextColor(R.id.btn_attention, Color.parseColor("#BFBFBF"))
                    .setBackgroundRes(R.id.btn_attention,R.drawable.btn);
                }else{
                    helper.setText(R.id.btn_attention,"+关注")
                    .setTextColor(R.id.btn_attention, Color.WHITE)
                    .setBackgroundRes(R.id.btn_attention,R.drawable.btns);
                }
            }
        });
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
        });
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
