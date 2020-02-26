package com.example.vkeline.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import com.example.vkeline.myapplication.AisuanguaActivity;
import com.example.vkeline.myapplication.R;
import com.example.vkeline.myapplication.ShiyexianshiActivity;
import com.vkeline.zlibrary.base.ZBaseFragment;

/**
 * Created by vkeline on 2018/3/1.
 */
public class Zicegongju extends ZBaseFragment {

    private Button aisuanguabazihehun;
    //aisuanguabzyinyuan
    private Button aisuanguabzyinyuan;
    //aisuanguacaiwuxiangpi
    private Button aisuanguacaiwuxiangpi;
//aisuanguataohuacesuan
    private Button aisuanguataohuacesuan;
    //aisuanguayuanfenpipei
    private Button aisuanguayuanfenpipei;
    //aisuangua2019yunshi
    private Button aisuangua2019yunshi;
    //aisuanguaxingmingceshi
    private Button aisuanguaxingmingceshi;

    @Override
    protected int initViewMVC() {
        return R.layout.zicegongju;
    }

    @Override
    protected void initEventMVC(View v) {
        aisuanguabazihehun = v.findViewById(R.id.aisuanguabazihehun);
        aisuanguabazihehun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), AisuanguaActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("url","https://www.aisuangua.com/aisuanguabzhehun");
                intent.putExtras(bundle);
                getActivity().startActivity(intent);

            }
        });

        //爱算卦八字姻缘
        aisuanguabzyinyuan = v.findViewById(R.id.aisuanguabzyinyuan);
        aisuanguabzyinyuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), AisuanguaActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("url","https://www.aisuangua.com/aisuanguabzyinyuan");
                intent.putExtras(bundle);
                getActivity().startActivity(intent);

            }
        });

        //爱算卦财务详批
        aisuanguacaiwuxiangpi = v.findViewById(R.id.aisuanguacaiwuxiangpi);
        aisuanguacaiwuxiangpi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), AisuanguaActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("url","https://www.aisuangua.com/aisuanguacaiwuxiangpi");
                intent.putExtras(bundle);
                getActivity().startActivity(intent);

            }
        });

        //爱算卦桃花测算http://www.aisuangua.com/aisuanguataohuacesuan
        aisuanguataohuacesuan = v.findViewById(R.id.aisuanguataohuacesuan);
        aisuanguataohuacesuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), AisuanguaActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("url","https://www.aisuangua.com/aisuanguataohuacesuan");
                intent.putExtras(bundle);
                getActivity().startActivity(intent);

            }
        });

        //爱算卦缘分匹配http://www.aisuangua.com/aisuanguayuanfenpipei
        aisuanguayuanfenpipei = v.findViewById(R.id.aisuanguayuanfenpipei);
        aisuanguayuanfenpipei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), AisuanguaActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("url","https://www.aisuangua.com/aisuanguayuanfenpipei");
                intent.putExtras(bundle);
                getActivity().startActivity(intent);

            }
        });

        //爱算卦姓名测算http://www.aisuangua.com/aisuanguaxingmingceshi
        aisuanguaxingmingceshi = v.findViewById(R.id.aisuanguaxingmingceshi);
        aisuanguaxingmingceshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), AisuanguaActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("url","https://www.aisuangua.com/aisuanguaxingmingceshi");
                intent.putExtras(bundle);
                getActivity().startActivity(intent);

            }
        });

        //爱算卦缘分匹配2019运势http://www.aisuangua.com/aisuangua2019yunshi
        aisuangua2019yunshi = v.findViewById(R.id.aisuangua2019yunshi);
        aisuangua2019yunshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), AisuanguaActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("url","https://www.aisuangua.com/aisuangua2019yunshi");
                intent.putExtras(bundle);
                getActivity().startActivity(intent);

            }
        });



    }
}

