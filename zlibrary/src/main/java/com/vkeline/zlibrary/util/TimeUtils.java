package com.vkeline.zlibrary.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Zhou
 *         Created on 2017/12/5 9:18.
 *         Email:qishuichixi@163.com
 *         Desc:
 */

public class TimeUtils {

    public static int MILLISECOND = 1;
    public static int SECOND = 1000 * MILLISECOND;
    public static int MINUTE = 60 * SECOND;
    public static long HOUR = 60 * MINUTE;
    public static long DAY = 24 * HOUR;


    public static final String TYPE_NYR = "yyyy-M-d";
    public static final String TYPE_NYRSF = "yyyy-M-d HH:mm";
    public static final String TYPE_NYRSFM = "yyyy-MM-dd HH:mm:ss";
    public static final String TYPE_HMS = "HH:mm:ss";

    /**
     * 获取自定义类型时间
     *
     * @param type
     * @return
     */
    public static String getTime(String type) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type);
        String time = simpleDateFormat.format(new Date());
        return time;
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static long getTimeCurrentSs() {
        return System.currentTimeMillis();
    }

    /**
     * 通过long值返回时间
     *
     * @param timeLong
     * @param type
     * @return
     */
    public static String getTimeStringByLong(long timeLong, String type) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type);
        return simpleDateFormat.format(new Date(timeLong));
    }


    /**
     * 格式化计时器
     *
     * @param s
     * @return
     */
    public static String getTimeDifference(int s) {

        String result = "";

        if (s < 60) {
            result = StringUtils.addString("00:00:", s >= 10 ? s : ("0" + s));
        } else if (s < 3600) {
            int min = s / 60;
            int sec = s % 60;
            result = StringUtils.addString("00:", min >= 10 ? min : "0" + min, ":", sec >= 10 ? sec : ("0" + sec));
        } else {

            int hour = (s / 3600);
            int min = (s % 3600 / 60);
            int sec = (s % 60);
            result = StringUtils.addString(hour >= 10 ? hour : "0" + hour, ":", min >= 10 ? min : "0" + min, ":", sec >= 10 ? sec : ("0" + sec));
        }

        return result;

    }


}
