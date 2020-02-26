package com.example.vkeline.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.vkeline.myapplication.data.Liushihuajiazi;
import com.vkeline.zlibrary.base.ZBaseActivity;
import com.vkeline.zlibrary.util.LogUtils;
import com.vkeline.zlibrary.view.HeadLayoutView;

public class BazimingyunActivity extends ZBaseActivity {
    private EditText bazimingyun_main;
    @Override
    public void initViewMVC() {
        super.initViewMVC();

        setContentView(R.layout.activity_bazimingyun);


        HeadLayoutView hlv= (HeadLayoutView) findViewById(R.id.bazimingyun_head);
        bazimingyun_main = (EditText)findViewById(R.id.bazimingyun_main);
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
            String caixing = huajiazi.getShishenshiye().get("财");
*/
            LogUtils.e("------------------------");
            shishenshiyezongfenxi = "此人八字强，是一个比较强的八字，八字强，见到了食神伤官，那么是适合做技术的一生，如果是正财，打工还是很适合的，见偏才，可以自己去创业，或者做写偏门的事业，见正印偏印，搞艺术或者是学术类的一生，八字如果比肩劫财比较多，加上大运走的比肩劫财，那么是财来财去的一生。如果见正官或者官杀，那么是从政的一生比较适合。";
            bazimingyun_main.setText(shishenshiyezongfenxi);

        }else if(qiangruo.contains("弱")){
            //八字偏弱的，适合比肩劫财，印枭
           /* String bijie = huajiazi.getShishenshiye().get("比");
            String yinxing = huajiazi.getShishenshiye().get("印");
*/
            shishenshiyezongfenxi = "此人八字偏弱，如果八字比肩劫财多，那么此人一生贵人帮，如果是食神伤官多，感情不顺先不说，事业不佳也常有，如果是正财偏才旺，那么此人大方不存钱的一生，如果是正官七杀多，那么此人一生可能会有官司是非，如果正印偏印，那么此人容易成名，容易在学术上有成就。";
            bazimingyun_main.setText(shishenshiyezongfenxi);

        }else if(qiangruo.contains("中和")){
            //八字中却什么可以补充什么事业
            shishenshiyezongfenxi = "此人八字中和，一生没有什么大的灾难，同时在事业方面是都比较适合的，如果八字中五行水弱点，那么还是可以补点水的职业更好，缺点什么还是补点什么会更好。八字的强弱容易受到运势的影响从而影响。中和的八字在古代算命来说，是非常好的八字。";
            bazimingyun_main.setText(shishenshiyezongfenxi);

        }



    }
}
