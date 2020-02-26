package com.example.vkeline.myapplication;


import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.example.vkeline.myapplication.Receiver.UpdateReceiver;
import com.example.vkeline.myapplication.Utils.CommonUtils;
import com.example.vkeline.myapplication.Utils.Lunar;
import com.example.vkeline.myapplication.Utils.YinYanLiHunhuan;
import com.example.vkeline.myapplication.data.DiquDatas;
import com.example.vkeline.myapplication.data.JsonRsUpdateInfoModel;
import com.example.vkeline.myapplication.data.Liushihuajiazi;
import com.example.vkeline.myapplication.data.UpdateInfoModel;
import com.vkeline.zlibrary.activity.CheckPermissionsActivity;
import com.vkeline.zlibrary.net.OkHttpManager;
import com.vkeline.zlibrary.util.LogUtils;
import com.vkeline.zlibrary.view.HeadLayoutView;
import com.zhy.http.okhttp.callback.StringCallback;
import okhttp3.Call;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class BzInfoActivity extends CheckPermissionsActivity {

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
    @Override
    public void initViewMVC() {
        LogUtils.e("加载关于页面");
        setContentView( R.layout.activity_bz_info);
        chushengriqi = (TextView)findViewById( R.id.riqi);
        diqu = (TextView)findViewById( R.id.diqu);
        xingbie = (RadioGroup)findViewById(R.id.xingbie);
        nan = (RadioButton)findViewById(R.id.nan);
        nv = (RadioButton)findViewById(R.id.nv);
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
        shifourunyue = (RadioGroup)findViewById(R.id.shifourunyue);
        shifourunyue.setVisibility(View.GONE);

        yangyingli = (RadioGroup)findViewById(R.id.yangyingli);
        yangli = (RadioButton)findViewById(R.id.yangli);
        yingli = (RadioButton)findViewById(R.id.yingli);

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
        runyue = (RadioButton)findViewById(R.id.runyue);
        feirunyue = (RadioButton)findViewById(R.id.feirunyue);



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

        HeadLayoutView hlv= (HeadLayoutView) findViewById(R.id.xinggefenxi_head);

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



    @Override
    public void initEventMVC() {

        String []per={WRITE_EXTERNAL_STORAGE};
        setNeedPermissions(per);
        //updateDiy();
        updateApp();


    }




    /**
     * shenj
     */
    private void updateApp() {


        OkHttpManager.getInstance().get("https://www.aisuangua.com/queryBuVersion").execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                LogUtils.e("-------------------onError"+e.getMessage());
            }

            @Override
            public void onResponse(String result, int id) {
                LogUtils.e("-------------------");
                String versionName = CommonUtils.getVersionName(BzInfoActivity.this);
                LogUtils.e("-------------------"+versionName);

                    Log.d("wuyiunlei",result);
                    UpdateInfoModel model = new UpdateInfoModel();
                //Object rsUpdateInfoModel = JSON.parse(result);
                JsonRsUpdateInfoModel rs = JSONObject.parseObject(result,JsonRsUpdateInfoModel.class);
                if ("1".equals(rs.getCode())){
                     return;
                }
                model.setAppname(rs.getRs().getAppname());
                model.setAppurl(rs.getRs().getAppurl());
                //model.setServerVersion(rs.getRs().getServerVersion());
                model.setServerVersion("3");
                model.setServerFlag(rs.getRs().getServerFlag());
                model.setUpgradeinfo(rs.getRs().getUpgradeinfo());
                model.setLastForce(rs.getRs().getLastForce());
                    //tmpMap.put(DeliverConsts.KEY_APP_UPDATE, model);
                //发送广播
                //先获取权限
                requestOverlayPermission();
                Intent intent = new Intent();
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("model", model);
                intent.setAction(UpdateReceiver.UPDATE_ACTION);
                intent.setComponent(new ComponentName("com.example.vkeline.myapplication",
                        "com.example.vkeline.myapplication.Receiver.UpdateReceiver"));
                sendBroadcast(intent);
            }


        });





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

    private static final int REQUEST_OVERLAY = 4444;
    private void requestOverlayPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (!Settings.canDrawOverlays(BzInfoActivity.this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, REQUEST_OVERLAY);
            } else {

            }
        }

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


    public String getKey(Map<String, String> map, String value){
        String key = null;
        for (String getKey:map.keySet()){
            if (map.get(getKey).equals(value)){
                key = getKey;
            }
        }
        return  key;
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

    public void kaishijisuan(View view){
        //获取当前页面的信息
        xingming = (EditText)findViewById(R.id.xingming);
        LogUtils.e(xingming.getText());
        LogUtils.e(xb);
        riqi = (EditText)findViewById(R.id.riqi);
        LogUtils.e(riqi.getText());
        diqu = (EditText)findViewById(R.id.diqu);
        LogUtils.e(diqu.getText());
        /**获取了所有的信息后，进行跳转*/
        /**根据出生年月日进行八字简单排盘处理*/
        /**（1979-3）÷60=32······56获取年干支*/
        Calendar dayc1 = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        //2018-01-01 00:00:00
        Boolean sbsry = false;
        String zuihoushijian = chushengriqi.getText().toString();
        if("阴历".equals(yyl)){
            if("是".equals(sfry)){
                sbsry = true;
            }
            //调用转换为阳历
            String jiequshij = chushengriqi.getText().toString();
            String jiequnian = jiequshij.substring(0,4);
            String jiequyue = jiequshij.substring(5,7);
            String jiequri = jiequshij.substring(8,10);
            String xiaoshijiequ = jiequshij.substring(10,19);
            LogUtils.e("截取的年：---"+jiequnian+"截取是月"+jiequyue+"截取的日："+jiequri+"--------------"+xiaoshijiequ);
            //转换的日期
            String zhsj = jiequnian+jiequyue+jiequri;
            try {
                 String yangli= YinYanLiHunhuan.lunarToSolar(zhsj, sbsry);
                String zhuanhounian = yangli.substring(0,4);
                String zhuanhouyue = yangli.substring(4,6);
                String zhuanhouri = yangli.substring(6,8);
                LogUtils.e("转换后的年：---"+zhuanhounian+"转换后的月"+zhuanhouyue+"转换后的日："+zhuanhouri);
                //拼接为阳历
                String zuihouyangl = zhuanhounian+"-"+ zhuanhouyue+"-"+zhuanhouri+xiaoshijiequ;
                zuihoushijian = zuihouyangl;
                LogUtils.e("最后转换后的阳历时间：---"+zuihouyangl);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            date = sdf.parse(zuihoushijian);
            dayc1.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Liushihuajiazi huajiazi = new Liushihuajiazi();
        Integer myear= dayc1.get(Calendar.YEAR); // 获取当前年份
        Integer myue= dayc1.get(Calendar.MONTH); // 获取当前月份
        Intent intent =new Intent(this, BzjieguoActivity.class);
        Bundle bundle=new Bundle();
        Lunar l = new Lunar(dayc1.getTimeInMillis());
        bundle.putString("nongliriqi",l.getLunarDateString()+"【"+l.getCyclicalDateString()+"】");
        //节气
        int[] a = Lunar.getnearsolarTerm(myear, dayc1.getTime());
        Date[] jieqi = Lunar.jieqilist(myear);
        String jq = "";
        LogUtils.e("第一个节气："+a[0]+"第二个节气："+a[1]);
        int ksquyu = a[0]%24;
        int jsquyu = a[1]%24;
        if(ksquyu == 24){
            ksquyu =1;
        }
        if(jsquyu == 24){
            jsquyu=1;
        }
        List<Date> jieqiall = Lunar.Alljieqi(myear);
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String kscreatedate = s.format(jieqiall.get(a[0]).getTime());
        String jscreatedate = s.format(jieqiall.get(a[1]).getTime());
        LogUtils.e("kscreatedate："+kscreatedate);
        LogUtils.e("jscreatedate："+jscreatedate);

        jq = myear+"年的"+Lunar.solarTerm[ksquyu]+":"+kscreatedate+","+Lunar.solarTerm[jsquyu]+":"+jscreatedate;
        bundle.putString("jq",jq);

        LogUtils.e(jq);


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

        /**获取地支藏干*/
        String[] yearDizhiwuxingcangan = huajiazi.getDizhicanzhi().get(yearDizhi);
        String nianzhicangan = "";
        String niancanganshishen = "";
        for (String yz:yearDizhiwuxingcangan) {
            nianzhicangan = nianzhicangan+yz;
            LogUtils.e(yearDizhi+"年支藏支：---"+nianzhicangan);
            /**获取对应的十神*/
            String canganwuxin = huajiazi.getTianganwuxing().get(yz);
            niancanganshishen =niancanganshishen+ huajiazi.getShishen().get(riTianganwuxing+canganwuxin);
            LogUtils.e("年支藏支十神：---"+niancanganshishen);

        }


        /**获取地支藏干*/
        String[] yueDizhiwuxingcangan = huajiazi.getDizhicanzhi().get(zuihouyuezhi);
        String yuezhicangan = "";
        String yuecanganshishen = "";
        for (String yz:yueDizhiwuxingcangan) {
            yuezhicangan = yuezhicangan+yz;
            LogUtils.e(zuihouyuezhi+"月支藏支：---"+yuezhicangan);
            /**获取对应的十神*/
            String canganwuxin = huajiazi.getTianganwuxing().get(yz);
            yuecanganshishen =yuecanganshishen+ huajiazi.getShishen().get(riTianganwuxing+canganwuxin);
            LogUtils.e("月支藏支十神：---"+yuecanganshishen);

        }



        /**获取地支藏干*/
        String[] riDizhiwuxingcangan = huajiazi.getDizhicanzhi().get(diZhi);
        String rizhicangan = "";
        String ricanganshishen = "";
        for (String yz:riDizhiwuxingcangan) {
            rizhicangan = rizhicangan+yz;
            LogUtils.e(zuihouyuezhi+"日支藏支：---"+rizhicangan);
            /**获取对应的十神*/
            String canganwuxin = huajiazi.getTianganwuxing().get(yz);
            ricanganshishen =ricanganshishen+ huajiazi.getShishen().get(riTianganwuxing+canganwuxin);
            LogUtils.e("日支藏支十神：---"+ricanganshishen);

        }

        /**获取地支藏干*/
        String[] shiDizhiwuxingcangan = huajiazi.getDizhicanzhi().get(shizhi);
        String shizhicangan = "";
        String shicanganshishen = "";
        for (String yz:shiDizhiwuxingcangan) {
            shizhicangan = shizhicangan+yz;
            LogUtils.e(zuihouyuezhi+"时支藏支：---"+shizhicangan);
            /**获取对应的十神*/
            String canganwuxin = huajiazi.getTianganwuxing().get(yz);
            shicanganshishen =shicanganshishen+ huajiazi.getShishen().get(riTianganwuxing+canganwuxin);
            LogUtils.e("时支藏支十神：---"+shicanganshishen);

        }

        /**年干支*/
        bundle.putString("yearTiangan", yearTiangan);
        bundle.putString("yearDizhi", yearDizhi);

        bundle.putString("yearTianganshishen", huajiazi.getShishen().get(riTianganwuxing+yearTianganwuxing));
        bundle.putString("nianzhicangan", nianzhicangan);
        bundle.putString("yearDizhishishen", niancanganshishen);

        /**月干支*/
        bundle.putString("yueTiangan",zuihouyuegan);
        bundle.putString("yueDizhi",zuihouyuezhi);
        bundle.putString("yuezhicangan",yuezhicangan);

        bundle.putString("yueTianganshishen", huajiazi.getShishen().get(riTianganwuxing+yueTianganwuxing));
        bundle.putString("yueDizhishishen", yuecanganshishen);

        /**日干支*/
        bundle.putString("riTiangan",riGan);
        bundle.putString("riDizhi",diZhi);

        bundle.putString("rizhicangan",rizhicangan);


        bundle.putString("riTianganshishen", huajiazi.getShishen().get(riTianganwuxing+riTianganwuxing));
        bundle.putString("riDizhishishen", ricanganshishen);

        /**时干支*/
        bundle.putString("shiTiangan",shiGan);
        bundle.putString("shiDizhi",shizhi);
        //
        bundle.putString("shizhicangan",shizhicangan);

        bundle.putString("shiTianganshishen", huajiazi.getShishen().get(riTianganwuxing+shiTianganwuxing));
        bundle.putString("shiDizhishishen", shicanganshishen);

        //判断八字的强弱算法

        //日做支
        String rizhidishi= CommonUtils.shengwang(riGan,diZhi);
        //月令
        String yuelingdishi= CommonUtils.shengwang(riGan,zuihouyuezhi);
        //时支
        String shidishi= CommonUtils.shengwang(riGan,shizhi);
        //年支
        String naindishi= CommonUtils.shengwang(riGan,yearDizhi);

        //得到地势得分（40分制度）
        Integer dishidefen = CommonUtils.dishidefen(yuelingdishi,"dishi");
        //日支得到做支得分（20分制度）
        Integer rizhidefen = CommonUtils.dishidefen(rizhidishi,"rizhi");
        //天干得分总为21分
        Integer niantiangandefen = CommonUtils.tiangandefen(huajiazi.getShishen().get(riTianganwuxing+yearTianganwuxing));
        Integer yuetiangandefen = CommonUtils.tiangandefen(huajiazi.getShishen().get(riTianganwuxing+yueTianganwuxing));
        Integer shitiangandefen = CommonUtils.tiangandefen(huajiazi.getShishen().get(riTianganwuxing+shiTianganwuxing));
        //其他地支得总分20分
        Integer shizhidefen = CommonUtils.dishidefen(shidishi,"rizhi");
        Integer nianzhidefen = CommonUtils.dishidefen(naindishi,"rizhi");
        String qiangruo = "";
        Integer zongdefen = dishidefen+rizhidefen+niantiangandefen+yuetiangandefen+shitiangandefen+shizhidefen+nianzhidefen;
        //总和得分大于80，强
        if(zongdefen>80){
            qiangruo = "强";
        }

        //小于80，大于60，偏强
        if(zongdefen<80 && zongdefen>60){
            qiangruo = "偏强";
        }

        //小于60，大于50，中和
        if(zongdefen<60 && zongdefen>50){
            qiangruo = "中和";
        }

        //小于50，大于20，偏弱
        if(zongdefen<50 && zongdefen>20){
            qiangruo = "偏弱";
        }

        //小于20，弱

        if(zongdefen<20){
            qiangruo = "弱";
        }

        bundle.putString("qiangruo",qiangruo);
        LogUtils.e("八字强弱：----"+qiangruo+"------"+zongdefen);


        bundle.putString("xingming",xingming.getText().toString());
        bundle.putString("xb",xb);
        bundle.putString("diqu",diqu.getText().toString());
        bundle.putString("riqi",riqi.getText().toString());
        bundle.putString("myear", String.valueOf(myear));

        //判断几岁起大运 kscreatedate  Lunar.solarTerm[ksquyu]-------jscreatedate   Lunar.solarTerm[jsquyu]
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int xiangchatianshu = 0;
        int qiyunnian = 0;
        int qiyunyue = 0;
        //判断性别
        /**
         *阳男阴女顺排，阴男阳女逆排
         * */
        if("男".equals(xb)){
            if("阳".equals(CommonUtils.yinyang(yearTiangan))){
                //出生时间 dayc1
                try {
                    xiangchatianshu= getDate2ToDate1(dayc1.getTime(),format.parse(jscreatedate));
                    qiyunnian = xiangchatianshu/3;
                    qiyunyue = (xiangchatianshu%3)*4;
                    LogUtils.e("阳男这个人在"+qiyunnian+"岁"+qiyunyue+"个月起大运...");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    xiangchatianshu= getDate2ToDate1(format.parse(kscreatedate),dayc1.getTime());
                    qiyunnian = xiangchatianshu/3;
                    qiyunyue = (xiangchatianshu%3)*4;
                    LogUtils.e("阴男这个人在"+qiyunnian+"岁"+qiyunyue+"个月起大运...");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

        }else{
            if("阴".equals(CommonUtils.yinyang(yearTiangan))){
                //出生时间 dayc1
                try {
                    xiangchatianshu= getDate2ToDate1(dayc1.getTime(),format.parse(jscreatedate));
                    qiyunnian = xiangchatianshu/3;
                    qiyunyue = (xiangchatianshu%3)*4;
                    LogUtils.e("阴女这个人在"+qiyunnian+"岁"+qiyunyue+"个月起大运...");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    xiangchatianshu= getDate2ToDate1(format.parse(kscreatedate),dayc1.getTime());
                    qiyunnian = xiangchatianshu/3;
                    qiyunyue = (xiangchatianshu%3)*4;
                    LogUtils.e("阳女这个人在"+qiyunnian+"岁"+qiyunyue+"个月起大运...");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

        }
        LogUtils.e(kscreatedate+"比-----"+dayc1.getTime()+"-------相差多少天？------------------------------------------"+xiangchatianshu);
        //qidayun
        bundle.putString("qidayun","在"+qiyunnian+"岁"+qiyunyue+"个月起大运...");
        bundle.putString("qiyunnian",qiyunnian+"");
        bundle.putString("qiyunyue",(qiyunyue+myue)+"");
        intent.putExtras(bundle);
        startActivity(intent);
    }





}
