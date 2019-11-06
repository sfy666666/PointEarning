package com.example.pointearning.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pointearning.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * created by shengfeiyu
 * on 2019/9/10
 * 项目详情Fragment
 */
public class ProgramInformationFragment extends BaseFragment {
    @BindView(R.id.tv_nianhuashouyilv)
    TextView tvNianhuashouyilv;
    @BindView(R.id.tv_shouyijine)
    TextView tvShouyijine;
    @BindView(R.id.tv_touziqixian)
    TextView tvTouziqixian;
    @BindView(R.id.tv_shijian1)
    TextView tvShijian1;
    @BindView(R.id.tv_shijian2)
    TextView tvShijian2;
    @BindView(R.id.tv_shijian3)
    TextView tvShijian3;
    @BindView(R.id.tv_program_introduction)
    TextView tvProgramIntroduction;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_program_information, container, false);
        ButterKnife.bind(this,view);
        return view;
    }
}
