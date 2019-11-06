package com.example.pointearning.ui;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.pointearning.R;
import com.example.pointearning.ui.fragment.CommunityFragment;
import com.example.pointearning.ui.fragment.HomeFragment;
import com.example.pointearning.ui.fragment.HomeFragment1;
import com.example.pointearning.ui.fragment.IMFragment;
import com.example.pointearning.ui.fragment.MyFragment;
import com.example.pointearning.ui.main.adapter.MainViewPagerAdapter;
import com.example.pointearning.zxing.activity.CaptureActivity;
import com.example.pointearning.zxing.util.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 首页
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.iv_tab_home_bg)
    ImageView ivTabHomeBg;
    @BindView(R.id.iv_tab_home_check)
    ImageView ivTabHomeCheck;
    @BindView(R.id.ll_tab_home)
    LinearLayout llTabHome;
    @BindView(R.id.tv_tab_home)
    TextView tvTabHome;
    @BindView(R.id.tab_home)
    RelativeLayout tabHome;
    @BindView(R.id.iv_tab_community_bg)
    ImageView ivTabCommunityBg;
    @BindView(R.id.iv_tab_community_check)
    ImageView ivTabCommunityCheck;
    @BindView(R.id.ll_tab_community)
    LinearLayout llTabCommunity;
    @BindView(R.id.tv_tab_community)
    TextView tvTabCommunity;
    @BindView(R.id.tab_community)
    RelativeLayout tabCommunity;
    @BindView(R.id.iv_tab_im_bg)
    ImageView ivTabImBg;
    @BindView(R.id.iv_tab_im_check)
    ImageView ivTabImCheck;
    @BindView(R.id.ll_tab_im)
    LinearLayout llTabIm;
    @BindView(R.id.tv_tab_im)
    TextView tvTabIm;
    @BindView(R.id.tab_im)
    RelativeLayout tabIm;
    @BindView(R.id.iv_tab_my_bg)
    ImageView ivTabMyBg;
    @BindView(R.id.iv_tab_my_check)
    ImageView ivTabMyCheck;
    @BindView(R.id.ll_tab_my)
    LinearLayout llTabMy;
    @BindView(R.id.tv_tab_my)
    TextView tvTabMy;
    @BindView(R.id.tab_my)
    RelativeLayout tabMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }


    private void initData() {
        //添加fragment到集合
        List<Fragment> fragmentList = new ArrayList<>();
        CommunityFragment communityFragment = new CommunityFragment();
        HomeFragment1 mainFragment = new HomeFragment1();
        IMFragment IMFragment2 = new IMFragment();
        MyFragment myFragment = new MyFragment();
        fragmentList.add(mainFragment);
        fragmentList.add(communityFragment);
        fragmentList.add(IMFragment2);
        fragmentList.add(myFragment);
        //设置适配器
        viewpager.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager(), fragmentList));

        //设置预加载4页数据 避免切到第3页（或超过第3页）再回到第1页时第1页销毁
        viewpager.setOffscreenPageLimit(4);

        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        checkHome();
                        break;
                    case 1:
                        checkCommunity();
                        break;
                    case 2:
                        checkIM();
                        break;
                    case 3:
                        checkMy();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        //扫描结果回调
//        if (requestCode == Constant.REQ_QR_CODE && resultCode == RESULT_OK) {
//            Bundle bundle = data.getExtras();
//            String scanResult = bundle.getString(Constant.INTENT_EXTRA_KEY_QR_SCAN);
//            //将扫描出的信息显示出来
//            Toast.makeText(MainActivity.this, scanResult, Toast.LENGTH_LONG).show();
//            //用默认浏览器打开扫描得到的地址
//            Intent intent = new Intent();
//            intent.setAction("android.intent.action.VIEW");
//            Uri content_url = Uri.parse(scanResult);
//            intent.setData(content_url);
//            startActivity(intent);
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode) {
//            case Constant.REQ_PERM_CAMERA:
//                // 摄像头权限申请
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    // 获得授权
//                    startQrCode();
//                } else {
//                    // 被禁止授权
//                    Toast.makeText(MainActivity.this, "请至权限中心打开本应用的相机访问权限", Toast.LENGTH_LONG).show();
//                }
//                break;
//            case Constant.REQ_PERM_EXTERNAL_STORAGE:
//                // 文件读写权限申请
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    // 获得授权
//                    startQrCode();
//                } else {
//                    // 被禁止授权
//                    Toast.makeText(MainActivity.this, "请至权限中心打开本应用的文件读写权限", Toast.LENGTH_LONG).show();
//                }
//                break;
//        }
//    }
//
//    // 开始扫码
//    private void startQrCode() {
//        // 申请相机权限
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//            // 申请权限
//            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, Constant.REQ_PERM_CAMERA);
//            return;
//        }
//        // 申请文件读写权限（部分朋友遇到相册选图需要读写权限的情况，这里一并写一下）
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//            // 申请权限
//            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, Constant.REQ_PERM_EXTERNAL_STORAGE);
//            return;
//        }
//        // 二维码扫码
//        Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
//        startActivityForResult(intent, Constant.REQ_QR_CODE);
//    }


    private void reset() {
        ivTabHomeBg.setImageResource(R.drawable.ic_tab_uncheck);
        ivTabCommunityBg.setImageResource(R.drawable.ic_tab_uncheck);
        ivTabImBg.setImageResource(R.drawable.ic_tab_uncheck);
        ivTabMyBg.setImageResource(R.drawable.ic_tab_uncheck);
        llTabHome.setPadding(0, 0, 0, 0);
        llTabCommunity.setPadding(0, 0, 0, 0);
        llTabIm.setPadding(0, 0, 0, 0);
        llTabMy.setPadding(0, 0, 0, 0);
        ivTabHomeCheck.setImageResource(R.drawable.ic_home_uncheck);
        ivTabCommunityCheck.setImageResource(R.drawable.ic_community_uncheck);
        ivTabImCheck.setImageResource(R.drawable.ic_im_uncheck);
        ivTabMyCheck.setImageResource(R.drawable.ic_my_uncheck);
        tvTabHome.setTextColor(Color.BLACK);
        tvTabCommunity.setTextColor(Color.BLACK);
        tvTabIm.setTextColor(Color.BLACK);
        tvTabMy.setTextColor(Color.BLACK);
    }


    private void checkHome() {
        reset();
        ivTabHomeBg.setImageResource(R.drawable.ic_tab_checked);
        llTabHome.setPadding(0, 0, 0, dp2px(10));
        ivTabHomeCheck.setImageResource(R.drawable.ic_home_checked);
        tvTabHome.setTextColor(Color.parseColor("#FF554B"));
        viewpager.setCurrentItem(0);
    }

    private void checkCommunity() {
        reset();
        ivTabCommunityBg.setImageResource(R.drawable.ic_tab_checked);
        llTabCommunity.setPadding(0, 0, 0, dp2px(10));
        ivTabCommunityCheck.setImageResource(R.drawable.ic_community_checked);
        tvTabCommunity.setTextColor(Color.parseColor("#FF554B"));
        viewpager.setCurrentItem(1);
    }

    private void checkIM() {
        reset();
        ivTabImBg.setImageResource(R.drawable.ic_tab_checked);
        llTabIm.setPadding(0, 0, 0, dp2px(10));
        ivTabImCheck.setImageResource(R.drawable.ic_im_checked);
        tvTabIm.setTextColor(Color.parseColor("#FF554B"));
        viewpager.setCurrentItem(2);
    }

    private void checkMy() {
        reset();
        ivTabMyBg.setImageResource(R.drawable.ic_tab_checked);
        llTabMy.setPadding(0, 0, 0, dp2px(10));
        ivTabMyCheck.setImageResource(R.drawable.ic_my_checked);
        tvTabMy.setTextColor(Color.parseColor("#FF554B"));
        viewpager.setCurrentItem(3);
    }

    @OnClick({R.id.tab_home, R.id.tab_community, R.id.tab_im, R.id.tab_my})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tab_home:
                checkHome();
                break;
            case R.id.tab_community:
                checkCommunity();
                break;
            case R.id.tab_im:
                checkIM();
                break;
            case R.id.tab_my:
                checkMy();
                break;
        }
    }

    private int dp2px(int dp) {//dp转换为px
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }
}
