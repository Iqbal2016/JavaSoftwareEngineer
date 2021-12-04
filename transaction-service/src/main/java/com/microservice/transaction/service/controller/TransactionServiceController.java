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
import org.springframework.web.bind.annotation.RestController;

import com.microservice.transaction.service.bean.WSResponse;
import com.microservice.transaction.service.entity.Transaction;
import com.microservice.transaction.service.service.TransactionService;

/**
 * @author MI
 *
 */

@RestController
@RequestMapping("/transaction-service")
public class TransactionServiceController {

	protected Logger logger = Logger.getLogger(TransactionServiceController.class.getName());

	@Autowired
	TransactionService transactionService;

	@GetMapping(value = "/index", produces = "text/plain")
	public String index() {
		logger.info("Application is running..............");
		return "Application is running...";

	}

	@PostMapping(value = "/dotransaction")
	public WSResponse doTransaction(@RequestBody Transaction transaction, BindingResult result,
			HttpServletResponse response) throws Exception {
		logger.info("Transaction start from controller....");
		WSResponse data = transactionService.performTransaction(transaction);
		if (data.getOutcome() == "error") {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		return data;

	}

}
