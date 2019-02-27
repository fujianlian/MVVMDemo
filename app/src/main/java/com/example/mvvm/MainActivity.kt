package com.example.mvvm

import android.os.Bundle
import me.goldze.mvvmhabit.base.BaseActivity
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun initVariableId(): Int {
        return BR.main
    }

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_main
    }

}