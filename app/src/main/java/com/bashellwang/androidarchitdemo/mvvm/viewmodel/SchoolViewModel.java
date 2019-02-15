package com.bashellwang.androidarchitdemo.mvvm.viewmodel;

import android.databinding.BaseObservable;
import android.util.Log;
import android.view.View;

import com.bashellwang.androidarchitdemo.databinding.ActivityMvvmDemoBinding;
import com.bashellwang.androidarchitdemo.mvvm.model.Callback;
import com.bashellwang.androidarchitdemo.mvvm.model.School;
import com.bashellwang.androidarchitdemo.mvvm.model.SchoolModelDao;

import java.util.Random;

/**
 * Created by liang.wang on 2019/2/1.
 */
public class SchoolViewModel extends BaseObservable {

    private static final String TAG = "SchoolViewModel";

    public School mSchool;
    private ActivityMvvmDemoBinding mBinding;
    private SchoolModelDao mSchoolDao;

    public SchoolViewModel(ActivityMvvmDemoBinding demoBinding) {
        this.mBinding = demoBinding;

        // 把自己和 binding 绑定，实现双向绑定
        mBinding.setViewModel(this);
        this.mSchoolDao = new SchoolModelDao();
        init();
    }

    // 初始化数据展示
    public void init() {
        mSchool = new School(5, "aa", "aaa", 300);
    }

    public void onItemClick(View view) {
        mSchoolDao.getSchoolById(new Random().nextInt(10), new Callback<School, String>() {

            @Override
            public void onSuccess(School school) {

                Log.e(TAG, "获取新school 成功：" + school.toString());
                updateData(school);
            }

            @Override
            public void onFail(String s) {
            }
        });
    }

    private void updateData(School school) {
        mSchool = school;
        notifyChange();
    }
}
