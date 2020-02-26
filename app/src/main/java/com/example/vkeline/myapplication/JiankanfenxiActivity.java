package com.example.vkeline.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.vkeline.myapplication.data.Liushihuajiazi;
import com.vkeline.zlibrary.base.ZBaseActivity;
import com.vkeline.zlibrary.util.LogUtils;
import com.vkeline.zlibrary.view.HeadLayoutView;

public class JiankanfenxiActivity extends ZBaseActivity {

    private EditText jiankanfenxi_main;

    @Override
    public void initViewMVC() {
        super.initViewMVC();

        setContentView(R.layout.activity_jiankanfenxi);


        HeadLayoutView hlv = (HeadLayoutView) findViewById(R.id.jiankanfenxi_head);
        jiankanfenxi_main = (EditText) findViewById(R.id.jiankanfenxi_main);
        hlv.setCallBack(new HeadLayoutView.CallBack() {
            @Override
            public void clickLeft() {
                activity.finish();
            }

            @Override
            public void clickRight() {

            }
        });

        Liushihuajiazi huajiazi = new Liushihuajiazi();
        Bundle bundle = this.getIntent().getExtras();
        String qiangruo = bundle.getString("qiangruo");
        String xb = bundle.getString("xb");
        LogUtils.e("------------------------" + xb);

        String shishenshiyezongfenxi = "";

            //八字中却什么可以补充什么事业

                String caixing = huajiazi.getShishenshiye().get("财");
                shishenshiyezongfenxi = "1、八字五行金太旺，容易呼吸不顺，感冒咳嗽，或有气喘等症状。\n" +
                        "\n" +
                        "2、八字五行缺金，则容易鼻子过敏、流鼻水、咳嗽、感冒、胸闷、腹泻或便秘，也导致鼻窦炎、气喘、肺炎、支气管炎、大肠息肉、直肠炎等问题。\n" +
                        "\n" +
                        "3、八字五行木太旺，容易肝胆出问题，容易肝火旺盛，要注意胆固醇，三酸甘油酯的问题。\n" +
                        "\n" +
                        "4、八字缺木，容易疲累，体力差。八字木有问题者，劝你要少喝酒，戒酒最好，要维持正常作息，早睡早起，才可以保护先天比较弱的肝胆功能。\n" +
                        "\n" +
                        "5、八字五行水太旺，体质比较寒冷，所以身体比较弱，容易手脚冰冷。\n" +
                        "\n" +
                        "6、八字五行缺水，则要注意泌尿系统的保健。这样做事虽快速有效率，但是欠缺缜密的思考，运气好的时后一帆风顺，运气差的时候白忙一场。\n" +
                        "\n" +
                        "7、八字五行缺火，容易有血压，贫血，心跳慢，容易疲累等心血管的机能问题。\n" +
                        "\n" +
                        "8、八字五行火太旺，容易有高血压，高血脂，心跳快等心血管机能较弱的问题。充满太多“火”的五行，也会导致健康，财运与事业的不圆满。\n" +
                        "\n" +
                        "9、八字五行土太旺，胃肠机能比较弱，容易有腹胀，腹痛，腹泻，消化吸收的问题。\n" +
                        "\n" +
                        "10、八字五行缺土，会有胃肠功能消化系统病变问题，例如食道炎，胃炎、胃溃疡、肠炎、大肠息肉、痔疮、糖尿病等问题。容易紧张、生活也比较缺乏规律性。";

            jiankanfenxi_main.setText(shishenshiyezongfenxi);



    }
}
