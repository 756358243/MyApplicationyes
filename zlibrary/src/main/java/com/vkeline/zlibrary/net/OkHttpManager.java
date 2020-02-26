package com.vkeline.zlibrary.net;


import com.vkeline.zlibrary.util.LogUtils;
import com.vkeline.zlibrary.util.StringUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.request.RequestCall;

import java.io.File;
import java.util.Map;

/**
 * @author Zhou
 *         Created on 2017/12/1 14:39.
 *         Email:qishuichixi@163.com
 *         Desc:网络请求，详情见https://github.com/hongyangAndroid/okhttputils
 */

public class OkHttpManager {

    private static OkHttpManager httpManager;

    private OkHttpManager() {
    }

    /**
     * 单例模式
     *
     * @return HttpManager对象
     */
    public static OkHttpManager getInstance() {
        if (httpManager == null) {
            synchronized (OkHttpManager.class) {
                if (httpManager == null) {
                    httpManager = new OkHttpManager();
                }
            }
        }
        return httpManager;
    }


    /**
     * 打印请求路径日志
     *
     * @param url
     * @param params
     */
    private void outLog(String url, Map<String, String> params) {

        if (LogUtils.getShow() && params != null) {
            String p = "";
            for (String key : params.keySet()) {
                p = p + StringUtils.addString(key, "=", params.get(key), "&");
            }
            LogUtils.e(StringUtils.addString("请求路径:", url, "?", p));
        } else {
            LogUtils.e(StringUtils.addString("请求路径:", url));
        }
    }

    /**
     * get请求
     * 可以下载文件
     *
     * @param url    请求路径
     * @param params 请求参数
     * @return RequestCall
     */
    public RequestCall get(String url, Map<String, String> params) {

        outLog(url, params);
        return OkHttpUtils.get().url(url).params(params).build();
    }

    /**
     * 无参数get请求
     *
     * @param url
     * @return
     */
    public RequestCall get(String url) {
        LogUtils.e(StringUtils.addString("请求路径:", url));
        return OkHttpUtils.get().url(url).build();
    }

    /**
     * post请求
     *
     * @param url    请求路径
     * @param params 请求参数
     * @return RequestCall
     */
    public RequestCall post(String url, Map<String, String> params) {

        outLog(url, params);
        return OkHttpUtils.post().url(url).params(params).build();
    }

    public RequestCall post(String url) {
        LogUtils.e(StringUtils.addString("请求路径:", url));
        return OkHttpUtils.post().url(url).build();
    }

    /**
     * post提交文件
     *
     * @param url
     * @param file
     * @return
     */
    public RequestCall postFile(String url, File file) {
        LogUtils.e(StringUtils.addString("post提交文件:", url));
        return OkHttpUtils.postFile().url(url).file(file).build();
    }

    public RequestCall postFile(String url, Map params, File file) {

        return OkHttpUtils.post()//
                .addFile("file", file.getName(), file)//
                .url(url)
                .params(params)//
                .build();//
    }

    /**
     * @param url        上传地址
     * @param params     其他文本信息
     * @param fileParams 表单文件接收参数
     * @return
     */
    public RequestCall postFile(String url, Map params, String fileParams, File file) {

        outLog(url,params);
        return OkHttpUtils.post()//
                .addFile(fileParams, file.getName(), file)//
                .url(url)
                .params(params)//
                .build();//
    }


    /**
     * 取消请求路径
     *
     * @param url
     */
    public void cancel(String url) {
        LogUtils.e(StringUtils.addString("取消网络请求:", url));
        get(url, null).cancel();
    }


}
