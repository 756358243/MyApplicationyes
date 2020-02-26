package com.example.vkeline.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vkeline.myapplication.BazimingyunActivity;
import com.example.vkeline.myapplication.BzjieguoActivity;
import com.example.vkeline.myapplication.CaiyunfenxiActivity;
import com.example.vkeline.myapplication.HunlianfenxiActivity;
import com.example.vkeline.myapplication.JiankanfenxiActivity;
import com.example.vkeline.myapplication.R;
import com.example.vkeline.myapplication.ShiyexianshiActivity;
import com.example.vkeline.myapplication.XgxianshiActivity;
import com.example.vkeline.myapplication.data.Liushihuajiazi;
import com.vkeline.zlibrary.base.ZBaseFragment;
import com.vkeline.zlibrary.util.LogUtils;

/**
 * Created by vkeline on 2018/3/1.
 */
public class Xiangximingpan extends ZBaseFragment {

    private Button xingge;

    private Button shiye;

    private Button bzmingyun;

    private Button caiyun;

    private Button hunlian;

    private Button jiankan;

    @Override
    protected int initViewMVC() {
        return R.layout.xiangximingpan;
    }

    @Override
    protected void initEventMVC(View v) {
        Bundle bundle = getActivity().getIntent().getExtras();
        //得到八字强弱
        final String qiangruo = bundle.getString("qiangruo");
        final String xb = bundle.getString("xb");
        LogUtils.e("---------------------------xingbie:"+xb);
        //得到月令十神
        final String yueDizhishishen = bundle.getString("yueDizhishishen");
        //得到月支
        final String yueDizhi = bundle.getString("yueDizhi");
        String riDizhi = bundle.getString("riDizhi");
        //riTiangan
        final String riTiangan = bundle.getString("riTiangan");
        LogUtils.e("日天干：---"+riTiangan);
        final String riTianganshishen = bundle.getString("riTianganshishen");
        final Liushihuajiazi huajiazi = new Liushihuajiazi();
        //得到月支五行
        final String yuedizhiwuxing = huajiazi.getDizhiwuxing().get(yueDizhi);
        final String riTianganwuxing = huajiazi.getTianganwuxing().get(riTiangan);
        //得到日支五行
        final String ridizhiwuxing = huajiazi.getDizhiwuxing().get(riDizhi);
        final String dizhishishen = huajiazi.getShishen().get(riTianganwuxing+ridizhiwuxing);
        xingge = v.findViewById(R.id.xingge);
        xingge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yuewuxingshuoming = huajiazi.getWuxingxinggefenxi().get(yuedizhiwuxing.substring(1,2));
                String yuezhishishenshuoming=  huajiazi.getShishenxingge().get(yueDizhishishen);
                String rizhizhishishenshuoming=  huajiazi.getShishenxingge().get(dizhishishen);
                LogUtils.e("yuewuxingshuoming----"+yuewuxingshuoming+"yuezhishishenshuoming-----"+yuezhishishenshuoming+"rizhizhishishenshuoming-----"+rizhizhishishenshuoming);
                LogUtils.e("性格分析中...."+dizhishishen+"----------"+riTianganwuxing+ridizhiwuxing);
                Intent intent =new Intent(getActivity(), XgxianshiActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("yuewuxingshuoming",yuewuxingshuoming);

                bundle.putString("yuezhishishenshuoming",yuezhishishenshuoming);

                bundle.putString("rizhizhishishenshuoming",rizhizhishishenshuoming);

                bundle.putString("riTiangan",riTiangan);

                bundle.putString("yueDizhi",yueDizhi);

                LogUtils.e("性格分析中....");
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
            }
        });


        shiye = v.findViewById(R.id.shiye);
        shiye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), ShiyexianshiActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("qiangruo",qiangruo);
                intent.putExtras(bundle);
                getActivity().startActivity(intent);

            }
        });


        bzmingyun = v.findViewById(R.id.bzmingyun);
        bzmingyun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //八字的命运分析来看，1.八字强弱，2，八字带的食神
                Intent intent =new Intent(getActivity(), BazimingyunActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("qiangruo",qiangruo);
                intent.putExtras(bundle);
                getActivity().startActivity(intent);

            }
        });


        caiyun = v.findViewById(R.id.caiyun);
        caiyun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), CaiyunfenxiActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("qiangruo",qiangruo);
                intent.putExtras(bundle);
                getActivity().startActivity(intent);

            }
        });


        hunlian = v.findViewById(R.id.hunlian);
        hunlian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //爱情，婚姻分析，男看正财偏才，女看官杀
                Intent intent =new Intent(getActivity(), HunlianfenxiActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("qiangruo",qiangruo);
                bundle.putString("xb",xb);
                intent.putExtras(bundle);
                getActivity().startActivity(intent);

            }
        });


        jiankan = v.findViewById(R.id.jiankan);
        jiankan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //分析八字的最弱五行
                Intent intent =new Intent(getActivity(), JiankanfenxiActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("qiangruo",qiangruo);
                bundle.putString("xb",xb);
                intent.putExtras(bundle);
                getActivity().startActivity(intent);

            }
        });


    }



}
