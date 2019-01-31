package com.bashellwang.androidarchitdemo.mvp;

import com.bashellwang.androidarchitdemo.mvp.model.User;
import com.bashellwang.androidarchitdemo.mvp.presenter.IPresenter;
import com.bashellwang.androidarchitdemo.mvp.view.IView;

/**
 * Created by bashellwang on 2019/1/25.
 */
public interface UserContract {

     interface View extends IView {
        void showLoading(boolean show);
        void showUserInfo(User user);
    }

     interface Presenter/* extends IPresenter*/ {
        void queryUserByName(String name);
        void addUser(String name);
    }
}
