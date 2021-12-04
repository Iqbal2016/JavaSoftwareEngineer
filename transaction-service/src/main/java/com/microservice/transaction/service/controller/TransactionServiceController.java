/**
 * 
 */
package com.microservice.transaction.service.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.transaction.service.bean.WSResponse;
import com.microservice.transaction.service.entity.Transaction;
import com.microservice.transaction.service.service.TransactionService;

/**
 * @author MI
 *
 */

@RestController
@RequestMapping("/")
public class TransactionServiceController {

	protected Logger logger = Logger.getLogger(TransactionServiceController.class.getName());

	@Autowired
	TransactionService transactionService;

	@ResponseBody
	@GetMapping(value = "/transaction-service/testing", produces = "text/plain")
	public String index() {
		System.out.println("request accept..............");
		logger.info("request accept..............");
		return "Application is running...";

	}

	@PostMapping(value = "/transaction-service/transaction")
	//@ResponseStatus(code = HttpStatus.BAD_GATEWAY)
	public WSResponse showRegistrationForm(@RequestBody Transaction transaction, BindingResult result, HttpServletResponse response)
			throws Exception {
		logger.info("request accept for insert data.........0.....");
		// return transactionService.performTransaction(transaction);

		/*
		 * if (result.hasErrors()) {
		 * logger.info("request accept for insert data........1......"); throw new
		 * Exception("The password provided is too short" + HttpStatus.BAD_REQUEST); }
		 * else { logger.info("request accept for insert data........2......");
		 * transaction = transactionService.performTransaction(transaction); new
		 * ResponseEntity<Transaction>(transaction, HttpStatus.OK); }
		 */
		
		WSResponse data = transactionService.performTransaction(transaction);
		if (data.getOutcome()=="error") {
			 response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}	
		return data;

	}

}
