package com.example.mvvm

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.example.lib_opensource.CommonSP
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mFragments: ArrayList<Fragment> = ArrayList()
    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ARouter.getInstance().inject(this)
        mFragments.add(ARouter.getInstance().build("/medical/main").navigation() as Fragment)
        mFragments.add(ARouter.getInstance().build("/photo/main").navigation() as Fragment)
        mFragments.add(ARouter.getInstance().build("/medical/main").navigation() as Fragment)

        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.fl_main_container, mFragments[0]).commit()
        initListener()
    }

    private fun initListener() {
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.checkbox1 -> {
                    setIndexSelected(0)
                }
                R.id.checkbox2 -> {
                    if (!CommonSP.isLogin()) {
                        ARouter.getInstance().build("/login/main").navigation(this, 0x111)
                        checkbox1.isChecked = true
                        index = 1
                    } else {
                        setIndexSelected(1)
                    }
                }
                R.id.checkbox3 -> {
                    if (!CommonSP.isLogin()) {
                        ARouter.getInstance().build("/login/main").navigation(this, 0x111)
                        checkbox1.isChecked = true
                        index = 2
                    } else {
                        setIndexSelected(2)
                    }
                }
            }
        }
    }

    private fun setIndexSelected(index: Int) {
        val ft = supportFragmentManager.beginTransaction()
        hideAllFragment()
        //判断是否添加
        if (!mFragments[index].isAdded) {
            ft.add(R.id.fl_main_container, mFragments[index]).show(mFragments[index])
        } else {
            ft.show(mFragments[index])
        }
        ft.commitAllowingStateLoss()
    }

    private fun hideAllFragment() {
        val ft = supportFragmentManager.beginTransaction()
        if (mFragments[0].isVisible)
            ft.hide(mFragments[0])
        if (mFragments[1].isVisible)
            ft.hide(mFragments[1])
        if (mFragments[2].isVisible)
            ft.hide(mFragments[2])
        ft.commitAllowingStateLoss()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 0x111 && resultCode == Activity.RESULT_OK) {
            if (index == 1) {
                checkbox2.isChecked = true
            } else if (index == 2) {
                checkbox3.isChecked = true
            }
        }
    }
}