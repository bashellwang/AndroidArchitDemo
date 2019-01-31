package com.bashellwang.androidarchitdemo.mvp.presenter;

import com.bashellwang.androidarchitdemo.mvp.view.IView;

/**
 * Created by liang.wang on 2019/1/30.
 * <p>
 * Presenter 层抽象出来的公共部分，P 层持有 View 层（实现 IView 接口）
 * <p>
 * P层每个功能需要适配生命周期
 */
public interface IPresenter<V extends IView> {
    void attachView(V view);

    void detachView();

    boolean isViewAttached();

    V getView();
}
