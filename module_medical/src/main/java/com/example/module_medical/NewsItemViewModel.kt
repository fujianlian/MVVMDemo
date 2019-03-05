package com.example.module_medical

import androidx.databinding.ObservableField
import android.os.Bundle
import com.example.lib_opensource.bean.GankBean
import me.goldze.mvvmhabit.base.ItemViewModel
import me.goldze.mvvmhabit.binding.command.BindingAction
import me.goldze.mvvmhabit.binding.command.BindingCommand

class NewsItemViewModel(viewModel: NewsViewModel, entity: GankBean) : ItemViewModel<NewsViewModel>(viewModel) {

    var entity = ObservableField<GankBean>()

    var empty = ""

    //条目的点击事件
    fun itemClick(): BindingCommand<BindingAction> {
        return BindingCommand(BindingAction {
            //这里可以通过一个标识,做出判断，已达到跳入不同界面的逻辑
            if (entity.get()?.url != null) {
                //跳转到详情界面,传入条目的实体对象
                val mBundle = Bundle()
                mBundle.putString("url", entity.get()!!.url)
                viewModel.startActivity(WebActivity::class.java, mBundle)
            }
        })
    }

    init {
        this.entity.set(entity)
    }

}
