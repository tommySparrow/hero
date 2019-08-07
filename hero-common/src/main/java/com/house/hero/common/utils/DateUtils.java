package com.house.hero.common.utils;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author User
 */
public class DateUtils {

    /**
     * 计算距离现在日期天数的日期
     *
     * @param nowTime
     * @return
     */
    public static String timeFromNow(String nowTime) {

        // 时间表示格式可以改变，yyyyMMdd需要写例如20160523这种形式的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 将字符串的日期转为Date类型，ParsePosition(0)表示从第一个字符开始解析
        Date date = sdf.parse(nowTime, new ParsePosition(0));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // add方法中的第二个参数n中，正数表示该日期后n天，负数表示该日期的前n天
        calendar.add(Calendar.DATE, 6);
        Date desTime = calendar.getTime();

        return sdf.format(desTime);
    }

    /**
     * 计算两个日期之间隔了几天
     *
     * @param startTime
     * @param endTime
     * @return
     * @throws ParseException
     */
    public static long getDaysSpace(String startTime, String endTime) throws ParseException {

        //算两个日期间隔多少天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date start = format.parse(startTime);
        Date end = format.parse(endTime);

        return (int) ((end.getTime() - start.getTime()) / (1000*3600*24));
    }

    public static void main(String[] args) throws ParseException {
        String timeFromNow = timeFromNow("2019-07-26");
        System.out.println(timeFromNow);
        System.out.println("=================================");
        long space = getDaysSpace("2019-8-7", "2019-8-10");
        System.out.println(space);
    }
}
