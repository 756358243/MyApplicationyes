package com.vkeline.zlibrary.util;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.vkeline.zlibrary.view.HeadLayoutView;

/**
 * @author Zhou
 *         Created on 2017/12/1 10:20.
 *         Email:qishuichixi@163.com
 *         Desc:
 */

public class CommonUtils {


    public static <T extends View> T findViewById(Activity activity, int id) {

        return (T) activity.findViewById(id);
    }

    public static <T extends View> T findViewById(View view, int id) {

        return (T) view.findViewById(id);
    }


    /**
     * 是否使屏幕常亮
     *
     * @param activity
     */
    public static void keepScreenLongLight(Activity activity, Boolean isOpenLight) {
        if (isOpenLight) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        } else {
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
    }


    //将光标移至文字末尾
    public static void moveLast(EditText editText) {

        if (editText == null) {
            return;
        }
        int pos = editText.getText().toString().length();
        editText.setSelection(pos);
    }




}
