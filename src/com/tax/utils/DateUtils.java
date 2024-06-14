package com.tax.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tax.exception.MyCustomeException;

public class DateUtils {
	private DateUtils() {

	}

	public static Date convertStringToDate(String inPutDate) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			date = sdf.parse(inPutDate);
		} catch (ParseException pe) {
			throw new MyCustomeException(
					"Exception occured in dateUtils Class" + inPutDate + "Exception is" + pe.getMessage());

		}
		return date;
	}

	public static String convertDateToString(Date date) {
		String outPutDate = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			outPutDate = sdf.format(date);
		} catch (Exception e) {

		}
		return outPutDate;
	}

}
