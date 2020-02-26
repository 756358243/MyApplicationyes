package com.vkeline.zlibrary.util;

import android.os.Handler;

import com.vkeline.zlibrary.base.ZBaseApplication;
import com.vkeline.zlibrary.net.OkHttpManager;

/**
 * Created by Administrator on 2017/12/28.
 * 计时器功能封装
 */
public class TimerUtils {

    //间隔时间
    private int t = 1;
    private static TimerUtils timerUtils;

    private int sumTime = 0;

    private TimerUtils() {
    }

    public static TimerUtils getInstance() {
        if (timerUtils == null) {
            synchronized (OkHttpManager.class) {
                if (timerUtils == null) {
                    timerUtils = new TimerUtils();
                }
            }
        }
        return timerUtils;
    }

    private Handler handler2 = ZBaseApplication.getHandler();
    private Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            handler2.postDelayed(this, t * 1000);
            sumTime++;
            if (callBack != null) {
                callBack.updateUI(sumTime, TimeUtils.getTimeDifference(sumTime));
            }
        }
    };

    /**
     * 开始计时
     */
    public TimerUtils start() {
        LogUtils.e(TimeUtils.getTime(TimeUtils.TYPE_NYRSFM) + " 开始计时");
        sumTime = 0;
        handler2.removeCallbacks(runnable2);
        handler2.postDelayed(runnable2, t * 1000);
        return this;
    }

    /**
     * 停止计时
     */
    public void stop() {
        LogUtils.e(TimeUtils.getTime(TimeUtils.TYPE_NYRSFM) + " 停止计时");
        handler2.removeCallbacks(runnable2);
    }


    private CallBack callBack;

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    /**
     * 更新界面
     */
    public interface CallBack {
        void updateUI(int sumTime, String time);
    }

}
