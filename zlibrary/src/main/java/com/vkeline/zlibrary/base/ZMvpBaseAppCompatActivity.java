package com.vkeline.zlibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.vkeline.zlibrary.util.AutoSizeUtils;

/**
 * Created by zhou on 2017/12/24.
 */

public abstract class ZMvpBaseAppCompatActivity<V extends ZMvpBaseView, P extends ZMvpBasePresenter> extends ZBaseActivity implements ZMvpBaseView {

    private P persenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(initView());
        AutoSizeUtils.auto(this);
        if (persenter == null) {
            persenter = creatPersenter();
        }
        persenter.onAttch((V) this);
        initEvent();

    }

    protected abstract void initEvent();

    @Override
    protected void onResume() {
        super.onResume();
        if (persenter != null) {
            persenter.onResumePersenter();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (persenter != null) {
            persenter.onDetch();
        }
    }

    /**
     * 添加布局
     *
     * @return
     */
    protected abstract int initView();

    /**
     * @return 创建P
     */
    protected abstract P creatPersenter();

    /**
     * @return 获取P
     */
    public P getPersenter()

    {
        return persenter;
    }


}
