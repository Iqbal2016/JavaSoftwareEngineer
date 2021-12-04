/**
 * 
 */
package com.spring.boot.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.entity.Transaction;
import com.spring.boot.service.TransactionService;

/**
 * @author MI
 *
 */
@Controller
@RequestMapping("/")
public class HomeController {
	protected Logger logger = Logger.getLogger(HomeController.class.getName());

	@Autowired
	TransactionService transactionService;

	@ResponseBody
	@RequestMapping(value = "/index", produces = "text/plain")
	public String index() {
		logger.info("Application is running...");
		return "Application is running...";
	}

	@RequestMapping(value = "/dotransaction", method = RequestMethod.POST)
	public Transaction doTransaction(@RequestBody Transaction transaction) {
		logger.info("Transaction start from controller..");
		return transactionService.performTransaction(transaction);
	}

}
