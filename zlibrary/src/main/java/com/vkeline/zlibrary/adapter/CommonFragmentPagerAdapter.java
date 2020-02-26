package com.vkeline.zlibrary.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author Zhou
 *         Created on 2017/12/4 15:19.
 *         Email:qishuichixi@163.com
 *         Desc:
 */

public class CommonFragmentPagerAdapter extends FragmentPagerAdapter {

    //fragment数据源
    List<Fragment> mDatas;

    public CommonFragmentPagerAdapter(FragmentManager fm, List<Fragment> mDatas) {
        super(fm);
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public Fragment getItem(int position) {

        if (mDatas == null) {
            return null;
        }
        return mDatas.get(position);
    }

}
