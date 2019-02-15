package com.bashellwang.androidarchitdemo.mvvm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by liang.wang on 2019/2/1.
 */
public class SchoolModelDao implements ModelDao {

    private static List<School> mSchoolList;

    private void mockData() {
        mSchoolList = new ArrayList<>();
        mSchoolList.clear();
        for (int i = 0; i < 10; i++) {
            int count = new Random().nextInt(1000);
            School school = new School(i, "育才小学" + i, "第" + i + "所育才小学", count);
            mSchoolList.add(school);
        }
    }

    public SchoolModelDao() {
        mockData();
    }


    @Override
    public School getSchoolById(int id, Callback callback) {

        School school = null;
        if (mSchoolList != null && mSchoolList.size() > 0) {
            for (int i = 0; i < mSchoolList.size(); i++) {
                if (mSchoolList.get(i).getId() == id) {
                    school = mSchoolList.get(i);
                }
            }
        }

        if (callback != null) {
            if (school != null) {
                callback.onSuccess(school);
            } else {
                callback.onFail("没有找到对应的学校");
            }
        }
        return school;
    }
}
