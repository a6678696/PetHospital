package com.ledao.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author LeDao
 * @company
 * @create 2020-01-19 23:58
 */
public class DateUtil {

    /**
     * 获取当年年月日字符串
     *
     * @return
     * @throws Exception
     */
    public static String getCurrentDateStr() throws Exception {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.format(date);
    }
}
