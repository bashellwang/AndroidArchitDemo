package com.bashellwang.androidarchitdemo.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bashellwang.androidarchitdemo.mvp.presenter.IPresenter;

/**
 * Created by bashellwang on 2019/1/25.
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
