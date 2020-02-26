package com.vkeline.zlibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhou on 2017/12/24.
 */

public abstract class ZMvpBaseFragment<V extends ZMvpBaseView, P extends ZMvpBasePresenter> extends ZBaseFragment implements ZMvpBaseView {

    private P persenter;
    private View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (v == null) {
            v = View.inflate(getActivity(), initView(), null);
        }

        if (persenter == null) {
            persenter = creatPersenter();
        }
        persenter.onAttch((V) this);
        initEvent(v);


        return v;
    }

    protected abstract void initEvent(View view);

    @Override
    public void onResume() {
        super.onResume();
        if (persenter != null) {
            persenter.onResumePersenter();
        }
    }


    @Override
    public void onDestroy() {
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
