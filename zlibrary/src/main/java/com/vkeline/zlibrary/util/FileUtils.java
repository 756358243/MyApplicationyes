package com.vkeline.zlibrary.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/12/26.
 */
public class FileUtils {

    /**
     * 是否可以使用SD卡
     *
     * @return
     */
    public static Boolean hasSD() {

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }

    /**
     * 获取SD卡路径
     *
     * @return
     */
    public static String getSDPath() {

        if (hasSD()) {
            return Environment.getExternalStorageDirectory().getPath();
        } else {
            throw new RuntimeException("SD卡不可用...");
        }

    }

    /**
     * 新建文件夹
     *
     * @param path
     * @return
     */
    public static Boolean createFilePath(String path) {
        if (StringUtils.isNull(path)) {
            LogUtils.e("新建目录为空!");
            return false;
        }
        File f = new File(path);
        if (!f.exists()) {
            LogUtils.e("新建目录" + path);
            return f.mkdirs();
        } else {
            return false;
        }
    }

    //拍照存取目录
    public static String getCachePath() {
        String path = FileUtils.getSDPath() + "/vkeline2018/cache/";
        FileUtils.createFilePath(path);
        return path;
    }

    /**
     * 格式化单位
     *
     * @param size
     * @return
     */
    public static String getFormatSize(double size) {
        double kiloByte = size / 1024;
        if (kiloByte < 1) {
            return size + "B";
        }

        double megaByte = kiloByte / 1024;
        if (megaByte < 1) {
            BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
            return result1.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "KB";
        }

        double gigaByte = megaByte / 1024;
        if (gigaByte < 1) {
            BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
            return result2.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "MB";
        }

        double teraBytes = gigaByte / 1024;
        if (teraBytes < 1) {
            BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
            return result3.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "GB";
        }
        BigDecimal result4 = new BigDecimal(teraBytes);
        return result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "TB";
    }


    /**
     * 保存信息到文件
     *
     * @param msg
     * @param path
     * @return
     */
    public static File save(String msg, String path) {

        byte[] b = msg.getBytes();
        BufferedOutputStream stream = null;
        File file = null;
        try {
            file = new File(path);

            if (!file.exists()) {
                file.mkdirs();
            }
            FileOutputStream fstream = new FileOutputStream(file);
            stream = new BufferedOutputStream(fstream);
            stream.write(b);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return file;
    }

    /**
     * 删除文件
     *
     * @param path
     * @return
     */
    public static Boolean deleteFile(String path) {

        if (path == null || "".equals(path)) {
            return false;
        }
        File f = new File(path);

        if (f != null && f.exists()) {

            return f.delete();
        }

        return false;
    }


    /**
     * 删除文件夹下，特定文件
     *
     * @param path
     * @param contains
     */
    public static void deletePhoto(String path, String contains) {

        File allfile = new File(path);
        String allPic[] = allfile.list();
        if (allPic != null) {
            for (int i = 0; i < allPic.length; i++) {
                if (allPic[i].contains(contains)) {
                    File a = new File(path + "/" + allPic[i]);
                    if (a.exists()) {
                        a.delete();
                    }
                }
            }
        }

    }

    /**
     * 将Bitmap转换成文件
     * 保存文件
     *
     * @param bm
     * @param fileName
     * @throws IOException
     */
    public static File saveBitmapToFile(Bitmap bm, String path, String fileName) {
        File dirFile = new File(path);
        if (!dirFile.exists()) {
            dirFile.mkdir();
        }
        File myCaptureFile = new File(path, fileName);
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
            bm.compress(Bitmap.CompressFormat.PNG, 100, bos);
            bos.flush();
            bos.close();
        } catch (Exception e) {
            LogUtils.e("将Bitmap转换成文件出现异常...");
            ToastUtils.show(e.getMessage());
            e.printStackTrace();
        }

        return myCaptureFile;
    }

    /**
     * 将文件转成bitmap
     */

    public static Bitmap decodeFile(String path) throws IOException {
        Bitmap bitmap = null;
        if (new File(path).exists() && new File(path).isFile()) {
            bitmap = BitmapFactory.decodeFile(path);
        }
        return bitmap;
    }


}
