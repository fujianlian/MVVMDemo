package com.example.module_photo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.example.lib_opensource.CommonSP

class PhotoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, PhotoFragment()).commit()

        if (!CommonSP.isLogin()) {
            // 构建标准的路由请求
            ARouter.getInstance().build("/login/main").navigation()
        }
    }
}
