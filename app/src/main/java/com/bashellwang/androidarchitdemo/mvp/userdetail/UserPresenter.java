package com.bashellwang.androidarchitdemo.mvp.userdetail;

import android.util.Log;

import com.bashellwang.androidarchitdemo.mvp.presenter.BasePresenter;
import com.bashellwang.androidarchitdemo.mvp.model.Callback;
import com.bashellwang.androidarchitdemo.mvp.model.bean.User;
import com.bashellwang.androidarchitdemo.mvp.model.UserModelDao;

import java.util.Random;

/**
 * Created by bashellwang on 2019/1/25.
 * <p>
 * 实际运用的一个 presenter 类，继承 基类
 * 里面是实际的 model 操作
 */
public class UserPresenter extends BasePresenter<UserContract.View> implements UserContract.Presenter {

    private UserModelDao mModelDao;


    public UserPresenter() {
        mModelDao = new UserModelDao();
    }


    @Override
    public void queryUserByName(String name) {

        if (isViewAttached()) {
            getView().showLoading(true);

            mModelDao.getUserByname(name, new Callback<User, String>() {

                @Override
                public void onSuccess(User user) {
                    Log.i("UserPresenter", "queryUserByName onSuccess...");
                    if (user != null) {
                        getView().showUserInfo(user);
                    }
                }

                @Override
                public void onFail(String s) {
                    Log.i("UserPresenter", "queryUserByName onFail...");
                }
            });

        }
    }

    @Override
    public void addUser(String name) {
        int age = new Random().nextInt(80);
        User user = new User("rose" + age, age);

        mModelDao.addUser(user, new Callback<User, String>() {

            @Override
            public void onSuccess(User user) {
                Log.i("UserPresenter", "addUser onSuccess...");
            }

            @Override
            public void onFail(String s) {
                Log.i("UserPresenter", "addUser onFail...");

            }
        });
    }

}
