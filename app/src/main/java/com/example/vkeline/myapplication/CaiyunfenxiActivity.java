package com.example.vkeline.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.vkeline.myapplication.data.Liushihuajiazi;
import com.vkeline.zlibrary.base.ZBaseActivity;
import com.vkeline.zlibrary.util.LogUtils;
import com.vkeline.zlibrary.view.HeadLayoutView;

public class CaiyunfenxiActivity extends ZBaseActivity {
    private EditText caiyunfenxi_main;
    @Override
    public void initViewMVC() {
        super.initViewMVC();

        setContentView(R.layout.activity_caiyunfenxi);


        HeadLayoutView hlv= (HeadLayoutView) findViewById(R.id.caiyunfenxi_head);
        caiyunfenxi_main = (EditText)findViewById(R.id.caiyunfenxi_main);
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
            /*String shishang = huajiazi.getShishenshiye().get("食");
            String guansha = huajiazi.getShishenshiye().get("官");
    */
            String caixing = huajiazi.getShishenshiye().get("财");

            LogUtils.e("------------------------");
            shishenshiyezongfenxi = "此人八字强，八字的财的多少就的看八字中的正财和偏财了，"+caixing+"不管八字中是正财带的多还是偏才带得多，都是很有钱的一个八字，如果八字不带正财或者偏才，也不能没有钱，这是要根据此人的运势，运势走了正财或者偏才运，那么一样可以发财。";
            caiyunfenxi_main.setText(shishenshiyezongfenxi);

        }else if(qiangruo.contains("弱")){
            //八字偏弱的，适合比肩劫财，印枭
           /* String bijie = huajiazi.getShishenshiye().get("比");
            String yinxing = huajiazi.getShishenshiye().get("印");
*/
            String caixing = huajiazi.getShishenshiye().get("财");
            shishenshiyezongfenxi = "此人八字偏弱，八字带的财越多反而不好，容易存不住钱，正财和偏才是指："+caixing+"看这类人的财富，那么是需要看此人的比肩和劫财，比肩劫财带的多，多数是能挣到钱，但是比较难存。大运走的比肩和劫财运势，也是可以挣到钱。";
            caiyunfenxi_main.setText(shishenshiyezongfenxi);

        }else if(qiangruo.contains("中和")){
            //八字中却什么可以补充什么事业
            String caixing = huajiazi.getShishenshiye().get("财");
            shishenshiyezongfenxi = "此人八字中和，一生没有什么大的灾难，一生的财运不会太差，如果大运的运势配合的好，那么能够发财，如果大运走的正财或者是偏才，那么这个人是可以挣到钱的，正财和偏才是指"+caixing+"如果八字带的多，那么此人一生会有比较多的财富。";
            caiyunfenxi_main.setText(shishenshiyezongfenxi);

        }



    }

}
