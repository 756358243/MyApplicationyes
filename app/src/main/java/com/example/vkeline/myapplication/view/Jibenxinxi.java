package com.example.vkeline.myapplication.view;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.vkeline.myapplication.BzInfoActivity;
import com.example.vkeline.myapplication.R;
import com.example.vkeline.myapplication.Utils.CommonUtils;
import com.example.vkeline.myapplication.data.Liushihuajiazi;
import com.vkeline.zlibrary.adapter.CommonListViewAdapter;
import com.vkeline.zlibrary.base.ZBaseActivity;
import com.vkeline.zlibrary.base.ZBaseFragment;
import com.vkeline.zlibrary.dialog.CommonDialog;
import com.vkeline.zlibrary.util.LogUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vkeline on 2018/3/1.
 */
public class Jibenxinxi extends ZBaseFragment {


    private TextView name;
    private TextView adress;
    private TextView chushengonglishijian;
    private TextView jieqi;
    private TextView qidayun;
    private TextView nianTianganshishen;
    private TextView yuetianganshishen;
    private TextView ritianganshishen;
    private TextView shitianganshishen;
    private TextView qiankun;
    private TextView niangan;
    private TextView yuegan;
    private TextView rigan;
    private TextView shigan;
    private TextView nianzhi;
    private TextView yuezhi;
    private TextView rizhi;
    private TextView shizhi;
    private TextView nianzhicangan;
    private TextView yuezhicangan;
    private TextView rizhicangan;
    private TextView shizhicangan;
    private TextView nianDizhishishen;
    private TextView yuedizhishishen;
    private TextView ridizhishishen;
    private TextView shidizhishishen;

    private TextView niangannayin;
    private TextView yuegannayin;
    private TextView rigannayin;
    private TextView shigannayin;

    private TextView rikun;
    private TextView shikun;



    private GridView gridView;
    private List<Map<String, Object>> dataList;
    private SimpleAdapter adapter;


    @Override
    protected int initViewMVC() {
        return R.layout.activity_bz_jieguo;
    }

    @Override
    protected void initEventMVC(View v) {
        /**取得所有的控件*/
        name = (TextView) v.findViewById(R.id.name);
        adress = (TextView) v.findViewById(R.id.adress);
        chushengonglishijian = (TextView) v.findViewById(R.id.chushengonglishijian);
        qiankun = (TextView) v.findViewById(R.id.qiankun);
        nianTianganshishen = (TextView) v.findViewById(R.id.nianTianganshishen);
        nianDizhishishen = (TextView) v.findViewById(R.id.nianDizhishishen);
        niangan = (TextView) v.findViewById(R.id.niangan);
        nianzhi = (TextView) v.findViewById(R.id.nianzhi);
        yuetianganshishen = (TextView) v.findViewById(R.id.yueTianganshishen);
        yuedizhishishen = (TextView) v.findViewById(R.id.yueDizhishishen);
        yuegan = (TextView) v.findViewById(R.id.yuegan);
        yuezhi = (TextView) v.findViewById(R.id.yuezhi);

        ritianganshishen = (TextView) v.findViewById(R.id.riTianganshishen);
        ridizhishishen = (TextView) v.findViewById(R.id.riDizhishishen);
        rigan = (TextView) v.findViewById(R.id.rigan);
        rizhi = (TextView) v.findViewById(R.id.rizhi);

        shitianganshishen = (TextView) v.findViewById(R.id.shiTianganshishen);
        shidizhishishen = (TextView) v.findViewById(R.id.shiDizhishishen);
        shigan = (TextView) v.findViewById(R.id.shigan);
        shizhi = (TextView) v.findViewById(R.id.shizhi);

        nianzhicangan = (TextView) v.findViewById(R.id.nianDicangan);
        yuezhicangan = (TextView) v.findViewById(R.id.yueDizhicangan);
        rizhicangan = (TextView) v.findViewById(R.id.riDizhicangan);
        shizhicangan = (TextView) v.findViewById(R.id.shiDizhicangan);

        niangannayin = (TextView) v.findViewById(R.id.niangannayin);
        yuegannayin = (TextView) v.findViewById(R.id.yuegannayin);
        rigannayin = (TextView) v.findViewById(R.id.rigannayin);
        shigannayin = (TextView) v.findViewById(R.id.shigannayin);

        rikun = (TextView) v.findViewById(R.id.rikun);
        shikun = (TextView) v.findViewById(R.id.shikun);

        qidayun = (TextView)v.findViewById(R.id.qidayun);
        jieqi = (TextView) v.findViewById(R.id.jieqi);
        /**接受传过来的参数*/
        Bundle bundle = getActivity().getIntent().getExtras();
        final String yearTiangan = bundle.getString("yearTiangan");
        final String yearDizhi = bundle.getString("yearDizhi");
        String yearTianganshishen = bundle.getString("yearTianganshishen");
        String yearzhicangan = bundle.getString("nianzhicangan");
        String yearDizhishishen = bundle.getString("yearDizhishishen");

        String yueTiangan = bundle.getString("yueTiangan");
        String yueDizhi = bundle.getString("yueDizhi");
        String yueZhicangan = bundle.getString("yuezhicangan");
        String yueTianganshishen = bundle.getString("yueTianganshishen");
        String yueDizhishishen = bundle.getString("yueDizhishishen");


        final String riTiangan = bundle.getString("riTiangan");
        String riDizhi = bundle.getString("riDizhi");
        String riZhicangan = bundle.getString("rizhicangan");
        String riTianganshishen = bundle.getString("riTianganshishen");
        String riDizhishishen = bundle.getString("riDizhishishen");

        String shiTiangan = bundle.getString("shiTiangan");
        String shiDizhi = bundle.getString("shiDizhi");
        String shiZhicangan = bundle.getString("shizhicangan");
        String shiTianganshishen = bundle.getString("shiTianganshishen");
        String shiDizhishishen = bundle.getString("shiDizhishishen");

        String xb = bundle.getString("xb");
        final String qiangruo = bundle.getString("qiangruo");
        String diqu = bundle.getString("diqu");
        String riqi = bundle.getString("riqi");
        String nongliriqi = bundle.getString("nongliriqi");
        String jq = bundle.getString("jq");
        String xingming = bundle.getString("xingming");
        String qdy = bundle.getString("qidayun");
        final String myear = bundle.getString("myear");
        Integer qiyunnian = Integer.valueOf(bundle.getString("qiyunnian"));
        Integer qiyunyue = Integer.valueOf(bundle.getString("qiyunyue"));
        LogUtils.e("上大运岁数;"+qiyunnian);
        final Liushihuajiazi huajiazi = new Liushihuajiazi();
        //得到日天干的五行，用于大运找食神
        String riTianganwuxing = huajiazi.getTianganwuxing().get(riTiangan);
        /**向每个空间设置值*/
        name.setText(xingming);
        adress.setText(diqu);
        chushengonglishijian.setText(nongliriqi);
        if ("男".equals(xb)) {
            qiankun.setText("乾");
        } else {
            qiankun.setText("坤");
        }

        nianTianganshishen.setText(yearTianganshishen);
        nianDizhishishen.setText(yearDizhishishen);
        niangan.setText(yearTiangan);
        nianzhi.setText(yearDizhi+"("+CommonUtils.shengwang(riTiangan,yearDizhi)+")");

        yuetianganshishen.setText(yueTianganshishen);
        yuedizhishishen.setText(yueDizhishishen);
        yuegan.setText(yueTiangan);
        yuezhi.setText(yueDizhi+"("+CommonUtils.shengwang(riTiangan,yueDizhi)+")");

        ritianganshishen.setText(riTianganshishen);
        ridizhishishen.setText(riDizhishishen);
        rigan.setText(riTiangan+"("+qiangruo+")");
        rizhi.setText(riDizhi+"("+CommonUtils.shengwang(riTiangan,riDizhi)+")");

        shitianganshishen.setText(shiTianganshishen);
        shidizhishishen.setText(shiDizhishishen);
        shigan.setText(shiTiangan);
        shizhi.setText(shiDizhi+"("+CommonUtils.shengwang(riTiangan,shiDizhi)+")");

        nianzhicangan.setText(yearzhicangan);
        yuezhicangan.setText(yueZhicangan);
        rizhicangan.setText(riZhicangan);
        shizhicangan.setText(shiZhicangan);

        LogUtils.e("年柱：" + yearTiangan + "----" + yearDizhi);
        LogUtils.e("月柱：" + yueTiangan + "----" + yueDizhi);
        LogUtils.e("日柱：" + riTiangan + "----" + riDizhi);
        LogUtils.e("时柱：" + shiTiangan + "----" + shiDizhi);


        niangannayin.setText(CommonUtils.jiazinaying(yearTiangan + yearDizhi));
        yuegannayin.setText(CommonUtils.jiazinaying(yueTiangan + yueDizhi));
        rigannayin.setText(CommonUtils.jiazinaying(riTiangan + riDizhi));
        shigannayin.setText(CommonUtils.jiazinaying(shiTiangan + shiDizhi));
        String rikunwang = "";
        String shikunwnasg="";
        Integer rikunwangint = Integer.valueOf(getKey(huajiazi.getDizhi(),riDizhi));
        Integer shikunwnasgint = Integer.valueOf(getKey(huajiazi.getDizhi(),shiDizhi));
        int x = rikunwangint-2;
        int b = rikunwangint-1;
        int c = shikunwnasgint-2;
        int d = shikunwnasgint-1;
        if(x==0){
            x=12;
        }
        if(x == -1){
            x=11;
        }
        if(b == 0){
            b=12;
        }
        if(b == -1){
            b=11;
        }
        if(c==0){
            c=12;
        }
        if(c == -1){
           c=11;
        }
        if(d == 0){
           d=12;
        }
        if(d == -1){
            d=11;
        }
        rikunwang = "(日)"+huajiazi.getDizhi().get(x+"")+huajiazi.getDizhi().get(b+"");
        shikunwnasg = "(时)"+huajiazi.getDizhi().get(c+"")+huajiazi.getDizhi().get(d+"");
        LogUtils.e("日空亡："+rikunwang+"------时空亡“"+shikunwnasg);

        rikun.setText(rikunwang);
        shikun.setText(shikunwnasg);
        qidayun.setText(qdy);
        jieqi.setText(jq);

        gridView = v.findViewById(R.id.gridview);
        /**
         *阳男阴女顺排，阴男阳女逆排
         * */
        String paidayunnianzhu = yearTiangan + yearDizhi;
        if(qiyunyue>12){
            qiyunnian = qiyunnian+1;
            qiyunyue = qiyunyue%12;
        }
        Integer ninazhuint =Integer.valueOf(getKey(huajiazi.getHuajiazi(),paidayunnianzhu))+qiyunnian;
        LogUtils.e("大运第一个流年的干支："+ninazhuint);
        List<String> mList = new ArrayList<>();
        int j = 0;
        if("男".equals(xb)){
            if("阳".equals(CommonUtils.yinyang(yearTiangan))){
                //获取对应的月柱，顺推月柱得大运，获取月柱的KEY
                String paidayunyuezhu = yueTiangan + yueDizhi;
                Integer yuezhuint =Integer.valueOf(getKey(huajiazi.getHuajiazi(),paidayunyuezhu));
                String paipanhang = "";
                String dayunxiang = "";
                int paiyun = yuezhuint+1;
                int paiyunxianzhi = yuezhuint+9;
                LogUtils.e(paiyun+"-----"+paiyunxianzhi);
                for (int i = paiyun; i <paiyunxianzhi; i++) {
                        i = i%60;
                    if(i == 0){
                        paiyunxianzhi = paiyunxianzhi%60;
                        dayunxiang  = huajiazi.getHuajiazi().get(""+60);
                    }else {
                        dayunxiang = huajiazi.getHuajiazi().get("" + i);
                    }
                        // paipanhang = ((10*j+qiyunnian)+"岁"+qiyunyue+"月-"+(10*(j+1)+qiyunnian-1))+"岁"+dayunxiang+":";
                    //获取天干和地址，分别对应的十神
                     String dayunxiangTiangan = dayunxiang.substring(0,1);
                    //riTiangan 五行
                     String dayunxiangTianganwuxing = huajiazi.getTianganwuxing().get(dayunxiangTiangan);
                     String dayunxiangTianganshishen = huajiazi.getShishen().get(riTianganwuxing+dayunxiangTianganwuxing);
                     String dayunxiangDizhi = dayunxiang.substring(1,2);
                     String dayunxiangDizhiwuxing = huajiazi.getDizhiwuxing().get(dayunxiangDizhi);
                     String dayunxiangDizhishishen = huajiazi.getShishen().get(riTianganwuxing+dayunxiangDizhiwuxing);
                    LogUtils.e("j----------------------------:"+j);
                    if(j == 0){
                        paipanhang = "0"+qiyunnian+"("+dayunxiangTianganshishen+")"+dayunxiangTiangan+" "+dayunxiangDizhishishen+")"+dayunxiangDizhi;
                    }else {
                        paipanhang = (10 * j + qiyunnian) + "(" + dayunxiangTianganshishen + ")" + dayunxiangTiangan + " " + dayunxiangDizhishishen + ")" + dayunxiangDizhi;
                    }

                    /*for (int a = 0; a <10; a++) {
                        Integer quzhi =(ninazhuint+(j)*10+a)%60;
                        if(quzhi == 0){
                            quzhi = 60;
                        }
                        String liunian = huajiazi.getHuajiazi().get(""+quzhi);
                       paipanhang = paipanhang +"("+((10*j+qiyunnian)+a)+")"+liunian+" ";
                        paipanhang = paipanhang +liunian+" ";
                    }*/
                    mList.add(paipanhang);
                    j=j+1;
                }

            }else{

                String paidayunyuezhu = yueTiangan + yueDizhi;
                Integer yuezhuint =Integer.valueOf(getKey(huajiazi.getHuajiazi(),paidayunyuezhu));
                LogUtils.e("test-----------------"+yuezhuint);
                String paipanhang = "";
                int paiyun = yuezhuint-1;
                int paiyunxianzhi = yuezhuint-9;
                for (int i = paiyun; i >paiyunxianzhi; i--) {
                    i = (i+60)%60;

                    if(i==0){
                        i=60;
                    }
                    if(i == 59){
                        paiyunxianzhi = (paiyunxianzhi+60)%60;
                    }

                    String dayunxiang = huajiazi.getHuajiazi().get(""+i);
                    LogUtils.e("test-----------------"+i+"----"+dayunxiang);
                    // paipanhang = ((10*j+qiyunnian)+"岁"+qiyunyue+"月-"+(10*(j+1)+qiyunnian-1))+"岁"+dayunxiang+":";
                    //获取天干和地址，分别对应的十神
                    String dayunxiangTiangan = dayunxiang.substring(0,1);
                    //riTiangan 五行
                    String dayunxiangTianganwuxing = huajiazi.getTianganwuxing().get(dayunxiangTiangan);
                    String dayunxiangTianganshishen = huajiazi.getShishen().get(riTianganwuxing+dayunxiangTianganwuxing);
                    String dayunxiangDizhi = dayunxiang.substring(1,2);
                    String dayunxiangDizhiwuxing = huajiazi.getDizhiwuxing().get(dayunxiangDizhi);
                    String dayunxiangDizhishishen = huajiazi.getShishen().get(riTianganwuxing+dayunxiangDizhiwuxing);
                    LogUtils.e("j----------------------------:"+j);
                    if(j == 0){
                        paipanhang = "0"+qiyunnian+"("+dayunxiangTianganshishen+")"+dayunxiangTiangan+" "+dayunxiangDizhishishen+")"+dayunxiangDizhi;
                    }else {
                        paipanhang = (10 * j + qiyunnian) + "(" + dayunxiangTianganshishen + ")" + dayunxiangTiangan + " " + dayunxiangDizhishishen + ")" + dayunxiangDizhi;
                    }
/*
                    for (int a = 0; a <10; a++) {
                        Integer quzhi =(ninazhuint+(j)*10+a)%60;
                        if(quzhi == 0){
                            quzhi = 60;
                        }
                        String liunian = huajiazi.getHuajiazi().get(""+quzhi);
                       // paipanhang = paipanhang +"("+((10*j+qiyunnian)+a)+")"+liunian+" ";
                        //paipanhang = paipanhang +liunian+" ";
                    }
*/
                    mList.add(paipanhang);
                    j=j+1;
                }

            }

        }else{
            if("阴".equals(CommonUtils.yinyang(yearTiangan))){
                //出生时间 dayc1
                String paidayunyuezhu = yueTiangan + yueDizhi;
                Integer yuezhuint =Integer.valueOf(getKey(huajiazi.getHuajiazi(),paidayunyuezhu));

                String paipanhang = "";
                String dayunxiang = "";
                int paiyun = yuezhuint+1;
                int paiyunxianzhi = yuezhuint+9;
                LogUtils.e(paiyun+"-----"+paiyunxianzhi);
                for (int i = paiyun; i <paiyunxianzhi; i++) {
                    i = i%60;
                    if(i == 0){
                        paiyunxianzhi = paiyunxianzhi%60;
                        dayunxiang  = huajiazi.getHuajiazi().get(""+60);
                    }else {
                        dayunxiang = huajiazi.getHuajiazi().get("" + i);
                    }
                    // paipanhang = ((10*j+qiyunnian)+"岁"+qiyunyue+"月-"+(10*(j+1)+qiyunnian-1))+"岁"+dayunxiang+":";
                    //获取天干和地址，分别对应的十神
                    String dayunxiangTiangan = dayunxiang.substring(0,1);
                    //riTiangan 五行
                    String dayunxiangTianganwuxing = huajiazi.getTianganwuxing().get(dayunxiangTiangan);
                    String dayunxiangTianganshishen = huajiazi.getShishen().get(riTianganwuxing+dayunxiangTianganwuxing);
                    String dayunxiangDizhi = dayunxiang.substring(1,2);
                    String dayunxiangDizhiwuxing = huajiazi.getDizhiwuxing().get(dayunxiangDizhi);
                    String dayunxiangDizhishishen = huajiazi.getShishen().get(riTianganwuxing+dayunxiangDizhiwuxing);
                    LogUtils.e("j----------------------------:"+j);
                    if(j == 0){
                        paipanhang = "0"+qiyunnian+"("+dayunxiangTianganshishen+")"+dayunxiangTiangan+" "+dayunxiangDizhishishen+")"+dayunxiangDizhi;
                    }else {
                        paipanhang = (10 * j + qiyunnian) + "(" + dayunxiangTianganshishen + ")" + dayunxiangTiangan + " " + dayunxiangDizhishishen + ")" + dayunxiangDizhi;
                    }

                   /* for (int a = 0; a <10; a++) {
                        Integer quzhi =(ninazhuint+(j)*10+a)%60;
                        if(quzhi == 0){
                            quzhi = 60;
                        }
                        String liunian = huajiazi.getHuajiazi().get(""+quzhi);
                       // paipanhang = paipanhang +"("+((10*j+qiyunnian)+a)+")"+liunian+" ";
                        //paipanhang = paipanhang +liunian+" ";
                    }*/
                    mList.add(paipanhang);
                    j=j+1;
                }


            }else{

                String paidayunyuezhu = yueTiangan + yueDizhi;
                Integer yuezhuint =Integer.valueOf(getKey(huajiazi.getHuajiazi(),paidayunyuezhu));
                LogUtils.e("test-----------------"+yuezhuint);
                String paipanhang = "";
                int paiyun = yuezhuint-1;
                int paiyunxianzhi = yuezhuint-9;
                for (int i = paiyun; i >paiyunxianzhi; i--) {
                    i = (i+60)%60;

                    if(i==0){
                        i=60;
                    }
                    if(i == 59){
                        paiyunxianzhi = (paiyunxianzhi+60)%60;
                    }

                    String dayunxiang = huajiazi.getHuajiazi().get(""+i);
                    LogUtils.e("test-----------------"+i+"----"+dayunxiang);
                    // paipanhang = ((10*j+qiyunnian)+"岁"+qiyunyue+"月-"+(10*(j+1)+qiyunnian-1))+"岁"+dayunxiang+":";
                    //获取天干和地址，分别对应的十神
                    String dayunxiangTiangan = dayunxiang.substring(0,1);
                    //riTiangan 五行
                    String dayunxiangTianganwuxing = huajiazi.getTianganwuxing().get(dayunxiangTiangan);
                    String dayunxiangTianganshishen = huajiazi.getShishen().get(riTianganwuxing+dayunxiangTianganwuxing);
                    String dayunxiangDizhi = dayunxiang.substring(1,2);
                    String dayunxiangDizhiwuxing = huajiazi.getDizhiwuxing().get(dayunxiangDizhi);
                    String dayunxiangDizhishishen = huajiazi.getShishen().get(riTianganwuxing+dayunxiangDizhiwuxing);
                    LogUtils.e("j----------------------------:"+j);
                    if(j == 0){
                        paipanhang = "0"+qiyunnian+"("+dayunxiangTianganshishen+")"+dayunxiangTiangan+" "+dayunxiangDizhishishen+")"+dayunxiangDizhi;
                    }else {
                        paipanhang = (10 * j + qiyunnian) + "(" + dayunxiangTianganshishen + ")" + dayunxiangTiangan + " " + dayunxiangDizhishishen + ")" + dayunxiangDizhi;
                    }
/*
                    for (int a = 0; a <10; a++) {
                        Integer quzhi =(ninazhuint+(j)*10+a)%60;
                        if(quzhi == 0){
                            quzhi = 60;
                        }
                        String liunian = huajiazi.getHuajiazi().get(""+quzhi);
                       // paipanhang = paipanhang +"("+((10*j+qiyunnian)+a)+")"+liunian+" ";
                        //paipanhang = paipanhang +liunian+" ";
                    }
*/
                    mList.add(paipanhang);
                    j=j+1;
                }

            }


        }


















        gridView.setAdapter(new CommonListViewAdapter<String>(getContext(), mList, R.layout.dayun_item) {
            @Override
            public void setData(final BaseHolder holder, final String item, final int position) {
                holder.setText(R.id.dayun,item);
                //添加大运的点击事件，获取对应的流年排盘
                holder.getView(R.id.dayun).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        switch (position) {
                            case 0:
                                //获取大运的开始岁数
                                Integer dayunsuishu = Integer.valueOf(item.substring(0,2));
                                LogUtils.e("dayunsuishu-------:"+dayunsuishu);
                                Integer myearInt = Integer.valueOf(myear);
                                //获取年干的六十花甲子的所在的位置 ninazhuint
                                Integer ninazhuint =Integer.valueOf(getKey(huajiazi.getHuajiazi(),yearTiangan+yearDizhi));
                                Integer diyigeliunian = (ninazhuint +dayunsuishu)%60;
                                if(diyigeliunian == 0){
                                    diyigeliunian =60;
                                }
                                //开始获取十年的流年
                                String result= "";
                                for (int i=0;i<10;i++){
                                    Integer liuniannianfen = myearInt+dayunsuishu +i;
                                    Integer huoqujiazi = (diyigeliunian+i)%60;
                                    if (huoqujiazi == 0 ){
                                        huoqujiazi = 60;
                                    }
                                    String dayunliunian = huajiazi.getHuajiazi().get(huoqujiazi+"");
                                    LogUtils.e("liuniannianfen-------:"+liuniannianfen);
                                    LogUtils.e("第一个大运流年："+dayunliunian+qiangruo);
                                    //获取年干
                                    String liunianniangan = dayunliunian.substring(0,1);
                                    String liunianwuxing = huajiazi.getTianganwuxing().get(liunianniangan);
                                    String rgwuxing = huajiazi.getTianganwuxing().get(riTiangan);
                                    //获取十食
                                    String liuganshishen  =  huajiazi.getShishen().get(rgwuxing+liunianwuxing);
                                    String jieguo = "";
                                    if(qiangruo.contains("强")){
                                           jieguo = huajiazi.getShishendaibiao().get("强"+liuganshishen);
                                    }if(qiangruo.contains("弱")){
                                           jieguo = huajiazi.getShishendaibiao().get("弱"+liuganshishen);
                                    }
                                    //把日干十食和流干食神进行对比，得出对应的结论

                                    result=result+"("+liuniannianfen+"年)"+dayunliunian+":"+liunianniangan+"为"+jieguo+"-------------";
                            }

                                CommonDialog.disPlay(mActivity,result).setCallBack(new CommonDialog.CallBack() {
                                    @Override
                                    public void left() {

                                    }

                                    @Override
                                    public void right() {

                                    }
                                });
                                break;
                            case 1:
                                //获取大运的开始岁数
                                Integer dayunsuishu1 = Integer.valueOf(item.substring(0,2));
                                LogUtils.e("dayunsuishu-------:"+dayunsuishu1);
                                Integer myearInt1 = Integer.valueOf(myear);
                                //获取年干的六十花甲子的所在的位置 ninazhuint
                                Integer ninazhuint1 =Integer.valueOf(getKey(huajiazi.getHuajiazi(),yearTiangan+yearDizhi));
                                Integer diyigeliunian1 = (ninazhuint1 +dayunsuishu1)%60;
                                if(diyigeliunian1 == 0){
                                    diyigeliunian1 =60;
                                }
                                //开始获取十年的流年
                                String result1= "";
                                for (int i=0;i<10;i++){
                                    Integer liuniannianfen = myearInt1+dayunsuishu1 +i;
                                    Integer huoqujiazi = (diyigeliunian1+i)%60;
                                    if (huoqujiazi == 0 ){
                                        huoqujiazi = 60;
                                    }
                                    String dayunliunian = huajiazi.getHuajiazi().get(huoqujiazi+"");
                                    //获取年干
                                    String liunianniangan = dayunliunian.substring(0,1);
                                    String liunianwuxing = huajiazi.getTianganwuxing().get(liunianniangan);
                                    String rgwuxing = huajiazi.getTianganwuxing().get(riTiangan);
                                    //获取十食
                                    String liuganshishen  =  huajiazi.getShishen().get(rgwuxing+liunianwuxing);
                                    String jieguo = "";
                                    if(qiangruo.contains("强")){
                                        jieguo = huajiazi.getShishendaibiao().get("强"+liuganshishen);
                                    }if(qiangruo.contains("弱")){
                                        jieguo = huajiazi.getShishendaibiao().get("弱"+liuganshishen);
                                    }
                                    //把日干十食和流干食神进行对比，得出对应的结论

                                    result1=result1+"("+liuniannianfen+"年)"+dayunliunian+":"+liunianniangan+"为"+jieguo+"-------------";
                                }

                                CommonDialog.disPlay(mActivity,result1).setCallBack(new CommonDialog.CallBack() {
                                    @Override
                                    public void left() {

                                    }

                                    @Override
                                    public void right() {

                                    }
                                });
                                break;
                            case 2:
                                //获取大运的开始岁数
                                Integer dayunsuishu2 = Integer.valueOf(item.substring(0,2));
                                LogUtils.e("dayunsuishu-------:"+dayunsuishu2);
                                Integer myearInt2 = Integer.valueOf(myear);
                                //获取年干的六十花甲子的所在的位置 ninazhuint
                                Integer ninazhuint2 =Integer.valueOf(getKey(huajiazi.getHuajiazi(),yearTiangan+yearDizhi));
                                Integer diyigeliunian2 = (ninazhuint2 +dayunsuishu2)%60;
                                if(diyigeliunian2 == 0){
                                    diyigeliunian =60;
                                }
                                //开始获取十年的流年
                                String result2= "";
                                for (int i=0;i<10;i++){
                                    Integer liuniannianfen = myearInt2+dayunsuishu2 +i;
                                    Integer huoqujiazi = (diyigeliunian2+i)%60;
                                    if (huoqujiazi == 0 ){
                                        huoqujiazi = 60;
                                    }
                                    String dayunliunian = huajiazi.getHuajiazi().get(huoqujiazi+"");
                                    //获取年干
                                    String liunianniangan = dayunliunian.substring(0,1);
                                    String liunianwuxing = huajiazi.getTianganwuxing().get(liunianniangan);
                                    String rgwuxing = huajiazi.getTianganwuxing().get(riTiangan);
                                    //获取十食
                                    String liuganshishen  =  huajiazi.getShishen().get(rgwuxing+liunianwuxing);
                                    String jieguo = "";
                                    if(qiangruo.contains("强")){
                                        jieguo = huajiazi.getShishendaibiao().get("强"+liuganshishen);
                                    }if(qiangruo.contains("弱")){
                                        jieguo = huajiazi.getShishendaibiao().get("弱"+liuganshishen);
                                    }
                                    //把日干十食和流干食神进行对比，得出对应的结论

                                    result2=result2+"("+liuniannianfen+"年)"+dayunliunian+":"+liunianniangan+"为"+jieguo+"-------------";
                                }

                                CommonDialog.disPlay(mActivity,result2).setCallBack(new CommonDialog.CallBack() {
                                    @Override
                                    public void left() {

                                    }

                                    @Override
                                    public void right() {

                                    }
                                });
                                break;
                            case 3:
                                //获取大运的开始岁数
                                Integer dayunsuishu3 = Integer.valueOf(item.substring(0,2));
                                LogUtils.e("dayunsuishu-------:"+dayunsuishu3);
                                Integer myearInt3 = Integer.valueOf(myear);
                                //获取年干的六十花甲子的所在的位置 ninazhuint
                                Integer ninazhuint3 =Integer.valueOf(getKey(huajiazi.getHuajiazi(),yearTiangan+yearDizhi));
                                Integer diyigeliunian3 = (ninazhuint3 +dayunsuishu3)%60;
                                if(diyigeliunian3 == 0){
                                    diyigeliunian3 =60;
                                }
                                //开始获取十年的流年
                                String result3= "";
                                for (int i=0;i<10;i++){
                                    Integer liuniannianfen = myearInt3+dayunsuishu3 +i;
                                    Integer huoqujiazi = (diyigeliunian3+i)%60;
                                    if (huoqujiazi == 0 ){
                                        huoqujiazi = 60;
                                    }
                                    String dayunliunian = huajiazi.getHuajiazi().get(huoqujiazi+"");
                                    //获取年干
                                    String liunianniangan = dayunliunian.substring(0,1);
                                    String liunianwuxing = huajiazi.getTianganwuxing().get(liunianniangan);
                                    String rgwuxing = huajiazi.getTianganwuxing().get(riTiangan);
                                    //获取十食
                                    String liuganshishen  =  huajiazi.getShishen().get(rgwuxing+liunianwuxing);
                                    String jieguo = "";
                                    if(qiangruo.contains("强")){
                                        jieguo = huajiazi.getShishendaibiao().get("强"+liuganshishen);
                                    }if(qiangruo.contains("弱")){
                                        jieguo = huajiazi.getShishendaibiao().get("弱"+liuganshishen);
                                    }
                                    //把日干十食和流干食神进行对比，得出对应的结论

                                    result3=result3+"("+liuniannianfen+"年)"+dayunliunian+":"+liunianniangan+"为"+jieguo+"-------------";
                                }

                                CommonDialog.disPlay(mActivity,result3).setCallBack(new CommonDialog.CallBack() {
                                    @Override
                                    public void left() {

                                    }

                                    @Override
                                    public void right() {

                                    }
                                });
                                break;
                            case 4:
                                //获取大运的开始岁数
                                Integer dayunsuishu4 = Integer.valueOf(item.substring(0,2));
                                LogUtils.e("dayunsuishu-------:"+dayunsuishu4);
                                Integer myearInt4 = Integer.valueOf(myear);
                                //获取年干的六十花甲子的所在的位置 ninazhuint
                                Integer ninazhuint4 =Integer.valueOf(getKey(huajiazi.getHuajiazi(),yearTiangan+yearDizhi));
                                Integer diyigeliunian4 = (ninazhuint4 +dayunsuishu4)%60;
                                if(diyigeliunian4 == 0){
                                    diyigeliunian4 =60;
                                }
                                //开始获取十年的流年
                                String result4= "";
                                for (int i=0;i<10;i++){
                                    Integer liuniannianfen = myearInt4+dayunsuishu4 +i;
                                    Integer huoqujiazi = (diyigeliunian4+i)%60;
                                    if (huoqujiazi == 0 ){
                                        huoqujiazi = 60;
                                    }
                                    String dayunliunian = huajiazi.getHuajiazi().get(huoqujiazi+"");
                                    //获取年干
                                    String liunianniangan = dayunliunian.substring(0,1);
                                    String liunianwuxing = huajiazi.getTianganwuxing().get(liunianniangan);
                                    String rgwuxing = huajiazi.getTianganwuxing().get(riTiangan);
                                    //获取十食
                                    String liuganshishen  =  huajiazi.getShishen().get(rgwuxing+liunianwuxing);
                                    String jieguo = "";
                                    if(qiangruo.contains("强")){
                                        jieguo = huajiazi.getShishendaibiao().get("强"+liuganshishen);
                                    }if(qiangruo.contains("弱")){
                                        jieguo = huajiazi.getShishendaibiao().get("弱"+liuganshishen);
                                    }
                                    //把日干十食和流干食神进行对比，得出对应的结论

                                    result4=result4+"("+liuniannianfen+"年)"+dayunliunian+":"+liunianniangan+"为"+jieguo+"-------------";
                                }

                                CommonDialog.disPlay(mActivity,result4).setCallBack(new CommonDialog.CallBack() {
                                    @Override
                                    public void left() {

                                    }

                                    @Override
                                    public void right() {

                                    }
                                });
                                break;

                            case 5:
                                //获取大运的开始岁数
                                Integer dayunsuishu5 = Integer.valueOf(item.substring(0,2));
                                LogUtils.e("dayunsuishu-------:"+dayunsuishu5);
                                Integer myearInt5 = Integer.valueOf(myear);
                                //获取年干的六十花甲子的所在的位置 ninazhuint
                                Integer ninazhuint5 =Integer.valueOf(getKey(huajiazi.getHuajiazi(),yearTiangan+yearDizhi));
                                Integer diyigeliunian5 = (ninazhuint5 +dayunsuishu5)%60;
                                if(diyigeliunian5 == 0){
                                    diyigeliunian5 =60;
                                }
                                //开始获取十年的流年
                                String result5= "";
                                for (int i=0;i<10;i++){
                                    Integer liuniannianfen = myearInt5+dayunsuishu5 +i;
                                    Integer huoqujiazi = (diyigeliunian5+i)%60;
                                    if (huoqujiazi == 0 ){
                                        huoqujiazi = 60;
                                    }
                                    String dayunliunian = huajiazi.getHuajiazi().get(huoqujiazi+"");
                                    //获取年干
                                    String liunianniangan = dayunliunian.substring(0,1);
                                    String liunianwuxing = huajiazi.getTianganwuxing().get(liunianniangan);
                                    String rgwuxing = huajiazi.getTianganwuxing().get(riTiangan);
                                    //获取十食
                                    String liuganshishen  =  huajiazi.getShishen().get(rgwuxing+liunianwuxing);
                                    String jieguo = "";
                                    if(qiangruo.contains("强")){
                                        jieguo = huajiazi.getShishendaibiao().get("强"+liuganshishen);
                                    }if(qiangruo.contains("弱")){
                                        jieguo = huajiazi.getShishendaibiao().get("弱"+liuganshishen);
                                    }
                                    //把日干十食和流干食神进行对比，得出对应的结论

                                    result5=result5+"("+liuniannianfen+"年)"+dayunliunian+":"+liunianniangan+"为"+jieguo+"-------------";
                                }

                                CommonDialog.disPlay(mActivity,result5).setCallBack(new CommonDialog.CallBack() {
                                    @Override
                                    public void left() {

                                    }

                                    @Override
                                    public void right() {

                                    }
                                });
                                break;


                            case 6:
                                //获取大运的开始岁数
                                Integer dayunsuishu6 = Integer.valueOf(item.substring(0,2));
                                LogUtils.e("dayunsuishu-------:"+dayunsuishu6);
                                Integer myearInt6 = Integer.valueOf(myear);
                                //获取年干的六十花甲子的所在的位置 ninazhuint
                                Integer ninazhuint6 =Integer.valueOf(getKey(huajiazi.getHuajiazi(),yearTiangan+yearDizhi));
                                Integer diyigeliunian6 = (ninazhuint6 +dayunsuishu6)%60;
                                if(diyigeliunian6 == 0){
                                    diyigeliunian6 =60;
                                }
                                //开始获取十年的流年
                                String result6= "";
                                for (int i=0;i<10;i++){
                                    Integer liuniannianfen = myearInt6+dayunsuishu6 +i;
                                    Integer huoqujiazi = (diyigeliunian6+i)%60;
                                    if (huoqujiazi == 0 ){
                                        huoqujiazi = 60;
                                    }
                                    String dayunliunian = huajiazi.getHuajiazi().get(huoqujiazi+"");
                                    //获取年干
                                    String liunianniangan = dayunliunian.substring(0,1);
                                    String liunianwuxing = huajiazi.getTianganwuxing().get(liunianniangan);
                                    String rgwuxing = huajiazi.getTianganwuxing().get(riTiangan);
                                    //获取十食
                                    String liuganshishen  =  huajiazi.getShishen().get(rgwuxing+liunianwuxing);
                                    String jieguo = "";
                                    if(qiangruo.contains("强")){
                                        jieguo = huajiazi.getShishendaibiao().get("强"+liuganshishen);
                                    }if(qiangruo.contains("弱")){
                                        jieguo = huajiazi.getShishendaibiao().get("弱"+liuganshishen);
                                    }
                                    //把日干十食和流干食神进行对比，得出对应的结论

                                    result6=result6+"("+liuniannianfen+"年)"+dayunliunian+":"+liunianniangan+"为"+jieguo+"-------------";
                                }

                                CommonDialog.disPlay(mActivity,result6).setCallBack(new CommonDialog.CallBack() {
                                    @Override
                                    public void left() {

                                    }

                                    @Override
                                    public void right() {

                                    }
                                });
                                break;

                            case 7:
                                //获取大运的开始岁数
                                Integer dayunsuishu7 = Integer.valueOf(item.substring(0,2));
                                LogUtils.e("dayunsuishu-------:"+dayunsuishu7);
                                Integer myearInt7 = Integer.valueOf(myear);
                                //获取年干的六十花甲子的所在的位置 ninazhuint
                                Integer ninazhuint7 =Integer.valueOf(getKey(huajiazi.getHuajiazi(),yearTiangan+yearDizhi));
                                Integer diyigeliunian7 = (ninazhuint7 +dayunsuishu7)%60;
                                LogUtils.e("------------------------"+diyigeliunian7+"-----------------");
                                if(diyigeliunian7 == 0){
                                    diyigeliunian7 =60;
                                }
                                //开始获取十年的流年
                                String result7= "";
                                for (int i=0;i<10;i++){
                                    Integer liuniannianfen = myearInt7+dayunsuishu7 +i;
                                    Integer huoqujiazi = (diyigeliunian7+i)%60;
                                    if (huoqujiazi == 0 ){
                                        huoqujiazi = 60;
                                    }
                                    String dayunliunian = huajiazi.getHuajiazi().get(huoqujiazi+"");
                                    //获取年干
                                    String liunianniangan = dayunliunian.substring(0,1);
                                    String liunianwuxing = huajiazi.getTianganwuxing().get(liunianniangan);
                                    String rgwuxing = huajiazi.getTianganwuxing().get(riTiangan);
                                    //获取十食
                                    String liuganshishen  =  huajiazi.getShishen().get(rgwuxing+liunianwuxing);
                                    String jieguo = "";
                                    if(qiangruo.contains("强")){
                                        jieguo = huajiazi.getShishendaibiao().get("强"+liuganshishen);
                                    }if(qiangruo.contains("弱")){
                                        jieguo = huajiazi.getShishendaibiao().get("弱"+liuganshishen);
                                    }
                                    //把日干十食和流干食神进行对比，得出对应的结论

                                    result7=result7+"("+liuniannianfen+"年)"+dayunliunian+":"+liunianniangan+"为"+jieguo+"-------------";
                                }

                                CommonDialog.disPlay(mActivity,result7).setCallBack(new CommonDialog.CallBack() {
                                    @Override
                                    public void left() {

                                    }

                                    @Override
                                    public void right() {

                                    }
                                });
                                break;


                            default:
                                break;
                        }

                    }
                });
            }
        });


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



}
