package com.bashellwang.androidarchitdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.bashellwang.androidarchitdemo.mvp.view.MvpDemoActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mMvpBtn, mMvvmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initView();
    }

    private void initView() {
        mMvpBtn = findViewById(R.id.mvp_btn);
        mMvvmBtn = findViewById(R.id.mvvm_btn);
        mMvpBtn.setOnClickListener(this);
        mMvvmBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mvp_btn:
                Intent mvpIntent = new Intent(this, MvpDemoActivity.class);
                startActivity(mvpIntent);
                break;
            case R.id.mvvm_btn:
                break;

            default:
                break;
        }
    }
}
