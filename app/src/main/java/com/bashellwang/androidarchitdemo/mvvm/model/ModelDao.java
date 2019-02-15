package com.bashellwang.androidarchitdemo.mvvm.model;


/**
 * Created by liang.wang on 2019/1/30.
 */
public interface ModelDao {

    School getSchoolById(int id, Callback callback);

}
