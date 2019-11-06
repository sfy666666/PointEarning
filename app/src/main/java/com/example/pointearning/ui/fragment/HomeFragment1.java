package com.example.pointearning.ui.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.pointearning.R;
import com.example.pointearning.bean.HomeProjectBean;
import com.example.pointearning.bean.HomeTutorBean;
import com.example.pointearning.bean.HomeTypeBean;
import com.example.pointearning.ui.TutorListActivity;
import com.example.pointearning.ui.main.JoinActivity;
import com.example.pointearning.ui.main.PointsForGiftsActivity;
import com.example.pointearning.ui.main.ProgramDetailActivity;
import com.example.pointearning.ui.main.SearchActivity;
import com.example.pointearning.ui.main.TutorDetailActivity;
import com.example.pointearning.widget.MyViewPager;
import com.example.pointearning.zxing.activity.CaptureActivity;
import com.example.pointearning.zxing.util.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment1 extends Fragment {
    @BindView(R.id.banner)
    MyViewPager banner;
    @BindView(R.id.grid_type)
    RecyclerView gridType;
    @BindView(R.id.rv_project)
    RecyclerView rvProject;
    @BindView(R.id.rv_tutor)
    RecyclerView rvTutor;
    @BindView(R.id.excellent_tutor)
    LinearLayout excellentTutor;
    @BindView(R.id.iv_points_for_gifts)
    ImageView ivPointsForGifts;
    List<HomeTutorBean> mDataList=new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        initBanner();
        initType();
        initProject();
        initTutor();
    }

    private void initBanner() {
        banner.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 200;
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                ImageView iv = (ImageView) View.inflate(getContext(), R.layout.item_banner, null);
                iv.setOnClickListener(v -> startActivity(new Intent(getActivity(), JoinActivity.class)));
                container.addView(iv);
                return iv;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View) object);
            }
        });
    }

    private void initType() {
        BaseQuickAdapter adapter = new BaseQuickAdapter<HomeTypeBean, BaseViewHolder>(R.layout.item_home_type) {
            @Override
            protected void convert(BaseViewHolder helper, HomeTypeBean item) {
                helper.setText(R.id.tv_type, item.getName())
                        .setImageResource(R.id.iv_type, item.getPic());
            }
        };
        gridType.setLayoutManager(new GridLayoutManager(getContext(), 5){
            @Override
            public boolean canScrollVertically() {
                //禁止垂直滑动解决ScrollView滑动冲突
                return false;
            }
        });
        gridType.setAdapter(adapter);
        adapter.setNewData(Constant.getType());
        adapter.setOnItemClickListener((adapter1, view, position) -> {
            pushType(position);
        });
    }

    private void pushType(int position) {
        // TODO: 2019-09-26 事件
        switch (position) {
//            case 0:
//                break;
//            case 1:
//                break;
//            case 2:
//                break;
//            case 3:
//                break;
//            case 4:
//                break;
//            case 5:
//                break;
//            case 6:
//                break;
//            case 7:
//                break;
//            case 8:
//                break;
//            case 9:
//                break;
            default:
                break;
        }
    }

    private void initProject() {
        BaseQuickAdapter adapter = new BaseQuickAdapter<HomeProjectBean, BaseViewHolder>(R.layout.item_home_project) {
            @Override
            protected void convert(BaseViewHolder helper, HomeProjectBean item) {
                helper.setText(R.id.item_project_name, item.getName())
                        .setText(R.id.item_project_content, "简介：" + item.getContent())
                        .setText(R.id.item_project_person, "参与人数：" + item.getPerson() + "人")
                        .setImageResource(R.id.item_project_pic, item.getPic());
            }
        };
        rvProject.setLayoutManager(new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        rvProject.setAdapter(adapter);
        adapter.setNewData(Constant.getProject());
        adapter.setOnItemClickListener((adapter1, view, position) -> {
            // TODO: 2019-09-26 详情页
            startActivity(new Intent(getContext(), ProgramDetailActivity.class));

        });
    }


    private void initTutor() {
        BaseQuickAdapter adapter = new BaseQuickAdapter<HomeTutorBean, BaseViewHolder>(R.layout.item_home_tutor) {
            @Override
            protected void convert(BaseViewHolder helper, HomeTutorBean item) {
                String tag1 = item.getTags().split(",")[0];
                String tag2 = item.getTags().split(",")[1];
                helper.setText(R.id.item_tutor_name, item.getName())
                        .setText(R.id.item_tutor_content, "简介：" + item.getContent())
                        .setText(R.id.item_tutor_hot, item.getHot() + "")
                        .setText(R.id.item_tutor_person, item.getPerson() + "")
                        .setText(R.id.item_tutor_tag1, tag1)
                        .setText(R.id.item_tutor_tag2, tag2)
                        .setImageResource(R.id.item_tutor_pic, item.getPic());
            }
        };
        rvTutor.setLayoutManager(new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        rvTutor.setAdapter(adapter);
        adapter.setNewData(mDataList=Constant.getTutor());
        adapter.setOnItemClickListener((adapter1, view, position) -> {
            // TODO: 2019-09-26 详情页
            startActivity(new Intent(getContext(), TutorDetailActivity.class));
        });


//        adapter.setOnLoadMoreListener(() -> rvTutor.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if (mDataList.size()<10){
//                    mDataList.addAll(Constant.getTutor());
//                }else {
//                    adapter.loadMoreComplete();
//                }
//                adapter.setNewData(mDataList);
//            }
//        },1000));
}

    @OnClick({R.id.ll_search, R.id.qr_code, R.id.excellent_tutor,R.id.iv_points_for_gifts})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_search://搜索
                startActivity(new Intent(getContext(), SearchActivity.class));
                break;
            case R.id.qr_code://扫一扫
                startQrCode();
                break;
            case R.id.excellent_tutor://优秀导师
                startActivity(new Intent(getContext(), TutorListActivity.class));
                break;
            case R.id.iv_points_for_gifts: //积分换好礼
                startActivity(new Intent(getContext(), PointsForGiftsActivity.class));
                break;
        }
    }

    /**
     * 开始扫码
     */
    private void startQrCode() {
        // 申请相机权限
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // 申请权限
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, Constant.REQ_PERM_CAMERA);
            return;
        }
        // 申请文件读写权限（部分朋友遇到相册选图需要读写权限的情况，这里一并写一下）
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // 申请权限
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, Constant.REQ_PERM_EXTERNAL_STORAGE);
            return;
        }
        // 二维码扫码
        Intent intent = new Intent(getContext(), CaptureActivity.class);
        startActivityForResult(intent, Constant.REQ_QR_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case Constant.REQ_PERM_CAMERA:
                // 摄像头权限申请
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 获得授权
                    startQrCode();
                } else {
                    // 被禁止授权
                    Toast.makeText(getContext(), "请至权限中心打开本应用的相机访问权限", Toast.LENGTH_LONG).show();
                }
                break;
            case Constant.REQ_PERM_EXTERNAL_STORAGE:
                // 文件读写权限申请
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 获得授权
                    startQrCode();
                } else {
                    // 被禁止授权
                    Toast.makeText(getContext(), "请至权限中心打开本应用的文件读写权限", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }


}
