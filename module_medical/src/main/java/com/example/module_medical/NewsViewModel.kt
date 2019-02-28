package com.example.module_medical

import android.util.Log
import com.example.lib_opensource.http.HttpModel
import com.vise.xsnow.http.ViseHttp
import com.vise.xsnow.http.callback.ACallback

class NewsViewModel {

    fun requestNetWork() {
        ViseHttp.GET("api/data/Android/20/1")
            .request(object : ACallback<HttpModel<List<NewsBean>>>() {
                override fun onSuccess(data: HttpModel<List<NewsBean>>) {
                    for (v in data.results)
                        Log.d("DATA===", v.toString())
                }

                override fun onFail(errCode: Int, errMsg: String) {
                    Log.d("DATA===", "fail")
                }
            })
    }
}