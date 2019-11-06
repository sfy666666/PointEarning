package com.example.pointearning.ui.main;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.pointearning.R;
import com.example.pointearning.ui.BaseActivity;
import com.example.pointearning.ui.fragment.GuidingMasterFragment;
import com.example.pointearning.ui.fragment.ProgramInformationFragment;
import com.example.pointearning.ui.fragment.SecurityFragment;
import com.example.pointearning.ui.main.adapter.MainViewPagerAdapter;
import com.example.pointearning.widget.ForScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目详情
 */

public class ProgramDetailActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.more)
    ImageView more;
    @BindView(R.id.tv_tab_program_information)
    TextView tvTabProgramInformation;
    @BindView(R.id.iv_tab_program_information)
    ImageView ivTabProgramInformation;
    @BindView(R.id.tv_tab_safe)
    TextView tvTabSafe;
    @BindView(R.id.iv_tab_safe)
    ImageView ivTabSafe;
    @BindView(R.id.tv_tab_teacher)
    TextView tvTabTeacher;
    @BindView(R.id.iv_tab_teacher)
    ImageView ivTabTeacher;
    @BindView(R.id.view_pager)
    ForScrollViewPager viewPager;
    @BindView(R.id.btn_contact_tutor)
    Button btnContactTutor;


    List<Fragment> mDataList = new ArrayList<>();
    @BindView(R.id.tab_information)
    RelativeLayout tabInformation;
    @BindView(R.id.tab_safe)
    RelativeLayout tabSafe;
    @BindView(R.id.tab_teacher)
    RelativeLayout tabTeacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_detail);
        //绑定控件
        ButterKnife.bind(this);
        //准备数据
        initData();
        //设置适配器
        viewPager.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager(), mDataList));

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        checkInformation();
                        break;
                    case 1:
                        checkSafe();
                        break;
                    case 2:
                        checkTeacher();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void initData() {
        mDataList.add(new ProgramInformationFragment());
        mDataList.add(new SecurityFragment());
        mDataList.add(new GuidingMasterFragment());

    }

    @OnClick({R.id.back, R.id.more, R.id.btn_contact_tutor,R.id.tab_information, R.id.tab_safe, R.id.tab_teacher})
    public void onViewClicked(View view) {
        Toast toast = Toast.makeText(this, null, Toast.LENGTH_SHORT);
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.more:
                toast.setText("更多");
                toast.show();
                break;
            case R.id.tab_information:
                checkInformation();
                break;
            case R.id.tab_safe:
                checkSafe();
                break;
            case R.id.tab_teacher:
                checkTeacher();
                break;
            case R.id.btn_contact_tutor:
                toast.setText("联系导师");
                toast.show();
                break;
        }
    }

    private void checkTeacher() {
        viewPager.setCurrentItem(2);
        ivTabTeacher.setVisibility(View.VISIBLE);
        ivTabSafe.setVisibility(View.INVISIBLE);
        ivTabProgramInformation.setVisibility(View.INVISIBLE);
        tvTabTeacher.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tvTabSafe.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        tvTabProgramInformation.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
    }

    private void checkSafe() {
        viewPager.setCurrentItem(1);
        ivTabSafe.setVisibility(View.VISIBLE);
        ivTabProgramInformation.setVisibility(View.INVISIBLE);
        ivTabTeacher.setVisibility(View.INVISIBLE);
        tvTabSafe.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tvTabProgramInformation.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        tvTabTeacher.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
    }

    private void checkInformation() {
        viewPager.setCurrentItem(0);
        ivTabProgramInformation.setVisibility(View.VISIBLE);
        ivTabSafe.setVisibility(View.INVISIBLE);
        ivTabTeacher.setVisibility(View.INVISIBLE);

        tvTabProgramInformation.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tvTabSafe.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        tvTabTeacher.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
    }


}
