package com.example.pointearning.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pointearning.R;
import com.example.pointearning.bean.CommentEntity;
import com.example.pointearning.bean.CommunityEntity;
import com.example.pointearning.bean.NewsEntity;
import com.example.pointearning.ui.fragment.adapter.CommunityCommentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * created by shengfeiyu
 * on 2019/9/6
 * 社区评论页面
 */
public class CommunityCommentFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    int TAB_TYPE;

    public CommunityCommentFragment(int TAB_TYPE) {
        this.TAB_TYPE = TAB_TYPE;
    }

    List<CommentEntity> mDataList = new ArrayList<>();
    private CommunityCommentAdapter mRVAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_community_comment, container, false);
        //绑定控件
        mRecyclerView = view.findViewById(R.id.recycler_view);
        //准备数据
        initData();

        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity()){
            @Override
            public boolean canScrollVertically() {
                //禁止垂直滑动
                return false;
            }
        };
        mRecyclerView.setLayoutManager(linearLayoutManager);

        //创建适配器

        mRVAdapter = new CommunityCommentAdapter(mDataList,TAB_TYPE);

        //设置适配器
        mRecyclerView.setAdapter(mRVAdapter);
        //设置条目监听

        return view;
    }

    private void initData() {
        //TODO
        for (int i = 0; i < 3; i++) {
            CommentEntity a = new CommentEntity(R.drawable.tou, "Rose you", "导师真才实学，感觉理财方面受益颇多", "8-21 1:23");
            mDataList.add(a);
            CommentEntity b = new CommentEntity(R.drawable.ta, "宋嘉树", "说得很好，哈哈", "8-21  3:21");
            mDataList.add(b);
            CommentEntity c = new CommentEntity(R.drawable.tb, "赵亮", "的确是这个样子的", "8-21  3:33");
            mDataList.add(c);
            CommentEntity d = new CommentEntity(R.drawable.tc, "吴昕", "现在理财的种类越来越多了", "8-21  3:55  ");
            mDataList.add(d);
        }
    }
}
