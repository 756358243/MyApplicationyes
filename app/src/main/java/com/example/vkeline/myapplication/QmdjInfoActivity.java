package com.example.vkeline.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.example.vkeline.myapplication.Utils.CommonUtils;
import com.example.vkeline.myapplication.Utils.Lunar;
import com.example.vkeline.myapplication.Utils.YinYanLiHunhuan;
import com.example.vkeline.myapplication.data.DiquDatas;
import com.example.vkeline.myapplication.data.Liushihuajiazi;
import com.vkeline.zlibrary.base.ZBaseActivity;
import com.vkeline.zlibrary.util.LogUtils;
import com.vkeline.zlibrary.view.HeadLayoutView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

public class QmdjInfoActivity extends ZBaseActivity {

    private TextView chushengriqi;
    private TextView diqu;
    private DiquDatas diquDatas;
    private EditText xingming;
    private String xb = "男";

    private String yyl = "阳历";

    private String sfry = "否";

    private RadioGroup xingbie;
    private RadioGroup yangyingli;
    private RadioButton yangli;
    private RadioButton yingli;


    private RadioGroup shifourunyue;
    private RadioButton runyue;
    private RadioButton feirunyue;


    private EditText riqi;
    private RadioButton nan;
    private RadioButton nv;
    private RadioGroup.OnCheckedChangeListener mradiogroup;
    /**
     * 不使用mvp的加载布局
     */
    @Override
    public void initViewMVC() {

        LogUtils.e("加载关于页面");
        setContentView( R.layout.activity_qmdj_info);
        chushengriqi = (TextView)findViewById( R.id.qmriqi);
        diqu = (TextView)findViewById( R.id.qmdiqu);
        xingbie = (RadioGroup)findViewById(R.id.qmxingbie);
        nan = (RadioButton)findViewById(R.id.qmnan);
        nv = (RadioButton)findViewById(R.id.qmnv);
        xingbie.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                LogUtils.e("-----------"+nan.isChecked());
                if(nan.isChecked()){
                    xb = nan.getText().toString();
                    nan.setChecked(true);
                    nv.setChecked(false);
                }else if(nv.isChecked()){
                    xb = nv.getText().toString();
                    nv.setChecked(true);
                    nan.setChecked(false);
                }
            }
        });
        shifourunyue = (RadioGroup)findViewById(R.id.qmshifourunyue);
        shifourunyue.setVisibility(View.GONE);

        yangyingli = (RadioGroup)findViewById(R.id.qmyangyingli);
        yangli = (RadioButton)findViewById(R.id.qmyangli);
        yingli = (RadioButton)findViewById(R.id.qmyingli);

        yangyingli.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                LogUtils.e("-----------"+yangli.isChecked());
                if(yangli.isChecked()){
                    yyl = yangli.getText().toString();
                    yangli.setChecked(true);
                    yingli.setChecked(false);
                    shifourunyue.setVisibility(View.GONE);
                }else if(yingli.isChecked()){
                    yyl = yingli.getText().toString();
                    yingli.setChecked(true);
                    yangli.setChecked(false);
                    shifourunyue.setVisibility(View.VISIBLE);
                }
            }
        });
        runyue = (RadioButton)findViewById(R.id.qmrunyue);
        feirunyue = (RadioButton)findViewById(R.id.qmfeirunyue);



        shifourunyue.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                LogUtils.e("-----------"+yangli.isChecked());
                if(runyue.isChecked()){
                    sfry = runyue.getText().toString();
                    runyue.setChecked(true);
                    feirunyue.setChecked(false);
                }else if(feirunyue.isChecked()){
                    sfry = feirunyue.getText().toString();
                    feirunyue.setChecked(true);
                    runyue.setChecked(false);
                }
            }
        });

        diquDatas = new DiquDatas();

        HeadLayoutView hlv= (HeadLayoutView) findViewById(R.id.qimendunjia_head);

        hlv.setCallBack(new HeadLayoutView.CallBack() {
            @Override
            public void clickLeft() {
                activity.finish();
            }

            @Override
            public void clickRight() {

            }
        });
    }

    ;

    /**
     * 不使用mvp的处理业务
     */
    @Override
    public void initEventMVC() {
    }



    public void shururiqi(View view) {
        //时间选择器
        TimePickerView pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String t1=format.format(date);
                chushengriqi.setText(t1);
            }
        })
                .build();
        pvTime.setDate( Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
        pvTime.show();


    }


    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     * @param date1
     * @param date2
     * @return
     */
    public static int getDate2ToDate1(Date date1,Date date2)
    {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days;
    }

    public void address(View view) {


        OptionsPickerView pvOptions = new  OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3 ,View v) {
                //返回的分别是三个级别的选中位置
                String tx = diquDatas.getOptions1Items().get(options1).getPickerViewText()
                        + diquDatas.getOptions2Items().get(options1).get(option2)
                        ;
                diqu.setText(tx);
            }
        })
                .setSubmitText("确定")//确定按钮文字
                .setCancelText("取消")//取消按钮文字
                .setTitleText("城市选择")//标题
                .setSubCalSize(18)//确定和取消文字大小
                .setTitleSize(20)//标题文字大小
                .setTitleColor(Color.rgb(155,167,200))//标题文字颜色
                .setSubmitColor(Color.BLUE)//确定按钮文字颜色
                .setCancelColor( Color.BLUE)//取消按钮文字颜色
                .setTitleBgColor(0xFF000000)//标题背景颜色 Night mode
                .setBgColor(0xFF256789)//滚轮背景颜色 Night mode
                .setContentTextSize(18)//滚轮文字大小
                .setLinkage(true)//设置是否联动，默认true
                .setLabels("省", "市", "区")//设置选择的三级单位
                .setCyclic(false, false, false)//循环与否
                .setSelectOptions(1, 1, 1)  //设置默认选中项
                .setOutSideCancelable(false)//点击外部dismiss default true
                .isDialog(false)//是否显示为对话框样式
                .build();

        pvOptions.setPicker(diquDatas.getOptions1Items(), diquDatas.getOptions2Items());//添加数据源
        pvOptions.show();


    }
    public Integer panduanShiChen(Integer hour){
        Integer rs = 1;
        if(1<=hour && hour<3){
            rs=2;
        }
        if(3<=hour && hour<5){
            rs=3;
        }
        if(5<=hour && hour<7){
            rs=4;
        }
        if(7<=hour && hour<9){
            rs=5;
        }
        if(9<=hour && hour<11){
            rs=6;
        }
        if(11<=hour && hour<13){
            rs=7;
        }
        if(13<=hour && hour<15){
            rs=8;
        }
        if(15<=hour && hour<17){
            rs=9;
        }
        if(17<=hour && hour<19){
            rs=10;
        }
        if(19<=hour && hour<21){
            rs=11;
        }
        if(21<=hour && hour<23){
            rs=12;
        }
        if(hour<1 || hour>=23){
            rs=1;
        }
        return  rs;
    }


    public String getKey(Map<String, String> map, String value){
        String key = null;
        for (String getKey:map.keySet()){
            if (map.get(getKey).equals(value)){
                key = getKey;
            }
        }
        return  key;
    }



    public void zwkaishijisuan(View view){
        //获取当前页面的信息
        xingming = (EditText)findViewById(R.id.qmxingming);
        LogUtils.e(xingming.getText());
        LogUtils.e(xb);
        riqi = (EditText)findViewById(R.id.qmriqi);
        LogUtils.e(riqi.getText());
        diqu = (EditText)findViewById(R.id.qmdiqu);
        LogUtils.e(diqu.getText());
        /**获取了所有的信息后，进行跳转*/
        /**根据出生年月日进行八字简单排盘处理*/
        /**（1979-3）÷60=32······56获取年干支*/
        Calendar dayc1 = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        Liushihuajiazi huajiazi = new Liushihuajiazi();
        Integer myear= dayc1.get(Calendar.YEAR); // 获取当前年份
        Integer myue= dayc1.get(Calendar.MONTH); // 获取当前月份
        Integer myday= dayc1.get(Calendar.DAY_OF_MONTH); // 获取当前日
        try {
            dayc1.setTime(sdf.parse(riqi.getText().toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Intent intent =new Intent(this, ZwjieguoActivity.class);
        Bundle bundle=new Bundle();
        Lunar l = new Lunar(dayc1.getTimeInMillis());
        LogUtils.e("-----------------------========="+l.getLunarDateString()+"【"+l.getCyclicalDateString()+"】");
        LogUtils.e("农历年--"+l.getLunarYear()+"农历月--"+l.getLunarMonth()+"农历日--"+l.getLunarDay());

        /**截取获得年干*/
        String yearTiangan = l.getCyclicalDateString().substring(0,1);
        String yearDizhi = l.getCyclicalDateString().substring(1,2);
        String zuihouyuegan = l.getCyclicalDateString().substring(3,4);
        String zuihouyuezhi = l.getCyclicalDateString().substring(4,5);
        String riGan = l.getCyclicalDateString().substring(6,7);
        String diZhi = l.getCyclicalDateString().substring(7,8);
        LogUtils.e("-------------------------------------------------");
        LogUtils.e("年柱："+yearTiangan+"----"+yearDizhi);
        LogUtils.e("月柱："+zuihouyuegan+"----"+zuihouyuezhi);
        LogUtils.e("日柱："+riGan+"----"+diZhi);
        LogUtils.e("-------------------------------------------------");
        String zhGstring = getKey(huajiazi.getTiangan(),riGan);
        Integer zhG = Integer.valueOf(zhGstring);
        //计算时干
        Integer hour = dayc1.get(Calendar.HOUR_OF_DAY);
        Integer shichendizhi = panduanShiChen(hour);
        Integer zishitgshu = (2*zhG-2+shichendizhi)%10;
        if(zishitgshu == 0){
            zishitgshu = 10;
        }
        String shiGan = huajiazi.getTiangan().get(zishitgshu+"");
        String shizhi = huajiazi.getShidizhi().get(shichendizhi+"");
        LogUtils.e("时干："+shiGan+shizhi);
        LogUtils.e(yearTiangan);
        //传递name参数为tinyphp
        /**获取日干五行*/
        String yearTianganwuxing = huajiazi.getTianganwuxing().get(yearTiangan);
        String yearDizhiwuxing = huajiazi.getDizhiwuxing().get(yearDizhi);

        String yueTianganwuxing = huajiazi.getTianganwuxing().get(zuihouyuegan);
        String yueDizhiwuxing = huajiazi.getDizhiwuxing().get(zuihouyuezhi);

        String riTianganwuxing = huajiazi.getTianganwuxing().get(riGan);
        String riDizhiwuxing = huajiazi.getDizhiwuxing().get(diZhi);

        String shiTianganwuxing = huajiazi.getTianganwuxing().get(shiGan);
        String shiDizhiwuxing = huajiazi.getDizhiwuxing().get(shizhi);


        /**年干支*/
        bundle.putString("yearTiangan", yearTiangan);
        bundle.putString("yearDizhi", yearDizhi);

        bundle.putString("yearTianganshishen", huajiazi.getShishen().get(riTianganwuxing+yearTianganwuxing));

        /**月干支*/
        bundle.putString("yueTiangan",zuihouyuegan);
        bundle.putString("yueDizhi",zuihouyuezhi);

        bundle.putString("yueTianganshishen", huajiazi.getShishen().get(riTianganwuxing+yueTianganwuxing));

        /**日干支*/
        bundle.putString("riTiangan",riGan);
        bundle.putString("riDizhi",diZhi);



        bundle.putString("riTianganshishen", huajiazi.getShishen().get(riTianganwuxing+riTianganwuxing));

        /**时干支*/
        bundle.putString("shiTiangan",shiGan);
        bundle.putString("shiDizhi",shizhi);
        //

        bundle.putString("shiTianganshishen", huajiazi.getShishen().get(riTianganwuxing+shiTianganwuxing));

        //判断八字的强弱算法

        //日做支
        String rizhidishi= CommonUtils.shengwang(riGan,diZhi);
        //月令
        String yuelingdishi= CommonUtils.shengwang(riGan,zuihouyuezhi);
        //时支
        String shidishi= CommonUtils.shengwang(riGan,shizhi);
        //年支
        String naindishi= CommonUtils.shengwang(riGan,yearDizhi);


        bundle.putString("xingming",xingming.getText().toString());
        bundle.putString("xb",xb);
        bundle.putString("diqu",diqu.getText().toString());
        bundle.putString("nlriqi",l.getLunarYear()+"年"+l.getLunarMonth()+"月"+l.getLunarDay()+"日"+shiGan+shizhi+"时");
        //l.getLunarMonth()
        bundle.putString("nlyue",l.getLunarMonth()+"");

        bundle.putString("nlri",l.getLunarDay()+"");

        bundle.putString("riqi",riqi.getText().toString());
        bundle.putString("myear", String.valueOf(myear));
        //qidayun
        intent.putExtras(bundle);
        startActivity(intent);
    }



}
