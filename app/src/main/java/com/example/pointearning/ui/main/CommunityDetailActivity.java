package com.example.pointearning.ui.main;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.pointearning.R;
import com.example.pointearning.ui.BaseActivity;
import com.example.pointearning.ui.CommentActivity;
import com.example.pointearning.ui.fragment.CommunityCommentFragment;
import com.example.pointearning.ui.main.adapter.MainViewPagerAdapter;
import com.example.pointearning.widget.MyViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 社区详情页面
 */
public class CommunityDetailActivity extends BaseActivity{

    @BindView(R.id.tv_comment)
    TextView tvComment;
    @BindView(R.id.iv_tab_comment)
    ImageView ivTabComment;
    @BindView(R.id.tv_forward)
    TextView tvForward;
    @BindView(R.id.iv_tab_forward)
    ImageView ivTabForward;
    @BindView(R.id.tv_like)
    TextView tvLike;
    @BindView(R.id.iv_tab_like)
    ImageView ivTabLike;
    @BindView(R.id.tab_comment)
    RelativeLayout tabComment;
    @BindView(R.id.tab_forward)
    RelativeLayout tabForward;
    @BindView(R.id.tab_like)
    RelativeLayout tabLike;
    List<Fragment> mFragmentList = new ArrayList<>();
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.iv_icon)
    ImageView ivIcon;
    @BindView(R.id.big_img)
    ImageView bigImg;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.iv_qq)
    ImageView ivQq;
    @BindView(R.id.rlt)
    RelativeLayout rlt;
    @BindView(R.id.rlt2)
    RelativeLayout rlt2;
    @BindView(R.id.my_view_pager)
    MyViewPager myViewPager;
    @BindView(R.id.forward_bottom)
    LinearLayout forwardBottom;
    @BindView(R.id.iv_message)
    ImageView ivMessage;
    @BindView(R.id.tv_message)
    TextView tvMessage;
    @BindView(R.id.message_bottom)
    LinearLayout messageBottom;
    @BindView(R.id.like_bottom)
    LinearLayout likeBottom;
    private MainViewPagerAdapter mVPAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_detail);
        ButterKnife.bind(this);
        //准备数据
        initData();
        //创建适配器
        mVPAdapter = new MainViewPagerAdapter(getSupportFragmentManager(), mFragmentList);
        //设置适配器
        myViewPager.setAdapter(mVPAdapter);
        myViewPager.setOffscreenPageLimit(3);
        myViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        checkComment();
                        break;
                    case 1:
                        checkForward();
                        break;
                    case 2:
                        checkLike();
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    private void initData() {
        mFragmentList.add(new CommunityCommentFragment(1));
        mFragmentList.add(new CommunityCommentFragment(2));
        mFragmentList.add(new CommunityCommentFragment(3));

    }





    @OnClick({R.id.tab_comment, R.id.tab_forward, R.id.tab_like,R.id.back,R.id.message_bottom})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tab_comment:
                checkComment();
                break;
            case R.id.tab_forward:
                checkForward();
                break;
            case R.id.tab_like:
                checkLike();
                break;
            case R.id.back:
                finish();
                break;
            case R.id.message_bottom:
                Intent intent = new Intent(CommunityDetailActivity.this, CommentActivity.class);
                startActivity(intent);
                break;


        }
    }

    private void checkLike() {
        myViewPager.setCurrentItem(2);
        ivTabComment.setVisibility(View.INVISIBLE);
        ivTabForward.setVisibility(View.INVISIBLE);
        ivTabLike.setVisibility(View.VISIBLE);

        tvComment.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        tvForward.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        tvLike.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
    }

    private void checkForward() {
        myViewPager.setCurrentItem(1);
        ivTabComment.setVisibility(View.INVISIBLE);
        ivTabForward.setVisibility(View.VISIBLE);
        ivTabLike.setVisibility(View.INVISIBLE);

        tvComment.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        tvForward.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tvLike.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
    }

    private void checkComment() {
        myViewPager.setCurrentItem(0);
        ivTabComment.setVisibility(View.VISIBLE);
        ivTabForward.setVisibility(View.INVISIBLE);
        ivTabLike.setVisibility(View.INVISIBLE);

        tvComment.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tvForward.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        tvLike.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
    }
}
