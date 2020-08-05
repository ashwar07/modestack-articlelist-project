package com.example.articleproject.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateService {
	
    public String currentDateString() {

    	String dateString = "";
    	SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	   
 	   try
 	   {
 		   Date date1 = new Date(); 
 		   dateString=f.format(date1);
 	   }
 	   catch (Exception e)
 	   {
 			e.printStackTrace();
 	   }	

        return dateString;
    }
    public Boolean dateDiffrence(String existingDate,String currentdate) {

    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	    try {
			Date firstDate = sdf.parse(existingDate);
			Date secondDate = sdf.parse(currentdate);
			long diff = secondDate.getTime() - firstDate.getTime();
			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);
			
			int seconds = (int)diffSeconds;
			int minutes = (int)diffMinutes;
			int hours = (int)diffHours;
			int days = (int)diffDays;
			
			int minuteLimit =  0;
			int secondsLimmit = 59;
			int hoursLimit = 0;
			int daysLimit = 0; 
		
			if(minutes > minuteLimit || hours > hoursLimit|| days > daysLimit|| seconds > secondsLimmit)
			{
					return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	 
    	return false;
    }

}
