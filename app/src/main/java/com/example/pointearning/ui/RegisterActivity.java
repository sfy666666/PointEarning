package com.example.pointearning.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pointearning.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 注册
 */
public class RegisterActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {

    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.text_area)
    TextView textArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        spinner.setOnItemSelectedListener(this);

        String[] curs = getResources().getStringArray(R.array.cities_data);
        //将写好的personal_spinner引用进来，此时改变的是选中后的情况，如果这里不想修改，可引用Android默认的布局，
        //比如android.R.layout.simple_spinner_item
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.item_spinner, curs);
        //此处修改的部分为 点击后弹出的选择框，同上可引用自己写的布局文件，也可以使用默认布局，此处使用的是默认布局
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


    }

    @OnClick({R.id.btn_register, R.id.img_down, R.id.text_area, R.id.tv_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                // TODO: 2019-09-25 注册成功
                finish();
                break;
            case R.id.img_down:
            case R.id.text_area:
                spinner.performClick();
                break;
            case R.id.tv_login:
                //立即登录或注册后关掉当前页面和登录页面 忘记密码页面
                finish();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String s = getResources().getStringArray(R.array.cities_data)[position];
//        String[] split = s.split("\\+");
//        textArea.setText("+" + split[1]);

        textArea.setText(s.replace("+"," +"));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
