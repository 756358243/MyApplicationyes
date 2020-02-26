package com.example.vkeline.myapplication.Receiver;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.WindowManager;
import com.example.vkeline.myapplication.R;
import com.example.vkeline.myapplication.Utils.SharedPreferencesHelper;
import com.example.vkeline.myapplication.data.SharedPreferencesTag;
import com.example.vkeline.myapplication.data.UpdateInfoModel;
import com.example.vkeline.myapplication.data.UpdateInformation;
import com.vkeline.zlibrary.util.LogUtils;

import java.io.File;
import java.util.HashMap;

public class UpdateReceiver extends BroadcastReceiver {
    private AlertDialog.Builder mDialog;
    public static final String UPDATE_ACTION = "wuyinlei_aixinwen";
    public UpdateInfoModel model;

    public UpdateInfoModel getModel() {
        return model;
    }

    public void setModel(UpdateInfoModel model) {
        this.model = model;
    }

    private SharedPreferencesHelper mSharedPreferencesHelper;
    private boolean isShowDialog;

    public UpdateReceiver() {
    }

    public UpdateReceiver(boolean isShowDialog) {
        super();
        this.isShowDialog = isShowDialog;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        mSharedPreferencesHelper = new SharedPreferencesHelper();
        //当然了，这里也可以直接new处hashmap
        HashMap<String, Object> tempMap = new HashMap<>();
        model = (UpdateInfoModel)intent.getSerializableExtra("model");
        PackageManager manager;
        PackageInfo info = null;
        manager = context.getPackageManager();
        try {
            info = manager.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }


        try {

            /**
             * 获取到当前的本地版本
             */
            UpdateInformation.localVersion = info.versionCode;
            /**
             * 获取到当前的版本名字
             */
            UpdateInformation.versionName = info.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //app名字
        UpdateInformation.appname = info.applicationInfo.name;
        //服务器版本
        UpdateInformation.serverVersion = Integer.parseInt(model
                .getServerVersion());
        //服务器标志
        UpdateInformation.serverFlag = Integer.parseInt(model.getServerFlag());
        //强制升级
        UpdateInformation.lastForce = Integer.parseInt(model.getLastForce());
        //升级地址
        UpdateInformation.updateurl = model.getAppurl();
        //升级信息
        UpdateInformation.upgradeinfo = model.getUpgradeinfo();

        //检查版本
        checkVersion(context);

    }

    /**
     * 检查版本更新
     *
     * @param context
     */
    public void checkVersion(Context context) {
        if (UpdateInformation.localVersion < UpdateInformation.serverVersion) {
            // 需要进行更新
            mSharedPreferencesHelper.applyInt(
                    //有新版本
                    SharedPreferencesTag.IS_HAVE_NEW_VERSION, 1);
            //更新
            update(context);
        } else {
            mSharedPreferencesHelper.applyInt(
                    SharedPreferencesTag.IS_HAVE_NEW_VERSION, 0);
            if (isShowDialog) {
                //没有最新版本，不用升级
                noNewVersion(context);
            }
            clearUpateFile(context);
        }
    }

    /**
     * 进行升级
     *
     * @param context
     */
    private void update(Context context) {
        if (UpdateInformation.serverFlag == 1) {
            // 官方推荐升级
            if (UpdateInformation.localVersion < UpdateInformation.lastForce) {
                //强制升级
                forceUpdate(context);
            } else {
                //正常升级
                normalUpdate(context);
            }

        } else if (UpdateInformation.serverFlag == 2) {
            // 官方强制升级
            forceUpdate(context);
        }
    }

    /**
     * 没有新版本
     * @param context
     */
    private void noNewVersion(final Context context) {
        mDialog = new AlertDialog.Builder(context);
        mDialog.setTitle("版本更新");
        mDialog.setMessage("当前为最新版本");
        mDialog.setNegativeButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create().show();
    }

    /**
     * 强制升级 ，如果不点击确定升级，直接退出应用
     *
     * @param context
     */
    private void forceUpdate(final Context context) {
        mDialog = new AlertDialog.Builder(context);
        mDialog.setTitle("版本更新");
        mDialog.setMessage(UpdateInformation.upgradeinfo);

        mDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                LogUtils.e("------------------确认按钮");
                Intent mIntent = new Intent(context, UpdateService.class);
                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mIntent.putExtra("appname", UpdateInformation.appname);
                mIntent.putExtra("appurl", UpdateInformation.updateurl);
                //启动服务
                context.startService(mIntent);
            }
        }).setNegativeButton("退出", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 直接退出应用
                //ManagerActivity.getInstance().finishActivity();
                LogUtils.e("------------------退出按钮");
                System.exit(0);
            }
        }).setCancelable(false).create().show();
    }

    /**
     * 正常升级，用户可以选择是否取消升级
     *
     * @param context
     */
    private void normalUpdate(final Context context) {
        mDialog = new AlertDialog.Builder(context);
        mDialog.setTitle("版本更新");
        mDialog.setMessage(UpdateInformation.upgradeinfo);
        mDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                LogUtils.e("------------------确认按钮");
                Intent mIntent = new Intent(context, UpdateService.class);
                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //传递数据
                mIntent.putExtra("appname", UpdateInformation.appname);
                mIntent.putExtra("appurl", UpdateInformation.updateurl);
                context.startService(mIntent);
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                LogUtils.e("------------------退出按钮");
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = mDialog.create();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){//6.0+
            alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);
        }else {
            alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        }
       // alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);
        alertDialog.show();
    }

    /**
     * 清理升级文件
     *
     * @param context
     */
    private void clearUpateFile(final Context context) {
        File updateDir;
        File updateFile;
        if (Environment.MEDIA_MOUNTED.equals(Environment
                .getExternalStorageState())) {
            updateDir = new File(Environment.getExternalStorageDirectory(),
                    UpdateInformation.downloadDir);
        } else {
            updateDir = context.getFilesDir();
        }
        updateFile = new File(updateDir.getPath(), context.getResources()
                .getString(R.string.app_name) + ".apk");
        if (updateFile.exists()) {
            Log.d("update", "升级包存在，删除升级包");
            updateFile.delete();
        } else {
            Log.d("update", "升级包不存在，不用删除升级包");
        }
    }
}
