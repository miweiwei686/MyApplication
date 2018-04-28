package com.example.miwei.myapplication.designmode;

/**
 * Created by miwei on 2018/4/25.
 *
 * 单例模式的基本写法
 */

public class Singleton {

    private static volatile Singleton instance = null; //volatile 修饰符是保证singleton是线程共享的，只存在一个不会重复

    private Singleton() {}

    public static Singleton getInstance() {

        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}
