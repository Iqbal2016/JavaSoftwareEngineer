/**
 * 
 */
package com.spring.boot.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

/**
 * @author MI
 *
 */
@Entity
@Table(name = "Transaction")
public class Transaction {

	@Id
	@Column(unique = true, nullable = false)
	@NotBlank(message = "*Please provide your account number (request Id)")
	private String requestId;

	private Timestamp transactionTime;

	private String requester;

	@NotBlank(message = "*Please provide transaction Type")
	private String transactionType;

	@Length(min = 14, max = 16, message = "*Your name must have at least 14 digits account number")
	@NotBlank(message = "*Please provide your account number")
	private String sourceAccountNumber;

	private double amount;

	@Length(min = 14, max = 16, message = "*Your name must have at least 14 digits account number")
	@NotBlank(message = "*Please provide destination account number")
	private String destinationAccountNumber;

	private String note;

	@Transient
	private String strAmount;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public Timestamp getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Timestamp transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getRequester() {
		return requester;
	}

	public void setRequester(String requester) {
		this.requester = requester;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getSourceAccountNumber() {
		return sourceAccountNumber;
	}

	public void setSourceAccountNumber(String sourceAccountNumber) {
		this.sourceAccountNumber = sourceAccountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDestinationAccountNumber() {
		return destinationAccountNumber;
	}

	public void setDestinationAccountNumber(String destinationAccountNumber) {
		this.destinationAccountNumber = destinationAccountNumber;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getStrAmount() {
		return strAmount;
	}

	public void setStrAmount(String strAmount) {
		this.strAmount = strAmount;
	}

}
