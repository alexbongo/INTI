package com.adaming.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Datetest2 {
	public static void main(String[] args) {
		/*
		SimpleDateFormat sdf  = new SimpleDateFormat("dd/MM/yyyy");
		Date d1 = sdf.parse("01/01/2000");
		System.out.println(d1.getTime());
		

		/*compare two date
		SimpleDateFormat sdf  = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Date d1 = sdf.parse("01/01/2000 05:30:30");
		Date d2 = sdf.parse("01/01/2000 05:30:60");
		
		if(d1.compareTo(d2) == 0){
			System.out.println("égale");
		}
		else if(d1.compareTo(d2) > 0){
			System.out.println("d1 > d2");
		}
		else if(d1.compareTo(d2) < 0){
			System.out.println("d1 < d2");
		}
		long d1InM = d1.getTime();
		long d2InM = d2.getTime();
		
		if(d1InM == d2InM){
			System.out.println("égale");
		}
		else if(d1InM > d2InM){
			System.out.println("d1 > d2");
		}
		else if(d1InM < d2InM){
			System.out.println("d1 < d2");
		}
		
		
		if(d1.equals(d2)){
			System.out.println("égale");
		}
		else if(d1.before(d2)){
			System.out.println("d1 < d2");
		}
		else if(d1.after(d2)){
			System.out.println("d1 > d2");
		}
		
		*/
		
		
		
		/*
		* 
		* Object Calendar
		* 
		*
		**/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
		Calendar calendar = new GregorianCalendar();

		int year       = calendar.get(Calendar.YEAR);
		int month      = calendar.get(Calendar.MONTH); // Jan = 0, dec = 11
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek  = calendar.get(Calendar.DAY_OF_WEEK);
		int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
		int weekOfMonth= calendar.get(Calendar.WEEK_OF_MONTH);

		int hour       = calendar.get(Calendar.HOUR);        // 12 hour clock
		int hourOfDay  = calendar.get(Calendar.HOUR_OF_DAY); // 24 hour clock
		int minute     = calendar.get(Calendar.MINUTE);
		int second     = calendar.get(Calendar.SECOND);
		int millisecond= calendar.get(Calendar.MILLISECOND);

		System.out.println(sdf.format(calendar.getTime()));

		System.out.println("year \t\t: " + year);
		System.out.println("month \t\t: " + month);
		System.out.println("dayOfMonth \t: " + dayOfMonth);
		System.out.println("dayOfWeek \t: " + dayOfWeek);
		System.out.println("weekOfYear \t: " + weekOfYear);
		System.out.println("weekOfMonth \t: " + weekOfMonth);

		System.out.println("hour \t\t: " + hour);
		System.out.println("hourOfDay \t: " + hourOfDay);
		System.out.println("minute \t\t: " + minute);
		System.out.println("second \t\t: " + second);
		System.out.println("millisecond \t: " + millisecond);
		
		
		/*Set a date manually./
		* 
		*
         *
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
		
		Calendar calendar = new GregorianCalendar(2013,1,28,13,24,56);
		System.out.println("#1. " + sdf.format(calendar.getTime()));
		
		//update a date
		calendar.set(Calendar.YEAR, 2014);
		calendar.set(Calendar.MONTH, 11);
		calendar.set(Calendar.MINUTE, 33);
		
		System.out.println("#2. " + sdf.format(calendar.getTime()));*/
	}
}
