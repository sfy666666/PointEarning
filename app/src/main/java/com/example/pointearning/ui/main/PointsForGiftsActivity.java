package com.example.pointearning.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pointearning.R;
import com.example.pointearning.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 积分换好礼
 */

public class PointsForGiftsActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.btn_send1)
    Button btnSend1;
    @BindView(R.id.btn_send_two)
    Button btnSendTwo;
    @BindView(R.id.btn_send_three)
    Button btnSendThree;
    @BindView(R.id.btn_send_four)
    Button btnSendFour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points_for_gifts);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.back, R.id.btn_send1, R.id.btn_send_two, R.id.btn_send_three, R.id.btn_send_four})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.btn_send1:
            case R.id.btn_send_two:
            case R.id.btn_send_three:
            case R.id.btn_send_four:
                Toast toast = Toast.makeText(this, null, Toast.LENGTH_SHORT);
                toast.setText("即将开启兑换");
                toast.show();
                break;
        }
    }
}
