package com.example.module_medical

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.module_medical.databinding.FragmentMedicalBinding
import me.goldze.mvvmhabit.base.BaseFragment

@Route(path = "/medical/main")
class MedicalFragment : BaseFragment<FragmentMedicalBinding, NewsViewModel>() {
    override fun initVariableId(): Int {
        return BR.meViewModel;
    }

    override fun initContentView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_medical
    }

    override fun initData() {
        viewModel.requestNetWork()
    }
}

