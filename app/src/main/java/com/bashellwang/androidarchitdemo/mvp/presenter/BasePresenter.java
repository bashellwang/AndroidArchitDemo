package com.bashellwang.androidarchitdemo.mvp.presenter;

import com.bashellwang.androidarchitdemo.mvp.view.IView;

import java.lang.ref.WeakReference;

/**
 * Created by bashellwang on 2019/1/25.
 */
public abstract class BasePresenter<V extends IView> implements IPresenter<V> {
    private WeakReference<V> weakReference;

    /**
     * 将传入的 View 接口实例通过若引用与 Presenter 绑定
     *
     * @param view 界面更新接口实例子
     */
    @Override
    public void attachView(V view) {
        weakReference = new WeakReference<>(view);
    }

    /**
     * View 和 Presenter 解绑，释放内存
     */
    @Override
    public void detachView() {
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }

    @Override
    public boolean isViewAttached() {
        return weakReference != null && weakReference.get() != null;
    }

    @Override
    public V getView() {
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        } else {
            return null;
        }
    }
}
