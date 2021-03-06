package com.regex.admin.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * 〈一句话功能简述〉<br> 
 * Date 转化为 Quartz cron 表达式
 *
 * @author ocean
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CronDateUtils {
    private static final String CRON_DATE_FORMAT = "ss mm HH dd MM ? yyyy";  
    
    /*** 
     * 
     * @param date 时间 
     * @return  cron类型的日期 
     */  
    public static String getCron(final Date  date){  
        SimpleDateFormat sdf = new SimpleDateFormat(CRON_DATE_FORMAT);  
        String formatTimeStr = "";  
        if (date != null) {  
            formatTimeStr = sdf.format(date);  
        }  
        return formatTimeStr;  
    }  
  
    /*** 
     * 
     * @param cron Quartz cron的类型的日期 
     * @return  Date日期 
     */  
  
    public static Date getDate(final String cron) {  
  
  
        if(cron == null) {  
            return null;  
        }  
  
        SimpleDateFormat sdf = new SimpleDateFormat(CRON_DATE_FORMAT);  
        Date date = null;  
        try {  
            date = sdf.parse(cron);  
        } catch (ParseException e) {  
            return null;// 此处缺少异常处理,自己根据需要添加  
        }  
        return date;  
    }  
    public static void main(String[] args) {
        Date now = new Date();  
        System.out.println(CronDateUtils.getCron(now));  
  
        String cron = "20 28 17 02 08 ? 2016";  
  
        Date cronDate = CronDateUtils.getDate(cron);  
        System.out.println("===================");  
        System.out.println(cronDate.toString());  
    }
}

