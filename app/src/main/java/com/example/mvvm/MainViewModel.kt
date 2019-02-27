package com.example.mvvm

import android.app.Application
import me.goldze.mvvmhabit.base.BaseViewModel
import me.goldze.mvvmhabit.binding.command.BindingAction
import me.goldze.mvvmhabit.binding.command.BindingCommand
import me.goldze.mvvmhabit.utils.ToastUtils

class MainViewModel(application: Application) : BaseViewModel(application) {

    //网络访问点击事件
    fun netWorkClick(): BindingCommand<BindingAction> {
        return BindingCommand(BindingAction { ToastUtils.showLong("sdfjfh")})
    }

}