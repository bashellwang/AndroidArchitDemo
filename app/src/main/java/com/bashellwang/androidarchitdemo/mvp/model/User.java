package com.bashellwang.androidarchitdemo.mvp.model;

import android.view.View;
import android.widget.Toast;

/**
 * Created by liang.wang on 2019/1/24.
 */
public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void onItemClick(View view) {
        Toast.makeText(view.getContext(), getName(), Toast.LENGTH_LONG).show();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
