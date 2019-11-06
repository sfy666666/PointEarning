package com.example.pointearning.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.pointearning.R;
import com.example.pointearning.bean.CommentEntity;
import com.example.pointearning.bean.CommunityEntity;
import com.example.pointearning.ui.fragment.adapter.CommunityAdapter;
import com.example.pointearning.ui.fragment.adapter.CommunityAdapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * created by shengfeiyu
 * on 2019/9/8
 */
public class TutorDynamicFragment extends BaseFragment {

    private View view;
    private RecyclerView mRecyclerView;
    List<CommunityEntity> mDataList  = new ArrayList<>();
    private BaseQuickAdapter mRVAdapter;

    //community_recyclerview_vertical_item1
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tutordynamic, container, false);
        //绑定控件
        bindView();
        //准备数据
        initData();
        //创建布局管理器
        LinearLayoutManager verticalManager = new LinearLayoutManager(getActivity()){
            @Override
            public boolean canScrollVertically() {
                //禁止垂直滑动解决与父层ScrollView的滑动冲突
                return false;
            }
        };
        //设置管理器
        mRecyclerView.setLayoutManager(verticalManager);
        //创建适配器

        mRVAdapter =  new BaseQuickAdapter<CommunityEntity,BaseViewHolder>(R.layout.item_tutor_dynamic_fragment_rv,mDataList){

            @Override
            protected void convert(BaseViewHolder helper, CommunityEntity item) {
                helper.setText(R.id.tv_name,item.getName())
                        .setText(R.id.tv_time,item.getTime())
                        .setText(R.id.tv_content,item.getContent())
                        .setImageResource(R.id.iv_image,item.getImage1())
                        .setImageResource(R.id.iv_icon,item.getIcon());

            }
        };
//        mRVAdapter = new CommunityAdapter2(mDataList,getActivity());
        //设置适配器
        mRecyclerView.setAdapter(mRVAdapter);
        return view;
    }

    private void initData() {
        CommunityEntity communityEntity1 = new CommunityEntity(R.drawable.dongtaitouxiang, "白雅晴", "31分钟前", getResources().getString(R.string.contene_two), R.drawable.iii);
        CommunityEntity communityEntity2 = new CommunityEntity(R.drawable.dongtaitouxiang, "白雅晴", "50分钟前", getResources().getString(R.string.contene_two), R.drawable.iii);
        CommunityEntity communityEntity3 = new CommunityEntity(R.drawable.dongtaitouxiang, "白雅晴", "55分钟前", getResources().getString(R.string.contene_two), R.drawable.iii);
        mDataList.add(communityEntity1);
        mDataList.add(communityEntity2);
        mDataList.add(communityEntity3);
    }

    private void bindView() {
        mRecyclerView = view.findViewById(R.id.recycler_view);
    }
}
