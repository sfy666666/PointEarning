package com.example.pointearning.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.pointearning.R;
import com.example.pointearning.ui.BaseActivity;
import com.example.pointearning.ui.fragment.adapter.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends BaseActivity implements View.OnClickListener {

    private SearchView mSearchView;
    private RecyclerView mRVSearchRecoding;//搜索记录
    private RecyclerView mRVHotSearch;//热门搜索
    List<String> mDataList1 =new ArrayList<>();//搜索记录数据
    List<String> mDataList2 =new ArrayList<>();//热门搜索数据
    BaseQuickAdapter mRVSearchRecodingAdapter;
    BaseQuickAdapter mRVHotSearchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //绑定控件
        bindView();
        //准备数据
        initData();
        //设置布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(this, 4);
        mRVSearchRecoding.setLayoutManager(gridLayoutManager);
        mRVHotSearch.setLayoutManager(gridLayoutManager2);
        //设置适配器
        mRVSearchRecoding.setAdapter(mRVSearchRecodingAdapter = new BaseQuickAdapter(R.layout.item_rv_search_recoding, mDataList1) {
            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                   Button btn= holder.itemView.findViewById(R.id.btn_search_item);
                   btn.setFocusable(false);
                   btn.setText(mDataList1.get(position));
            }

            @Override
            protected void convert(BaseViewHolder helper, Object item) {
//                helper.setText(R.id.btn_search_item, item.toString());
            }



        });

        mRVHotSearch.setAdapter(mRVHotSearchAdapter = new BaseQuickAdapter(R.layout.item_rv_hot_search, mDataList2) {
            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                Button btn= holder.itemView.findViewById(R.id.btn_search_item);
                btn.setText(mDataList2.get(position));
            }

            @Override
            protected void convert(BaseViewHolder helper, Object item) {
//                helper.setText(R.id.btn_search_item, item.toString());
            }



        });

        //搜索记录长按删除
        mRVSearchRecodingAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                mDataList1.remove(position);
                mRVSearchRecodingAdapter.notifyDataSetChanged();
                Toast.makeText(SearchActivity.this, "已删除此条记录", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        mRVSearchRecodingAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                Toast.makeText(SearchActivity.this, position+"", Toast.LENGTH_SHORT).show();
//                mSearchView.setQueryHint(mDataList1.get(position));
                startActivity(new Intent(SearchActivity.this,TutorDetailActivity.class));
            }
        });
        mRVHotSearchAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                Toast.makeText(SearchActivity.this, position+"", Toast.LENGTH_SHORT).show();
//                mSearchView.setQueryHint(mDataList1.get(position));
                startActivity(new Intent(SearchActivity.this,TutorDetailActivity.class));
            }
        });
    }

    private void initData() {
        //搜索记录数据
        for (int i = 0; i <2 ; i++) {
            mDataList1.add("白雅晴");
            mDataList1.add("李元");
            mDataList1.add("孙长生");
        }

        //热门搜索数据
        for (int i = 0; i <4 ; i++) {
            mDataList2.add("李元");
            mDataList2.add("白雅晴");
        }

    }

    private void bindView() {
        mSearchView = findViewById(R.id.search_view);
        //设置搜索框内字体颜色
        int id = mSearchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        TextView textView =mSearchView.findViewById(id);
        textView.setTextColor(Color.parseColor("#AAAAAA"));

        TextView delete = findViewById(R.id.delete);
        TextView cancel = findViewById(R.id.cancel);
        delete.setOnClickListener(this);
        cancel.setOnClickListener(this);

        mRVSearchRecoding = findViewById(R.id.rv_search_recoding);
        mRVHotSearch = findViewById(R.id.rv_hot_search);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //删除搜索记录
            case R.id.delete:
                mDataList1.clear();
                mRVSearchRecodingAdapter.notifyDataSetChanged();
                break;
                //取消返回上一页
            case R.id.cancel:finish();break;

        }
    }
}
