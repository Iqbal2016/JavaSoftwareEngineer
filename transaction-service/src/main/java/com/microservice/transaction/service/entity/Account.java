package com.microservice.transaction.service.entity;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

/**
 * @author MI
 *
 */
@Entity
@Table(name = "Account")
public class Account implements Serializable {

	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private String id;

	@Column(name = "name")
	@Length(min = 5, message = "*Your name must have at least 5 characters")
	@NotBlank(message = "*Please provide your name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "accountNumber")
	@NotBlank(message = "*Please provide your account number")
	private String accountNumber;

	@Column(name = "balance")
	private double balance;

	@Column(name = "status")
	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", address=" + address + ", accountNumber=" + accountNumber
				+ ", balance=" + balance + ", status=" + status + "]";
	}

}
