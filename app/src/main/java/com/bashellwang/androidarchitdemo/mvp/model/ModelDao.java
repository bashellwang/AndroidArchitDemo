package com.bashellwang.androidarchitdemo.mvp.model;


/**
 * Created by liang.wang on 2019/1/30.
 */
public interface ModelDao extends IModel{

    User getUserByname(String name, Callback callback);

    void addUser(User user, Callback callback);

}
