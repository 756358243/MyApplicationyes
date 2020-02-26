package com.vkeline.zlibrary.base;

import android.os.Bundle;

/**
 * Created by zhou on 2017/12/24.
 */

public abstract class ZMvpBasePresenter<V extends ZMvpBaseView> {

    private V mView;

    public void onCreatePersenter(Bundle savedState) {

    }

    public void onAttch(V mView) {
        this.mView = mView;
    }

    public void onDetch() {
        mView = null;
    }


    public V getView() {
        return mView;
    }

    public void onDestroyPersenter() {
    }

    public void onResumePersenter() {
    }


}
