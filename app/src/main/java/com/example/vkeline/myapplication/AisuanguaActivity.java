package com.example.vkeline.myapplication;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import com.example.vkeline.myapplication.data.Liushihuajiazi;
import com.vkeline.zlibrary.base.ZBaseActivity;
import com.vkeline.zlibrary.util.LogUtils;
import com.vkeline.zlibrary.view.HeadLayoutView;

public class AisuanguaActivity extends ZBaseActivity {


    @Override
    public void initViewMVC() {
        super.initViewMVC();
        setContentView(R.layout.activity_aisuanguabazihehun);
        HeadLayoutView hlv= (HeadLayoutView) findViewById(R.id.asgbazihehun_head);
        hlv.setCallBack(new HeadLayoutView.CallBack() {
            @Override
            public void clickLeft() {
                activity.finish();
            }

            @Override
            public void clickRight() {

            }
        });
        //获取对应到url
        Bundle bundle = this.getIntent().getExtras();
        String url = bundle.getString("url");
        LogUtils.e("------------------------"+url);
        //获得WebView控件
        WebView webView=(WebView)findViewById(R.id.idWebViewasgbazihehun);
        webView.setWebViewClient(new WebViewClient() {});
        WebSettings webSettings = webView.getSettings();
        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        //调用loadUrl()方法嵌入百度新闻页面
        webView.loadUrl(url);
    }



}
