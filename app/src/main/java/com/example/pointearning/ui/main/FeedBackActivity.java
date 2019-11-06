package com.example.pointearning.ui.main;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pointearning.R;
import com.example.pointearning.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 意见反馈
 */
public class FeedBackActivity extends BaseActivity {

    Toast toast;


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.zhanghaowenti)
    Button zhanghaowenti;
    @BindView(R.id.zhifuwenti)
    Button zhifuwenti;
    @BindView(R.id.qitawenti)
    Button qitawenti;
    @BindView(R.id.submit)
    Button submit;
    @BindView(R.id.input)
    EditText input;
    @BindView(R.id.zishuxianzhi)
    TextView zishuxianzhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        ButterKnife.bind(this);
        toast = Toast.makeText(FeedBackActivity.this, null, Toast.LENGTH_SHORT);
        input.addTextChangedListener(new TextWatcher() {
            private CharSequence temp;
            private int selectionStart;
            private int selectionEnd;

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                temp = s;
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
//                int number = 10 - s.length();
                int number = s.length();
                zishuxianzhi.setText("" + number);
                selectionStart = input.getSelectionStart();
                selectionEnd = input.getSelectionEnd();
                if (temp.length() > 200) {
                    s.delete(selectionStart - 1, selectionEnd);
                    int tempSelection = selectionStart;
                    input.setText(s);
                    input.setSelection(tempSelection);//设置光标在最后
                    toast.setText("已超过最大字数");
                    toast.show();
                }
            }
        });
    }

    @OnClick({R.id.back, R.id.title, R.id.zhanghaowenti, R.id.zhifuwenti, R.id.qitawenti, R.id.submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.title:
                break;

                /*input.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        //超过200字禁止输入
                        if (s.length() >= 10) {
//                            input.setEnabled(false);//输入框不可输入但是点击事件不执行
                            input.setFocusable(false);//输入框不可输入  点击事件执行
                            toast.setText("已超过最大字数限制");
                            toast.show();

                        }

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });*/




            case R.id.zhanghaowenti:
                zhanghaowenti.setBackgroundResource(R.drawable.hong);
                zhifuwenti.setBackgroundResource(R.drawable.hui);
                qitawenti.setBackgroundResource(R.drawable.hui);
                zhanghaowenti.setTextColor(Color.parseColor("#FF564B"));
                zhifuwenti.setTextColor(Color.parseColor("#CDCDCD"));
                qitawenti.setTextColor(Color.parseColor("#CDCDCD"));
                break;
            case R.id.zhifuwenti:
                zhifuwenti.setBackgroundResource(R.drawable.hong);
                zhanghaowenti.setBackgroundResource(R.drawable.hui);
                qitawenti.setBackgroundResource(R.drawable.hui);
                zhifuwenti.setTextColor(Color.parseColor("#FF564B"));
                qitawenti.setTextColor(Color.parseColor("#CDCDCD"));
                zhanghaowenti.setTextColor(Color.parseColor("#CDCDCD"));
                break;
            case R.id.qitawenti:
                qitawenti.setBackgroundResource(R.drawable.hong);
                zhifuwenti.setBackgroundResource(R.drawable.hui);
                zhanghaowenti.setBackgroundResource(R.drawable.hui);
                qitawenti.setTextColor(Color.parseColor("#FF564B"));
                zhifuwenti.setTextColor(Color.parseColor("#CDCDCD"));
                zhanghaowenti.setTextColor(Color.parseColor("#CDCDCD"));
                break;
            case R.id.submit:
                Toast toast = Toast.makeText(this, null, Toast.LENGTH_SHORT);
                toast.setText("已提交");
                toast.show();
                break;
        }
    }


}
