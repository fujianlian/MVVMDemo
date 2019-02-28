package com.example.module_photo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.module_photo.databinding.FragmentPhotoBinding
import me.goldze.mvvmhabit.base.BaseFragment

@Route(path = "/photo/main")
class PhotoFragment : BaseFragment<FragmentPhotoBinding, PhotoViewModel>() {
    override fun initVariableId(): Int {
        return BR.photoViewModel
    }

    override fun initContentView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_photo
    }

    override fun initData() {
        viewModel.requestNetWork()
    }
}

