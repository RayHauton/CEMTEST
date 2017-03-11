package com.cem.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang.time.DateUtils;



public class MessageInform {
	public String genereteFriendlyTime(Date date,Date nowTime){
		//精确到哪一个时间点
		long ys = DateUtils.truncate(nowTime, Calendar.YEAR).getTime();//当前时间精确到年
		long ds = DateUtils.truncate(nowTime, Calendar.DAY_OF_MONTH).getTime();//当前时间精确到日
		long yd = DateUtils.truncate(date, Calendar.DAY_OF_MONTH).getTime();//转换时间精确到日
		
		long n = nowTime.getTime();
		long e = date.getTime();
		if (e < ys) {//时间转换成y-m-d//去年的
			return new SimpleDateFormat("yyyy-MM-dd").format(date);
		}
		if ((ds - yd) == (24 * 60 * 60 * 1000)) {//24h内
			return new SimpleDateFormat("昨天  HH:mm").format(date);
		}
		if (e < ds) {//今天以前的信息
			return new SimpleDateFormat("yyyy-MM-dd").format(date);
		}
		if (n - e > 60 * 60 * 1000) {
			return new SimpleDateFormat("今天  HH:mm").format(date);
		}
		if (n - e > 60 * 1000) {
			//1d 是double 自动转换
			return (long) Math.floor((n - e) * 1d / 60000) + "分钟前";
		}
		if (n - e > 1 * 1000) {
			return "刚刚";
		}
		return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
	}
}
