package com.vkeline.zlibrary.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.vkeline.zlibrary.activity.SeeBigPictureActivity;
import com.vkeline.zlibrary.util.AutoSizeUtils;
import com.vkeline.zlibrary.util.KeyUtils;
import com.vkeline.zlibrary.util.LogUtils;
import com.vkeline.zlibrary.util.StatusBarUtils;
import com.vkeline.zlibrary.util.StringUtils;
import com.vkeline.zlibrary.util.ToastUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/25.
 */
public abstract class ZBaseActivity extends AppCompatActivity {

    public static LinkedList<ZBaseActivity> mActivitys = new LinkedList<>();
    public static ZBaseActivity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置屏幕方向
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //加入
        synchronized (ZBaseActivity.class) {
            mActivitys.add(this);
        }
        initViewMVC();
        AutoSizeUtils.auto(this);
        initEventMVC();
    }

    /**
     * 不使用mvp的加载布局
     */
    public void initViewMVC() {
    }

    ;

    /**
     * 不使用mvp的处理业务
     */
    public void initEventMVC() {
    }

    ;

    @Override
    protected void onResume() {
        super.onResume();
        activity = this;
    }

    @Override
    protected void onPause() {
        super.onPause();
        activity = null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        synchronized (ZBaseActivity.class) {
            mActivitys.remove(this);
        }
    }

    /**
     * 退出程序
     */
    public static void killAll() {
        // 复制了一份mActivities 集合
        List<ZBaseActivity> copy;
        synchronized (ZBaseActivity.class) {
            copy = new LinkedList<>(mActivitys);
        }
        for (ZBaseActivity activity : copy) {
            activity.finish();
        }
        // 杀死当前的进程
        android.os.Process.killProcess(android.os.Process.myPid());
    }


    /**
     * 查看大图特定方法
     *
     * @param url
     */
    public void startSeeBigPicActivity(String url) {
        Intent intent = new Intent(this, SeeBigPictureActivity.class);
        intent.putExtra(KeyUtils.KEY_BIG_PIC_URL, url);
        startActivity(intent);
    }

    public void startActivity(Class c) {
        startActivity(new Intent(this, c));
    }

    public void startActivityFinish(Class c) {
        startActivity(new Intent(this, c));
        finish();
    }


    public String getText(EditText et) {
        if (et == null) {
            return "";
        }
        return et.getText().toString().trim();
    }

    public String getText(TextView tv) {
        if (tv == null) {
            return "";
        }
        return tv.getText().toString().trim();
    }

    public void show(String message) {

        if (StringUtils.isNull(message)) {
            message = "提示内容为空";
        }
        ToastUtils.show(message);
    }


}
