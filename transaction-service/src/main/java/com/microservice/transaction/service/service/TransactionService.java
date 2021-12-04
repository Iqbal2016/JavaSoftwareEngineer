package com.microservice.transaction.service.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.logging.Logger;

/**
 * 
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.transaction.service.bean.Utility;
import com.microservice.transaction.service.bean.Validation;
import com.microservice.transaction.service.bean.WSResponse;
import com.microservice.transaction.service.entity.Transaction;
import com.microservice.transaction.service.repository.TransactionRepository;

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
	public WSResponse performTransaction(Transaction transaction) {
		logger.info("Call transaction Service..................");
		// TODO Auto-generated method stub

		// System.out.println("...."+transaction.getParameter("requestId"));
		
		/*
		 * Transaction transaction = new Transaction();
		 * System.out.println("..."+request.getParameter("requestId"));
		 * 
		 * transaction.setRequestId(request.getParameter("requestId"));
		 * transaction.setTransactionTime(Utility.getCurrentTimeStamp());
		 * transaction.setRequester(request.getParameter("requester"));
		 * transaction.setTransactionType(request.getParameter("transactionType"));
		 * transaction.setSourceAccountNumber(request.getParameter("sourceAccountNumber"
		 * ));
		 * transaction.setAmount(Double.parseDouble(Utility.base64Decode(String.valueOf(
		 * request.getParameter("amount")))));
		 * transaction.setDestinationAccountNumber(request.getParameter(
		 * "destinationAccountNumber"));
		 * transaction.setNote(request.getParameter("note"));
		 */
		
		ArrayList<String> errorMessages = this.validateTransaction(transaction);
		if (errorMessages.size() == 0) {
		
		  transaction.setRequestId(transaction.getRequestId());
		  transaction.setTransactionTime(Utility.getCurrentTimeStamp());
		  transaction.setRequester(transaction.getRequester());
		  transaction.setTransactionType(Utility.base64Decode(transaction.getTransactionType()));
		  
		  logger.info("TRANSFER.................."+Utility.base64Decode(transaction.getTransactionType()));
		  transaction.setSourceAccountNumber(Utility.base64Decode(transaction.getSourceAccountNumber()));
		  transaction.setDestinationAccountNumber(Utility.base64Decode(transaction.getDestinationAccountNumber()));
		  
		  byte[] decodedBytes = Base64.getDecoder().decode(transaction.getTransactionType());
		  String decodedString = new String(decodedBytes);
		  
		  
		 // String tt = Utility.base64Decode(transaction.getTransactionType());
			/*
			 * logger.info("TRANSFER.................."+decodedString); if(
			 * decodedString=="TRANSFER") { logger.info("TRANSFER..................");
			 * transaction.setSourceAccountNumber(Utility.base64Decode(transaction.
			 * getSourceAccountNumber()));
			 * transaction.setDestinationAccountNumber(Utility.base64Decode(transaction.
			 * getDestinationAccountNumber())); } if(decodedString =="REVERSE") {
			 * logger.info("REVERSE TRANSFER..................");
			 * transaction.setSourceAccountNumber(Utility.base64Decode(transaction.
			 * getDestinationAccountNumber()));
			 * transaction.setDestinationAccountNumber(Utility.base64Decode(transaction.
			 * getSourceAccountNumber())); }
			 */
		  //transaction.setAmount(Double.parseDouble(Utility.base64Decode(String. valueOf(transaction.getAmount()))));
		  
		  
		 /* double dd = request.getAmount(); String ss = String.valueOf(dd); String bs1 =
		  Utility.base64Decode(ss); double bs2 = Double.parseDouble(bs1);
		  
		  System.out.println("dd "+dd +" ss "+ss +" bs1 " +bs1+ " bs2 "+bs2);
		  */
		  //transaction.setAmount(transaction.getAmount());	
		  transaction.setAmount(Double.parseDouble(Utility.base64Decode(transaction.getStrAmount())));		  
		   
		  transaction.setNote(transaction.getNote());
		 	 
		  transaction = transactionRepository.save(transaction);
		  if (transaction != null) {
			  return WSResponse.createSuccess("Transaction success ", transaction);
		  }else {
			  return WSResponse.createFailure("Error", (String[]) errorMessages.toArray());
		  }
		   
		}
		
		return WSResponse.createFailure("Error", errorMessages.toArray(new String[errorMessages.size()]));
	}


	public WSResponse performReverseTransaction(Transaction transaction) {
		ArrayList<String> errorMessages = this.validateTransaction(transaction);
		if (errorMessages.size() == 0) {
		
		  transaction.setRequestId(transaction.getRequestId());
		  transaction.setTransactionTime(Utility.getCurrentTimeStamp());
		  transaction.setRequester(transaction.getRequester());
		  transaction.setTransactionType(Utility.base64Decode(transaction.getTransactionType())); 
		 
		  //transaction.setAmount(Double.parseDouble(Utility.base64Decode(String. valueOf(transaction.getAmount()))));
		  
		  
		 /* double dd = request.getAmount(); String ss = String.valueOf(dd); String bs1 =
		  Utility.base64Decode(ss); double bs2 = Double.parseDouble(bs1);
		  
		  System.out.println("dd "+dd +" ss "+ss +" bs1 " +bs1+ " bs2 "+bs2);
		  */ 
		  // Utility.base64Decode(transaction.getSourceAccountNumber())
		  //Utility.base64Decode(transaction.getDestinationAccountNumber())
		  //transaction.setAmount(transaction.getAmount());	
		  if(Utility.base64Decode(transaction.getTransactionType()) =="TRANSFER") {
			  transaction.setSourceAccountNumber(Utility.base64Decode(transaction.getSourceAccountNumber()));			   
			  transaction.setDestinationAccountNumber(Utility.base64Decode(transaction.getDestinationAccountNumber()));  
		  } else {
			  transaction.setSourceAccountNumber(Utility.base64Decode(transaction.getDestinationAccountNumber()));			   
			  transaction.setDestinationAccountNumber(Utility.base64Decode(transaction.getSourceAccountNumber())); 
		  }
		  transaction.setAmount(Double.parseDouble(Utility.base64Decode(transaction.getStrAmount())));		 
		  transaction.setNote(transaction.getNote());
		 	 
		  transaction = transactionRepository.save(transaction);
		  if (transaction != null) {
			  return WSResponse.createSuccess("Reverse Transaction success ", transaction);
		  }else {
			  return WSResponse.createFailure("Error", (String[]) errorMessages.toArray());
		  }
		   
		}
		
		return WSResponse.createFailure("Error", errorMessages.toArray(new String[errorMessages.size()]));
	}
	
	private ArrayList<String> validateTransaction(Transaction transaction) {
		ArrayList<String> errors = new ArrayList<String>();
			if (Validation.isStrEmpty(transaction.getRequestId())) {
			/*
			 * boolean RequestId =
			 * transactionRepository.checkUniqueRequestId(transaction.getRequestId()); if
			 * (!RequestId) {
			 * errors.add("Request Id should not Empty and should be Unique"); }
			 */
				errors.add("Request Id should not Empty and should be Unique");
			}
			if (Validation.isStrEmpty(transaction.getRequester())) {
				errors.add("Requester name should not Empty");
			}
			if (Validation.isStrEmpty(Utility.base64Decode(transaction.getTransactionType()))) {
				errors.add("Transaction type should not Empty");
			}
			if (Validation.isStrEmpty(Utility.base64Decode(transaction.getSourceAccountNumber()))) {
				errors.add("Source Account Number should not Empty");
			}
			if (Double.parseDouble(Utility.base64Decode(transaction.getStrAmount())) <= 0) {
				errors.add("transaction amount should not be 0 or less than 0");
			}
			if (Validation.isStrEmpty(Utility.base64Decode(transaction.getDestinationAccountNumber()))) {
				errors.add("Destination Account Number should not Empty");
			}
		
			if (Validation.isStrEmpty(transaction.getNote())) {
				errors.add("Please provide Transaction note");
			}
		return errors;
	}


}
