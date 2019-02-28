package com.example.module_photo

import android.databinding.ObservableField
import android.os.Bundle
import com.example.lib_opensource.bean.GankBean
import me.goldze.mvvmhabit.base.ItemViewModel
import me.goldze.mvvmhabit.binding.command.BindingAction
import me.goldze.mvvmhabit.binding.command.BindingCommand

class PhotoItemViemModel(viewModel: PhotoViewModel, entity: GankBean) : ItemViewModel<PhotoViewModel>(viewModel) {

    var entity = ObservableField<GankBean>()

    //条目的点击事件
    fun itemClick(): BindingCommand<BindingAction> {
        return BindingCommand(BindingAction {
            //这里可以通过一个标识,做出判断，已达到跳入不同界面的逻辑
            if (entity.get()?.url != null) {
                //跳转到详情界面,传入条目的实体对象
                val mBundle = Bundle()
                mBundle.putString("title", entity.get()!!.who)
                mBundle.putString("url", entity.get()!!.url)
                viewModel.startActivity(ShowActivity::class.java, mBundle)
            }
        })
    }

    init {
        this.entity.set(entity)
    }

}

