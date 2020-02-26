package com.vkeline.zlibrary.activity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;

import com.vkeline.zlibrary.util.FileProvider7;
import com.vkeline.zlibrary.util.LogUtils;

import java.io.File;

/**
 * Created by Administrator on 2017/12/26.
 * <p/>
 * 拍照
 */
public class TakeAPictureActivity extends CheckPermissionsActivity {

    private static final int TAKE_PHOTO = 0x1234;
    private File file;
    private String[] needPermissions = {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private CallBack callBack;

    @Override
    protected void onResume() {
        super.onResume();
        setNeedPermissions(needPermissions);
    }

    public void takePicture(String picPath, CallBack callBack) {

        file = new File(picPath);
        LogUtils.e("拍照文件保存:" + file.getAbsolutePath());
        if (file.exists()) {
            file.delete();
        }

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //自定义拍摄路径
        intent.putExtra(MediaStore.EXTRA_OUTPUT, FileProvider7.getUriForFile(this, file));
        startActivityForResult(intent, TAKE_PHOTO);
        this.callBack = callBack;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == TAKE_PHOTO) {
            {
                //获取默认bitmap
                //  Bitmap bitmap =
                Bitmap bitmap = BitmapFactory.decodeFile(file.getPath());
                if (callBack != null) {
                    callBack.disPlay(file.getPath(), bitmap);
                }
            }
        }


    }

    public interface CallBack {
        //图片路径和bitmap
        void disPlay(String path, Bitmap bitmap);
    }

}


