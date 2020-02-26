package com.vkeline.zlibrary.util;

import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

/**
 * @author Zhou
 *         Created on 2017/12/1 9:46.
 *         Email:qishuichixi@163.com
 *         Desc:
 */
public class LogUtils {

    private static final String KEY_TAG = "Zhou";
    private static Boolean isShow = true;

    public static String getKeyTag() {
        return KEY_TAG;
    }

    public static Boolean getShow() {
        return isShow;
    }

    public void setShow(Boolean show) {
        isShow = show;
    }

    public static void e(Object msg) {
        if (isShow) {
            if (msg instanceof Map) {
                outMap((Map<Object, Object>) msg);
            } else {
                Log.e(KEY_TAG, "" + msg);
                writeToFile(true, "" + msg);
            }
        }
    }

    public static void outMap(Map<Object, Object> map) {
        //遍历map
        int index = 0;
        LogUtils.e("==================================请求参数S===================================");
        writeToFile(true, "==================================请求参数S===================================");
        String printMsg = "";
        for (Object s : map.keySet()) {
            LogUtils.e("第:" + (index++) + "参数:" + "\tKEY  " + s + "\tVALUE  " + map.get(s));
            printMsg = printMsg + "第:" + (index++) + "参数:" + "\tKEY  " + s + "\tVALUE  " + map.get(s);
        }
        writeToFile(true, printMsg);
        LogUtils.e("==================================请求参数E===================================");
        writeToFile(true, "==================================请求参数E===================================");
    }


    /**
     * 打印LOG到文件中
     *
     * @param isPrint
     * @param msg
     */
    private static void writeToFile(Boolean isPrint, final String msg) {

        if (!isPrint && FileUtils.hasSD()) {
            return;
        }
        //开启子线程读写文件
        new Thread(){
            @Override
            public void run() {

                String logPath = FileUtils.getSDPath() + "/vkeline2018/log/" + TimeUtils.getTime("yyyy-MM-dd");
                String fileName = logPath + "/" + TimeUtils.getTime("yyyy-MM-dd HH") + ".log";//log日志名，使用时间命名，保证不重复
                String log = TimeUtils.getTime(TimeUtils.TYPE_NYRSFM) + ": " + msg + "\n";//log日志内容，可以自行定制
                FileOutputStream fos = null;//FileOutputStream会自动调用底层的close()方法，不用关闭
                BufferedWriter bw = null;
                try {
                    //如果父路径不存在
                    File file = new File(logPath);
                    if (!file.exists()) {
                        file.mkdirs();//创建父路径
                    }
                    fos = new FileOutputStream(fileName, true);//这里的第二个参数代表追加还是覆盖，true为追加，flase为覆盖
                    bw = new BufferedWriter(new OutputStreamWriter(fos));
                    bw.write(log);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (bw != null) {
                            bw.close();//关闭缓冲流
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

//        ThreadUtils.getInstance().createLongPool().execute(new Runnable() {
//            @Override
//            public void run() {
//
//                String logPath = FileUtils.getSDPath() + "/vkeline2018/log/" + TimeUtils.getTime("yyyy-MM-dd");
//                String fileName = logPath + "/" + TimeUtils.getTime("yyyy-MM-dd HH") + ".log";//log日志名，使用时间命名，保证不重复
//                String log = TimeUtils.getTime(TimeUtils.TYPE_NYRSFM) + ": " + msg + "\n";//log日志内容，可以自行定制
//                FileOutputStream fos = null;//FileOutputStream会自动调用底层的close()方法，不用关闭
//                BufferedWriter bw = null;
//                try {
//                    //如果父路径不存在
//                    File file = new File(logPath);
//                    if (!file.exists()) {
//                        file.mkdirs();//创建父路径
//                    }
//                    fos = new FileOutputStream(fileName, true);//这里的第二个参数代表追加还是覆盖，true为追加，flase为覆盖
//                    bw = new BufferedWriter(new OutputStreamWriter(fos));
//                    bw.write(log);
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } finally {
//                    try {
//                        if (bw != null) {
//                            bw.close();//关闭缓冲流
//                        }
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });

    }


}

