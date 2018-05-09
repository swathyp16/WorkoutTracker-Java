package com.tracker.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tracker.Exception.BusinessException;
import com.tracker.constants.CommonConstants;

/**
 * The Class CommonUtil.
 */
public class CommonUtil {

	/**
	 * Format date.
	 *
	 * @param inputDate the input date
	 * @return the date
	 * @throws BusinessException the business exception
	 */
	public static Date formatDate(String inputDate) throws BusinessException {
		 Date formattedDate = null;
		try {
			formattedDate = new SimpleDateFormat("dd/MM/yyyy").parse(inputDate);
			if(new Date().before(formattedDate)) {
			 throw new BusinessException(CommonConstants.FUTURE_DATE);
			}
		} catch (ParseException e) {
			throw new BusinessException(CommonConstants.INVALID_DATE_FORMAT);
		}
		 return formattedDate;
	}
	
	/**
	 * Format current date to string.
	 *
	 * @param currentDate the current date
	 * @return the string
	 * @throws BusinessException the business exception
	 */
	public static String formatCurrentDateToString(Date currentDate) throws BusinessException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = simpleDateFormat.format(currentDate);
		 return formattedDate;
	}
	
	/**
	 * Format date to string.
	 *
	 * @param inputDate the input date
	 * @return the string
	 * @throws BusinessException the business exception
	 */
	public static String formatDateToString(Date inputDate) throws BusinessException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = simpleDateFormat.format(inputDate);
		return formattedDate;
	}
	
	
	/**
	 * Format date for UI.
	 *
	 * @param inputDate the input date
	 * @return the string
	 * @throws BusinessException the business exception
	 */
	public static String formatDateForUI(Date inputDate) throws BusinessException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
		Date initDate;
		try {
			initDate = simpleDateFormat.parse(inputDate.toString());
		} catch (ParseException e) {
			throw new BusinessException(e.toString());
		}
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
	    String parsedDate = formatter.format(initDate);
	    return parsedDate; 
	}
}
