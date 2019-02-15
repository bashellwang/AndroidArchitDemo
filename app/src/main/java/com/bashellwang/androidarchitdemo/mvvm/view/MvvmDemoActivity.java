package com.bashellwang.androidarchitdemo.mvvm.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bashellwang.androidarchitdemo.R;
import com.bashellwang.androidarchitdemo.databinding.ActivityMvvmDemoBinding;
import com.bashellwang.androidarchitdemo.mvvm.viewmodel.SchoolViewModel;

/**
 * Created by liang.wang on 2019/1/31.
 */
public class MvvmDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMvvmDemoBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_demo);
        SchoolViewModel viewModel = new SchoolViewModel(binding);
    }
}
