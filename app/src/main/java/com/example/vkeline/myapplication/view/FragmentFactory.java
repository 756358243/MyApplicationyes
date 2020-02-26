package com.example.vkeline.myapplication.view;

import android.support.v4.app.Fragment;

import com.vkeline.zlibrary.util.LogUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vkeline on 2018/3/1.
 */
public class FragmentFactory {

    private static Map<Integer, Fragment> mapMainFragment = new HashMap<>();

    public static Fragment addMainFragment(int position) {

        Fragment curFragment = mapMainFragment.get(position);
        if (curFragment == null) {
            switch (position) {
                case 0:
                    LogUtils.e("jibenxinxi");
                   curFragment = new Jibenxinxi();
                    break;
                case 1:
                    LogUtils.e("ganzhifenxi");
                    curFragment = new Ganzhifenxi();
                    break;
                case 2:
                    LogUtils.e("xiangximingpan");
                    curFragment = new Xiangximingpan();
                    break;

                case 3:
                    LogUtils.e("zicegongju");
                    curFragment = new Zicegongju();
                    break;

                case 4:
                    LogUtils.e("guanyuwomen");
                    curFragment = new Guanyuwomen();
                    break;

                default:
                    break;
            }
        }
        return curFragment;
    }

}
