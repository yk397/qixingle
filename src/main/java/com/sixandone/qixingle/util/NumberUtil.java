package com.sixandone.qixingle.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @ClassName yk
 * @Descprition:  订单编码生成器，生成32位数字编码
 * @生成规则: 1位单号类型+17位时间戳+14位（用户id加密&随机数）
 * @Autor DELL
 * @Date 2023/5/13 9:26
 **/
public class NumberUtil {

    //订单类别头
    private static final String ORDER_CODE = "OD";

    //随即编码
    private static final int[] r = new int[]{7, 9, 6, 2, 8, 1, 3, 0, 5, 4};

    //用户id和随机数长度
    private static final int maxLength =14;

    /**
     * 根据id进行编码+加固定长度编码
     * @param idStr
     * @return
     */
    private static String toCode(String idStr) {
        StringBuilder idsbs = new StringBuilder();
        for (int i = idStr.length() - 1; i >= 0; i--) {
            idsbs.append(r[idStr.charAt(i)-'0']);
        }
        return idsbs.append(getRandom(maxLength - idStr.length())).toString();
    }

    /**
     * 生成固定长度随机码
     * @param n 长度
     * @return rangeLong随机码
     */
    private static long getRandom(long n) {
        long min = 1, max = 9;
        for (int i = 1; i < n; i++) {
            min *= 10;
            max *= 10;
        }
        long rangeLong = ((long) (new Random().nextDouble() * (max - min))) + min;
        return rangeLong;
    }

    /**
     * 生成时间戳
     * @return
     */
    private static String getDateTime() {
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date());
    }

    /**
     * 生成不带类别头的编号
     * @param openid
     * @return
     */
    private static synchronized String getCode(String openid) {
        openid = openid == null? "10000" : openid;
        return getDateTime()+toCode(openid);
    }

    public static String getOrderCode(String openid) {
        return ORDER_CODE + getCode(openid);
    }

    public static String getReturnCode() {
        Long res = getRandom(4);
        return res.toString();
    }

}
