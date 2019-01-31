package com.bashellwang.androidarchitdemo.mvp.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 这里是对外获取数据的统一类，内部实现可分别从本地获取、从网络获取
 * <p>
 * 可参考：https://github.com/googlesamples/android-architecture/blob/todo-mvp/todoapp/app/src/main/java/com/example/android/architecture/blueprints/todoapp/data/source/TasksRepository.java
 * 这里只模拟从本地获取数据
 */
public class UserModelDao implements ModelDao {
    private static List<User> mUserList;


    private void mockData() {
        mUserList = new ArrayList<>();
        mUserList.clear();
        for (int i = 0; i < 5; i++) {
            int age = new Random().nextInt(80);
            User user = new User("jack" + i, age);
            mUserList.add(user);
        }
    }

    public UserModelDao() {
        mockData();
    }


    @Override
    public User getUserByname(String name, Callback callback) {
        User result = null;
        if (mUserList != null && mUserList.size() > 0) {
            for (int i = 0; i < mUserList.size(); i++) {
                if (mUserList.get(i).getName().equals(name)) {
                    result = mUserList.get(i);
                }
            }
        }
        if (result == null) {
            callback.onFail("Failed , no data");
        } else {
            callback.onSuccess(result);
        }
        return result;
    }

    @Override
    public void addUser(User user, Callback callback) {
        if (mUserList == null) {
            mUserList = new ArrayList<>();
        }
        mUserList.add(user);
        callback.onSuccess(null);
    }

}