package com.adaming.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Datetest {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		/*SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss"); // personalisation du patern
		// attention pour le mois MM les minutes mm
		Date d =sdf.parse("11-11-1989 10:52:23");		// Date d = new Date(); Pour la date d'aujourdhui
		//System.out.println(sdf.format(d));
		System.out.println(d);
		// Pour comparer deux date on recupere les date qu'on converti en milliseconde
		long milliseconde= d.getTime();
		System.out.println(milliseconde);
		*/
		// Comparaison de date
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date d1 =sdf.parse("11-11-1989");	
		Date d2 =sdf.parse("11-11-1999");
		if (d1.compareTo(d2) == 0){
			System.out.println("egal");
		}else if (d1.compareTo(d2 )>0){
			System.out.println("d1>d2");
		}else if(d1.compareTo(d2)<0){
			System.out.println("d1>d2");
		}
 // Deuxieme methode
		Long d1milliseconde= d1.getTime();
		Long d2milliseconde= d2.getTime();
		Long dif= d1milliseconde-d2milliseconde;
		
		if (d1milliseconde==d2milliseconde){
			System.out.println("egal");
		}else if (d1milliseconde<d2milliseconde){
			System.out.println("d1>d2");
		}else if(d1milliseconde>d2milliseconde){
			System.out.println("d1>d2");
		}
		
		if (d1.equals(d2)){
			System.out.println("egal");
		}else if (d1.before(d2)){
			System.out.println("d1>d2");
		}else if(d1.after(d2)){
			System.out.println("d1>d2");
		}
		
		// Troisieme methode calendar
		Calendar c = new GregorianCalendar(2017, 2, 15);
		System.out.println(c.getDisplayName(field, style, locale));
		
	}

}
