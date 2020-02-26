package com.vkeline.zlibrary.image;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.module.GlideModule;
import com.vkeline.zlibrary.util.KeyUtils;

/**
 * Created by Administrator on 2017/12/27.
 */
public class GlideConfiguration implements GlideModule {

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        // 把缓存位置设置到sd卡上的公共缓存目录100M
        builder.setDiskCache(new ExternalCacheDiskCacheFactory(context, KeyUtils.KEY_GLIDE_PIC, KeyUtils.KEY_GLIDE_SIZE));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
    }
}
