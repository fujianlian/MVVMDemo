package com.example.lib_opensource;

import android.app.Application;

/**
 * 全局静态参数集合
 */
public class Global {
    static Application mContext;

    public synchronized static void setApplicationContext(Application context) {
        mContext = context;
    }

    public static Application getApplicationContext() {
        return mContext;
    }
}
