package com.example.vkeline.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.example.vkeline.myapplication.data.PaiPanItem;
import com.example.vkeline.myapplication.view.Ganzhifenxi;
import com.example.vkeline.myapplication.view.Guanyuwomen;
import com.example.vkeline.myapplication.view.Jibenxinxi;
import com.example.vkeline.myapplication.view.Xiangximingpan;
import com.example.vkeline.myapplication.view.Zicegongju;
import com.vkeline.zlibrary.adapter.CommonListViewAdapter;
import com.vkeline.zlibrary.base.ZBaseActivity;
import com.vkeline.zlibrary.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class AllPaipanActivity extends ZBaseActivity {
    private GridView paipangridview;

    @Override
    public void initViewMVC() {
        setContentView( R.layout.activity_all_paipan);
    }

    /**
     * 不使用mvp的处理业务
     */
    @Override
    public void initEventMVC() {
        paipangridview = (GridView)findViewById(R.id.paipangridview);
        List<PaiPanItem> items = new ArrayList<>();
        items.add(new PaiPanItem(R.mipmap.bazipaipan,"八字四柱排盘"));
        items.add(new PaiPanItem(R.mipmap.ziweidoushipaipan,"紫微斗数排盘"));
        items.add(new PaiPanItem(R.mipmap.qimendunjiapaipan,"奇门遁甲排盘"));
        items.add(new PaiPanItem(R.mipmap.liuyaozhanbu,"六爻梅花排盘"));
        items.add(new PaiPanItem(R.mipmap.jinkoujuepaipan,"金口诀排盘"));
        items.add(new PaiPanItem(R.mipmap.daliuren,"大六壬排盘"));
        items.add(new PaiPanItem(R.mipmap.xuankongfengshui,"玄空风水排盘"));
        items.add(new PaiPanItem(R.mipmap.zhouyizhanbu,"周易占卜起卦"));
        items.add(new PaiPanItem(R.mipmap.zhenrenzaixian,"真人在线咨询"));
        paipangridview.setAdapter(new CommonListViewAdapter<PaiPanItem>(this, items, R.layout.activity_all_paipan_item) {
            @Override
            public void setData(BaseHolder holder, final PaiPanItem item, final int position) {

                holder.setText(R.id.tv_item,item.getText()).setImageResource(R.id.iv_item,item.getImg());

                holder.getView(R.id.rl_item).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        switch (position) {
                            case 0:
                                LogUtils.e("BzInfoActivity");
                                show(item.getText()+position);
                                startActivity(BzInfoActivity.class);
                                break;
                            case 1:
                                LogUtils.e("liuyaoInfoActivity");
                                startActivity(ZwdsInfoActivity.class);

                                break;
                            case 2:
                                LogUtils.e("qimenInfoActivity");
                                startActivity(QmdjInfoActivity.class);
                                break;

                            case 3:
                                LogUtils.e("zicegongju");
                                break;

                            case 4:
                                LogUtils.e("guanyuwomen");
                                break;

                            default:
                                break;
                        }

                    }
                });
            }

        });

    }

}
