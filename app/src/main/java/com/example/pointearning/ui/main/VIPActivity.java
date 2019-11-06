package com.example.pointearning.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.pointearning.R;
import com.example.pointearning.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 会员
 */
public class VIPActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.card)
    View card;
    @BindView(R.id.iv_icon)
    ImageView ivIcon;
    @BindView(R.id.tv_vip)
    TextView tvVip;
    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.introduction)
    TextView introduction;
    @BindView(R.id.chengzhangzhi)
    TextView chengzhangzhi;
    @BindView(R.id.integral)
    TextView integral;
    @BindView(R.id.chengzhangzhiwenzi)
    TextView chengzhangzhiwenzi;
    @BindView(R.id.rlt_chengzhangzhi)
    RelativeLayout rltChengzhangzhi;
    @BindView(R.id.wodetequan)
    TextView wodetequan;
    @BindView(R.id.nichengshezhi)
    TextView nichengshezhi;
    @BindView(R.id.rlt_wodetequan)
    RelativeLayout rltWodetequan;
    @BindView(R.id.rlt_chengzhangrenwu)
    RelativeLayout rltChengzhangrenwu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back, R.id.iv_icon, R.id.tv_vip, R.id.user_name, R.id.introduction, R.id.chengzhangzhi, R.id.integral})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
                //用户头像
            case R.id.iv_icon:
                break;
                //续费会员
            case R.id.tv_vip:
                break;
                //用户名
            case R.id.user_name:
                break;
                //用户简介
            case R.id.introduction:
                break;
                //用户成长值
            case R.id.chengzhangzhi:
                break;
                //积分
            case R.id.integral:

                break;
        }
    }
}
