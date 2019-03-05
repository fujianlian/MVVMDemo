package com.example.module_medical

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import android.util.Log
import com.example.lib_opensource.bean.GankBean
import com.example.lib_opensource.http.HttpModel
import com.vise.xsnow.http.ViseHttp
import com.vise.xsnow.http.callback.ACallback
import me.goldze.mvvmhabit.base.BaseViewModel
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter
import me.tatarka.bindingcollectionadapter2.ItemBinding

class NewsViewModel(application: Application) : BaseViewModel(application) {

    fun requestNetWork() {
        ViseHttp.GET("api/data/Android/20/2")
            .request(object : ACallback<HttpModel<List<GankBean>>>() {
                override fun onSuccess(data: HttpModel<List<GankBean>>) {
                    for (v in data.results){
                        val itemViewModel = NewsItemViewModel(this@NewsViewModel, v)
                        //双向绑定动态添加Item
                        observableList.add(itemViewModel)
                    }
                }

                override fun onFail(errCode: Int, errMsg: String) {
                    Log.d("DATA===", "fail")
                }
            })
    }

    //给RecyclerView添加ObservableList
    var observableList: ObservableList<NewsItemViewModel> = ObservableArrayList()
    //给RecyclerView添加ItemBinding
    val itemBinding: ItemBinding<NewsItemViewModel> = ItemBinding.of(BR.itemViewModel, R.layout.item_news)
    //给RecyclerView添加Adpter，请使用自定义的Adapter继承BindingRecyclerViewAdapter，重写onBindBinding方法，里面有你要的Item对应的binding对象
    val adapter = BindingRecyclerViewAdapter<NewsItemViewModel>()


}