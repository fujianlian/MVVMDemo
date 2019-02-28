package com.example.mvvm

import android.os.Bundle
import android.support.v4.app.Fragment
import me.goldze.mvvmhabit.base.BaseActivity
import com.example.mvvm.databinding.ActivityMainBinding
import com.alibaba.android.arouter.launcher.ARouter



class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun initVariableId(): Int {
        return BR.main
    }

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        // 获取Fragment
        val fragment = ARouter.getInstance().build("/photo/main").navigation() as Fragment
        supportFragmentManager.beginTransaction().replace(R.id.fl_main_container, fragment).commit()
    }
}