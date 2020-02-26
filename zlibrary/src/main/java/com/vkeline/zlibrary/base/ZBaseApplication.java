package com.vkeline.zlibrary.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.vkeline.zlibrary.util.AutoSizeUtils;
import com.vkeline.zlibrary.util.CrashHandler;
import com.vkeline.zlibrary.util.DensityUtils;
import com.vkeline.zlibrary.util.SPUtils;
import com.vkeline.zlibrary.util.ToastUtils;
import com.vkeline.zlibrary.util.UiUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.cookie.CookieJarImpl;
import com.zhy.http.okhttp.cookie.store.PersistentCookieStore;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2017/12/25.
 */
public class ZBaseApplication extends Application {

    private static ZBaseApplication application;
    private static int mainTid;
    private static Handler handler;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;
        mainTid = android.os.Process.myTid();
        handler = new Handler();

        //初始化toast
        ToastUtils.init(this);
        //初始化Sp
        SPUtils.init(this);
        //初始化UiUtils
        UiUtils.init(this);

        //初始化网络请求
        CookieJarImpl cookieJar = new CookieJarImpl(new PersistentCookieStore(getApplicationContext()));
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cookieJar(cookieJar)
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);


        //捕获异常
        CrashHandler.getInstance().init(this);
       
        //初始化尺寸
        AutoSizeUtils.setSize(this, true, DensityUtils.getWidthPixels(this), DensityUtils.getHeightPixels(this));
    }

    public static Context getApplication() {
        return application;
    }

    public static int getMainTid() {
        return mainTid;
    }

    public static Handler getHandler() {
        return handler;
    }

}
