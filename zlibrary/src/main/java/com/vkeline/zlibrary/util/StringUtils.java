package com.vkeline.zlibrary.util;

/**
 * Created by Administrator on 2017/12/26.
 */
public class StringUtils {


    public static String getStringValue(String s) {
        return isNull(s) ? "" : s;
    }

    public static Boolean isNull(String s) {

        if (null == s || "".equals(s)) {
            return true;
        }
        return false;
    }

    public static Boolean isNotNull(String s) {

        if (null != s && !"".equals(s)) {
            return true;
        }
        return false;
    }


    /**
     * @param s1
     * @param s2
     * @return 比较字符串是否相等
     */
    public static Boolean isEquals(String s1, String s2) {

        if (s1 != null && s2 != null) {
            if (s1.equals(s2)) {
                return true;
            }
            return false;
        } else {
            if (s1 == null && s2 == null) {
                return true;
            }
            return false;
        }
    }

    /**
     * 转成String
     *
     * @param obj
     * @return
     */
    public static String toString(Object obj) {
        return "" + obj;
    }

    /**
     * @param obj 可变数组
     * @return 依次叠加
     */
    public static String addString(Object... obj) {

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < obj.length; i++) {
            stringBuffer.append(obj[i]);
        }
        return stringBuffer.toString();
    }


}
