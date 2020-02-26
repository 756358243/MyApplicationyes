package com.example.vkeline.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.vkeline.myapplication.data.Liushihuajiazi;
import com.vkeline.zlibrary.base.ZBaseActivity;
import com.vkeline.zlibrary.util.LogUtils;
import com.vkeline.zlibrary.view.HeadLayoutView;

public class ShiyexianshiActivity extends ZBaseActivity {

    private EditText shiyefenxi_main;

    @Override
    public void initViewMVC() {
        super.initViewMVC();

        setContentView(R.layout.activity_shiyexianshi);


        HeadLayoutView hlv= (HeadLayoutView) findViewById(R.id.shiyefenxi_head);
        shiyefenxi_main = (EditText)findViewById(R.id.shiyefenxi_main);
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
        LogUtils.e("------------------------"+qiangruo);

        String shishenshiyezongfenxi = "";
        if(qiangruo.contains("强")){
            //八字偏强，适合工作为食伤，官杀，财才
            String shishang = huajiazi.getShishenshiye().get("食");
            String guansha = huajiazi.getShishenshiye().get("官");
            String caixing = huajiazi.getShishenshiye().get("财");
            LogUtils.e("------------------------"+shishang);
            shishenshiyezongfenxi = "如果八字中是食神或者伤官旺的人，那么是"+shishang+"。如果八字中官杀比较旺的人，那么是"+guansha+"。如果是正财偏财比较旺的人，那么是"+caixing;
            shiyefenxi_main.setText(shishenshiyezongfenxi);

        }else if(qiangruo.contains("弱")){
            //八字偏弱的，适合比肩劫财，印枭
            String bijie = huajiazi.getShishenshiye().get("比");
            String yinxing = huajiazi.getShishenshiye().get("印");
            shishenshiyezongfenxi = "如果八字中是比肩或者劫财旺的人，那么是"+bijie+"。如果是正印或者偏印旺的人，那么是"+yinxing;
            shiyefenxi_main.setText(shishenshiyezongfenxi);

        }else if(qiangruo.contains("中和")){
            //八字中却什么可以补充什么事业
            shishenshiyezongfenxi = "此人八字中和，一生没有什么大的灾难，同时在事业方面是都比较适合的，如果八字中五行水弱点，那么还是可以补点水的职业更好，缺点什么还是补点什么会更好。中和的八字在古代算命来说，是非常好的八字。";
            shiyefenxi_main.setText(shishenshiyezongfenxi);

        }

        //yuezhishishenshuoming

    }
}
