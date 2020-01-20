package com.eats.utilities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Utilities{

	/**
	 * 
	 * @param duration of days/hours
	 * @return date after subtract according to days/hours
	 */
	public static Date getDateByLastHrOrDtOr(Duration duration) {
		return convertDateToMySQLTIMESTAMP(LocalDateTime.now().minus(duration));
	}

	/**
	 * 
	 * @return timestamp
	 */
	public static Date todaysDate() {
		return convertDateToMySQLTIMESTAMP(LocalDateTime.now());
	}

	/**
	 * 
	 * @param localDateTime
	 * @return converted date
	 */
	public static Date convertDateToMySQLTIMESTAMP(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

}