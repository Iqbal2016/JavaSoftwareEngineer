package com.spring.boot.bean;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Calendar;

public class Utility {


	/**
	 * @author This method is used to convert StringDate into java.util.date
	 */

	public static java.sql.Timestamp getCurrentTimeStamp() {
		// 1) create a java calendar instance
		Calendar calendar = Calendar.getInstance();

		// 2) get a java.util.Date from the calendar instance.
		// this date will represent the current instant, or "now".
		java.util.Date now = calendar.getTime();

		// 3) a java current time (now) instance
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		return currentTimestamp;
	}
	
	/**
	 * @author This method is used to convert String to base64Encode
	 */

	public static String base64Encode(String token) {
		String encoded = Base64.getEncoder().encodeToString(token.getBytes());
		return encoded;
	}
	
	/**
	 * @author This method is used to convert base64Encode to base64Decode
	 */


	public static String base64Decode(String encodedBytes) {
		byte[] barr = Base64.getDecoder().decode(encodedBytes);
		return new String(barr, Charset.forName("UTF-8"));
	}

}
