package com.weibo.loadtest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyTimeUtil {
	
	public static Long getSecLong(String date) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yyyy:hh:mm:ss",Locale.ENGLISH);
		Long sec = 1l;
		String result = "";
		try {
			sec = format.parse(date).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = sec.toString();
		result = result.substring(0, result.length()-3);
		return sec/1000;
	}
	
	public static String getDate(){
		SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yyyy:hh:mm:ss",Locale.ENGLISH);
		String str=format.format(new Date());  
		return str;
	}
	
	public static void main(String[] args) {
		System.out.println(getSecLong("15/Mar/2016:09:59:59"));
		
		System.out.println(getDate());
	}

}
