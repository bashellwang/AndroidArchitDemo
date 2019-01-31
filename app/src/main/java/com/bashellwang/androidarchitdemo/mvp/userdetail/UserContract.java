package com.bashellwang.androidarchitdemo.mvp.userdetail;

import com.bashellwang.androidarchitdemo.mvp.model.bean.User;
import com.bashellwang.androidarchitdemo.mvp.view.IView;

/**
 * Created by bashellwang on 2019/1/25.
 * <p>
 * 合约类，方便管理同一个业务下的场景接口使用
 */
public interface UserContract {

    /**
     * 这里是每个 view 的单独接口
     */
    interface View extends IView {
        void showLoading(boolean show);

        void showUserInfo(User user);
    }

    /**
     * 这里是每个 presenter 单独的接口，基础接口已在 BasePresenter 中实现
     */
    interface Presenter {
        void queryUserByName(String name);

        void addUser(String name);
    }
}
