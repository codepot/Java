package com.ple.finalProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Helper {
	private static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
	private static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	
	public static String getCalendarText(Calendar calendar){
		return formatter.format(calendar.getTime());
	}
	
	public static String getHeader(){
			
			String output = String.format("%-3s", "ID");
			output += String.format("%-8s", "TYPE");
			output += String.format("%-8s", "MAKE");
			output += String.format("%-15s", "MODEL");
			output += String.format("%-8s", "  YEAR");
			output += String.format("%-10s", "START");
			output += String.format("%-10s", "  SOLD");
			output += String.format("%12s", "COST  ");
			output += String.format("%12s", "PRICE  ");
			output += String.format("%-10s", "  OTHER");		
			
			return output;
		
	}
	
	public static Calendar initCalendar(String date) {
		Date dateObj;
		Calendar calendar = Calendar.getInstance();
		try {
			dateObj = sdf.parse(date);
			calendar.setTime(dateObj);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return calendar;
	}
}
