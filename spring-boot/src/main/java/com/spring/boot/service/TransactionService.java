/**
 * 
 */
package com.spring.boot.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.bean.Utility;
import com.spring.boot.controller.HomeController;
import com.spring.boot.entity.Transaction;
import com.spring.boot.repository.TransactionRepository;

/**
 * @author MI
 *
 */

@Service("transactionService")
public class TransactionService {
	
	protected Logger logger = Logger.getLogger(TransactionService.class.getName());

	@Autowired
	TransactionRepository transactionRepository;

	@Transactional
	public Transaction performTransaction(Transaction transaction) {
		 logger.info("perform Transaction in server..............");
		  transaction.setRequestId(transaction.getRequestId());
		  transaction.setTransactionTime(Utility.getCurrentTimeStamp());
		  transaction.setRequester(transaction.getRequester());
		  transaction.setTransactionType(Utility.base64Decode(transaction.getTransactionType())); 
		  transaction.setSourceAccountNumber(Utility.base64Decode(transaction.getSourceAccountNumber()));
		  //transaction.setAmount(transaction.getAmount());
		  transaction.setAmount(Double.parseDouble(Utility.base64Decode(transaction.getStrAmount()))); //strAmount used for received String data 
		  transaction.setDestinationAccountNumber(Utility.base64Decode(transaction.getDestinationAccountNumber())); 
		  transaction.setNote(transaction.getNote());
		 	 
		  return transactionRepository.save(transaction);
	}

}
