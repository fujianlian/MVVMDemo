package com.example.lib_opensource.http;

import com.vise.xsnow.http.callback.ACallback;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * @author fujianlian Created on 2018/4/18 9:51
 * 自定义扩展
 */
public abstract class HttpCallBack<T extends HttpModel> extends ACallback<T> {

    @Override
    public void onSuccess(T data) {
        if (data.isError()) {
            onResponse(data);
        }
    }

    @Override
    public void onFail(int errCode, String errMsg) {
        hideProgress();
        ToastUtils.showShort(errMsg+errCode);
    }

    /**
     * 响应成功操作
     */
    public abstract void onResponse(T data);

    public void hideProgress() {
    }

}
