package com.bashellwang.androidarchitdemo.mvp.presenter;

import com.bashellwang.androidarchitdemo.mvp.view.IView;

/**
 * Created by liang.wang on 2019/1/30.
 */
public interface IPresenter<V extends IView> {
    void attachView(V view);

    void detachView();

    boolean isViewAttached();

    V getView();
}
