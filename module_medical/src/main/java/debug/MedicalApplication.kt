package debug

import com.vise.log.ViseLog
import com.vise.log.inner.LogcatTree
import com.vise.xsnow.http.ViseHttp
import com.vise.xsnow.http.interceptor.HttpLogInterceptor
import me.goldze.mvvmhabit.base.BaseApplication

class MedicalApplication:BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        initNet()
        initNetLog()
    }

    private fun initNetLog() {
        ViseLog.getLogConfig()
            .configAllowLog(true)//是否输出日志
            .configShowBorders(false)//是否排版显示
        ViseLog.plant(LogcatTree())//添加打印日志信息到Logcat的树
    }

    fun initNet() {
        ViseHttp.init(this)
        ViseHttp.CONFIG()
            //配置请求主机地址
            .baseUrl("https://gank.io/")
            .setCookie(true)
            //配置日志拦截器
            .interceptor(
                HttpLogInterceptor()
                    .setLevel(HttpLogInterceptor.Level.BODY)
            )
    }
}