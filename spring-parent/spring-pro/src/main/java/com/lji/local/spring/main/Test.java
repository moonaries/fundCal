package com.lji.local.spring.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Test {
	
	public static void main(String[] args) {
		SimpleDateFormat fm = new SimpleDateFormat("MMM d yyyy hh:mma", Locale.US);
	    fm.setTimeZone(TimeZone.getTimeZone("GMT+8"));
	    Date date = new Date();
	    System.out.println(date);
	    System.out.println(fm.format(date));
	}

}
