package com.example.pointearning.ui.main;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.NonNull;
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
 * 关注
 */
public class AttentionActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    List<AttentionEntity> mDataList;
    BaseQuickAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attention);
        ButterKnife.bind(this);
        initData();
        bindView();
    }

    private void initData() {
        mDataList=new ArrayList<>();
        mDataList.add(new AttentionEntity(0,R.drawable.hhh,"Rose","你还在纠结大盘不放量吗？其实你知道A股已经开始裂变了吗？你还在纠结大盘不放量吗？其实你知道A股已经开始裂变了吗？",true));
        mDataList.add(new AttentionEntity(1,R.drawable.hhh,"阳光的阳光","你还在纠结大盘不放量吗？其实你知道A股已经开始裂变了吗？你还在纠结大盘不放量吗？其实你知道A股已经开始裂变了吗？",false));
        mDataList.add(new AttentionEntity(2,R.drawable.hhh,"改变","你还在纠结大盘不放量吗？其实你知道A股已经开始裂变了吗？你还在纠结大盘不放量吗？其实你知道A股已经开始裂变了吗？",false));
        mDataList.add(new AttentionEntity(3,R.drawable.hhh,"只可远观","你还在纠结大盘不放量吗？其实你知道A股已经开始裂变了吗？你还在纠结大盘不放量吗？其实你知道A股已经开始裂变了吗？",true));
        mDataList.add(new AttentionEntity(4,R.drawable.hhh,"出人头地","你还在纠结大盘不放量吗？其实你知道A股已经开始裂变了吗？你还在纠结大盘不放量吗？其实你知道A股已经开始裂变了吗？",true));
        mDataList.add(new AttentionEntity(5,R.drawable.hhh,"Matilda","你还在纠结大盘不放量吗？其实你知道A股已经开始裂变了吗？你还在纠结大盘不放量吗？其实你知道A股已经开始裂变了吗？",false));
    }

    private void bindView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter = new BaseQuickAdapter<AttentionEntity,BaseViewHolder>(R.layout.item_attention,mDataList) {
            @Override
            protected void convert(BaseViewHolder helper, AttentionEntity item) {
                helper.setImageResource(R.id.icon,item.getIcon())
                        .setText(R.id.name,item.getName())
                        .setText(R.id.content,item.getContent());
                if(item.isStatus()){
                    helper.setText(R.id.btn_attention,"已关注");
                }else{
                    helper.setText(R.id.btn_attention,"互相关注");
                }
            }
        });
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
