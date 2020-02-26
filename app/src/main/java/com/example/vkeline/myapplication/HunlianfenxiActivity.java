package com.example.vkeline.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.vkeline.myapplication.data.Liushihuajiazi;
import com.vkeline.zlibrary.base.ZBaseActivity;
import com.vkeline.zlibrary.util.LogUtils;
import com.vkeline.zlibrary.view.HeadLayoutView;

public class HunlianfenxiActivity extends ZBaseActivity {
    private EditText hunlianfenxi_main;
    @Override
    public void initViewMVC() {
        super.initViewMVC();

        setContentView(R.layout.activity_hunlianfenxi);


        HeadLayoutView hlv= (HeadLayoutView) findViewById(R.id.hunlianfenxi_head);
        hunlianfenxi_main = (EditText)findViewById(R.id.hunlianfenxi_main);
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
        LogUtils.e("------------------------"+xb);

        String shishenshiyezongfenxi = "";
        if(qiangruo.contains("强")){
            //八字偏强，适合工作为食伤，官杀，财才
            /*String shishang = huajiazi.getShishenshiye().get("食");
            String guansha = huajiazi.getShishenshiye().get("官");
    */
            if("男".equals(xb)){
                String caixing = huajiazi.getShishenshiye().get("财");
                shishenshiyezongfenxi = "此人八字强，是一个男命八字，男命以财为异性，八字财星旺，虽然可以挣到很多的钱，但是也是说明大运来了异性也是很旺的，财和才指"+caixing+"。八字用财，日过日做偏才或者是月令偏才，多数是生意人，异性多，如果八字财星不见，说明异性缘相对少，并且大运来了还是有。";
            }else{
                String guansha = huajiazi.getShishenshiye().get("官");
                shishenshiyezongfenxi = "此人八字强，是一个女命八字，女命以官为异性，八字官星旺，说明异性比教有能力，容易有权，或者是管理人员，官和杀指"+guansha+"。八字用官，日过日做杀或者是月令杀，多数不能专一，容易出轨，同时也说明异性缘分混乱，找不到合适的缘分。如果八字官杀都透，此人婚姻必定不顺，容易有二婚。";

            }

            hunlianfenxi_main.setText(shishenshiyezongfenxi);

        }else if(qiangruo.contains("弱")){
            //八字偏弱的，适合比肩劫财，印枭
           /* String bijie = huajiazi.getShishenshiye().get("比");
            String yinxing = huajiazi.getShishenshiye().get("印");
*/
            if("男".equals(xb)){
                String caixing = huajiazi.getShishenshiye().get("财");
                shishenshiyezongfenxi = "此人八字弱，是一个男命八字，男命以财为异性，八字财星旺，容易 存不到钱，并且多是与金钱有关的工作，自己用钱大，挣钱少，但是也是说明大运来了比肩劫财，财运也是很旺的，财和才指"+caixing+"。八字忌财，日过日做偏才或者是月令偏才，多数是不专一，并且容易出鬼，用钱大方，如流水。异性多，如果八字财星不见，说明异性缘相对少，并且大运来了还是有。";
            }else{
                String guansha = huajiazi.getShishenshiye().get("官");
                shishenshiyezongfenxi = "此人八字弱，是一个女命八字，女命以官为异性，八字官星旺，说明异性比教多，容易有口舌是非，或者是身边异性异性多，官和杀指"+guansha+"。八字忌官，日过日做杀或者是月令杀，多数不能专一，容易出轨，同时也说明异性缘分混乱，找不到合适的缘分。如果八字官杀都透，此人婚姻必定不顺，容易有二婚。同时容易有口舌是非，官司之事";

            }
            hunlianfenxi_main.setText(shishenshiyezongfenxi);

        }else if(qiangruo.contains("中和")){
            //八字中却什么可以补充什么事业
            if("男".equals(xb)){
                String caixing = huajiazi.getShishenshiye().get("财");
                shishenshiyezongfenxi = "此人八字中和，是一个男命八字，男命以财为异性，八字财星旺，容易存到些钱，但是挣到不多，并且多是与金钱有关的工作，自己用钱大，但是也是说明大运来了比肩劫财，财运也是很旺的，财和才指"+caixing+"。八字忌财，日过日做偏才或者是月令偏才，多数是不专一，并且容易出鬼，用钱大方，如流水。异性多，如果八字财星不见，说明异性缘相对少，并且大运来了还是有。";
            }else{
                String guansha = huajiazi.getShishenshiye().get("官");
                shishenshiyezongfenxi = "此人八字中和，是一个女命八字，女命以官为异性，八字官星旺，说明异性比教多，容易有口舌是非，或者是身边异性异性多，官和杀指"+guansha+"。八字忌官，日过日做杀或者是月令杀，多数不能专一，容易出轨，同时也说明异性缘分混乱，找不到合适的缘分。如果八字官杀都透，此人婚姻必定不顺，容易有二婚。同时容易有口舌是非，官司之事";

            }
            hunlianfenxi_main.setText(shishenshiyezongfenxi);

        }



    }


}
