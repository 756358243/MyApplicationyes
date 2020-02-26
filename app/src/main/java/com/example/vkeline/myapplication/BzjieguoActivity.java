package com.example.vkeline.myapplication;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.vkeline.myapplication.R;
import com.example.vkeline.myapplication.Utils.CommonUtils;
import com.example.vkeline.myapplication.Utils.Lunar;
import com.example.vkeline.myapplication.view.FragmentFactory;
import com.vkeline.zlibrary.base.ZBaseActivity;
import com.vkeline.zlibrary.util.LogUtils;

/**
 * Created by vkeline on 2018/2/27.
 */
public class BzjieguoActivity extends ZBaseActivity{



    private RadioGroup dbdhhz;
    private RadioButton jbxx;
    private RadioButton gzfx;
    private RadioButton xxmp;
    private RadioButton zcgj;
    private RadioButton gywm;


   /* private RadioGroup mRadioGroup;
    private RadioButton mRadioButtonHome;
*/

    @Override
    public void initViewMVC() {
        LogUtils.e("加载关于页面");
        setContentView( R.layout.dibudaohang);
        dbdhhz =(RadioGroup) findViewById(R.id.daohangzu);
        jbxx =(RadioButton) findViewById(R.id.jibenxinxi);
        gzfx =(RadioButton) findViewById(R.id.ganzhifenxi);
        xxmp =(RadioButton) findViewById(R.id.xiangximingpan);
        zcgj =(RadioButton) findViewById(R.id.zicegongju);
        gywm =(RadioButton) findViewById(R.id.guanyuwomen);
     //初始化第一个
        getSupportFragmentManager().beginTransaction().replace(R.id.yemianqiehuan, FragmentFactory.addMainFragment(0)).commit();
        dbdhhz.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                Fragment mFragment = null;
                switch (i) {
                    case R.id.jibenxinxi:
                        jbxx.setTextColor(Color.BLUE);
                        gzfx.setTextColor(Color.BLACK);
                        xxmp.setTextColor(Color.BLACK);
                        zcgj.setTextColor(Color.BLACK);
                        gywm.setTextColor(Color.BLACK);
                        mFragment = FragmentFactory.addMainFragment(0);
                        break;
                    case R.id.ganzhifenxi:
                        gzfx.setTextColor(Color.BLUE);
                        jbxx.setTextColor(Color.BLACK);
                        xxmp.setTextColor(Color.BLACK);
                        zcgj.setTextColor(Color.BLACK);
                        gywm.setTextColor(Color.BLACK);
                        mFragment = FragmentFactory.addMainFragment(1);
                        break;
                    case R.id.xiangximingpan:
                        xxmp.setTextColor(Color.BLUE);
                        jbxx.setTextColor(Color.BLACK);
                        gzfx.setTextColor(Color.BLACK);
                        zcgj.setTextColor(Color.BLACK);
                        gywm.setTextColor(Color.BLACK);
                        mFragment = FragmentFactory.addMainFragment(2);
                        break;
                    case R.id.zicegongju:
                        zcgj.setTextColor(Color.BLUE);
                        jbxx.setTextColor(Color.BLACK);
                        gzfx.setTextColor(Color.BLACK);
                        xxmp.setTextColor(Color.BLACK);
                        gywm.setTextColor(Color.BLACK);
                        mFragment = FragmentFactory.addMainFragment(3);
                        break;
                    case R.id.guanyuwomen:
                        gywm.setTextColor(Color.BLUE);
                        jbxx.setTextColor(Color.BLACK);
                        gzfx.setTextColor(Color.BLACK);
                        xxmp.setTextColor(Color.BLACK);
                        zcgj.setTextColor(Color.BLACK);
                        mFragment = FragmentFactory.addMainFragment(4);
                        break;
                    default:
                        break;
                }
                if (mFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.yemianqiehuan, mFragment).commit();
                }
            }
        });



    }



}
