package com.example.pointearning.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pointearning.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 忘记密码
 */
public class ForgotPasswordActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {

    @BindView(R.id.input_phone_number)
    EditText inputPhoneNumber;
    @BindView(R.id.et_input_code)
    EditText etInputCode;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.text_area)
    TextView textArea;
    @BindView(R.id.img_down)
    ImageView imgDown;
    @BindView(R.id.tv_get_code)
    TextView tvGetCode;
    @BindView(R.id.btn_done)
    Button btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ButterKnife.bind(this);
        spinner.setOnItemSelectedListener(this);
    }

    @OnClick({R.id.text_area, R.id.img_down, R.id.btn_done})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_area:
            case R.id.img_down:
                spinner.performClick();
                break;
            case R.id.btn_done:
                // TODO: 2019-09-25 忘记密码
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
