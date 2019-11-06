package com.example.pointearning.ui.main;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.pointearning.R;
import com.example.pointearning.ui.BaseActivity;
import com.example.pointearning.ui.fragment.TutorDynamicFragment;
import com.example.pointearning.ui.fragment.TutorEvaluationFragment;
import com.example.pointearning.ui.fragment.TutorIntroductionFragment;
import com.example.pointearning.ui.main.adapter.MainViewPagerAdapter;
import com.example.pointearning.widget.MyViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by shengfeiyu
 * on  2019年9月8日
 * 导师详情页面
 */
public class TutorDetailActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.tv_introduction2)
    TextView tvIntroduction2;
    @BindView(R.id.iv_tab_introduction2)
    ImageView ivTabIntroduction2;
    @BindView(R.id.tv_evaluation)
    TextView tvEvaluation;
    @BindView(R.id.iv_tab_evaluation)
    ImageView ivTabEvaluation;
    @BindView(R.id.tv_dynamic)
    TextView tvDynamic;
    @BindView(R.id.iv_tab_dynamic)
    ImageView ivTabDynamic;
    @BindView(R.id.tab_introduction)
    RelativeLayout tabIntroduction;
    @BindView(R.id.tab_evaluation)
    RelativeLayout tabEvaluation;
    @BindView(R.id.tab_dynamic)
    RelativeLayout tabDynamic;
    private MyViewPager mViewPager;

    List<Fragment> mDataList = new ArrayList<>();
    private MainViewPagerAdapter mPVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_detail);
        ButterKnife.bind(this);
        //绑定控件
        bindView();
        //准备数据
        initData();
        //创建并设置适配器
        mPVAdapter = new MainViewPagerAdapter(getSupportFragmentManager(), mDataList);
        mViewPager.setAdapter(mPVAdapter);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        checkIntroduction();
                        break;
                    case 1:
                        checkEvaluation();
                        break;
                    case 2:
                        checkDynamic();
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initData() {
        mDataList.add(new TutorIntroductionFragment());
        mDataList.add(new TutorEvaluationFragment(1));
        mDataList.add(new TutorDynamicFragment());

    }

    private void bindView() {
        mViewPager = findViewById(R.id.view_pager);
        ImageView imageView = findViewById(R.id.back);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //返回
            case R.id.back:
                finish();
                break;


        }
    }

    @OnClick({R.id.tab_introduction, R.id.tab_evaluation, R.id.tab_dynamic})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tab_introduction:
                checkIntroduction();
                break;
            case R.id.tab_evaluation:
                checkEvaluation();
                break;
            case R.id.tab_dynamic:
                checkDynamic();
                break;
        }
    }

    private void checkDynamic() {
        mViewPager.setCurrentItem(2);
        ivTabIntroduction2.setVisibility(View.INVISIBLE);
        ivTabEvaluation.setVisibility(View.INVISIBLE);
        ivTabDynamic.setVisibility(View.VISIBLE);

        tvIntroduction2.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        tvEvaluation.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        tvDynamic.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
    }

    private void checkEvaluation() {
        mViewPager.setCurrentItem(1);
        ivTabIntroduction2.setVisibility(View.INVISIBLE);
        ivTabEvaluation.setVisibility(View.VISIBLE);
        ivTabDynamic.setVisibility(View.INVISIBLE);

        tvIntroduction2.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        tvEvaluation.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tvDynamic.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
    }

    private void checkIntroduction() {
        mViewPager.setCurrentItem(0);
        ivTabIntroduction2.setVisibility(View.VISIBLE);
        ivTabEvaluation.setVisibility(View.INVISIBLE);
        ivTabDynamic.setVisibility(View.INVISIBLE);

        tvIntroduction2.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tvEvaluation.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        tvDynamic.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
    }
}
