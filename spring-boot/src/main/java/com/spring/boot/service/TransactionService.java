/**
 * 
 */
package com.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.bean.Utility;
import com.spring.boot.entity.Transaction;
import com.spring.boot.repository.TransactionRepository;

/**
 * @author MI
 *
 */

@Service("transactionService")
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Transactional
	public Transaction performTransaction(Transaction transaction) {
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
		
		
		
		  transaction.setRequestId(transaction.getRequestId());
		  transaction.setTransactionTime(Utility.getCurrentTimeStamp());
		  transaction.setRequester(transaction.getRequester());
		  transaction.setTransactionType(Utility.base64Decode(transaction.getTransactionType())); 
		  transaction.setSourceAccountNumber(Utility.base64Decode(transaction.getSourceAccountNumber()));
		  //transaction.setAmount(Double.parseDouble(Utility.base64Decode(String. valueOf(transaction.getAmount()))));
		  
		  
		 // double dd = transaction.getAmount(); 
		/*
		 * String ss = transaction.getStrAmount(); String bs1 =Utility.base64Decode(ss);
		 * double bs2 = Double.parseDouble(bs1);
		 * 
		 * System.out.println(" ss "+ss +" bs1 " +bs1+ " bs2 "+bs2);
		 */
		  
		  //transaction.setAmount(transaction.getAmount());

		  transaction.setAmount(Double.parseDouble(Utility.base64Decode(transaction.getStrAmount())));

		  transaction.setDestinationAccountNumber(Utility.base64Decode(transaction.getDestinationAccountNumber())); 
		  transaction.setNote(transaction.getNote());
		 	 
		  return transactionRepository.save(transaction);
	}

}
