package com.zhangxf.dingcan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) throws Exception {
		/*int renewalsdata = 6;
		String validatetime =new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Date now = sdf.parse(validatetime);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		System.out.println(sdf.format(calendar.getTime()));
		calendar.add(Calendar.DAY_OF_MONTH, renewalsdata);
		System.out.println(sdf.format(calendar.getTime()));*/
		new TestDate().getFortureTime(6, "day");
		new TestDate().test();
	}
	public static Date getFortureTime(int i,String type) throws ParseException{
		String validatetime =new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Date now = sdf.parse(validatetime);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		if(type.equals("day")){
			calendar.add(Calendar.DAY_OF_MONTH, i);
		}
		if(type.equals("month")){
			calendar.add(Calendar.MONTH, i);
		}
		if(type.equals("year")){
			calendar.add(Calendar.YEAR, i);
		}
		return calendar.getTime();
	}
	public static void test(){
		double n=4.0;
		int a=(int) n;
		System.out.println(n);
		System.out.println(a);
	}
}
