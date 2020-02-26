package com.vkeline.zlibrary.util;

/**
 * Created by Administrator on 2017/12/26.
 */
public class MathUtils {

    /**
     * 转换
     *
     * @param value
     * @return
     */
    public static int valueOf(String value) {

        int p = 0;
        try {
            p = Integer.valueOf(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }


    /**
     * 数据转换
     *
     * @param value
     * @return
     */
    public static Boolean toDoublevalueOf(String value) {

        Boolean flag = true;
        try {
            Double.valueOf(value);
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

}
