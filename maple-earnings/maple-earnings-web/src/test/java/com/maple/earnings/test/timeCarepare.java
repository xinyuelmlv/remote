package com.maple.earnings.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class timeCarepare {
	public static void main(String[] args) {
		// int i= compare_date("1995-11-1 15:21", "1995-11-10 15:22");
	   //    System.out.println("i=="+i);
		  Date dNow = new Date();
		  Date dAfter = new Date();
		  Calendar calendar = Calendar.getInstance(); //得到日历
		  calendar.setTime(dNow);//把当前时间赋给日历
		  calendar.add(Calendar.DAY_OF_MONTH, 3);  //设置为3天后
		  dAfter = calendar.getTime(); 
		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		  System.out.println(df.format(dNow.getTime()));
	}
	 public static int compare_date(String DATE1, String DATE2) {
	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
	        try {
	            Date dt1 = df.parse(DATE1);
	            Date dt2 = df.parse(DATE2); 
	            if (dt1.getTime() > dt2.getTime()) {
	                System.out.println("dt1 在dt2前");
	                return 1;
	            } else if (dt1.getTime() < dt2.getTime()) {
	                System.out.println("dt1在dt2后");
	                return -1;
	            } else {
	                return 0;
	            }
	        } catch (Exception exception) {
	            exception.printStackTrace();
	        }
	        return 0;
	    }
}
