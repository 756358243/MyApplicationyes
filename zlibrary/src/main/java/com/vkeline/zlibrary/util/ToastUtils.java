package com.vkeline.zlibrary.util;

import android.content.Context;
import android.widget.Toast;


/**
 * @author Zhou
 *         Created on 2017/12/1 9:45.
 *         Email:qishuichixi@163.com
 *         Desc:
 */

public class ToastUtils {

    private static Toast mToast;
    private static Context mContext;

    public static void init(Context mContext) {
        ToastUtils.mContext = mContext;
    }

    public static void show(String msg) {

        if (mToast == null) {
            mToast = Toast.makeText(mContext, msg, Toast.LENGTH_LONG);
        } else {
            mToast.setText(msg);
        }
        mToast.show();

    }
}
