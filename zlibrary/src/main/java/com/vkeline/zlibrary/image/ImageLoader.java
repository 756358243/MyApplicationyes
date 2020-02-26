package com.vkeline.zlibrary.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.vkeline.zlibrary.R;
import com.vkeline.zlibrary.net.OkHttpManager;
import com.zhy.http.okhttp.callback.BitmapCallback;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import okhttp3.Call;

/**
 * Created by Administrator on 2017/12/26.
 */
public class ImageLoader {

    /**
     * 展示图片
     *
     * @param iv
     * @param url
     */
    public static void display(final ImageView iv, String url) {

        iv.setImageResource(R.drawable.nophoto);
        OkHttpManager.getInstance().get(url).execute(new BitmapCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                iv.setImageResource(R.drawable.nophoto);
            }

            @Override
            public void onResponse(Bitmap response, int id) {
                iv.setImageBitmap(response);
            }
        });
    }

    /**
     * 展示一般图片
     *
     * @param iv
     * @param url
     */
    public static void display(Context context, ImageView iv, String url) {

        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.loading)
                .error(R.drawable.nophoto)
                .into(iv);

    }

    /**
     * 展示一般图片
     *
     * @param iv
     * @param url
     */
    public static void displayNOCache(Context context, ImageView iv, String url) {

        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .placeholder(R.drawable.loading)
                .error(R.drawable.nophoto)
                .into(iv);

    }

    /**
     * 清理内存
     *
     * @param context
     */
    public static void clearDiskCache(Context context) {
        Glide.get(context).clearDiskCache();
    }

    /**
     * 展示圆形图片
     */
    public static void displayCircle(Context context, ImageView iv, String url) {

        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.nophoto)
                .error(R.drawable.nophoto)
                .transform(new CircleTransform(context))
                .into(iv);
    }

    /**
     * 展示圆角图片
     */
    public static void displayCorners(Context context, ImageView iv, int size, String url) {

        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.nophoto)
                .error(R.drawable.nophoto)
                .transform(new CornersTransform(context, size))
                .into(iv);
    }


    /**
     * 获取bitmap
     */
    public Bitmap getBitmap(Context context, String url, int width, int hight) {
        Bitmap myBitmap = null;
        try {
            myBitmap = Glide.with(context)
                    .load(url)
                    .asBitmap()
                    .centerCrop()
                    .into(width, hight)
                    .get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myBitmap;
    }


    /**
     * 按质量压缩
     *
     * @param src         源图片
     * @param maxByteSize 允许最大值字节数
     * @return 质量压缩压缩过的图片
     */
    public static Boolean compressByQuality(final Bitmap src, final long maxByteSize, String filePath) {
        if (maxByteSize <= 0) return null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        src.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] bytes;
        if (baos.size() <= maxByteSize) {// 最好质量的不大于最大字节，则返回最佳质量
            bytes = baos.toByteArray();
        } else {
            baos.reset();
            src.compress(Bitmap.CompressFormat.JPEG, 0, baos);
            if (baos.size() >= maxByteSize) { // 最差质量不小于最大字节，则返回最差质量
                bytes = baos.toByteArray();
            } else {
                // 二分法寻找最佳质量
                int st = 0;
                int end = 100;
                int mid = 0;
                while (st < end) {
                    mid = (st + end) / 2;
                    baos.reset();
                    src.compress(Bitmap.CompressFormat.JPEG, mid, baos);
                    int len = baos.size();
                    if (len == maxByteSize) {
                        break;
                    } else if (len > maxByteSize) {
                        end = mid - 1;
                    } else {
                        st = mid + 1;
                    }
                }
                if (end == mid - 1) {
                    baos.reset();
                    src.compress(Bitmap.CompressFormat.JPEG, st, baos);
                }
                bytes = baos.toByteArray();
            }
        }
        Bitmap mBitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

        try {
            File f = new File(filePath);
            f.createNewFile();
            FileOutputStream fOut = null;
            fOut = new FileOutputStream(f);
            mBitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
            fOut.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
