package com.tracker.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {

	public static Date formatDate(String inputDate) {
		 Date formattedDate = null;
		try {
			formattedDate = new SimpleDateFormat("dd/MM/yyyy").parse(inputDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		 return formattedDate;
	}
	
}
