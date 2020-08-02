package com.example.articleproject.service;

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


}
