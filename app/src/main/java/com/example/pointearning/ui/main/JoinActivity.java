package com.example.pointearning.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.pointearning.R;
import com.example.pointearning.ui.BaseActivity;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 加入点赚通
 */

public class JoinActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.title)
    TextView title;
    /*@BindView(R.id.scroll_view)
    ScrollView scrollView;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        //绑定控件
        ButterKnife.bind(this);
//        AutoUtils.auto(scrollView);


    }


    @OnClick({R.id.back, R.id.title})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.title:
                break;
        }
    }
}
