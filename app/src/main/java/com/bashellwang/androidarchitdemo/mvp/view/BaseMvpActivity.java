package com.bashellwang.androidarchitdemo.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bashellwang.androidarchitdemo.mvp.presenter.IPresenter;

/**
 * Created by bashellwang on 2019/1/25.
 * <p>
 * View 层 Activity 基类，实现 IView 接口，供 P 层调用；
 * 同时持有 P 层（实现 P 层 抽象接口 IPresenter ），调用 P 层功能
 */
public abstract class BaseMvpActivity<P extends IPresenter> extends AppCompatActivity implements IView {

    protected P mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        init();
    }

    @Override
    protected void onDestroy() {

        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        super.onDestroy();

    }

    protected abstract P createPresenter();

    protected abstract void init();
}
