/**
 * 
 */
package com.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.bean.Utility;
import com.spring.boot.entity.Transaction;
import com.spring.boot.service.TransactionService;

/**
 * @author MI
 *
 */
@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	TransactionService transactionService;

	@ResponseBody
	@RequestMapping(value="/home", produces="text/plain")
	public String showRegistrationForm( ) {
		String s = "TRANSFER";
		System.out.println(".Encode...."+Utility.base64Encode(s));
		String encodedBytes = Utility.base64Encode(s);
		
		Utility.base64Decode(encodedBytes);
		System.out.println(".DEncode...."+Utility.base64Decode(encodedBytes));
		
		return "Application is running...";
	}

	

	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public Transaction showRegistrationForm(@RequestBody Transaction transaction) {
		/*
		 * Transaction userEmailExists =
		 * transactionService.findUserByEmail(user.getEmail()); if (userEmailExists !=
		 * null) { bindingResult.rejectValue("email", "error.user",
		 * "There is already a user registered with the email provided"); }
		 */

		/*
		 * if (bindingResult.hasErrors()) { modelAndView.setViewName("registration"); }
		 * else { userService.saveUser(user); modelAndView.addObject("successMessage",
		 * "User has been registered successfully"); modelAndView.addObject("user", new
		 * User()); modelAndView.setViewName("registration");
		 * 
		 * }
		 */
		System.out.println(".....value...."+transaction.getRequestId());
		System.out.println(".....value...."+transaction.toString());
		
		return transactionService.performTransaction(transaction);
	}
	
	
}
