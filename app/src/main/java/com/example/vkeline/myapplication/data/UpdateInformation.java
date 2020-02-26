package com.example.vkeline.myapplication.data;

import com.example.vkeline.myapplication.R;

public class UpdateInformation {

    public static String appname = "";
    public static int localVersion = 1;// 本地版本
    public static String versionName = ""; // 本地版本名
    public static int serverVersion = 1;// 服务器版本
    public static int serverFlag = 0;// 服务器标志
    public static int lastForce = 0;// 之前强制升级版本
    public static String updateurl = "";// 升级包获取地址
    public static String upgradeinfo = "";// 升级信息

    public static String downloadDir = "wuyinlei";// 下载目录

    public static String getAppname() {
        return appname;
    }

    public static void setAppname(String appname) {
        UpdateInformation.appname = appname;
    }

    public static int getLocalVersion() {
        return localVersion;
    }

    public static void setLocalVersion(int localVersion) {
        UpdateInformation.localVersion = localVersion;
    }

    public static String getVersionName() {
        return versionName;
    }

    public static void setVersionName(String versionName) {
        UpdateInformation.versionName = versionName;
    }

    public static int getServerVersion() {
        return serverVersion;
    }

    public static void setServerVersion(int serverVersion) {
        UpdateInformation.serverVersion = serverVersion;
    }

    public static int getServerFlag() {
        return serverFlag;
    }

    public static void setServerFlag(int serverFlag) {
        UpdateInformation.serverFlag = serverFlag;
    }

    public static int getLastForce() {
        return lastForce;
    }

    public static void setLastForce(int lastForce) {
        UpdateInformation.lastForce = lastForce;
    }

    public static String getUpdateurl() {
        return updateurl;
    }

    public static void setUpdateurl(String updateurl) {
        UpdateInformation.updateurl = updateurl;
    }

    public static String getUpgradeinfo() {
        return upgradeinfo;
    }

    public static void setUpgradeinfo(String upgradeinfo) {
        UpdateInformation.upgradeinfo = upgradeinfo;
    }

    public static String getDownloadDir() {
        return downloadDir;
    }

    public static void setDownloadDir(String downloadDir) {
        UpdateInformation.downloadDir = downloadDir;
    }
}
