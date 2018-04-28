package com.example.miwei.myapplication.designmode;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by miwei on 2018/4/25.
 * 单例模式的例子，用来管理Activity
 */

public class ActivityManager {

    private static volatile ActivityManager instance;
    private Stack<Activity> mActivityStack = new Stack<>();
    private ActivityManager(){};
    public static ActivityManager getInstance() {
        if (instance == null) {
            synchronized (ActivityManager.class) {
                if (instance == null) {
                    instance = new ActivityManager();
                }
            }
        }
            return instance;
    }


    public void addActicity(Activity act){
        mActivityStack.push(act);
    }

    public void removeActivity(Activity act){
        mActivityStack.remove(act);
    }

    public void killMyProcess(){
        int nCount = mActivityStack.size();
        for (int i = nCount - 1; i >= 0; i--) {
            Activity activity = mActivityStack.get(i);
            activity.finish();
        }

        mActivityStack.clear();
        android.os.Process.killProcess(android.os.Process.myPid());
    }


}
