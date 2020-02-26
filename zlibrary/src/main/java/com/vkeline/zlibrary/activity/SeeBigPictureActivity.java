package com.vkeline.zlibrary.activity;

import android.view.View;
import android.widget.ImageView;

import com.bm.library.Info;
import com.bm.library.PhotoView;
import com.vkeline.zlibrary.R;
import com.vkeline.zlibrary.base.ZBaseActivity;
import com.vkeline.zlibrary.image.ImageLoader;
import com.vkeline.zlibrary.util.KeyUtils;
import com.vkeline.zlibrary.util.LogUtils;
import com.vkeline.zlibrary.util.StatusBarUtils;

/**
 * Created by Administrator on 2017/12/27.
 */
public class SeeBigPictureActivity extends ZBaseActivity {

    @Override
    public void initViewMVC() {
        setContentView(R.layout.activity_see_big);
    }

    @Override
    public void initEventMVC() {

        StatusBarUtils.setFullScreen(this);

        String url = getIntent().getStringExtra(KeyUtils.KEY_BIG_PIC_URL);

        LogUtils.e("查看大图:" + url);


        ImageView iv = (ImageView) findViewById(R.id.id_see_iv);


        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        PhotoView photoView = (PhotoView) findViewById(R.id.id_see_img);

        ImageLoader.displayNOCache(this, photoView, url);

        // 启用图片缩放功能
        photoView.enable();
// 获取图片信息
        Info info = photoView.getInfo();
// 从普通的ImageView中获取Info
        //      Info info = PhotoView.getImageViewInfo(ImageView);
// 从一张图片信息变化到现在的图片，用于图片点击后放大浏览，具体使用可以参照demo的使用
//            photoView.animaFrom(info);
// 从现在的图片变化到所给定的图片信息，用于图片放大后点击缩小到原来的位置，具体使用可以参照demo的使用
//        photoView.animaTo(info, new Runnable() {
//            @Override
//            public void run() {
//                //动画完成监听
//            }
//        });
// 获取/设置 动画持续时间
        //    photoView.setAnimaDuring(3);
        //int d = photoView.getAnimaDuring();
        // 获取/设置 最大缩放倍数
        photoView.setMaxScale(5);
        // 设置动画的插入器
        //photoView.setInterpolator(Interpolator interpolator);


    }
}
