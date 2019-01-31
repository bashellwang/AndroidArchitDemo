package com.bashellwang.androidarchitdemo.mvp.model;


import com.bashellwang.androidarchitdemo.mvp.model.bean.User;

/**
 * Created by liang.wang on 2019/1/30.
 */
public interface ModelDao extends IModel{

    User getUserByname(String name, Callback callback);

    void addUser(User user, Callback callback);

}
