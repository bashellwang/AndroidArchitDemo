package com.bashellwang.androidarchitdemo.mvp.model;

/**
 * Created by liang.wang on 2019/1/30.
 *
 * 接口回调，Model 层和 Presenter 层连接桥梁
 */
public interface Callback<K,V> {
    void onSuccess(K k);
    void onFail(V v);
}
