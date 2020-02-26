package com.example.vkeline.myapplication;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.vkeline.myapplication.data.Ganzhisuanming;
import com.example.vkeline.myapplication.data.Liushihuajiazi;
import com.example.vkeline.myapplication.data.ZiWeiConstants;
import com.example.vkeline.myapplication.view.FragmentFactory;
import com.vkeline.zlibrary.base.ZBaseActivity;
import com.vkeline.zlibrary.util.LogUtils;

import java.util.Map;

public class ZwjieguoActivity extends ZBaseActivity {




    private TextView ziweizi;

    private TextView ziweichou;

    private TextView ziweiyin;

    private TextView ziweimao;

    private TextView ziweichen;

    private TextView ziweisi;

    private TextView ziweiwu;

    private TextView ziweiwei;

    private TextView ziweishen;

    private TextView ziweiyou;

    private TextView ziweixu;

    private TextView ziweihai;
    //ziweibazi
    private TextView ziweibazi;

    private TextView ziweibazijieshao;




   /* private RadioGroup mRadioGroup;
    private RadioButton mRadioButtonHome;
*/

    @Override
    public void initViewMVC() {
        LogUtils.e("加载关于页面");
        setContentView( R.layout.activity_zwjieguo);
        ziweizi = (TextView) findViewById(R.id.ziweizi);
        ziweichou = (TextView) findViewById(R.id.ziweichou);
        ziweiyin = (TextView) findViewById(R.id.ziweiyin);
        ziweimao = (TextView) findViewById(R.id.ziweimao);
        ziweichen = (TextView) findViewById(R.id.ziweichen);
        ziweisi = (TextView) findViewById(R.id.ziweisi);
        ziweiwu = (TextView) findViewById(R.id.ziweiwu);
        ziweiwei = (TextView) findViewById(R.id.ziweiwei);
        ziweishen = (TextView) findViewById(R.id.ziweishen);
        ziweiyou = (TextView) findViewById(R.id.ziweiyou);
        ziweixu = (TextView) findViewById(R.id.ziweixu);
        ziweihai = (TextView) findViewById(R.id.ziweihai);
        ziweibazi = (TextView) findViewById(R.id.ziweibazi);
        ziweibazijieshao = (TextView) findViewById(R.id.ziweibazijieshao);

        //接受参数
        Bundle bundle = this.getIntent().getExtras();

        String xingming = bundle.getString("xingming");

        String xb = bundle.getString("xb");

        String diqu = bundle.getString("diqu");

        String riqi = bundle.getString("riqi");

        String nlriqi = bundle.getString("nlriqi");

        Integer nlyue = Integer.valueOf(bundle.getString("nlyue"));

        Integer nlri = Integer.valueOf(bundle.getString("nlri"));



        String yearTiangan = bundle.getString("yearTiangan");
         String yearDizhi = bundle.getString("yearDizhi");

         String yueTiangan = bundle.getString("yueTiangan");
         String yueDizhi = bundle.getString("yueDizhi");

         String riTiangan = bundle.getString("riTiangan");
         String riDizhi = bundle.getString("riDizhi");

         String shiTiangan = bundle.getString("shiTiangan");
         String shiDizhi = bundle.getString("shiDizhi");

        String rizhuganzhi = riTiangan+riDizhi;
        Liushihuajiazi l = new Liushihuajiazi();
        Integer rizhuint = Integer.valueOf(getKey(l.getHuajiazi(),rizhuganzhi));
        Ganzhisuanming gzarray = new Ganzhisuanming();
        String[][] nzshuoming = gzarray.getArrayOfString();
        //紫薇斗数排盘
        //排命宫,从寅月开始正月，到生的月分，然后从生的月分逆推到出生的时辰  公式（【（月所在的数字-时辰所在的数字+1）+12】%12）
        Integer shizhiint = Integer.valueOf(getKey(l.getShidizhi(),shiDizhi));

        //得到月干
        Integer yueganint = Integer.valueOf(getKey(l.getTiangan(),yueTiangan));

        Integer minggongint = ((nlyue-shizhiint+1)+12)%12;
        ZiWeiConstants ziWeiConstants = new ZiWeiConstants();
        //对应的寅宫对应的12宫
        Integer yinInt = minggongint%12 == 0 ?12:minggongint%12;


        String mingTiangan = l.getTiangan().get((yueganint+minggongint-1)%10 == 0?"10":""+(yueganint+minggongint-1)%10);
        String mingDizhi = l.getDizhi().get(minggongint%12 == 0?"12":""+minggongint%12);
        LogUtils.e(mingTiangan+"----------------------"+mingDizhi);


        /*宫支→
        宫干↓	子、丑	寅、卯	辰、巳	午、未	申、酉	戍、亥
        甲、乙  金四局	水二局	火六局	金四局	水二局	火六局
        丙、丁	水二局	火六局	土五局	水二局	火六局	土五局
        戊、己	火六局	土五局	木三局	火六局	土五局	木三局
        庚、辛	土五局	木三局	金四局	土五局	木三局	金四局
        壬、癸	木三局	金四局	水二局	木三局	金四局	水二局*/



        String wuxingju = ziWeiConstants.getWuxingju().get(mingTiangan+mingDizhi);
        LogUtils.e("wuxingju =========================:"+wuxingju);



        //得到五行局的五行数
        Integer wuxingshu = Integer.valueOf(getKey(ziWeiConstants.getWuxingshu(),wuxingju.substring(0,1)));
        LogUtils.e(nlri+"---------------------:"+wuxingshu);
        String ziweisuozaidizhi = ziWeiConstants.getZiweixin()[nlri-1][wuxingshu];
        LogUtils.e("紫薇星所在：-----"+ziweisuozaidizhi);

        //得到所对应的紫薇星地支数

        Integer ziweixingdizhishu = Integer.valueOf(getKey(l.getShidizhi(),ziweisuozaidizhi));

        //十四正星排  ziWeiConstants.getShisizhengxing()[ziweixingdizhishu-1][i]


        //排12宫的公式  (14-minggongint)%12 == 0 ?12:(14-minggongint)%12

        //月分排ziWeiConstants.getYuefenxingxiu()[nlyue-1][0]

        //年支星系
        Integer nianzhixingxi = Integer.valueOf(getKey(l.getShidizhi(),yearDizhi));
        Integer nianganxingxi = Integer.valueOf(getKey(l.getTiangan(),yearTiangan));


        ziweiyin.setText(ziWeiConstants.getZiweishiergong().get((yinInt+0)%12 == 0?"12":""+(yinInt+0)%12)+"\n"+l.getTiangan().get((yueganint+0)%10 == 0?"10":""+(yueganint+0)%10)+"寅"+"|"+ziWeiConstants.getShisizhengxing()[ziweixingdizhishu-1][2]+"|"+ziWeiConstants.getYuefenxingxiu()[nlyue-1][2]+"|"+ziWeiConstants.getNianzhixizhuxing()[nianzhixingxi-1][2]+"|"+ziWeiConstants.getShizhixizhuxing()[shizhiint-1][2]+"|"+ziWeiConstants.getNianganxizhuxing()[nianganxingxi-1][2]);
        ziweimao.setText(ziWeiConstants.getZiweishiergong().get((yinInt+11)%12 == 0?"12":""+(yinInt+11)%12)+"\n"+l.getTiangan().get((yueganint+1)%10 == 0?"10":""+(yueganint+1)%10)+"卯"+"|"+ziWeiConstants.getShisizhengxing()[ziweixingdizhishu-1][3]+"|"+ziWeiConstants.getYuefenxingxiu()[nlyue-1][3]+"|"+ziWeiConstants.getNianzhixizhuxing()[nianzhixingxi-1][3]+"|"+ziWeiConstants.getShizhixizhuxing()[shizhiint-1][3]+"|"+ziWeiConstants.getNianganxizhuxing()[nianganxingxi-1][3]);
        ziweichen.setText(ziWeiConstants.getZiweishiergong().get((yinInt+10)%12 == 0?"12":""+(yinInt+10)%12)+"\n"+l.getTiangan().get((yueganint+2)%10 == 0?"10":""+(yueganint+2)%10)+"辰"+"|"+ziWeiConstants.getShisizhengxing()[ziweixingdizhishu-1][4]+"|"+ziWeiConstants.getYuefenxingxiu()[nlyue-1][4]+"|"+ziWeiConstants.getNianzhixizhuxing()[nianzhixingxi-1][4]+"|"+ziWeiConstants.getShizhixizhuxing()[shizhiint-1][4]+"|"+ziWeiConstants.getNianganxizhuxing()[nianganxingxi-1][4]);
        ziweisi.setText(ziWeiConstants.getZiweishiergong().get((yinInt+9)%12 == 0?"12":""+(yinInt+9)%12)+"\n"+l.getTiangan().get((yueganint+3)%10 == 0?"10":""+(yueganint+3)%10)+"巳"+"|"+ziWeiConstants.getShisizhengxing()[ziweixingdizhishu-1][5]+"|"+ziWeiConstants.getYuefenxingxiu()[nlyue-1][5]+"|"+ziWeiConstants.getNianzhixizhuxing()[nianzhixingxi-1][5]+"|"+ziWeiConstants.getShizhixizhuxing()[shizhiint-1][5]+"|"+ziWeiConstants.getNianganxizhuxing()[nianganxingxi-1][5]);
        ziweiwu.setText(ziWeiConstants.getZiweishiergong().get((yinInt+8)%12 == 0?"12":""+(yinInt+8)%12)+"\n"+l.getTiangan().get((yueganint+4)%10 == 0?"10":""+(yueganint+4)%10)+"午"+"|"+ziWeiConstants.getShisizhengxing()[ziweixingdizhishu-1][6]+"|"+ziWeiConstants.getYuefenxingxiu()[nlyue-1][6]+"|"+ziWeiConstants.getNianzhixizhuxing()[nianzhixingxi-1][6]+"|"+ziWeiConstants.getShizhixizhuxing()[shizhiint-1][6]+"|"+ziWeiConstants.getNianganxizhuxing()[nianganxingxi-1][6]);
        ziweiwei.setText(ziWeiConstants.getZiweishiergong().get((yinInt+7)%12 == 0?"12":""+(yinInt+7)%12)+"\n"+l.getTiangan().get((yueganint+5)%10 == 0?"10":""+(yueganint+5)%10)+"未"+"|"+ziWeiConstants.getShisizhengxing()[ziweixingdizhishu-1][7]+"|"+ziWeiConstants.getYuefenxingxiu()[nlyue-1][7]+"|"+ziWeiConstants.getNianzhixizhuxing()[nianzhixingxi-1][7]+"|"+ziWeiConstants.getShizhixizhuxing()[shizhiint-1][7]+"|"+ziWeiConstants.getNianganxizhuxing()[nianganxingxi-1][7]);
        ziweishen.setText(ziWeiConstants.getZiweishiergong().get((yinInt+6)%12 == 0?"12":""+(yinInt+6)%12)+"\n"+l.getTiangan().get((yueganint+6)%10 == 0?"10":""+(yueganint+6)%10)+"申"+"|"+ziWeiConstants.getShisizhengxing()[ziweixingdizhishu-1][8]+"|"+ziWeiConstants.getYuefenxingxiu()[nlyue-1][8]+"|"+ziWeiConstants.getNianzhixizhuxing()[nianzhixingxi-1][8]+"|"+ziWeiConstants.getShizhixizhuxing()[shizhiint-1][8]+"|"+ziWeiConstants.getNianganxizhuxing()[nianganxingxi-1][8]);
        ziweiyou.setText(ziWeiConstants.getZiweishiergong().get((yinInt+5)%12 == 0?"12":""+(yinInt+5)%12)+"\n"+l.getTiangan().get((yueganint+7)%10 == 0?"10":""+(yueganint+7)%10)+"酉"+"|"+ziWeiConstants.getShisizhengxing()[ziweixingdizhishu-1][9]+"|"+ziWeiConstants.getYuefenxingxiu()[nlyue-1][9]+"|"+ziWeiConstants.getNianzhixizhuxing()[nianzhixingxi-1][9]+"|"+ziWeiConstants.getShizhixizhuxing()[shizhiint-1][9]+"|"+ziWeiConstants.getNianganxizhuxing()[nianganxingxi-1][9]);
        ziweixu.setText(ziWeiConstants.getZiweishiergong().get((yinInt+4)%12 == 0?"12":""+(yinInt+4)%12)+"\n"+l.getTiangan().get((yueganint+8)%10 == 0?"10":""+(yueganint+8)%10)+"戌"+"|"+ziWeiConstants.getShisizhengxing()[ziweixingdizhishu-1][10]+"|"+ziWeiConstants.getYuefenxingxiu()[nlyue-1][10]+"|"+ziWeiConstants.getNianzhixizhuxing()[nianzhixingxi-1][10]+"|"+ziWeiConstants.getShizhixizhuxing()[shizhiint-1][10]+"|"+ziWeiConstants.getNianganxizhuxing()[nianganxingxi-1][10]);
        ziweihai.setText(ziWeiConstants.getZiweishiergong().get((yinInt+3)%12 == 0?"12":""+(yinInt+3)%12)+"\n"+l.getTiangan().get((yueganint+9)%10 == 0?"10":""+(yueganint+9)%10)+"亥"+"|"+ziWeiConstants.getShisizhengxing()[ziweixingdizhishu-1][11]+"|"+ziWeiConstants.getYuefenxingxiu()[nlyue-1][11]+"|"+ziWeiConstants.getNianzhixizhuxing()[nianzhixingxi-1][11]+"|"+ziWeiConstants.getShizhixizhuxing()[shizhiint-1][11]+"|"+ziWeiConstants.getNianganxizhuxing()[nianganxingxi-1][11]);
        ziweizi.setText(ziWeiConstants.getZiweishiergong().get((yinInt+2)%12 == 0?"12":""+(yinInt+2)%12)+"\n"+l.getTiangan().get((yueganint+10)%10 == 0?"10":""+(yueganint+10)%10)+"子"+"|"+ziWeiConstants.getShisizhengxing()[ziweixingdizhishu-1][0]+"|"+ziWeiConstants.getYuefenxingxiu()[nlyue-1][0]+"|"+ziWeiConstants.getNianzhixizhuxing()[nianzhixingxi-1][0]+"|"+ziWeiConstants.getShizhixizhuxing()[shizhiint-1][0]+"|"+ziWeiConstants.getNianganxizhuxing()[nianganxingxi-1][0]);
        ziweichou.setText(ziWeiConstants.getZiweishiergong().get((yinInt+1)%12 == 0?"12":""+(yinInt+1)%12)+"\n"+l.getTiangan().get((yueganint+11)%10 == 0?"10":""+(yueganint+11)%10)+"丑"+"|"+ziWeiConstants.getShisizhengxing()[ziweixingdizhishu-1][1]+"|"+ziWeiConstants.getYuefenxingxiu()[nlyue-1][1]+"|"+ziWeiConstants.getNianzhixizhuxing()[nianzhixingxi-1][1]+"|"+ziWeiConstants.getShizhixizhuxing()[shizhiint-1][1]+"|"+ziWeiConstants.getNianganxizhuxing()[nianganxingxi-1][1]);





        //十二天干排盘
       /* ziweiyin.setText(l.getTiangan().get((yueganint+0)%10 == 0?"10":""+(yueganint+0)%10));
        ziweimao.setText(l.getTiangan().get((yueganint+1)%10 == 0?"10":""+(yueganint+1)%10));
        ziweichen.setText(l.getTiangan().get((yueganint+2)%10 == 0?"10":""+(yueganint+2)%10));
        ziweisi.setText(l.getTiangan().get((yueganint+3)%10 == 0?"10":""+(yueganint+3)%10));
        ziweiwu.setText(l.getTiangan().get((yueganint+4)%10 == 0?"10":""+(yueganint+4)%10));
        ziweiwei.setText(l.getTiangan().get((yueganint+5)%10 == 0?"10":""+(yueganint+5)%10));
        ziweishen.setText(l.getTiangan().get((yueganint+6)%10 == 0?"10":""+(yueganint+6)%10));
        ziweiyou.setText(l.getTiangan().get((yueganint+7)%10 == 0?"10":""+(yueganint+7)%10));
        ziweixu.setText(l.getTiangan().get((yueganint+8)%10 == 0?"10":""+(yueganint+8)%10));
        ziweihai.setText(l.getTiangan().get((yueganint+9)%10 == 0?"10":""+(yueganint+9)%10));
        ziweizi.setText(l.getTiangan().get((yueganint+10)%10 == 0?"10":""+(yueganint+10)%10));
        ziweichou.setText(l.getTiangan().get((yueganint+11)%10 == 0?"10":""+(yueganint+11)%10));*/


        Integer yearTianganint = Integer.valueOf(getKey(l.getTiangan(),yearTiangan));

        //ziweibazijieshao.setText("日柱"+nzshuoming[rizhuint][0]+"，"+nzshuoming[rizhuint][1]);
        ziweibazijieshao.setText("化禄星:——"+ziWeiConstants.getSihuaxing()[0][yearTianganint-1]+"\n化权星:——"+ziWeiConstants.getSihuaxing()[1][yearTianganint-1]+"\n化科星:——"+ziWeiConstants.getSihuaxing()[2][yearTianganint-1]+"\n化忌星:——"+ziWeiConstants.getSihuaxing()[3][yearTianganint-1]);
        ziweibazi.setText("姓名；"+xingming+","+diqu+"人\n性别："+xb+"\n日期："+nlriqi+"("+wuxingju+")"+"\n八字："+yearTiangan+yearDizhi+" "+yueTiangan+yueDizhi+" "+riTiangan+riDizhi+" "+shiTiangan+shiDizhi);


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
