package com.example.pointearning.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pointearning.R;

/**
 * created by shengfeiyu
 * on 2019/9/8
 * 导师详情中的介绍
 */
public class TutorIntroductionFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tutorintroduction, container, false);
        return view;
    }
}
