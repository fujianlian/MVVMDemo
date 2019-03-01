package com.example.lib_opensource;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author fujianlian Created on 2018/5/18 18:41
 * 描述：系统默认配置信息
 */
@SuppressLint("StaticFieldLeak")
public class CommonSP {

    /**
     * String数据
     */
    private static final byte STRING = 0;
    /**
     * Integer数据
     */
    private static final byte INT = 1;
    /**
     * 布尔值数据
     */
    private static final byte BOOLEAN = 2;
    /**
     * 长整形数据
     */
    private static final byte LONG = 3;
    /**
     * FLOAT数据
     */
    private static final byte FLOAT = 4;
    private static SharedPreferences preferences;
    private static CommonSP mUserConfig;
    private static Context context;

    public synchronized static CommonSP getInstance() {
        if (null == mUserConfig) {
            mUserConfig = new CommonSP();
        }
        if (null == context) {
            context = Global.getApplicationContext();
        }
        if (null == preferences) {
            try {
                preferences = context.getSharedPreferences("system", Context.MODE_PRIVATE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mUserConfig;
    }

    /**
     * @param key   键
     * @param value 值
     * @param type  传入值的类型
     * @type类型 SharedPreUtils.STRING， SharedPreUtils.INT，
     * SharedPreUtils.BOOLEAN， SharedPreUtils.LONG， SharedPreUtils.FLOAT
     */
    public static void putValue(String key, Object value, byte type) {
        getInstance();
        SharedPreferences.Editor edit = preferences.edit();
        switch (type) {
            case STRING:
                edit.putString(key, (String) value);
                break;
            case INT:
                edit.putInt(key, (Integer) value);
                break;
            case BOOLEAN:
                edit.putBoolean(key, (Boolean) value);
                break;
            case LONG:
                edit.putLong(key, (Long) value);
                break;
            case FLOAT:
                edit.putFloat(key, (Float) value);
                break;
            default:

        }
        edit.apply();
    }

    /**
     * @param key  键
     * @param type 传入值的类型
     * @type 类型 SharedPreUtils.STRING， SharedPreUtils.INT，
     * SharedPreUtils.BOOLEAN， SharedPreUtils.LONG
     */
    public static Object getValue(String key, byte type) {
        getInstance();
        switch (type) {
            case STRING:
                return preferences.getString(key, "");
            case INT:
                return preferences.getInt(key, -1);
            case BOOLEAN:
                return preferences.getBoolean(key, false);
            case LONG:
                return preferences.getLong(key, -1);
            case FLOAT:
                return preferences.getFloat(key, -1);
            default:
                return null;
        }
    }

    /**
     * 是否登录
     */
    public static boolean isLogin() {
        return (boolean) getValue("isLogin", BOOLEAN);
    }

    public static void setIsLogin(boolean isLogin) {
        putValue("isLogin", isLogin, BOOLEAN);
    }
}