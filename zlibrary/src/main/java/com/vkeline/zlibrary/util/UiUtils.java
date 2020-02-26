package com.vkeline.zlibrary.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.vkeline.zlibrary.base.ZBaseApplication;
import com.vkeline.zlibrary.view.HeadLayoutView;

import java.lang.reflect.Method;


/**
 * @author Zhou
 *         Created on 2017/11/30 17:32.
 *         Email:qishuichixi@163.com
 *         Desc:
 */

public class UiUtils {


    private static Context mContext;

    public static void init(Context mContext) {
        UiUtils.mContext = mContext;
    }

    /**
     * 获取到字符数组
     *
     * @param tabNames 字符数组的id
     */
    public static String[] getStringArray(int tabNames) {
        return getResource().getStringArray(tabNames);
    }

    public static Resources getResource() {
        return mContext.getResources();
    }

    public static Context getContext() {
        return mContext;
    }

    /**
     * dip转换px
     */
    public static int dip2px(int dip) {
        final float scale = getResource().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

    /**
     * px转换dip
     */

    public static int px2dip(int px) {
        final float scale = getResource().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }

    /**
     * 把Runnable 方法提交到主线程运行
     *
     * @param runnable
     */
    public static void runOnUiThread(Runnable runnable) {
        // 在主线程运行
        if (android.os.Process.myTid() == ZBaseApplication.getMainTid()) {
            runnable.run();
        } else {
            //获取handler
            ZBaseApplication.getHandler().post(runnable);
        }
    }

    public static View inflate(int id) {
        return View.inflate(getContext(), id, null);
    }

    public static Drawable getDrawalbe(int id) {
        return getResource().getDrawable(id);
    }

    public static int getDimens(int homePictureHeight) {
        return (int) getResource().getDimension(homePictureHeight);
    }

    public static int getDimensHeight(Activity activity) {

        DisplayMetrics dm = new DisplayMetrics();

        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);

        return dm.heightPixels;

    }

    public static int getDimensWidth(Activity activity) {

        DisplayMetrics dm = new DisplayMetrics();

        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);

        return dm.widthPixels;

    }

    /**
     * 延迟执行 任务
     *
     * @param run  任务
     * @param time 延迟的时间
     */
    public static void postDelayed(Runnable run, int time) {
        ZBaseApplication.getHandler().postDelayed(run, time); // 调用Runable里面的run方法
    }

    /**
     * 取消任务
     *
     * @param auToRunTask
     */
    public static void cancel(Runnable auToRunTask) {
        ZBaseApplication.getHandler().removeCallbacks(auToRunTask);
    }




    //隐藏item
    public static void setVisibility(Boolean isVisible, LinearLayout linearLayout) {
        ViewGroup.LayoutParams param = linearLayout.getLayoutParams();
        if (isVisible) {
            param.height = LinearLayout.LayoutParams.WRAP_CONTENT;
            param.width = LinearLayout.LayoutParams.MATCH_PARENT;
            linearLayout.setVisibility(View.VISIBLE);
        } else {
            linearLayout.setVisibility(View.GONE);
            param.height = 0;
            param.width = 0;
        }
        linearLayout.setLayoutParams(param);
    }


    public static void removeParent(View v) {
        //  先找到爹 在通过爹去移除孩子
        ViewParent parent = v.getParent();
        //所有的控件 都有爹  爹一般情况下 就是ViewGoup
        if (parent instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) parent;
            group.removeView(v);
        }
    }


    /**
     * 添加虚拟按键设置
     */
    public static void showNagivationMenuKey(Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            return;
        }
        if (Build.VERSION.SDK_INT <= 20) {
            try {
                int flags = WindowManager.LayoutParams.class.getField("FLAG_NEEDS_MENU_KEY").getInt(null);
                activity.getWindow().addFlags(flags);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Method setNeedsMenuKey = Window.class.getDeclaredMethod("setNeedsMenuKey", int.class);
                setNeedsMenuKey.setAccessible(true);
                int value = WindowManager.LayoutParams.class.getField("NEEDS_MENU_SET_TRUE").getInt(null);
                setNeedsMenuKey.invoke(activity.getWindow(), value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭页面
     */
    public static void setHLV(final Activity activity, int id, String colorString) {

        HeadLayoutView hlv = CommonUtils.findViewById(activity, id);
        hlv.getmHead_rl().setBackgroundColor(Color.parseColor(colorString));
        hlv.setCallBack(new HeadLayoutView.CallBack() {
            @Override
            public void clickLeft() {
                activity.finish();
            }

            @Override
            public void clickRight() {

            }
        });
    }


}

