package com.microservice.transaction.service.bean;

public class Validation {
	
  
	/*------------------empty----------------------*/
    
	public static boolean isStrEmpty(String str) {
		if (str == null || str.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	
}
