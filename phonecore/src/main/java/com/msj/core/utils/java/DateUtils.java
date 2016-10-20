package com.msj.core.utils.java;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author Vincent.M
 * @date 16/9/13 下午3:31
 * @copyright ©2016 孟祥程 All Rights Reserved
 * @desc Data工具类
 */
public class DateUtils {

	private final static ThreadLocal<SimpleDateFormat> dateFormater = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};

	private final static ThreadLocal<SimpleDateFormat> dateFormater2 = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		}
	};

	/**
	 * 将字符串转位日期类型
	 * @param sdate yyyy-MM-dd HH:mm:ss格式的字符串
	 * @return 转换后的Date对象
	 */
	public static Date toDate(String sdate) {
		try {
			return dateFormater.get().parse(sdate);
		} catch (ParseException e) {
			return null;
		}
	}


	/**
	 * 通过long类型时间返回自定义format格式字符串
	 * @param time 需要转换的时间
	 * @param format 转换的样式
	 * @return 转换后的字符串
	 */
	public static String timeToString(long time, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(time);//添加的时间操作的时间
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * 将long转换成yyyy年MM月dd日形式字符串
	 * @param time 需要转换的时间
	 * @return 转换后的字符串
     */
	public static String timeToString(long time) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			return sdf.format(new Date(time));//添加的时间操作的时间
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * 通过Date类型时间返回自定义format格式字符串
	 * @param date 需要转换的时间
	 * @param format 转换的样式
	 * @return 转换后的字符串
	 */
	public static String dateToString(Date date, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);//添加的时间操作的时间
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * 判断参数是否为合法日期
	 * @param str 日期字符串，格式为 yyyy-MM-dd
	 * @return 返回boolean true表示日期合法，false表示日期不合法
	 */
	public static boolean checkDate(String str) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			formatter.parse(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 根据日期格式，判断参数是否为合法日期
	 * @param str 日期字符串
	 * @param format 日期格式
	 * @return 返回boolean true表示日期合法，false表示日期不合法
	 */
	public static boolean checkDate(String str, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		try {
			formatter.parse(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	/**
	 * 取得格式为yyyy-MM-dd HH:mm:ss 的系统日期
	 * 
	 * @return String 返回的日期
	 */
	public static String getDate() {
		Date date = new Date(); // 当前日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String senddate = sdf.format(date);
		return senddate;
	}

	/**
	 * 取得指定格式的系统日期
	 * 
	 * @param format
	 *            日期格式，如 "yyyy-MM-dd HH:mm"
	 * @return String 返回的日期
	 * 
	 */
	public static String getDate(String format) {
		Date date = new Date(); // 当前日期
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String senddate = sdf.format(date);
		return senddate;
	}

	/**
	 * 将字符串转换为Date类型，字符串默认格式为yyyy-MM-dd
	 * 
	 * @param str
	 *            yyyy-MM-dd格式日期字符串
	 * @return 返回的日期
	 */
	public static Date stringToDate(String str) {
		Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = formatter.parse(str);
			return date;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 将字符串转换为Date类型，字符串默认格式为HH：mm：ss
	 * 
	 * @param str
	 *            HH:mm:ss日期字符串
	 * @return 返回的日期
	 */
	public static Date stringToHour(String str) {
		Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		try {
			date = formatter.parse(str);
			return date;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 将字符串转换为Date类型
	 * 
	 * @param str
	 *            日期字符串
	 * @param format
	 *            日期格式
	 * @return 返回的日期
	 */
	public static Date stringToDate(String str, String format) {
		Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		try {
			date = formatter.parse(str);
			return date;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 将字符串转换为Date类型
	 * 
	 * @param str
	 *            日期字符串
	 * @param format
	 *            日期格式
	 * @param locale
	 * 			  地区
	 * @return 返回的日期
	 */
	public static Date stringToDate(String str, String format, Locale locale) {
		Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat(format, locale);
		try {
			date = formatter.parse(str);
			return date;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 计算两个日期相差的小时数
	 *
	 * @param strDate1
	 *            开始日期
	 * @param strDate2
	 *            结束日期
	 * @return 返回两个日期相差的小时数
	 */
	public static float discrepancyByHour(String strDate1, String strDate2) {
		Date d1 = stringToHour(strDate1);
		Date d2 = stringToHour(strDate2);
		if (d1 == null || d2 == null) {
			return 0;
		}
		long l1 = d1.getTime();
		long l2 = d2.getTime();
		double difference = (l2 - l1) / (1000.0 * 60.0 * 60.0);
		float discrepancy = Float.parseFloat(String.valueOf(difference));
		return discrepancy;
	}

	/**
	 * 计算两个日期相差的天数
	 * 
	 * @param strDate1
	 *            开始日期
	 * @param strDate2
	 *            结束日期
	 * @return 返回两个日期相差的天数
	 */
	public static int discrepancyByDay(String strDate1, String strDate2) {
		Date d1 = stringToDate(strDate1);
		Date d2 = stringToDate(strDate2);
		if (d1 == null || d2 == null) {
			return 0;
		}
		long l1 = d1.getTime();
		long l2 = d2.getTime();
		long difference = (l2 - l1) / (1000 * 60 * 60 * 24);
		int discrepancy = Integer.parseInt(String.valueOf(difference));
		return discrepancy + 1;
	}

	/**
	 * 计算两个日期相差的分钟数
	 * 
	 * @param strDate1
	 *            开始日期
	 * @param strDate2
	 *            结束日期
	 * @return 返回两个日期相差的分钟数
	 */
	public static int discrepancyByMM(String strDate1, String strDate2) {
		Date d1 = stringToDate(strDate1);
		Date d2 = stringToDate(strDate2);
		if (d1 == null || d2 == null) {
			return 0;
		}
		long l1 = d1.getTime();
		long l2 = d2.getTime();
		long difference = (l2 - l1) / (1000 * 60);
		int discrepancy = Integer.parseInt(String.valueOf(difference));
		return discrepancy + 1;
	}

	/**
	 * 计算两个日期相差的毫秒
	 * 
	 * @param strDate1
	 *            开始日期
	 * @param strDate2
	 *            结束日期
	 * @return 返回两个日期相差的毫秒
	 */
	public static long disMillisec(String strDate1, String strDate2) {
		Date d1 = stringToDate(strDate1, "yyyy-MM-dd HH:mm:ss");
		Date d2 = stringToDate(strDate2, "yyyy-MM-dd HH:mm:ss");
		if (d1 == null || d2 == null) {
			return 0;
		}
		return (d1.getTime() - d2.getTime());
	}

	/**
	 * 比较两个日期大小，日期格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @param strDate1 比较1日期
	 * @param strDate2 比较2日期
	 * @return 如果strDate2大于strDate1返回大于0的值，strDate2等于strDate1返回值0,
	 *         strDate2小于strDate1返回小于0的值
	 */
	public static int compareDate(String strDate1, String strDate2) {
		int value = 0;
		Date d1 = stringToDate(strDate1, "yyyy-MM-dd HH:mm:ss");
		Date d2 = stringToDate(strDate2, "yyyy-MM-dd HH:mm:ss");
		if (d1 == null || d2 == null) {
			return value;
		}
		value = d2.compareTo(d1);
		return value;
	}

	/**
	 * 根据日期取得星期
	 * 
	 * @param strDate
	 *            yyyy-MM-dd形式的日期字符串
	 * @return 返回星期
	 */
	public static int getWeek(String strDate) {
		Date date = stringToDate(strDate);
		Calendar calendar = new GregorianCalendar();
		calendar.setTimeInMillis(date.getTime());
		int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		return week;
	}

	public static String getWeekString(String strDate) {
		String ret = "星期";
		int value = getWeek(strDate);
		switch (value) {
		case 1:
			ret += "一";
			break;
		case 2:
			ret += "二";
			break;
		case 3:
			ret += "三";
			break;
		case 4:
			ret += "四";
			break;
		case 5:
			ret += "五";
			break;
		case 6:
			ret += "六";
			break;
		case 0:
			ret += "日";
			break;
		}
		return ret;
	}

	/**
	 * 根据指定日期的月份的最大日期
	 * 
	 * @param strDate
	 *            yyyy-MM形式的日期字符串
	 * @return 返回星期
	 */
	public static int getMonthMaxDay(String strDate) {
		Date date = stringToDate(strDate, "yyyy-MM");
		Calendar calendar = new GregorianCalendar();
		calendar.setTimeInMillis(date.getTime());
		int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		return maxDay;
	}

	/**
	 * 根据指定日期的月份所有日期
	 * 
	 * @param strDate
	 *             yyyy-MM-dd形式的日期字符串
	 * @return 返回星期
	 */
	public static String[] getMonths(String strDate) {
		Date date = stringToDate(strDate);
		Calendar calendar = new GregorianCalendar();
		calendar.setTimeInMillis(date.getTime());
		int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		String[] monthInfo = new String[maxDay];
		for (int i = 1; i <= maxDay; i++) {
			java.text.Format formatter3 = new SimpleDateFormat(
					"yyyy-MM-" + (i <= 9 ? "0" + i : i + ""));
			monthInfo[i - 1] = formatter3.format(calendar.getTime());
		}
		return monthInfo;
	}

	/**
	 * 取得当前日期的前后N年的日期
	 * 
	 * @param number 前后几年，负数表示前
	 * @param format
	 *            日期格式
	 * @return 返回日期字符串
	 */
	public static String getBehindYear(int number, String format) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, number);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(c.getTime());
	}

	/**
	 * 取得指定日期的前后N年的日期
	 * @param time 指定时间
	 * @param number 前后几月，负数表示前
	 * @param format 返回日期格式
	 * @return 返回日期字符串
	 */
	public static String getBehindYear(long time, int number, String format) {
		Date dates = new Date(time);
		Calendar c = Calendar.getInstance();
		c.setTime(dates);
		c.add(Calendar.YEAR, number);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(c.getTime());
	}


	/**
	 * 取得当前日期的后N月的日期
	 *
	 * @param number 前后几月，负数表示前
	 * @param format
	 *            返回日期格式
	 * @return 返回日期字符串
	 */
	public static String getBehindMonth(int number, String format) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, number);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(c.getTime());
	}

	/**
	 * 取得指定日期的前后N月的日期
	 * @param time 指定时间
	 * @param number 前后几月，负数表示前
	 * @param format 返回日期格式
	 * @return 返回日期字符串
	 */
	public static String getBehindMonth(long time, int number, String format) {
		Date dates = new Date(time);
		Calendar c = Calendar.getInstance();
		c.setTime(dates);
		c.add(Calendar.MONTH, number);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(c.getTime());
	}

	/**
	 * 取得当前日期的后N天的日期
	 *
	 * @param number 前后几天天数，负数表示前几天
	 *
	 * @return 返回yyyy-MM-dd HH:mm:ss形式字符串
	 */
	public static String getBehindDay(int number) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, number);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(c.getTime());
	}

	/**
	 * 取得当前日期的后N天的日期
	 *
	 * @param number 前后几天天数，负数表示前几天
	 * @param format
	 *            返回字符串日期格式
	 * @return 返回日期字符串
	 */
	public static String getBehindDay(int number, String format) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, number);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(c.getTime());
	}

	/**
	 * 取得指定日期的前后N天的日期
	 *
	 * @param time 指定日期
	 * @param number 前后几天天数，负数表示前几天
	 * @param format
	 *            返回日期的格式
	 * @return 返回日期字符串
	 */
	public static String getBehindDay(long time,int number, String format) {
		Date dates = new Date(time);
		Calendar c = Calendar.getInstance();
		c.setTime(dates);
//		Calendar c = new GregorianCalendar(dates.getYear(), dates.getMonth(), dates.getDay());
//		Calendar c = new GregorianCalendar(dates.get, dates.getMonth(),
//				dates.getDay(), dates.getHours(), dates.getMinutes(),
//				dates.getSeconds());
		c.add(Calendar.DAY_OF_MONTH, number);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(c.getTime());
	}


	/**
	 * 取得系统前某小时的日期
	 *
	 * @param number  可以负数，负数表示前几天
	 * @param format
	 *            日期格式
	 * @return
	 */
	public static String getBehindHours(int number, String format) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.HOUR, number);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(c.getTime());
	}

	/**
	 * 取得指定日期的前后N小时的日期
	 * @param time 指定时间
	 * @param number 前后几小时，负数表示前
	 * @param format 返回日期格式
	 * @return 返回日期字符串
	 */
	public static String getBehindHours(long time, int number, String format) {
		Date dates = new Date(time);
		Calendar c = Calendar.getInstance();
		c.setTime(dates);
		c.add(Calendar.HOUR, number);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(c.getTime());
	}

	/**
	 * 24小时制取得指定日期的前N小时或后N小时的日期
	 *
	 * @param number 可以负数，负数表示前几天
	 * @param format 返回日期格式
	 * @return 返回的字符串
	 */
	public static String getBehindHour(int number, String format) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.HOUR_OF_DAY, number);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(c.getTime());
	}

	/**
	 * 24小时制取得指定日期的前后N小时的日期
	 * @param time 指定时间
	 * @param number 前后几小时，负数表示前
	 * @param format 返回日期格式
	 * @return 返回日期字符串
	 */
	public static String getBehindHour(long time, int number, String format) {
		Date dates = new Date(time);
		Calendar c = Calendar.getInstance();
		c.setTime(dates);
		c.add(Calendar.HOUR, number);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(c.getTime());
	}

	/**
	 * 取得系统前后几分的日期
	 *
	 * @param number  可以负数，负数表示前几分
	 * @param format
	 *            日期格式
	 * @return
	 */
	public static String getBehindMinute(int number, String format) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MINUTE, number);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(c.getTime());
	}

	/**
	 * 取得指定日期的前后N小时的日期
	 * @param time 指定时间
	 * @param number 前后几小时，负数表示前几分
	 * @param format 返回日期格式
	 * @return 返回日期字符串
	 */
	public static String getBehindMinute(long time, int number, String format) {
		Date dates = new Date(time);
		Calendar c = Calendar.getInstance();
		c.setTime(dates);
		c.add(Calendar.MINUTE, number);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(c.getTime());
	}

	/**
	 * 取得指定日期的前N分或后N分的日期
	 *
	 * @param number
	 *            可以负数，负数表示前几分
	 * @return 返回yyyy-MM-dd HH:mm:ss样式的字符串
	 */
	public static String getBehindMinute(int number) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MINUTE, number);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(c.getTime());
	}

	/**
	 * 取得指定日期的前N分或后N分的日期
	 *
	 * @param strDate HH:mm:ss格式的日期字符串
	 * @param number
	 *             可以负数，负数表示前几分
	 * @return 返回HH:mm:ss样式的字符串
	 */
	public static String getBehindMinuteByHour(String strDate, int number) {
		Date date = stringToDate(strDate, "HH:mm:ss");
		Calendar c = new GregorianCalendar();
		c.setTimeInMillis(date.getTime());
		c.add(Calendar.MINUTE, number);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(c.getTime());
	}

	/**
	 * 取得指定日期的前N分或后N分的日期
	 *
	 * @param strDate yyyy-MM-dd HH:mm:ss格式的日期字符串
	 * @param number
	 *             可以负数，负数表示前几分
	 * @return 返回yyyy-MM-dd HH:mm:ss格式的字符串
	 */
	public static String getBehindMinute(String strDate, int number) {
		Date date = stringToDate(strDate, "yyyy-MM-dd HH:mm:ss");
		Calendar c = new GregorianCalendar();
		c.setTimeInMillis(date.getTime());
		c.add(Calendar.MINUTE, number);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(c.getTime());
	}



	/**
	 * 根据用户的生日,计算用户的年龄
	 * 
	 * @param birthDay 生日日期
	 * @return 用户年龄
	 */
	public static int getUserAge(Date birthDay) {
		Calendar cal = Calendar.getInstance();

		if (cal.before(birthDay)) {
			return 0;
		}
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH);
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		if (null == birthDay) {
			return 0;
		} else {
			cal.setTime(birthDay);

			int yearBirth = cal.get(Calendar.YEAR);
			int monthBirth = cal.get(Calendar.MONTH);
			int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

			int age = yearNow - yearBirth;

			if (monthNow <= monthBirth) {
				if (monthNow == monthBirth) {
					// monthNow==monthBirth
					if (dayOfMonthNow < dayOfMonthBirth) {
						age--;
					} else {
						// do nothing
					}
				} else {
					// monthNow>monthBirth
					age--;
				}
			} else {
				// monthNow<monthBirth
				// donothing
			}
			return age;
		}
	}

	/**
	 * 获取系统时间时间值
	 * @return
	 */
	public static String getTime() {
		Date date = new Date(); // 当前日期
		long time1 = date.getTime() / 1000;
		return String.valueOf(time1);
	}


	/**
	 * 以友好的方式显示时间
	 * @param date 日期
	 * @return 返回几分钟前，几小时前，前天，昨天等形式日期
	 */
	public static String friendly_time(Date date) {
		if (date == null) {
			return "Unknown";
		}
		String ftime = "";
		Calendar cal = Calendar.getInstance();
		// 判断是否是同一天
		String curDate = dateFormater2.get().format(cal.getTime());
		String paramDate = dateFormater2.get().format(date);
		if (curDate.equals(paramDate)) {
			int hour = (int) ((cal.getTimeInMillis() - date.getTime()) / 3600000);
			if (hour == 0)
				ftime = Math.max(
						(cal.getTimeInMillis() - date.getTime()) / 60000, 1)
						+ "分钟前";
			else
				ftime = hour + "小时前";
			return ftime;
		}

		long lt = date.getTime() / 86400000;
		long ct = cal.getTimeInMillis() / 86400000;
		int days = (int) (ct - lt);
		if (days == 0) {
			int hour = (int) ((cal.getTimeInMillis() - date.getTime()) / 3600000);
			if (hour == 0)
				ftime = Math.max(
						(cal.getTimeInMillis() - date.getTime()) / 60000, 1)
						+ "分钟前";
			else
				ftime = hour + "小时前";
		} else if (days == 1) {
			ftime = "昨天";
		} else if (days == 2) {
			ftime = "前天";
		} else if (days > 2 && days <= 10) {
			ftime = days + "天前";
		} else if (days > 10) {
			ftime = dateFormater2.get().format(date);
		}
		return ftime;
	}



	/**
	 * 判断给定字符串时间是否为今日
	 *
	 * @param sdate
	 * @return boolean
	 */
	public static boolean isToday(String sdate) {
		boolean b = false;
		Date time = toDate(sdate);
		Date today = new Date();
		if (time != null) {
			String nowDate = dateFormater2.get().format(today);
			String timeDate = dateFormater2.get().format(time);
			if (nowDate.equals(timeDate)) {
				b = true;
			}
		}
		return b;
	}


	/**
	 * 判断给定字符串时间是否为今日
	 *
	 * @param date yyyy-MM-dd格式的字符串
	 * @return boolean true是同一天，false不是同一天
	 */	public static boolean isToday(long date){
		boolean b = false;
		Date time = new Date(date);
		Date today = new Date();
		if (time != null) {
			String nowDate = dateFormater2.get().format(today);
			String timeDate = dateFormater2.get().format(time);
			if (nowDate.equals(timeDate)) {
				b = true;
			}
		}
		return b;
	}

	/**
	 * 判断两个给定的时间是否是同一天
	 * @param date1 日期1
	 * @param date2 日期2
	 * @return true是同一天，false是不同一天
	 */
	public static boolean isSameDay(long date1,long date2){
		boolean b = false;
		Date day1 = new Date(date1);
		Date day2 = new Date(date2);
		String sdate1 = dateFormater2.get().format(day1);
		String sdate2 = dateFormater2.get().format(day2);
		if(sdate1.equals(sdate2)){
			b = true;
		}
		return b;
	}


	/**
	 * 比较两个date类型的数据的大小
	 * @param date1 日期1
	 * @param date2 日期2
     * @return
     */
	public static int compare_Date(Date date1, Date date2) {

		if (date1.getTime() > date2.getTime()) {
			return 1;
		} else if (date1.getTime() < date2.getTime()) {
			return -1;
		} else {
			return 0;
		}

	}

	/**
	 * 返回两个时间相差时间 样式*天*小时*分钟
	 * @param time1 时间1
	 * @param time2 时间2
	 * @return 返回样式*天*小时*分钟
	 */
	public static String dissTime(long time1,long time2){
		long diff = Math.abs(time1-time2);
		long ONE_MINUTE = 1000*60;
		long ONE_HOUR = ONE_MINUTE*60;
		long ONE_DAY = ONE_HOUR*24;

		int day =  new BigDecimal(diff).divide(new BigDecimal(ONE_DAY),0,BigDecimal.ROUND_DOWN).intValue();
		int hour = new BigDecimal (diff - day*(ONE_DAY)).divide(new BigDecimal(ONE_HOUR),0,BigDecimal.ROUND_DOWN).intValue();
		int minute = new BigDecimal((diff - day*ONE_DAY-hour*ONE_HOUR)).divide(new BigDecimal(ONE_MINUTE), 0, BigDecimal.ROUND_DOWN).intValue();
		String time = "";
		if(day >0){
			time  += ""+day+"天";
		}
		if(hour >0){
			time += ""+hour+"小时";
		}
		if(minute >0){
			time += ""+minute+"分";
		}
		return time;
	}

	/**
	 * 根据时区返回时间
	 * @param timeZoneId 时区id
	 * @return
	 */
	public static Date getTimeByTimeZone(String timeZoneId){
		return Calendar.getInstance(TimeZone.getTimeZone(timeZoneId)).getTime();
	}

}
