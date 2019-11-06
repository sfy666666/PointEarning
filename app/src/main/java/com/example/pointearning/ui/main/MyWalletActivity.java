package com.example.pointearning.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pointearning.R;
import com.example.pointearning.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的钱包
 */
public class MyWalletActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.yue)
    TextView yue;
    @BindView(R.id.btn_chongzhi)
    Button btnChongzhi;
    @BindView(R.id.btn_tixian)
    Button btnTixian;
    @BindView(R.id.bank_card)
    TextView bankCard;
    @BindView(R.id.zhangdan)
    TextView zhangdan;
    @BindView(R.id.erweima)
    TextView erweima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wallet);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back, R.id.yue, R.id.btn_chongzhi, R.id.btn_tixian, R.id.bank_card, R.id.zhangdan, R.id.erweima})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.yue:
                break;
            case R.id.btn_chongzhi:
                break;
            case R.id.btn_tixian:
                break;
            case R.id.bank_card:
                break;
            case R.id.zhangdan:
                break;
            case R.id.erweima:
                break;
        }
    }
}
