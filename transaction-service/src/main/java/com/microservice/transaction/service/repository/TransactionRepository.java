package com.microservice.transaction.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.microservice.transaction.service.entity.Transaction;

/**
 * @author MI
 *
 */
@Repository("transactionRepository")
public interface TransactionRepository extends JpaRepository<Transaction, Id> {

	/*
	 * @Query("select requestId from Transaction where requestId =:requestId")
	 * boolean checkUniqueRequestId(String requestId);
	 */

	

}
