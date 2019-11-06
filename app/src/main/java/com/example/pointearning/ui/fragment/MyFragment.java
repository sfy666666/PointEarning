package com.example.pointearning.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pointearning.R;
import com.example.pointearning.ui.main.AttentionActivity;
import com.example.pointearning.ui.main.FansActivity;
import com.example.pointearning.ui.main.FeedBackActivity;
import com.example.pointearning.ui.main.FocusOnArticleActivity;
import com.example.pointearning.ui.main.MyWalletActivity;
import com.example.pointearning.ui.main.SettingsActivity;
import com.example.pointearning.ui.main.VIPActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * created by shengfeiyu
 * on 2019/9/6
 * 我的  页面
 */
public class MyFragment extends BaseFragment {
    @BindView(R.id.iv_icon)
    ImageView ivIcon;
    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.introduction)
    TextView introduction;
    @BindView(R.id.favorite_count)
    TextView favoriteCount;
    @BindView(R.id.attention_count)
    TextView attentionCount;
    @BindView(R.id.fans_count)
    TextView fansCount;
    @BindView(R.id.red_envelope_count)
    TextView redEnvelopeCount;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.settings, R.id.favorite_count, R.id.favorite, R.id.attention_count, R.id.attention, R.id.fans_count, R.id.fans, R.id.vip_card, R.id.wallet, R.id.attention_article, R.id.red_envelope, R.id.my_integral, R.id.invite_friends, R.id.my_bank_card, R.id.help_center})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //设置
            case R.id.settings:
                startActivity(new Intent(getActivity(), SettingsActivity.class));
                break;
            //收藏
            case R.id.favorite_count:
            case R.id.favorite:
                break;
            //关注
            case R.id.attention_count:
            case R.id.attention:
                startActivity(new Intent(getActivity(), AttentionActivity.class));
                break;
            //粉丝
            case R.id.fans_count:
            case R.id.fans:
                startActivity(new Intent(getActivity(), FansActivity.class));
                break;
            //会员卡
            case R.id.vip_card:
                startActivity(new Intent(getActivity(), VIPActivity.class));
                break;
            //我的钱包
            case R.id.wallet:
                startActivity(new Intent(getActivity(), MyWalletActivity.class));
                break;
            //关注文章
            case R.id.attention_article:
                startActivity(new Intent(getActivity(), FocusOnArticleActivity.class));
                break;
            //我的红包
            case R.id.red_envelope:
                break;
            //我的积分
            case R.id.my_integral:
                break;
            //邀请好友
            case R.id.invite_friends:
                break;
            //我的银行卡
            case R.id.my_bank_card:
                break;
            //帮助中心
            case R.id.help_center:
                startActivity(new Intent(getActivity(), FeedBackActivity.class));
                break;
        }
    }
}
