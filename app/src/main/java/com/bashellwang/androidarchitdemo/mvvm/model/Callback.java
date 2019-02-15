package com.bashellwang.androidarchitdemo.mvvm.model;

/**
 * Created by liang.wang on 2019/1/30.
 *
 */
public interface Callback<K,V> {
    void onSuccess(K k);
    void onFail(V v);
}
