package com.bashellwang.androidarchitdemo.mvp.userdetail;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bashellwang.androidarchitdemo.R;
import com.bashellwang.androidarchitdemo.mvp.model.bean.User;
import com.bashellwang.androidarchitdemo.mvp.view.BaseMvpActivity;

/**
 * Created by bashellwang on 2019/1/25.
 * <p>
 * 单页面单 presenter 请求
 */
public class MvpDemoActivity extends BaseMvpActivity<UserPresenter> implements UserContract.View {

    private TextView mInfoTv;
    private Button mGetBtn;


    @Override
    protected void init() {
        setContentView(R.layout.activity_mvpdemo);

        mInfoTv = findViewById(R.id.tv_info);
        mGetBtn = findViewById(R.id.btn_get);

        mGetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.queryUserByName("jack2");
            }
        });

    }

    @Override
    public void showLoading(boolean show) {
        Log.i("MvpDemoActivity", "假装在 loading ：" + show);
    }

    @Override
    public void showUserInfo(User user) {
        Log.i("MvpDemoActivity", "showUserInfo...");
        if (user != null) {
            mInfoTv.setText(user.toString());
        }
    }

    @Override
    protected UserPresenter createPresenter() {
        return new UserPresenter();
    }


}
