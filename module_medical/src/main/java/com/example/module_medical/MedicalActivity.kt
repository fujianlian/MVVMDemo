package com.example.module_medical

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.example.lib_opensource.CommonSP

class MedicalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medical)
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, MedicalFragment()).commit()

        if (!CommonSP.isLogin()) {
            // 构建标准的路由请求
            ARouter.getInstance().build("/login/main").navigation()
        }
    }
}
