package com.example.mvvm

import com.alibaba.android.arouter.launcher.ARouter
import com.vise.log.ViseLog
import com.vise.log.inner.LogcatTree
import com.vise.xsnow.http.ViseHttp
import com.vise.xsnow.http.interceptor.HttpLogInterceptor
import me.goldze.mvvmhabit.base.BaseApplication

class MyApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        ARouter.openLog()   // 打印日志
        ARouter.openDebug() // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)

        ARouter.init(this)

        initNet()
        initNetLog()
    }

    private fun initNetLog() {
        ViseLog.getLogConfig()
            .configAllowLog(true)//是否输出日志
            .configShowBorders(false)//是否排版显示
        ViseLog.plant(LogcatTree())//添加打印日志信息到Logcat的树
    }

    private fun initNet() {
        ViseHttp.init(this)
        ViseHttp.CONFIG()
            //配置请求主机地址
            .baseUrl("https://gank.io/")
    }

}