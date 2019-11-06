package com.example.pointearning.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pointearning.R;
import com.example.pointearning.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 设置
 */
public class SettingsActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.gerenziliaoshezhi)
    TextView gerenziliaoshezhi;
    @BindView(R.id.qingchuhuancun)
    TextView qingchuhuancun;
    @BindView(R.id.guanyuwomen)
    TextView guanyuwomen;
    @BindView(R.id.tebieganxie)
    TextView tebieganxie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back, R.id.gerenziliaoshezhi, R.id.qingchuhuancun, R.id.guanyuwomen, R.id.tebieganxie})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.gerenziliaoshezhi:
                startActivity(new Intent(this, PersonalSettingsActivity.class));
                break;
            case R.id.qingchuhuancun:
                break;
            case R.id.guanyuwomen:
                break;
            case R.id.tebieganxie:
                break;
        }
    }
}
