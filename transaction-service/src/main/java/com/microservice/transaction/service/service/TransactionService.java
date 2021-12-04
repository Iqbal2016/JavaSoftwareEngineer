package com.microservice.transaction.service.service;

import java.util.ArrayList;
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

		ArrayList<String> errorMessages = this.validateTransaction(transaction);
		if (errorMessages.size() == 0) {

			transaction.setRequestId(transaction.getRequestId());
			transaction.setTransactionTime(Utility.getCurrentTimeStamp());
			transaction.setRequester(transaction.getRequester());
			transaction.setTransactionType(Utility.base64Decode(transaction.getTransactionType()));
			String trnsType = transaction.getTransactionType();
			if (trnsType.equals("TRANSFER") ) {
				logger.info("Call transaction Service........TRANSFER..........");
				transaction.setSourceAccountNumber(Utility.base64Decode(transaction.getSourceAccountNumber()));
				transaction.setDestinationAccountNumber(Utility.base64Decode(transaction.getDestinationAccountNumber()));
			}
			if (trnsType.equals("REVERSE")) {
				logger.info("Call transaction Service........REVERSE..........");
				transaction.setSourceAccountNumber(Utility.base64Decode(transaction.getDestinationAccountNumber()));
				transaction.setDestinationAccountNumber(Utility.base64Decode(transaction.getSourceAccountNumber()));
			}
			transaction.setAmount(Double.parseDouble(Utility.base64Decode(transaction.getStrAmount())));
			transaction.setNote(transaction.getNote());

			transaction = transactionRepository.save(transaction);
			if (transaction != null) {
				return WSResponse.createSuccess("Transaction success ", transaction);
			} else {
				return WSResponse.createFailure("Error", (String[]) errorMessages.toArray());
			}

		}

		return WSResponse.createFailure("Error", errorMessages.toArray(new String[errorMessages.size()]));
	}

	private ArrayList<String> validateTransaction(Transaction transaction) {
		ArrayList<String> errors = new ArrayList<String>();
		if (Validation.isStrEmpty(transaction.getRequestId())) {
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
