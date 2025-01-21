package com.hongxing.basetools;

import android.content.Context;

public class BaseTools {

    // 私有静态变量持有唯一的单例实例
    private static volatile BaseTools instance;

    // 私有的构造函数防止直接实例化
    private BaseTools() {}

    // 线程安全的单例获取方法
    public static BaseTools getInstance() {
        if (instance == null) {
            synchronized (BaseTools.class) {
                if (instance == null) {
                    instance = new BaseTools();
                }
            }
        }
        return instance;
    }

    // 用于保存和提供全局的 Context
    private static Context appContext;

    /**
     * 初始化上下文
     *
     * @param context 应用程序上下文
     */
    public void init(Context context) {
        if (appContext == null) {
            appContext = context.getApplicationContext(); // 获取应用程序级别的上下文
        }
    }

    /**
     * 获取已初始化的上下文
     *
     * @return 已初始化的应用程序上下文
     */
    public Context getAppContext() {
        if (appContext == null) {
            throw new IllegalStateException("Context has not been initialized yet.");
        }
        return appContext;
    }
}
