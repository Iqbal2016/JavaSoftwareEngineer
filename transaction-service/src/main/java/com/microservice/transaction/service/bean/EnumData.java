package com.microservice.transaction.service.bean;

/**
 * 
 */

import java.util.Map;
import java.util.TreeMap;

/**
 * @author MI
 *
 */
public class EnumData {

	public static Map<String, String> getAccountStatus() {
		Map<String, String> data = new TreeMap<String, String>();
		data.put("Active", "Active");
		data.put("Inactive", "Inactive");
		return data;
	}

	public static Map<String, String> getTransactionType() {
		Map<String, String> data = new TreeMap<String, String>();
		data.put("TRANSFER", "TRANSFER");
		data.put("REVERSE", "REVERSE");
		return data;
	}

}
