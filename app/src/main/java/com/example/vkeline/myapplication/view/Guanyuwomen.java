package com.example.vkeline.myapplication.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import com.example.vkeline.myapplication.HunlianfenxiActivity;
import com.example.vkeline.myapplication.R;
import com.vkeline.zlibrary.base.ZBaseFragment;

/**
 * Created by vkeline on 2018/3/1.
 */
public class Guanyuwomen extends ZBaseFragment {

    @Override
    protected int initViewMVC() {
        return R.layout.guanyuwomen;
    }




    @Override
    protected void initEventMVC(View v) {

        //获得WebView控件
        WebView webView=(WebView)v.findViewById(R.id.idWebView);
        WebSettings webSettings = webView.getSettings();
        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webView.setWebViewClient(new WebViewClient() {});
        //调用loadUrl()方法嵌入百度新闻页面
        webView.loadUrl("https://www.aisuangua.com/");

       /* aisuangua = v.findViewById(R.id.aisuangua);
        aisuangua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //爱情，婚姻分析，男看正财偏才，女看官杀
                Intent intent = new Intent();
                Uri content_url = Uri.parse("http://www.aisuangua.com");
                intent.setAction("android.intent.action.VIEW").setData(content_url);
                getActivity().startActivity(intent);
            }
        });*/
    }


}

