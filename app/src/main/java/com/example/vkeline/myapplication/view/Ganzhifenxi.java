package com.example.vkeline.myapplication.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.vkeline.myapplication.R;
import com.example.vkeline.myapplication.data.Ganzhisuanming;
import com.example.vkeline.myapplication.data.Liushihuajiazi;
import com.vkeline.zlibrary.base.ZBaseFragment;
import com.vkeline.zlibrary.util.LogUtils;

import java.util.Map;

/**
 * Created by vkeline on 2018/3/1.
 */
public class Ganzhifenxi extends ZBaseFragment {

    private TextView nianganzhifenxi;
    private TextView yueganzhifenxi;
    private TextView riganzhifenxi;
    private TextView shiganzhifenxi;

    private TextView jibenshuoming;


    @Override
    protected int initViewMVC() {
        return R.layout.ganzhifenxi;
    }

    @Override
    protected void initEventMVC(View v) {
        nianganzhifenxi = v.findViewById(R.id.nianganzhifenxi);
        yueganzhifenxi = v.findViewById(R.id.yueganzhifenxi);
        riganzhifenxi = v.findViewById(R.id.riganzhifenxi);
        shiganzhifenxi = v.findViewById(R.id.shiganzhifenxi);
        jibenshuoming = v.findViewById(R.id.jibenshuoming);
        Bundle bundle = getActivity().getIntent().getExtras();
        String yearTiangan = bundle.getString("yearTiangan");
        String yearDizhi = bundle.getString("yearDizhi");

        String yueTiangan = bundle.getString("yueTiangan");
        String yueDizhi = bundle.getString("yueDizhi");

        String riTiangan = bundle.getString("riTiangan");
        String riDizhi = bundle.getString("riDizhi");

        String shiTiangan = bundle.getString("shiTiangan");
        String shiDizhi = bundle.getString("shiDizhi");

        String xingming = bundle.getString("xingming");
        String xb = bundle.getString("xb");
        String diqu = bundle.getString("diqu");
        String nongliriqi = bundle.getString("nongliriqi");

        jibenshuoming.setText(xingming+"，性别"+xb+"，出生于"+diqu+"。诞生于"+nongliriqi+"。");
        String nianzhuganzhi = yearTiangan+yearDizhi;
        String yuezhuganzhi = yueTiangan+yueDizhi;
        String rizhuganzhi = riTiangan+riDizhi;
        String shizhuganzhi = shiTiangan+shiDizhi;
        Liushihuajiazi l = new Liushihuajiazi();
        Integer nianzhuint = Integer.valueOf(getKey(l.getHuajiazi(),nianzhuganzhi));
        Integer yuezhuint = Integer.valueOf(getKey(l.getHuajiazi(),yuezhuganzhi));
        Integer rizhuint = Integer.valueOf(getKey(l.getHuajiazi(),rizhuganzhi));
        Integer shizhuint = Integer.valueOf(getKey(l.getHuajiazi(),shizhuganzhi));

        Ganzhisuanming gzarray = new Ganzhisuanming();
        String[][] nzshuoming = gzarray.getArrayOfString();
        nianganzhifenxi.setText(nzshuoming[nianzhuint][0]+"，"+nzshuoming[nianzhuint][1]);
        yueganzhifenxi.setText(nzshuoming[yuezhuint][0]+"，"+nzshuoming[yuezhuint][1]);
        riganzhifenxi.setText(nzshuoming[rizhuint][0]+"，"+nzshuoming[rizhuint][1]);
        shiganzhifenxi.setText(nzshuoming[shizhuint][0]+"，"+nzshuoming[shizhuint][1]);


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
