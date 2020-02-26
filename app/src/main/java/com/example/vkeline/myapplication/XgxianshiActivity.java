package com.example.vkeline.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.vkeline.zlibrary.base.ZBaseActivity;
import com.vkeline.zlibrary.base.ZBaseFragment;
import com.vkeline.zlibrary.view.HeadLayoutView;

public class XgxianshiActivity extends ZBaseActivity {

private EditText xinggefenxi_main;
 @Override
 public void initViewMVC() {
     super.initViewMVC();

     setContentView(R.layout.activity_xgxianshi);


     HeadLayoutView hlv= (HeadLayoutView) findViewById(R.id.xinggefenxi_head);
     xinggefenxi_main = (EditText)findViewById(R.id.xinggefenxi_main);
     hlv.setCallBack(new HeadLayoutView.CallBack() {
         @Override
         public void clickLeft() {
             activity.finish();
         }

         @Override
         public void clickRight() {

         }
     });


     Bundle bundle = this.getIntent().getExtras();
     String yuewuxingshuoming = bundle.getString("yuewuxingshuoming");
     //yuezhishishenshuoming
     String yuezhishishenshuoming = bundle.getString("yuezhishishenshuoming");
     String rizhizhishishenshuoming = bundle.getString("rizhizhishishenshuoming");
     String riTiangan = bundle.getString("riTiangan");
     String yueDizhi = bundle.getString("yueDizhi");
     String zongxinggefenxi ="此人为"+riTiangan+"日出生的人，生于"+yueDizhi+"月。从月令五行分析此人性格："+yuewuxingshuoming+"。从月令十神分析此人："+yuezhishishenshuoming+"。从日支食神分析此人："+rizhizhishishenshuoming+"。";
     xinggefenxi_main.setText(zongxinggefenxi);
 }

}
