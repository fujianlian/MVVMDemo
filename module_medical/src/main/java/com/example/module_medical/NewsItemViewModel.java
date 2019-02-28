package com.example.module_medical;

import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.NonNull;
import me.goldze.mvvmhabit.base.ItemViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class NewsItemViewModel extends ItemViewModel<NewsViewModel> {

    public ObservableField<NewsBean> entity = new ObservableField<>();

    public String empty = "";

    public NewsItemViewModel(@NonNull NewsViewModel viewModel, NewsBean entity) {
        super(viewModel);
        this.entity.set(entity);
    }

    //条目的点击事件
    public BindingCommand itemClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            //这里可以通过一个标识,做出判断，已达到跳入不同界面的逻辑
            if (entity.get().getUrl() != null) {
                //跳转到详情界面,传入条目的实体对象
                Bundle mBundle = new Bundle();
                mBundle.putString("url", entity.get().getUrl());
                viewModel.startActivity(WebActivity.class, mBundle);
            }
        }
    });


}
