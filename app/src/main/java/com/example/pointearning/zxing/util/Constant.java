package com.example.pointearning.zxing.util;

import com.example.pointearning.R;
import com.example.pointearning.bean.HomeProjectBean;
import com.example.pointearning.bean.HomeTutorBean;
import com.example.pointearning.bean.HomeTypeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 常量
 */
public class Constant {
    // request参数
    public static final int REQ_QR_CODE = 11002; // // 打开扫描界面请求码
    public static final int REQ_PERM_CAMERA = 11003; // 打开摄像头
    public static final int REQ_PERM_EXTERNAL_STORAGE = 11004; // 读写文件

    public static final String INTENT_EXTRA_KEY_QR_SCAN = "qr_scan_result";


    public static List<HomeTypeBean> getType() {
        List<HomeTypeBean> list = new ArrayList<>();
        list.add(new HomeTypeBean("投资理财", R.drawable.ic_home_tzlc));
        list.add(new HomeTypeBean("股票证券", R.drawable.ic_home_gpzq));
        list.add(new HomeTypeBean("网赚", R.drawable.ic_home_wz));
        list.add(new HomeTypeBean("兼职", R.drawable.ic_home_jz));
        list.add(new HomeTypeBean("金融大神", R.drawable.ic_home_jrds));
        list.add(new HomeTypeBean("网赚大神", R.drawable.ic_home_wzds));
        list.add(new HomeTypeBean("投资先锋", R.drawable.ic_home_tzxf));
        list.add(new HomeTypeBean("理财项目", R.drawable.ic_home_lcxm));
        list.add(new HomeTypeBean("最佳导师", R.drawable.ic_home_zjds));
        list.add(new HomeTypeBean("全部导师", R.drawable.ic_home_qbds));
        return list;
    }

    public static List<HomeProjectBean> getProject() {
        List<HomeProjectBean> list = new ArrayList<>();
        list.add(new HomeProjectBean("星时代投资金融", "由多位老师整体把握项目经验，整体运营规划", 20, R.drawable.ic_project_one));
        list.add(new HomeProjectBean("云翳科技融资", "由多位老师整体把握项目经验，整体运营规划", 20, R.drawable.yunyi));
        return list;
    }

    public static List<HomeTutorBean> getTutor() {
        List<HomeTutorBean> list = new ArrayList<>();
        list.add(new HomeTutorBean("白雅晴", "一级导师,风投分析","这是一位有着丰富经验的老司机，投资和理财是他的强项", 23456,234, R.drawable.ewnwu));
        list.add(new HomeTutorBean("李元", "一级导师,数据分析","1999年从事金融至今，帮助多名企业家", 68796,335, R.drawable.re));
        return list;
    }

    public static  List<Integer> getImage(){
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.one);
        list.add(R.drawable.two);
        list.add(R.drawable.three);
        list.add(R.drawable.four);
        list.add(R.drawable.five);
        list.add(R.drawable.six);
        return list;

    }
}
