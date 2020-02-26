package com.vkeline.zlibrary.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.vkeline.zlibrary.adapter.CommonListViewAdapter;
import com.vkeline.zlibrary.util.UiUtils;

/**
 * Created by Administrator on 2017/12/25.
 */
public abstract class ZBaseFragment extends Fragment {

    private View v;
    protected Activity mActivity;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (v == null) {
            v = UiUtils.inflate(initViewMVC());
        }
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initEventMVC(v);
    }

    /**
     * 加载view
     *
     * @return
     */
    protected abstract int initViewMVC();

    /**
     * 处理事件
     *
     * @param v
     */
    protected abstract void initEventMVC(View v);


    /**
     * 获取数据
     *
     * @param et
     * @return
     */
    public String getText(EditText et) {
        if (et == null) {
            return "";
        }
        return et.getText().toString().trim() == null ? "" : et.getText().toString().trim();
    }

    public String getText(TextView tv) {
        if (tv == null) {
            return "";
        }
        return tv.getText().toString().trim() == null ? "" : tv.getText().toString().trim();
    }


}
