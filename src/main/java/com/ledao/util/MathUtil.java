package com.ledao.util;

/**
 * 数学工具类
 *
 * @author LeDao
 * @company
 * @create 2020-01-19 23:57
 */
public class MathUtil {

    /**
     * 格式化数字  保留两位
     *
     * @param n
     * @return
     */
    public static float format2Bit(float n) {
        return (float) (Math.round(n * 100)) / 100;
    }
}
